package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EvaluationCommentPostDAO;
import DAO.PostedCheckDAO;
import model.EvaluationComment;
import model.IndicateProductLogic;
import model.PreventXSSLogic;
import model.Product;
import model.User;

/**
 * コメント投稿のためのコントローラー。productDetail.jspからリクエストを受ける
 * 同一書籍に同一ユーザーが複数コメントすることはできない
 * @author kazuo
 */

@WebServlet("/CommentPostServlet")
public class CommentPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投稿に必要なデータはコメントのテキスト、ユーザーID、商品ID、現在時刻の4つ
		// XSS防止の為文字の置き換えを実行しリクエストパラメータからコメントのテキスト取得
		request.setCharacterEncoding("UTF-8");
		PreventXSSLogic preventXSS = new PreventXSSLogic();
		String text = preventXSS.preventXSS(request.getParameter("text"));
		// セッションスコープからUser型を取得し、そこからuserIdを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		// セッションスコープからProduct型を取得し、そこからproductIdを取得
		Product product = (Product)session.getAttribute("productDetail");
		String productId = product.getProductId();
		// Date型を作成し現在時刻を取得。Date型をjava.sql.Date型に変換
		Date commentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(commentDate);
        java.sql.Date sqlCommentDate = java.sql.Date.valueOf(formattedDate);
        // 取得したデータからEvaluationCommentインスタンス生成
        EvaluationComment addComment = new EvaluationComment(userId, productId, text, sqlCommentDate);
        
        // 過去に投稿しているかどうかをPostedCheckDAOのPostedCheckメソッドを使用して確認
        PostedCheckDAO postedCheckDAO = new PostedCheckDAO();
        boolean postedCheck = postedCheckDAO.PostedCheck(userId, productId);
        String errMsg = null;
        // 投稿がなければEvaluationCommentPostDAOでコメント追加メソッドを実行
        if(!postedCheck) {
        	EvaluationCommentPostDAO addCommentLogic = new EvaluationCommentPostDAO();
    		boolean commentPostOk = addCommentLogic.CommentPost(addComment);
    		// コメントの投稿に失敗したらエラーメッセージを格納
    		if(!commentPostOk) { 
    			errMsg = "コメント投稿に失敗しました";
    			request.setAttribute("errMsg", errMsg);
    		}
        }
        // セッションにEvaluationCommentのList型を保存
        IndicateProductLogic ipl = new IndicateProductLogic();
        List<EvaluationComment> commentList = ipl.IndicateComment(productId);
        session.setAttribute("commentList", commentList);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
