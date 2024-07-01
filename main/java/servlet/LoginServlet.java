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

import DAO.GetUserNameDAO;
import DAO.ProductDetailDAO;
import DAO.PropertyDAO;
import model.LoginLogic;
import model.Product;
import model.Property;
import model.User;

/**
 * isLogin.jspからGETリクエストを受けてlogin.jspにフォワード
 * login.jspからPOSTリクエストを受けてログイン処理をするためのコントローラー
 * @author kazuo
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 処理にはString ユーザーID と String パスワードを使ってデータベースと照合する
		// リクエストパラメータからuserIdとpassを取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		// ログイン判定をしてログイン成功ならデータベースから名前を取得
		LoginLogic loginCheck = new LoginLogic();
		boolean isLogin = loginCheck.execute(userId, pass);
		if(isLogin) {
			// userIdとnameだけのUserインスタンス生成
			// userIdからpropetyをデータベースから取得
			// user型とList<Property>型をセッションスコープに保存
			GetUserNameDAO getName = new GetUserNameDAO();
			String name = getName.execute(userId);
			User user = new User(userId, name);
			PropertyDAO propertyDAO = new PropertyDAO();
			List<Property> propertyList = new ArrayList<>();
			propertyList = propertyDAO.getProperty(userId);
			HttpSession session = request.getSession();
			List<Product> myProductList = new ArrayList<>();
			// List<Property>型の各要素からproductIdを取得
			// 各要素のproductIdからProduct型のインスタンスを生成しList<Product>のaddメソッドを使用
			ProductDetailDAO readProduct = new ProductDetailDAO();
			for(Property property : propertyList) {
				Product product = readProduct.ReadProductDetail(property.getProductId());
				myProductList.add(product);
			}
			session.setAttribute("user", user);
			session.setAttribute("propertyList", propertyList);
			session.setAttribute("myProductList", myProductList);
			// ログイン成功index.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			// ログイン失敗loginFalse.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginFalse.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
