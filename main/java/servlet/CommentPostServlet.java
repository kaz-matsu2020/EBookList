package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DistributorDAO;
import DAO.EvaluationCommentPostDAO;
import DAO.EvaluationCommentReadDAO;
import DAO.PostedCheckDAO;
import DAO.ProductDetailDAO;
import model.EvaluationComment;
import model.Product;
import model.User;

@WebServlet("/CommentPostServlet")
public class CommentPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		String text = request.getParameter("text");
		
		// productIdからproductDetail取得
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		
		// distributorIdからdistributorNameを取得
		DistributorDAO readName = new DistributorDAO();
		String distributorName = readName.ReadDistributorName(productDetail.getDistributorId());
		
		// コメント追加のためステータス取得しEvaluationCommentインスタンス生成
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		
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
    		}
        }
		
		// EvaluationCommentの取得
		List<EvaluationComment> commentList = new ArrayList<>();
		EvaluationCommentReadDAO readComment = new EvaluationCommentReadDAO();
		commentList = readComment.ReadCommentList(productId);
		
		// リクエストパラメータにproductDetail、productName、EvaluationCommentを保存
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("productDetail", productDetail);
		request.setAttribute("distributorName", distributorName);
		request.setAttribute("commentList", commentList);
		request.setAttribute("errMsg", errMsg);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
