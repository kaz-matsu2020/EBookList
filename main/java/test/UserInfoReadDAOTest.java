package test;
import DAO.UserInfoReadDAO;
import model.User;

public class UserInfoReadDAOTest {
	public static void main(String args[]) {
		testA(); // 登録済みuserIDの場合
		testN(); // 未登録userIDの場合
	}
	public static void testA() {
		UserInfoReadDAO d = new UserInfoReadDAO();
		User u = d.readUserInfo("kaz1");
		if(u != null) {
			System.out.print(u);
			System.out.println(":Aテスト成功");
		} else {
			System.out.print(u);
			System.out.println(":Aテスト失敗");
		}
	}
	public static void testN() {
		UserInfoReadDAO d = new UserInfoReadDAO();
		User u = d.readUserInfo("kaz5");
		if(u == null) {
			System.out.print(u);
			System.out.println(":Nテスト成功");
		} else {
			System.out.print(u);
			System.out.println(":Nテスト失敗");
		}
	}
}
