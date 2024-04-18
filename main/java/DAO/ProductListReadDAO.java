package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

/**
 * 書籍一覧を取得するためのDAO
 * @author kazuo
 */

public class ProductListReadDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * ReadProductListメソッド
	 * @return productテーブル登録情報をProduct型に格納したList型
	 * productテーブルに登録してあるproduct_id, product_name, price, top_imageのみを格納して返す
	 */
	
	public List<Product> ReadProductList() {
		List<Product> productList = new ArrayList<>();
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
			String sql = "select product_id, product_name, price, top_image from product";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("product_id");
				String name = rs.getString("product_name");
				int price = rs.getInt("price");
				String topImage = rs.getString("top_image");
				Product product = new Product(id, name, price, topImage);
				productList.add(product);
			}
			return productList;
			
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
