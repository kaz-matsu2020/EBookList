package test;

import java.util.List;

import DAO.PropertyDAO;
import model.Property;

public class PropertyDAOTest {
	public static void main(String args[]) {
		test();
	}
	public static void test() {
		PropertyDAO d = new PropertyDAO();
		List<Property> l = d.getProperty("kaz1");
		if(l != null) {
			System.out.println(l);
			System.out.println(":テスト成功");
		} else {
			System.out.println(l);
			System.out.println(":テスト失敗");
		}
	}
}
