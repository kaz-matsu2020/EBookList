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

import DAO.ProductDetailDAO;
import model.Product;
import model.Property;
import model.User;

/**
 * マイページで購入物だけを表示するためのコントローラー
 * ユーザーの購入物をList<Product>型で取得しmyPage.jspにフォワードする
 * @author kazuo
 */

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからList<Property>型の取得
		// List<Product>型を生成
		HttpSession session = request.getSession();
		List<Property> propertyList = (List<Property>)session.getAttribute("propertyList");
		List<Product> myProductList = new ArrayList<>();
		
		// List<Property>型の各要素からproductIdを取得
		// 各要素のproductIdからProduct型のインスタンスを生成しList<Product>のaddメソッドを使用
		ProductDetailDAO readProduct = new ProductDetailDAO();
		for(Property property : propertyList) {
			Product product = readProduct.ReadProductDetail(property.getProductId());
			myProductList.add(product);
		}
		// List<Product>型をセッションスコープに保存
		session.setAttribute("myProductList", myProductList);
		
		// ログインが確認できればmyPageにフォワード
		User user = (User)session.getAttribute("user");
		if(user != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp");
			dispatcher.forward(request, response);
		} else {
			// ログイン失敗したのでindex.jspにフォワード
			response.sendRedirect("index.jsp");
		}
	}

}
