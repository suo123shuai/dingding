package com.ddcar.entity;

import java.io.Serializable;

public class Manager implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 600888011950568523L;
	private Long managerId;
	private String userAccount;
	private String userPassword;
	private String userName;
	private String createTime;
	private Integer uRole;
	private Integer deleteFlag;
	private Long cityId;
	private Integer uStatus;
	 
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getuRole() {
		return uRole;
	}

	public void setuRole(Integer uRole) {
		this.uRole = uRole;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getuStatus() {
		return uStatus;
	}

	public void setuStatus(Integer uStatus) {
		this.uStatus = uStatus;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
