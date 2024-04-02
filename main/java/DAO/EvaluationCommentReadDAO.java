package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EvaluationComment;

/**
 * 特定商品に対するコメントリストを取得するDAO
 * @author kazuo
 */

public class EvaluationCommentReadDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	/**
	 * ReadCommentListメソッド
	 * @param productId 文字列
	 * @return 投稿コメント(EvaluationComment)のList型
	 */
	
	public List<EvaluationComment> ReadCommentList(String productId) {
		List<EvaluationComment> commentList = new ArrayList<>();
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
			String sql = "select user_id, eva_comment, comment_date from evaluationcomment where product_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, productId);
			
			// sqlを実行
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				EvaluationComment c;
				String userId = rs.getString("user_id");
				String trimUserId = userId.trim();
				String comment = rs.getString("eva_comment");
				java.sql.Date date = rs.getDate("comment_date");
				c = new EvaluationComment(trimUserId, productId, comment, date);
				commentList.add(c);
			}
			return commentList;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
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
