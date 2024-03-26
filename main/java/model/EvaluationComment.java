package model;

import java.io.Serializable;
import java.util.Date;

public class EvaluationComment implements Serializable{
	private String userId;
	private String productId;
	private String evaComment;
	private Date commentDate;
	
	public EvaluationComment() { }
	
	public EvaluationComment(String userId, String productId, String evaComment, Date commentDate) {
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
	public Date getCommentDate() { return commentDate; }
	public void setCommentDate(Date commentDate) { this.commentDate = commentDate; }
}
