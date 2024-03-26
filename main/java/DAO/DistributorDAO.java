package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistributorDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public String ReadDistributorName(String distributorId){
		String distributorName = null;
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
			String sql = "select name from distributor where distributor_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, distributorId);
			
			// sqlを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				distributorName = rs.getString("name");
			}
			return distributorName;
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
