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
import DAO.PropertyDAO;
import model.LoginLogic;
import model.Property;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		// ログイン判定
		// ログイン成功ならデータベースから名前を取得
		// userIdとnameだけのUserインスタンス生成
		// userIdからpropetyをデータベースから取得
		LoginLogic loginCheck = new LoginLogic();
		boolean isLogin = loginCheck.execute(userId, pass);
		if(isLogin) {
			GetUserNameDAO getName = new GetUserNameDAO();
			String name = getName.execute(userId);
			User user = new User(userId, name);
			PropertyDAO propertyDAO = new PropertyDAO();
			List<Property> propertyList = new ArrayList<>();
			propertyList = propertyDAO.getProperty(userId);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("propertyList", propertyList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginFalse.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
