package test;

import DAO.PostedCheckDAO;

public class PostedCheckDAOTest {
	public static void main(String args[]) {
		testA(); // コメント済みの場合
		testN(); // コメントまだの場合
	}
	public static void testA() {
		PostedCheckDAO d = new PostedCheckDAO();
		boolean b = d.PostedCheck("kaz1", "E001");
		if(b == true) {
			System.out.print(b);
			System.out.println(":済みテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":済みテスト失敗");
		}
	}
	public static void testN() {
		PostedCheckDAO d = new PostedCheckDAO();
		boolean b = d.PostedCheck("kaz1", "E002");
		if(b == false) {
			System.out.print(b);
			System.out.println(":まだテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":まだテスト失敗");
		}
	}
}
