package com.ddcar.entity;


import java.io.Serializable;

public class TbManager implements Serializable {

  private long managerId;
  private String userAccount;
  private String userPassword;
  private String userName;
  private String createTime;
  private long uRole;
  private long deleteFlag;
  private long cityId;
  private long uStatus;
  private long companyId;
  private TbBranch branch;
  private String company;
  private String phone;
  private long roleType;
  private String createBy;
  private String modifyBy;
  private String modifyTime;
  private String lastTime;

  public String getLastTime() {
    return lastTime;
  }

  public void setLastTime(String lastTime) {
    this.lastTime = lastTime;
  }

  public TbBranch getBranch() {
    return branch;
  }

  public void setBranch(TbBranch branch) {
    this.branch = branch;
  }

  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
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

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public long getuRole() {
    return uRole;
  }

  public void setuRole(long uRole) {
    this.uRole = uRole;
  }

  public long getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(long deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public long getCityId() {
    return cityId;
  }

  public void setCityId(long cityId) {
    this.cityId = cityId;
  }

  public long getuStatus() {
    return uStatus;
  }

  public void setuStatus(long uStatus) {
    this.uStatus = uStatus;
  }

  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public long getRoleType() {
    return roleType;
  }

  public void setRoleType(long roleType) {
    this.roleType = roleType;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public String getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(String modifyBy) {
    this.modifyBy = modifyBy;
  }

  public String getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(String modifyTime) {
    this.modifyTime = modifyTime;
  }
}
