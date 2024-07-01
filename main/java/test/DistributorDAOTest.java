package test;

import DAO.DistributorDAO;

public class DistributorDAOTest {
	public static void main(String args[]) {
		testOK(); // Distributorが見つかる場合のテスト
		testNG(); // Distributorが見つからない場合のテスト
	}
	public static void testOK() {
		DistributorDAO d = new DistributorDAO();
		String s = d.ReadDistributorName("D001");
		if(s != null) {
			System.out.print(s);
			System.out.println(":テスト成功");
		} else {
			System.out.print(s);
			System.out.println(":テスト失敗");
		}
	}
	public static void testNG() {
		DistributorDAO d = new DistributorDAO();
		String s = d.ReadDistributorName("D004");
		if(s == null) {
			System.out.print(s);
			System.out.println(":テスト成功");
		} else {
			System.out.print(s);
			System.out.println(":テスト失敗");
		}
		
	}
}
