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
import model.Product;
import model.User;

@WebServlet("/CommentPostServlet")
public class CommentPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		// コメント追加のためステータスを取得しEvaluationCommentインスタンス生成
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		Product product = (Product)session.getAttribute("productDetail");
		String productId = product.getProductId();
		Date commentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(commentDate);
        java.sql.Date sqlCommentDate = java.sql.Date.valueOf(formattedDate);
        EvaluationComment addComment = new EvaluationComment(userId, productId, text, sqlCommentDate);
        
        // 過去に投稿していないかをチェックし投稿がなければEvaluationCommentPostDAOでコメント追加メソッドを実行
        PostedCheckDAO postedCheckDAO = new PostedCheckDAO();
        boolean postedCheck = postedCheckDAO.PostedCheck(userId, productId);
        String errMsg = null;
        System.out.println(postedCheck);
        if(!postedCheck) {
        	EvaluationCommentPostDAO addCommentLogic = new EvaluationCommentPostDAO();
    		boolean commentPostOk = addCommentLogic.CommentPost(addComment);
    		if(!commentPostOk) { 
    			errMsg = "コメント投稿に失敗しました";
    			request.setAttribute("errMsg", errMsg);
    		}
        }
		
        // セッションにEvaluationCommentを保存
        IndicateProductLogic ipl = new IndicateProductLogic();
        List<EvaluationComment> commentList = ipl.IndicateComment(productId);
        session.setAttribute("commentList", commentList);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
