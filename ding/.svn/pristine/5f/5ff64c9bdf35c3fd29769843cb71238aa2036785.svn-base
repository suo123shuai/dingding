package com.ddcar.entity;

import java.io.Serializable;

public class TbBranch implements Serializable {
    private Long branchId;

    private String branchName;

    private String branchType;

    private Long managerId;
    private TbManager tbManager;

    private Integer source;

    private String manager;

    private String branchPhone;

    private String branchaaddr;

    private double monthdiscount;

    private double discount;

    private double twodiscount;

    private Integer branchState;

    private Integer type;

    private Integer deleteFlag;

    private String createBy;

    private String createTime;

    private String modifyBy;

    private String modifyTime;

    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    private String userName;
    private String pwd;
    private Integer websiteType;
    private String items;
    private long parentId;
    private String x;
    private String y;
    private Integer juli;
    private String distance;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getJuli() {
        return juli;
    }

    public void setJuli(Integer juli) {
        int i = 0;
        if(juli > 1000){
            i = juli / 100;
            double i1 = (double)i/10;
            this.setDistance(i1 + "KM");
        }else {
            this.setDistance(juli + "M");
        }
        this.juli = i;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public double getMonthdiscount() {
        return monthdiscount;
    }

    public void setMonthdiscount(double monthdiscount) {
        this.monthdiscount = monthdiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTwodiscount() {
        return twodiscount;
    }

    public void setTwodiscount(double twodiscount) {
        this.twodiscount = twodiscount;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getWebsiteType() {
        return websiteType;
    }

    public void setWebsiteType(Integer websiteType) {
        this.websiteType = websiteType;
    }

    public Integer getType() {
        return type;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public TbManager getTbManager() {
        return tbManager;
    }

    public void setTbManager(TbManager tbManager) {
        this.tbManager = tbManager;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType == null ? null : branchType.trim();
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone == null ? null : branchPhone.trim();
    }

    public String getBranchaaddr() {
        return branchaaddr;
    }

    public void setBranchaaddr(String branchaaddr) {
        this.branchaaddr = branchaaddr == null ? null : branchaaddr.trim();
    }

    public Integer getBranchState() {
        return branchState;
    }

    public void setBranchState(Integer branchState) {
        this.branchState = branchState;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}