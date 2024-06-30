package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnyChangesCheckLogic;
import model.ChangeUserInfoLogic;
import model.User;
import model.UserInfoReadLogic;
import model.ValidationLogic;
/**
 * GETリクエストを受けてchangeUserInfo.jspにフォワード
 * changeUserInfo.jspからPOSTリクエストを受けて登録情報変更を処理するコントローラー
 * @author kazuo
 */

@WebServlet("/ChangeUserInfoServlet")
public class ChangeUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからUserIdを取得
		// IdからUser情報を取得してリクエストスコープに保存
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		UserInfoReadLogic readUserInfo = new UserInfoReadLogic();
		user = readUserInfo.readUserInfo(userId);
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("user", user);
		
		// changeUserInfo.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeUserInfo.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからuserId,pass,mail,name,ageを取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));
		
		// バリデーションチェックに問題なければ変更処理を行う
		ValidationLogic userInfoCheck = new ValidationLogic();
		boolean valiCheckOK = false;
		if (userInfoCheck.idCheck(userId) && userInfoCheck.passCheck(pass)) { valiCheckOK = true; }
		
		boolean changeOK = false;
		String resultMsg = null;
		String errMsg = null;
		if(valiCheckOK) {
			// 変更箇所だけ変更処理を行う
			AnyChangesCheckLogic changeCheck = new AnyChangesCheckLogic();
			ChangeUserInfoLogic changeUserInfo = new ChangeUserInfoLogic();
			int changeCount = 0;
			if(changeCheck.changeCheckPass(userId, pass)) { 
				changeCount += 1;
				changeUserInfo.changeUserPass(userId, pass); 
				}
			if(changeCheck.changeCheckMail(userId, mail)) { 
				changeCount += 1;
				changeUserInfo.changeUserMail(userId, mail); 
				}
			if(changeCheck.changeCheckName(userId, name)) { 
				changeCount += 1;
				changeUserInfo.changeUserName(userId, name); 
				}
			if(changeCheck.changeCheckAge(userId, age)) { 
				changeCount += 1;
				changeUserInfo.changeUserAge(userId, age); 
				}
			if(changeCount == 0) { 
				resultMsg = "変更箇所はありません";
			} else {
				resultMsg = "変更完了です";
			}
			changeOK = true;
		} else {
			// バリデーションチェックに引っかかっているのでエラーメッセージを保存
			errMsg = "パスワードは半角英数字3文字～10文字で入力してください。";
		}
		
		if(changeOK) {
			// 変更処理成功でuser情報とresultMsgをリクエストスコープに保存してフォワード
			user = new User(userId, pass, mail, name, age);
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("user", user);
			
			request.setAttribute("resultMsg", resultMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeUserInfo.jsp");
			dispatcher.forward(request, response);
		} else {
			// 変更失敗なので元のユーザー情報とエラーメッセージをリクエストスコープに保存してフォワード
			UserInfoReadLogic readUserInfo = new UserInfoReadLogic();
			user = readUserInfo.readUserInfo(userId);
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("user", user);
			
			request.setAttribute("errMsg", errMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeUserInfo.jsp");
			dispatcher.forward(request, response);
		}
	}
}
