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
import model.UserIdOverlapCheckLogic;
import model.ValidationLogic;
/**
 * login.jspからGETリクエストを受けてuserRegister.jspにフォワード
 * userRegister.jspからPOSTリクエストを受けてユーザー登録を処理するコントローラー
 * @author kazuo
 */

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userRegisterにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからuserId,pass,mail,name,ageを取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));

		// バリデーションチェックをして問題なければ登録する
		ValidationLogic userInfoCheck = new ValidationLogic();
		boolean valiCheckOK = false;
		if (userInfoCheck.idCheck(userId) && userInfoCheck.passCheck(pass)) { valiCheckOK = true; }
		
		boolean registerOK = false;
		String errMsg = null;
		if(valiCheckOK) {
			// UserRegisterDAOのuserRegisterメソッドを使用し登録処理を行う
			UserRegisterDAO userRegister = new UserRegisterDAO();
			registerOK = userRegister.userRegister(userId, pass, mail, name, age);
		} else {
			// エラーメッセージを保存
			errMsg = "ユーザーIDとパスワードは半角英数字6文字～10文字で入力してください。";
		}
		
		// ユーザーIDが重複している場合のエラーメッセージを保存
		UserIdOverlapCheckLogic checkOverlap = new UserIdOverlapCheckLogic();
		if(checkOverlap.userIdOverlapCheck(userId)) { errMsg = "入力されたユーザーIDはすでに使用されています。"; }
		
		// 登録成功か失敗かでフォワード先を変更
		if(registerOK) {
			// ユーザー登録が成功なのでuserRegisterResultOKにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRegisterResultOK.jsp");
			dispatcher.forward(request, response);
		} else {
			// 登録失敗なのでエラーメッセージをセッションスコープに保存してUserRegisterServletにリダイレクト
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", errMsg);
			response.sendRedirect("UserRegisterServlet");
		}
	}
}