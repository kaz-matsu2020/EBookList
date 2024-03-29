package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

// 商品概要のjavabeans

public class Product implements Serializable {
	private String productId;
	private String name;
	private int price;
	private String distributorId;
	private Date saleDate;
	private Date updateDate;
	private String topImage;
	private List<String> detailImage;
	private String introduceComment;
	
	public Product() {}
	public Product(String productId) {
		this.productId = productId;
	}
	public Product(List<String> imageList) {
		this.detailImage = imageList;
	}
	public Product(String productId, String name, int price, String topImage) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.topImage = topImage;
	}
	public Product(String productId, String name, int price, String distributorId, Date saleDate, Date updateDate,String topImage, String introduceComment) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.distributorId = distributorId;
		this.saleDate = saleDate;
		this.updateDate = updateDate;
		this.topImage = topImage;
		this.introduceComment = introduceComment;
	}
	
	public void setProductId(String productId) { this.productId = productId; }
	public void setName(String name) { this.name = name; }
	public void setPrice(int price) { this.price = price; }
	public void setDistributorId(String distributorId) { this.distributorId = distributorId; }
	public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }
	public void setTopImage(String topImage) { this.topImage = topImage; }
	public void setDetailImage(List<String> detailImage) { this.detailImage = detailImage; }
	public void setIntroduceComment(String introduceComment) { this.introduceComment = introduceComment; }
	
	public String getProductId() { return productId; }
	public String getName() { return name; }
	public int getPrice() { return price; }
	public String getDistributorId() { return distributorId; }
	public Date getSaleDate() { return saleDate; }
	public Date getUpdateDate() { return updateDate; }
	public String getTopImage() { return topImage; }
	public List<String> getDetailImage() { return detailImage; }
	public String getIntroduceComment() { return introduceComment; }
}
