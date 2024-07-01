package test;

import java.util.List;

import DAO.ProductListReadDAO;
import model.Product;

public class ProductListReadDAOTest {
	public static void main(String args[]) {
		test();
	}
	public static void test() {
		ProductListReadDAO d = new ProductListReadDAO();
		List<Product> l = d.ReadProductList();
		if(l != null) {
			System.out.println(l);
			System.out.println(":テスト成功");
		} else {
			System.out.println(l);
			System.out.println(":テスト失敗");
		}
	}
}
