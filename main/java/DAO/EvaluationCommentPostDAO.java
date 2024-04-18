package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EvaluationComment;

/**
 * コメント投稿のDAO
 * @author kazuo
 */

public class EvaluationCommentPostDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * CommentPostメソッド
	 * @param comment EvaluationComment型
	 * @return コメント投稿が成功したか失敗したかの真偽値
	 */
	
	public boolean CommentPost (EvaluationComment comment){
		// 引数EvaluationComment型からuserId,productId,投稿するコメント,日時を取得
		EvaluationComment addComment = new EvaluationComment();
		addComment = comment;
		String userId = addComment.getUserId();
		String productId = addComment.getProductId();
		String evaComment = addComment.getEvaComment();
		java.sql.Date commentDate = addComment.getCommentDate();
		boolean postOk;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			if(r != 0) {
				// 投稿成功なのでtrueを格納
				postOk = true; 
			} else {
				// 投稿失敗なのでfalseを格納
				postOk = false; 
			}
			// 投稿が成功したか失敗したかを返す
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
