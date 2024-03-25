package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserNameDAO {
	// データベース接続に使用する情報
		private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
		private final String DB_USER = "sa";
		private final String DB_PASS = "";
		
		public String execute(String userId) {
			String name = null;
			//JDBCドライバを読み込む
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("JDBCを読み込めませんでした");
			}
			// データベースに接続
			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
				//select文を準備
				String sql = "select name from users where user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// insert文中の｢?｣に使用する値を設定してSQL文を完成
				pStmt.setString(1, userId);
				
				// selectを実行
				ResultSet rs = pStmt.executeQuery();
				if(rs.next()) { name = rs.getString("name"); }
				
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			return name;
		}
}
