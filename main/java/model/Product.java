package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
	private String productId;
	private String productName;
	private int price;
	private String distributorId;
	private Date saleDate;
	private Date updateDate;
	private String topImage;
	private List<String> detailImage;
	private String introduceComment;
	
	public Product() {}
	public Product(String productId, String productName, int price, String topImage) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.topImage = topImage;
	}
	
	public void setProductId(String productId) { this.productId = productId; }
	public void setProductName(String productName) { this.productName = productName; }
	public void setPrice(int price) { this.price = price; }
	public void setDistributorId(String distributorId) { this.distributorId = distributorId; }
	public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
	public void setTopImage(String topImage) { this.topImage = topImage; }
	public void setDetailImage(List<String> detailImage) { this.detailImage = detailImage; }
	public void setIntroduceComment(String introduceComment) { this.introduceComment = introduceComment; }
	
	public String getProductId() { return productId; }
	public String getProductName() { return productName; }
	public int getPrice() { return price; }
	public String getDistributorId() { return distributorId; }
	public Date getSaleDate() { return saleDate; }
	public Date getUpdateDate() { return updateDate; }
	public String getTopImage() { return topImage; }
	public List<String> getDetailImage() { return detailImage; }
	public String getIntroduceComment() { return introduceComment; }
}
