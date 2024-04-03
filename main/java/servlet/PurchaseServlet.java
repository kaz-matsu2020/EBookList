package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PropertyDAO;
import DAO.PurchaseDAO;
import model.Product;
import model.Property;
import model.User;

/**
 * productDetail.jspからGETリクエストを受けてpurchase.jspにフォワード
 * purchase.jspからPOSTリクエストを受けて購入処理をするためのコントローラー
 * @author kazuo
 */

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchase.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからUser型とProduct型を取得
		// getterでproductIdとuserIdを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Product productDetail = (Product)session.getAttribute("productDetail");
		String userId = user.getUserId();
		String productId = productDetail.getProductId();
		
		// PurchaseDAOのexecuteメソッドを使用して購入処理を行う
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		boolean purchaseDone = purchaseDAO.execute(userId, productId);
		if(purchaseDone) {
			// 処理成功ならList<Property>型を取得してセッションスコープに保存しpurchaseDone.jspにフォワード
			PropertyDAO propertyDAO = new PropertyDAO();
			List<Property> propertyList = new ArrayList<>();
			propertyList = propertyDAO.getProperty(userId);
			session.setAttribute("propertyList", propertyList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchaseDone.jsp");
			dispatcher.forward(request, response);
		} else {
			// 失敗ならpurchaseFalse.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchaseFalse.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
