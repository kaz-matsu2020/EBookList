package test;

import java.util.List;

import model.EvaluationComment;
import model.IndicateProductLogic;
import model.Product;

public class IndicateProductLogicTest {
	public static void main(String args[]) {
		testComment(); // 
		testDetail(); // 
		testDistributorName(); //
	}
	public static void testComment() {
		IndicateProductLogic d = new IndicateProductLogic();
		List<EvaluationComment> l = d.IndicateComment("E001");
		if(l != null) {
			System.out.print(l);
			System.out.println(":テスト成功");
		} else {
			System.out.print(l);
			System.out.println(":テスト失敗");
		}
	}
	public static void testDetail() {
		IndicateProductLogic d = new IndicateProductLogic();
		Product p = d.IndicateDetail("E001");
		if(p != null) {
			System.out.print(p);
			System.out.println(":テスト成功");
		} else {
			System.out.print(p);
			System.out.println(":テスト失敗");
		}
	}
	public static void testDistributorName() {
		IndicateProductLogic d = new IndicateProductLogic();
		String s = d.IndicateDistributorName("E001");
		if(s != null) {
			System.out.print(s);
			System.out.println(":テスト成功");
		} else {
			System.out.print(s);
			System.out.println(":テスト失敗");
		}
	}
}
