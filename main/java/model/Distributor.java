package model;

import java.io.Serializable;

public class Distributor implements Serializable{
	private String distributorId;
	private String pass;
	private String mail;
	private String distributorName;
	private String image;
	
	public Distributor() { }

	public String getDistributorId() { return distributorId; }
	public void setDistributorId(String distributorId) { this.distributorId = distributorId; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public String getMail() { return mail; }
	public void setMail(String mail) { this.mail = mail; }
	public String getDistributorName() { return distributorName; }
	public void setDistributorName(String distributorName) { this.distributorName = distributorName; }
	public String getImage() { return image; }
	public void setImage(String image) { this.image = image; }
	
}
