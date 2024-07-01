package test;

import DAO.UserCheckDAO;

public class UserCheckDAOTest {
	public static void main(String args[]) {
		testA(); // ログイン成功
		testN(); // ログイン失敗
	}
	public static void testA() {
		UserCheckDAO d = new UserCheckDAO();
		boolean b = d.execute("kaz1", "1234");
		if(b == true) {
			System.out.print(b);
			System.out.println(":Aテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Aテスト失敗");
		}
	}
	public static void testN() {
		UserCheckDAO d = new UserCheckDAO();
		boolean b = d.execute("kaz1", "5678");
		if(b == false) {
			System.out.print(b);
			System.out.println(":Nテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Nテスト失敗");
		}
	}
}
