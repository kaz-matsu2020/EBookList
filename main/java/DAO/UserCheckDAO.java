package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCheckDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean execute(String userId, String pass) {
		boolean isLogin = false;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCを読み込めませんでした");
		}
		// データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//select文を準備
			String sql = "select user_id, pass from users where user_id = ? and pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// 文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			pStmt.setString(2, pass);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) { isLogin = true; }
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return isLogin;
	}
}
