package model;

import java.io.Serializable;

// 評価コメントのjavabeans

public class EvaluationComment implements Serializable{
	private String userId;
	private String productId;
	private String evaComment;
	private java.sql.Date commentDate;
	
	public EvaluationComment() { }
	
	public EvaluationComment(String userId, String productId, String evaComment, java.sql.Date commentDate) {
		this.userId = userId;
		this.productId = productId;
		this.evaComment = evaComment;
		this.commentDate = commentDate;
	}

	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }
	public String getEvaComment() { return evaComment; }
	public void setEvaComment(String evaComment) { this.evaComment = evaComment; }
	public java.sql.Date getCommentDate() { return commentDate; }
	public void setCommentDate(java.sql.Date commentDate) { this.commentDate = commentDate; }
}
