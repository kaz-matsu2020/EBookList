package test;

import DAO.ChangeUserInfoDAO;

public class ChangeUserInfoLogicTest {
	public static void main(String args[]) {
		changePassOK(); // 変更が成功する場合のテスト
		changePassNG(); // 変更が失敗する場合のテスト
		changeMailOK(); // 変更が成功する場合のテスト
		changeMailNG(); // 変更が失敗する場合のテスト
		changeNameOK(); // 変更が成功する場合のテスト
		changeNameNG(); // 変更が失敗する場合のテスト
		changeAgeOK(); // 変更が成功する場合のテスト
		changeAgeNG(); // 変更が失敗する場合のテスト
		changeReset(); // 変更を元に戻す
	}
	public static void changePassOK() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserPass("kaz1", "5678");
		if(b == true) {
			System.out.print(b);
			System.out.println(":PassOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":PassOKテスト失敗");
		}
	}
	public static void changePassNG() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserPass("kaz3", "5678");
		if(b == false) {
			System.out.print(b);
			System.out.println(":PassNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":PassNGテスト失敗");
		}
	}
	public static void changeMailOK() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserMail("kaz1", "c@c");
		if(b == true) {
			System.out.print(b);
			System.out.println(":MailOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":MailOKテスト失敗");
		}
	}
	public static void changeMailNG() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserMail("kaz3", "c@c");
		if(b == false) {
			System.out.print(b);
			System.out.println(":MailNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":MailNGテスト失敗");
		}
	}
	public static void changeNameOK() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserName("kaz1", "ははは");
		if(b == true) {
			System.out.print(b);
			System.out.println(":NameOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":NameOKテスト失敗");
		}
	}
	public static void changeNameNG() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserName("kaz3", "ははは");
		if(b == false) {
			System.out.print(b);
			System.out.println(":NameNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":NameNGテスト失敗");
		}
	}
	public static void changeAgeOK() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserAge("kaz1", 120);
		if(b == true) {
			System.out.print(b);
			System.out.println(":AgeOKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":AgeOKテスト失敗");
		}
	}
	public static void changeAgeNG() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		boolean b = d.changeUserAge("kaz3", 120);
		if(b == false) {
			System.out.print(b);
			System.out.println(":AgeNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":AgeNGテスト失敗");
		}
	}
	public static void changeReset() {
		ChangeUserInfoDAO d = new ChangeUserInfoDAO();
		d.changeUserPass("kaz1", "1234");
		d.changeUserMail("kaz1", "a@a");
		d.changeUserName("kaz1", "松 和");
		d.changeUserAge("kaz1", 36);
	}
}
