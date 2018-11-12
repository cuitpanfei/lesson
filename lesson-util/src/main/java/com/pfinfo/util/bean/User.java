package com.pfinfo.util.bean;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1384152065547903420L;
	
	private Integer id;
	
	private String userName;
	
	private String userPasswd;
	
	private String description;
	
	public User(){
		
	}

	public User(Integer id, String userName, String userPasswd) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPasswd = userPasswd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ",\tuserName=" + userName + ",\tuserPasswd="
				+ userPasswd + ",\tdescription=" + description + "]";
	}
}
