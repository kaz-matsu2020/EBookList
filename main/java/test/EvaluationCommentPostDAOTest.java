package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.EvaluationCommentPostDAO;
import model.EvaluationComment;

public class EvaluationCommentPostDAOTest {
	static Date commentDate = new Date();
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static String formattedDate = simpleDateFormat.format(commentDate);
    static java.sql.Date date = java.sql.Date.valueOf(formattedDate);
    
	public static void main(String args[]) {
		testOK(); // コメントのテスト
		doubleNG(); // コメントの二重投稿失敗の確認
	}
	public static void testOK() {
		EvaluationCommentPostDAO d = new EvaluationCommentPostDAO();
		EvaluationComment ac = new EvaluationComment("kaz1", "E001", "hehehe", date);
		boolean b = d.CommentPost(ac);
		if(b == true) {
			System.out.print(b);
			System.out.println(":OKテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":OKテスト失敗");
		}
	}
	public static void doubleNG() {
		EvaluationCommentPostDAO d = new EvaluationCommentPostDAO();
		EvaluationComment ac = new EvaluationComment("kaz1", "E001", "hehehe", date);
		boolean b = d.CommentPost(ac);
		if(b == false) {
			System.out.print(b);
			System.out.println(":doubleNGテスト成功");
		} else {
			System.out.print(b);
			System.out.println(":doubleNGテスト失敗");
		}
	}
}
