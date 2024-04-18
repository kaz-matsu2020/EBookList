package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Product;

/**
 * 商品詳細を取得するためのDAO
 * @author kazuo
 */

public class ProductDetailDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * ReadProductDetailメソッド
	 * @param productId 文字列
	 * @return 引数に紐づいたProduct型
	 */
	
	public Product ReadProductDetail(String productId) {
		Product product = new Product();
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
			String sql = "select product_name, price, distributor_id, sale_date, update_date,  top_image, introduce_comment from product where product_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
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
			return product;
			
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
