package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 購入処理するためのDAO
// 戻り値はboolean型で引数はString ユーザーID, String 商品ID

public class PurchaseDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean execute(String userId, String productId) {
		boolean done = false;
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
			
			// 購入していないものかをチェック
			// sql処理を記述
			String sql = "select property_number from property where user_id = ? and product_id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, userId);
			pStmt.setString(2, productId);
			// selectを実行
			ResultSet rs = pStmt.executeQuery();
			// 購入してなければ最大所持数を検索しpropertyに追加する
			if(!rs.next()) {
				// sql処理を記述
				sql = "select max(property_number) as number_of_possession from property where user_id = ?";
				pStmt = con.prepareStatement(sql);
				// sql文中の｢?｣に使用する値を設定してSQL文を完成
				pStmt.setString(1, userId);
				// selectを実行
				rs = pStmt.executeQuery();
				int numberOfPossession = 0;
				if(rs.next()) { numberOfPossession = rs.getInt("number_of_possession"); }
				numberOfPossession += 1;
				try {
					sql = "insert into property (property_number, user_id, product_id) values (?, ?, ?)";
					pStmt = con.prepareStatement(sql);
					pStmt.setInt(1, numberOfPossession);
					pStmt.setString(2, userId);
					pStmt.setString(3, productId);
					int r = pStmt.executeUpdate();
					if (r != 0) { done = true; }
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
			return done;
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
