package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログイン成功したユーザーのユーザー名を取得するためのDAO
 * @author kazuo
 */

public class GetUserNameDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	/**
	 * executeメソッド
	 * @param userId 文字列
	 * @return 引数userIdに紐づいた文字列name
	 */
	
	public String execute(String userId) {
		String name;
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
			
			//select文を準備
			String sql = "select name from users where user_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) { 
				// 取得できたユーザー名を格納
				name = rs.getString("name"); 
			} else {
				// 取得できなかったのでnullを格納
				name = null;
			}
			// 取得したユーザー名を返す
			return name;
			
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
