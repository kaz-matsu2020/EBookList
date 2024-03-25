package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Product;

public class ProductDetailDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Product ReadProductDetail(String productId) {
		Product product = new Product();
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCを読み込めませんでした");
		}
		// データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//select文を準備
			String sql = "select product_name, price, distributor_id, sale_date, update_date,  top_image, introduce_comment from product where product_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, productId);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String distributorId = rs.getString("distributor_id");
				Date saleDate = rs.getDate("sale_date");
				Date updateDate = rs.getDate("update_date");
				String topImage = rs.getString("top_image");
				String introComment = rs.getString("introduce_comment");
				product = new Product(productId, name, price, distributorId, saleDate, updateDate, topImage, introComment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return product;
	}
}
