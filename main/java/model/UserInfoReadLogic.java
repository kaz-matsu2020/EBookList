package model;

import DAO.UserInfoReadDAO;

public class UserInfoReadLogic {
	public User readUserInfo(String userId) {
		UserInfoReadDAO readUserInfo = new UserInfoReadDAO();
		User user = readUserInfo.readUserInfo(userId);
		return user;
	}
}
