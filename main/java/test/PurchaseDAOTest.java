package test;

import DAO.PurchaseDAO;

public class PurchaseDAOTest {
	public static void main(String args[]) {
		testA(); // まだ購入していない場合
		testN(); // 購入済みの場合
	}
	public static void testA() {
		PurchaseDAO d = new PurchaseDAO();
		boolean b = d.execute("kaz1", "E002");
		if(b == true) {
			System.out.print(b);
			System.out.println(":まだテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":まだテスト失敗");
		}
	}
	public static void testN() {
		PurchaseDAO d = new PurchaseDAO();
		boolean b = d.execute("kaz1", "E002");
		if(b == false) {
			System.out.print(b);
			System.out.println(":済みテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":済みテスト失敗");
		}
	}
}
