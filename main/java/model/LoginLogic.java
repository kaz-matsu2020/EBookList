package model;

import DAO.UserCheckDAO;

public class LoginLogic {
	public boolean execute(String userId, String pass) {
		UserCheckDAO check = new UserCheckDAO();
		return check.execute(userId, pass);
	}
}
