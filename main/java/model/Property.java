package model;

import java.io.Serializable;

// 各ユーザーの購入物のjavabeans

public class Property implements Serializable{
	private int propertyNumber;
	private String userId;
	private String productId;
	
	public Property() { }
	public Property(int propertyNumber, String userId, String productId) {
		this.propertyNumber = propertyNumber;
		this.userId = userId;
		this.productId = productId;
	}

	public int getPropertyNumber() { return propertyNumber; }
	public void setPropertyNumber(int propertyNumber) { this.propertyNumber = propertyNumber; }
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }
	
}
