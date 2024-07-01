package test;

import DAO.UserIdOverlapCheckDAO;

public class UserIdOverlapCheckDAOTest {
	public static void main(String args[]) {
		testA(); // 登録済みuserIDの場合
		testN(); // 未登録userIDの場合
	}
	public static void testA() {
		UserIdOverlapCheckDAO d = new UserIdOverlapCheckDAO();
		boolean b = d.userIdOverlapCheck("kaz1");
		if(b == true) {
			System.out.print(b);
			System.out.println(":Aテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Aテスト失敗");
		}
	}
	public static void testN() {
		UserIdOverlapCheckDAO d = new UserIdOverlapCheckDAO();
		boolean b = d.userIdOverlapCheck("kaz5");
		if(b == false) {
			System.out.print(b);
			System.out.println(":Nテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":Nテスト失敗");
		}
	}
}
