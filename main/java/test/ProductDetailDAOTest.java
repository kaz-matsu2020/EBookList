package test;

import DAO.ProductDetailDAO;
import model.Product;

public class ProductDetailDAOTest {
	public static void main(String args[]) {
		test();
	}
	public static void test() {
		ProductDetailDAO d = new ProductDetailDAO();
		Product p = d.ReadProductDetail("E001");
		if(p != null) {
			System.out.print(p);
			System.out.println(":テスト成功");
		} else {
			System.out.print(p);
			System.out.println(":テスト失敗");
		}
	}
}
