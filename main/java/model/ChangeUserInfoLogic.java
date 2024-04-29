package model;

import DAO.ChangeUserInfoDAO;

public class ChangeUserInfoLogic {
	public boolean changeUserInfo(String userId, String pass, String mail, String name, int age) {
		AnyChangesCheckLogic changeCheck = new AnyChangesCheckLogic();
		boolean isChanged = false;
		// 変更箇所があれば変更処理を実行する
		if(changeCheck.changeCheckPass(userId, pass)) { 
			isChanged = true;
			changeUserPass(userId, pass); 
			}
		if(changeCheck.changeCheckMail(userId, mail)) { 
			isChanged = true;
			changeUserMail(userId, mail); 
			}
		if(changeCheck.changeCheckName(userId, name)) { 
			isChanged = true;
			changeUserName(userId, name); 
			}
		if(changeCheck.changeCheckAge(userId, age)) { 
			isChanged = true;
			changeUserAge(userId, age); 
			}
		return isChanged;
	}
	
	private boolean changeUserPass(String userId, String pass) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserPass(userId, pass); 
	}
	
	private boolean changeUserMail(String userId, String mail) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserMail(userId, mail); 
	}
	
	private boolean changeUserName(String userId, String name) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserName(userId, name); 
	}
	
	private boolean changeUserAge(String userId, int age) {
		ChangeUserInfoDAO changeUserInfo = new ChangeUserInfoDAO();
		return changeUserInfo.changeUserAge(userId, age); 
	}
}
