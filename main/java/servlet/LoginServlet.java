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

// isLogin.jspからGETリクエストを受けてlogin.jspにフォワード
// login.jspからPOSTリクエストを受けてログイン処理をするためのコントローラー
// 処理にはString ユーザーID と String パスワードを使ってデータベースと照合する

// ユーザーIDとパスワードはリクエストパラメータから取得
// LoginLogicクラスのメソッド、戻り値boolean型のexecute(String ユーザーID, String パスワード)を使用
// ログイン成功ならユーザーIDからUser型とList<Property>型を取得してセッションスコープに保存してindex.jspにフォワードする 

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		// ログイン判定をしてログイン成功ならデータベースから名前を取得
		// userIdとnameだけのUserインスタンス生成
		// userIdからpropetyをデータベースから取得
		// user型とList<Property>型をセッションスコープに保存
		// ログイン成功ならindex.jspにフォワード
		// ログイン失敗なたloginFalse.jspにフォワード
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
