package test;

import DAO.UserRegisterDAO;

public class UserRegisterDAOTest {
	public static void main(String args[]) {
		testA(); // 登録成功の場合
		testN(); // 登録失敗の場合
	}
	public static void testA() {
		UserRegisterDAO d = new UserRegisterDAO();
		boolean b = d.userRegister("kaz5", "1234", "b@b", "和 松", 30);
		if(b == true) {
			System.out.print(b);
			System.out.println(":Aテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Aテスト失敗");
		}
	}
	public static void testN() {
		UserRegisterDAO d = new UserRegisterDAO();
		boolean b = d.userRegister("kaz1", "1234", "b@b", "和 松", 30);
		if(b == false) {
			System.out.print(b);
			System.out.println(":Nテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Nテスト失敗");
		}
	}
}
