package model;

import DAO.EvaluationCommentDeleteDAO;

// コメント投稿を処理するクラス
// 記述をまとめる為に作成したクラスで変更途中

public class EvaluationCommentLogic {
	public void commentPost(User user) {}
	public void commentPostedCheck() {}
	public void commentRead() {}
	public boolean commentDelete(String productId, String userId) {
		EvaluationCommentDeleteDAO dDao = new EvaluationCommentDeleteDAO();
		boolean delDone = dDao.CommentDelete(productId, userId);
		return delDone;
	}
	public void commentUpload() {}
}
