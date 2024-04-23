package model;

import DAO.UserInfoReadDAO;

public class AnyChangesCheckLogic {
	public boolean changeCheckPass(String userId, String pass) {
		UserInfoReadDAO userInfo = new UserInfoReadDAO();
		User user = userInfo.readUserInfo(userId);
		return !pass.equals(user.getPass());
	}
	public boolean changeCheckMail(String userId, String mail) {
		UserInfoReadDAO userInfo = new UserInfoReadDAO();
		User user = userInfo.readUserInfo(userId);
		return !mail.equals(user.getMail());
	}
	public boolean changeCheckName(String userId, String name) {
		UserInfoReadDAO userInfo = new UserInfoReadDAO();
		User user = userInfo.readUserInfo(userId);
		return !name.equals(user.getName());
	}
	public boolean changeCheckAge(String userId, int age) {
		UserInfoReadDAO userInfo = new UserInfoReadDAO();
		User user = userInfo.readUserInfo(userId);
		return !(age == user.getAge());
	}
}
