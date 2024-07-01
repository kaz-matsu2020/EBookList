package test;

import DAO.EvaluationCommentDeleteDAO;

public class EvaluationCommentDeleteDAOTest {
	public static void main(String args[]) {
		testOK(); // コメント削除成功のテスト
	}
	public static void testOK() {
		EvaluationCommentDeleteDAO d = new EvaluationCommentDeleteDAO();
		boolean b = d.CommentDelete("E001", "kaz1");
		if(b == true) {
			System.out.print(b);
			System.out.println(":OKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":OKテスト失敗");
		}
	}
}
