package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PurchaseDAO;
import model.Product;
import model.User;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchase.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// productIdとuserIdを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Product productDetail = (Product)session.getAttribute("productDetail");
		String userId = user.getUserId();
		String productId = productDetail.getProductId();
		
		// 購入メソッドを実行し成功ならpurchaseDone.jspにフォワード
		// 失敗ならpurchaseFalse.jspにフォワード
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		boolean purchaseDone = purchaseDAO.execute(userId, productId);
		if(purchaseDone) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchaseDone.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/purchaseFalse.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
