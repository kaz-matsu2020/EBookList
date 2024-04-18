package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * コメントを削除するためのDAO
 * @author kazuo
 */

public class EvaluationCommentDeleteDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * CommentDeleteメソッド
	 * @param productId 文字列
	 * @param userId 文字列
	 * @return 削除が成功したか失敗したかの真偽値
	 */
	
	public boolean CommentDelete(String productId, String userId) {
		boolean delDone;
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
			String sql = "delete from evaluationcomment where product_id = ? and user_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, productId);
			pStmt.setString(2, userId);
			
			// sqlを実行
			int r = pStmt.executeUpdate();
			if(r != 0) { 
				// 削除成功なのでtrueを格納
				delDone = true; 
			} else {
				// 削除失敗なのでfalseを格納
				delDone = false;
			}
			// 削除成功したか失敗したかを返す
			return delDone;
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
