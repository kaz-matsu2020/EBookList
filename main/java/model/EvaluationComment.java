package model;

import java.io.Serializable;
import java.util.Date;

public class EvaluationComment implements Serializable{
	private String userId;
	private String product_id;
	private String evaComment;
	private Date commentDate;
	
	public EvaluationComment() { }

	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	public String getProduct_id() { return product_id; }
	public void setProduct_id(String product_id) { this.product_id = product_id; }
	public String getEvaComment() { return evaComment; }
	public void setEvaComment(String evaComment) { this.evaComment = evaComment; }
	public Date getCommentDate() { return commentDate; }
	public void setCommentDate(Date commentDate) { this.commentDate = commentDate; }
}
