package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ユーザー登録情報を変更するためのDAO
 * @author kazuo
 */

public class ChangeUserInfoDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/EBookList";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	/**
	 * 各メソッド
	 * @param userId 文字列
	 * @param pass 文字列
	 * @param mail 文字列
	 * @param name 文字列
	 * @param age 整数値
	 * @return ユーザー登録情報変更が成功か失敗かの真偽値
	 */
	
	public boolean changeUserPass(String userId, String pass) {
		boolean changeOK = false;
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
			// sql処理を記述
			String sql = "update users set pass = ? where user_id = ?;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, pass);
			pStmt.setString(2, userId);
			
			// selectを実行
			int r = pStmt.executeUpdate();
			
			// 変更成功ならtrueを格納
			if(r != 0) { changeOK = true;}
			
			return changeOK;
			
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
	
	public boolean changeUserMail(String userId, String mail) {
		boolean changeOK = false;
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
			
			// sql処理を記述
			String sql = "update users set mail = ? where user_id = ?;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, mail);
			pStmt.setString(2, userId);
			// selectを実行
			int r = pStmt.executeUpdate();
			// 変更成功ならtrueを格納
			if(r != 0) { changeOK = true;}

			return changeOK;
			
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

	public boolean changeUserName(String userId, String name) {
		boolean changeOK = false;
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
			
			// sql処理を記述
			String sql = "update users set name = ? where user_id = ?;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setString(1, name);
			pStmt.setString(2, userId);
			// selectを実行
			int r = pStmt.executeUpdate();
			// 変更成功ならtrueを格納
			if(r != 0) { changeOK = true;}

			return changeOK;
			
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

	public boolean changeUserAge(String userId, int age) {
		boolean changeOK = false;
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
			
			// sql処理を記述
			String sql = "update users set age = ? where user_id = ?;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			// sql文中の｢?｣に使用する値を設定してSQL文を完成
			pStmt.setInt(1, age);
			pStmt.setString(2, userId);
			// selectを実行
			int r = pStmt.executeUpdate();
			// 変更成功ならtrueを格納
			if(r != 0) { changeOK = true;}

			return changeOK;
			
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
