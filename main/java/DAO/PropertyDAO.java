package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Property;

// 購入物だけを表示するために購入リストを取得するDAO
// 戻り値はList<Property>型で引数はString ユーザーID

public class PropertyDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Property> getProperty(String userId) {
		List<Property> propertyList = new ArrayList<>();
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
			String sql = "select property_number, product_id from property where user_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				int number = rs.getInt("property_number");
				String productId = rs.getString("product_id");
				Property property = new Property(number, userId, productId);
				propertyList.add(property);
				}
			return propertyList;
			
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
