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

// productDetail.jspからのリクエストでコメントを削除するためのコントローラー
// コメントを削除した後にコメントリストを取得しなおして、セッションスコープに保存してproductDetail.jspにフォワードする

// 処理内容
// 削除にはEvaluationCommentLogicクラスの戻り値boolean型のcommentDelete(String 商品ID,String ユーザーID)メソッドを使用する
// 引数の商品IDはセッションスコープからProduct型を取得しgetProductId()を使用
// ユーザーIDはセッションスコープからUser型を取得しgetUserId()を使用

@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからパラメータを取得
		// EvaluationCommentLogicのcommentDeleteメソッドを使用してコメントの削除
		HttpSession session = request.getSession();
		Product product = (Product)session.getAttribute("productDetail");
		User user = (User)session.getAttribute("user");
		String productId = product.getProductId();
		String userId = user.getUserId();
		EvaluationCommentLogic delLogic = new EvaluationCommentLogic();
		boolean deleatDone = delLogic.commentDelete(productId, userId);
		
		// 削除成功ならコメントリストを取得してセッションスコープに保存
		// 失敗ならerrMsgを残してフォワード
		if(deleatDone) {
			// セッションにEvaluationCommentを保存
			IndicateProductLogic ipl = new IndicateProductLogic();
			List<EvaluationComment> commentList = ipl.IndicateComment(productId);
			session.setAttribute("commentList", commentList);
			} else {
				String errMsg = "削除は失敗です";
				request.setAttribute("errMsg", errMsg);
			}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}