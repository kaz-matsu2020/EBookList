package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ユーザーIDとパスワードが登録情報と一致しているか判定するDAO
 * @author kazuo
 */

public class UserCheckDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * executeメソッド
	 * @param userId 文字列
	 * @param pass 文字列
	 * @return 引数を条件にusersテーブルから行が取得できればtrue,取得できなければfalse
	 */
	
	public boolean execute(String userId, String pass){
		boolean isLogin = false;
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
			
			//select文を準備
			String sql = "select user_id, pass from users where user_id = ? and pass = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			pStmt.setString(2, pass);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) { isLogin = true; }
			return isLogin;
			
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
