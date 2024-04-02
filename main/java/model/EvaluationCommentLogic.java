package model;

import DAO.EvaluationCommentDeleteDAO;

/**
 * コメント投稿を処理するクラス
 * 記述をまとめる為に作成したクラスで変更途中
 * @author kazuo
 */

public class EvaluationCommentLogic {
	public void commentPost(User user) {}
	public void commentPostedCheck() {}
	public void commentRead() {}
	
	/**
	 * commentDelete
	 * @param productId 文字列
	 * @param userId 文字列
	 * @return 引数に対応したコメントを削除できたらtrue,失敗すればfalse
	 */
	public boolean commentDelete(String productId, String userId) {
		EvaluationCommentDeleteDAO dDao = new EvaluationCommentDeleteDAO();
		boolean delDone = dDao.CommentDelete(productId, userId);
		return delDone;
	}
	public void commentUpload() {}
}
