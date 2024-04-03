package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EvaluationComment;
import model.EvaluationCommentLogic;
import model.IndicateProductLogic;
import model.Product;
import model.User;

/**
 * productDetail.jspからのリクエストを受けてコメントを削除するためのコントローラー
 * コメントを削除した後にコメントリストを取得しなおして、セッションスコープに保存してproductDetail.jspにフォワードする
 * @author kazuo
 */

@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからProduct型とUser型を取得
		HttpSession session = request.getSession();
		Product product = (Product)session.getAttribute("productDetail");
		User user = (User)session.getAttribute("user");
		// getterでproductIdとuserIdを取得
		String productId = product.getProductId();
		String userId = user.getUserId();
		// EvaluationCommentLogicのcommentDeleteメソッドを使用してコメントの削除
		// 引数はString productId, String userId
		EvaluationCommentLogic delLogic = new EvaluationCommentLogic();
		boolean deleatDone = delLogic.commentDelete(productId, userId);
		
		// 削除成功ならコメントリストを取得してセッションスコープに保存
		if(deleatDone) {
			// セッションに削除した後のEvaluationCommentのList型を保存
			IndicateProductLogic ipl = new IndicateProductLogic();
			List<EvaluationComment> commentList = ipl.IndicateComment(productId);
			session.setAttribute("commentList", commentList);
			} else {
				// 削除失敗なのでerrMsgを残してフォワード
				String errMsg = "削除は失敗です";
				request.setAttribute("errMsg", errMsg);
			}
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}