package model;

import DAO.UserCheckDAO;

/**
 * ログイン処理するためのクラス
 * @author kazuo
 */

public class LoginLogic {
	/**
	 * executeメソッド
	 * @param userId 文字列
	 * @param pass 文字列
	 * @return 引数を基にログイン成功すればture,失敗すればfalse
	 */
	public boolean execute(String userId, String pass) {
		UserCheckDAO check = new UserCheckDAO();
		return check.execute(userId, pass);
	}
}
