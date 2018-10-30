package com.ddcar.entity;

import java.io.Serializable;

public class TbInvoice implements Serializable {
    private Long invoiceId;

    private Long userId;

    private Long vehicleId;

    private Long vehicle2Id;

    private Integer vehicle1Status;

    private Integer vehicle2Status;

    private String imgPath;

    private String buyTime;

    private String repairTime;

    private Long wangnUesrid;

    private Integer deleteFlag;

    private String createBy;

    private String createTime;

    private String modifyBy;

    private String modifyTime;

    private String phone;

    private String userName;

    private String wangPhone;

    private String serialNumber;

    private String vin;

    private String gpsNumber;

    private String vehicleImg;

    private String vehicleBrand;

    private String vehicleNumber;

    private String wangName;

    public String getWangPhone() {
        return wangPhone;
    }

    public void setWangPhone(String wangPhone) {
        this.wangPhone = wangPhone;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getGpsNumber() {
        return gpsNumber;
    }

    public void setGpsNumber(String gpsNumber) {
        this.gpsNumber = gpsNumber;
    }

    public String getVehicleImg() {
        return vehicleImg;
    }

    public void setVehicleImg(String vehicleImg) {
        this.vehicleImg = vehicleImg;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getVehicle2Id() {
        return vehicle2Id;
    }

    public void setVehicle2Id(Long vehicle2Id) {
        this.vehicle2Id = vehicle2Id;
    }

    public Integer getVehicle1Status() {
        return vehicle1Status;
    }

    public void setVehicle1Status(Integer vehicle1Status) {
        this.vehicle1Status = vehicle1Status;
    }

    public Integer getVehicle2Status() {
        return vehicle2Status;
    }

    public void setVehicle2Status(Integer vehicle2Status) {
        this.vehicle2Status = vehicle2Status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime == null ? null : buyTime.trim();
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime == null ? null : repairTime.trim();
    }

    public Long getWangnUesrid() {
        return wangnUesrid;
    }

    public void setWangnUesrid(Long wangnUesrid) {
        this.wangnUesrid = wangnUesrid;
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

    public String getWangName() {
        return wangName;
    }

    public void setWangName(String wangName) {
        this.wangName = wangName;
    }
}