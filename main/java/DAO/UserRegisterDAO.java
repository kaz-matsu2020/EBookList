package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ユーザー登録するためのDAO
 * @author kazuo
 */

public class UserRegisterDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * userRegisterメソッド
	 * @param userId 文字列
	 * @param pass 文字列
	 * @param mail 文字列
	 * @param name 文字列
	 * @param age 整数値
	 * @return ユーザー登録が成功か失敗かの真偽値
	 */
	
	public boolean userRegister(String userId, String pass, String mail, String name, int age) {
		boolean registerOK = false;
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
			String sql = "select user_id from users where user_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(!rs.next()) {
				try {
					sql = "insert into users (user_id, pass, mail, name, age) values (?, ?, ?, ?, ?)";
					pStmt = con.prepareStatement(sql);
					pStmt.setString(1, userId);
					pStmt.setString(2, pass);
					pStmt.setString(3, mail);
					pStmt.setString(4, name);
					pStmt.setInt(5, age);
					int r = pStmt.executeUpdate();
					// 登録成功ならtrueを格納
					if(r != 0) { registerOK = true; }
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
			return registerOK;
			
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
