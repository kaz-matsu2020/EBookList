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
 * 読書用で商品の中身を取得するDAO
 * @author kazuo
 */

// 戻り値List<String>型で引数はString 商品ID

public class ReadingProductDAO {
	private final String DB_NAME = "EBookList";
	private final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
	private final String JDBC_URL = "jdbc:mysql://エンドポイント/" + DB_NAME + PROPATIES;
	private final String DB_USER = "ユーザー";
	private final String DB_PASS = "パスワード";
	
	/**
	 * ReadingProductメソッド
	 * @param productId 文字列
	 * @return productDetailテーブルから引数に対応したデータを格納したProduct型
	 * productDetailテーブルのdetail_imageのみを扱う
	 */
	
	public Product ReadingProduct(String productId) {
		List<String> imageList = new ArrayList<>();
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
			String sql = "select detail_image from productdetail where product_id = ? order by page_number";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, productId);
			
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String detailImage = rs.getString("detail_image");
				imageList.add(detailImage);
			}
			Product product = new Product(imageList);
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
