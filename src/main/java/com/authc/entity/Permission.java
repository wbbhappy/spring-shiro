package com.authc.entity;

public class Permission {
	private int permId;
	private String permName;

	public Permission() {
		super();
	}

	public Permission(int permId, String permName) {
		super();
		this.permId = permId;
		this.permName = permName;
	}

	public int getPermId() {
		return permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermId(int permId) {
		this.permId = permId;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
}
