package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserRegisterDAO;

// login.jspからGETリクエストを受けてuserRegister.jspにフォワード
// userRegister.jspからPOSTリクエストを受けてユーザー登録を処理するコントローラー

// 処理内容
// リクエストパラメータからユーザーID、パスワード、メール、名前、年齢を取得する
// 登録はUserRegisterDAOクラスのメソッドで、戻り値boolean型のuserRegister(ユーザーID, パスワード, メール, 名前, 年齢)を使用
// 上記メソッドでユーザーIDの重複確認が行われて
// 登録成功ならuserRegisterResultOK.jspにフォワード
// 失敗ならエラーメッセージをセッションスコープに保存してUserRegisterServletにリダイレクト

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userRegisterにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザー登録をするため、リクエストパラメータを取得しuserRegisterメソッドを使用
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		
		UserRegisterDAO userRegister = new UserRegisterDAO();
		boolean registerOK = userRegister.userRegister(userId, pass, mail, name, age);
		
		// ユーザー登録が成功すればuserRegisterResultOKにフォワード、失敗すればエラーメッセージを取得しUserRegisterServletにフォワード
		if(registerOK) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRegisterResultOK.jsp");
			dispatcher.forward(request, response);
		} else {
			String errMsg = "入力されたユーザーIDはすでに使用されています。";
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", errMsg);
			response.sendRedirect("UserRegisterServlet");
		}
	}
}