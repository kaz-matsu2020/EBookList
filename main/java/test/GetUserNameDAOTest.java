package test;

import DAO.GetUserNameDAO;

public class GetUserNameDAOTest {
	public static void main(String args[]) {
		testOK(); // userが見つかる場合のテスト
		testNG(); // userが見つからない場合のテスト
	}
	public static void testOK() {
		GetUserNameDAO d = new GetUserNameDAO();
		String s = d.execute("kaz1");
		if(s != null) {
			System.out.print(s);
			System.out.println(":テスト成功");
		} else {
			System.out.print(s);
			System.out.println(":テスト失敗");
		}
	}
	public static void testNG() {
		GetUserNameDAO d = new GetUserNameDAO();
		String s = d.execute("kaz2");
		if(s == null) {
			System.out.print(s);
			System.out.println(":テスト成功");
		} else {
			System.out.print(s);
			System.out.println(":テスト失敗");
		}
		
	}
}
