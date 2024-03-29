package model;

import DAO.UserCheckDAO;

// ログイン処理するためのクラス
// userIdとpassを使用してデータベースと照合しboolean型を返す

public class LoginLogic {
	public boolean execute(String userId, String pass) {
		UserCheckDAO check = new UserCheckDAO();
		return check.execute(userId, pass);
	}
}
