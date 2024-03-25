package model;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;
	private String pass;
	private String mail;
	private String name;
	private int age;
	
	public User() { }
	
	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}
	
	public void setUserId(String userId) { this.userId = userId; }
	public void setPass(String pass) { this.pass = pass; }
	public void setMail(String mail) { this.mail = mail; }
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	
	public String getUserId() { return userId; }
	public String getPass() { return pass; }
	public String getMail() { return mail; }
	public String getName() { return name; }
	public int getAge() { return age; }
	
}
