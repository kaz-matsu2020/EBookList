package model;

import DAO.ChangeUserInfoDAO;

public class ChangeUserInfoLogic {
	public boolean changeUserPass(String userId, String pass) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserPass(userId, pass); 
	}
	
	public boolean changeUserMail(String userId, String mail) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserMail(userId, mail); 
	}
	
	public boolean changeUserName(String userId, String name) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserName(userId, name); 
	}
	
	public boolean changeUserAge(String userId, int age) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserAge(userId, age); 
	}
}
