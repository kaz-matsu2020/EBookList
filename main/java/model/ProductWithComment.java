package model;

import java.io.Serializable;
import java.util.List;

public class ProductWithComment implements Serializable{
	private String productId;
	private List<Product> productList;
	
	public ProductWithComment() { }

	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }
	public List<Product> getProductList() { return productList; }
	public void setProductList(List<Product> productList) { this.productList = productList; }
	
}
