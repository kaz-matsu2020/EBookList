package test;

import java.util.List;

import DAO.EvaluationCommentReadDAO;
import model.EvaluationComment;

public class EvaluationCommentReadDAOTest {
	public static void main(String args[]) {
		testA(); // コメントがある場合のテスト
		testN(); // コメントがない場合のテスト
	}
	public static void testA() {
		EvaluationCommentReadDAO d = new EvaluationCommentReadDAO();
		List<EvaluationComment> l = d.ReadCommentList("E001");
		if(l != null) {
			System.out.print(l);
			System.out.println(":コメントありテスト成功");
		} else {
			System.out.print(l);
			System.out.println(":コメントありテスト失敗");
		}
	}
	public static void testN() {
		EvaluationCommentReadDAO d = new EvaluationCommentReadDAO();
		List<EvaluationComment> l = d.ReadCommentList("E002");
		if(l != null) {
			System.out.print(l);
			System.out.println(":コメントなしテスト成功");
		} else {
			System.out.print(l);
			System.out.println(":コメントなしテスト失敗");
		}
		
	}
}
