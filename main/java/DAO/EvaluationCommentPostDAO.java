package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EvaluationComment;

// コメント投稿するためのDAO
// 戻り値はboolean型で引数はEvaluationComment 投稿コメント

public class EvaluationCommentPostDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean CommentPost (EvaluationComment comment){
		EvaluationComment addComment = new EvaluationComment();
		addComment = comment;
		String userId = addComment.getUserId();
		String productId = addComment.getProductId();
		String evaComment = addComment.getEvaComment();
		java.sql.Date commentDate = addComment.getCommentDate();
		boolean postOk = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCを読み込めませんでした");
		}
		
		Connection con = null;
		try {
			// データベースに接続
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS); 
			
			// sql処理を記述
			String sql = "insert into evaluationcomment (user_id, product_id, eva_comment, comment_date) values (?, ?, ?, ?)";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, userId);
			pStmt.setString(2, productId);
			pStmt.setString(3, evaComment);
			pStmt.setDate(4, commentDate);
			int r = pStmt.executeUpdate();
			if(r != 0) { postOk = true; }
			return postOk;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベース接続の切断
			if (con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
