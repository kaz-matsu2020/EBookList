package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 過去に投稿しているかを調べるDAO
 * @author kazuo
 */

public class PostedCheckDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mySQL://エンドポント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー名";
	private final String DB_PASS = "パスワード";
	
	/**
	 * PostedCheckメソッド
	 * @param userId 文字列
	 * @param productId 文字列
	 * @return 過去に投稿しているかどうかの真偽値
	 */
	
	public boolean PostedCheck (String userId, String productId){
		boolean check;
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
			String sql = "select user_id from evaluationcomment where user_id = ? and product_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			pStmt.setString(2, productId);
			
			// sqlを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				// 過去に投稿があるのでtrueを格納
				check = true;
			} else {
				// 過去に投稿がないのでfalseを格納
				check = false;
			}
			// 過去に投稿があるかどうかを返す
			return check;
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
