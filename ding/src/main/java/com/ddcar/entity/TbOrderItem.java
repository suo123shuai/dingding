package com.ddcar.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TbOrderItem implements Serializable {
    private Long orderItemId;

    private Long userId;

    private String orderId;

    private Long vehicleId;

    private Double cashDeposit;

    private Double rentMoney;

    private Double discount;

    private Integer deleteFlag;

    private String createBy;

    private String createTime;

    private String modifyBy;

    private String modifyTime;

    private String startRentalTime;

    private String stopRentalTime;

    private String serialNumber;

    private String model;

    private String type;

    private Long wangUserId;

    public Long getWangUserId() {
        return wangUserId;
    }

    public void setWangUserId(Long wangUserId) {
        this.wangUserId = wangUserId;
    }

    public String getStartRentalTime() {
        return startRentalTime;
    }

    public void setStartRentalTime(String startRentalTime) throws ParseException {
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startRentalTime);
        String format = new SimpleDateFormat("yyyy.MM.dd").format(parse);
        this.startRentalTime = format;
    }

    public String getStopRentalTime() {
        return stopRentalTime;
    }

    public void setStopRentalTime(String stopRentalTime) throws ParseException {
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stopRentalTime);
        String format = new SimpleDateFormat("yyyy.MM.dd").format(parse);
        this.stopRentalTime = format;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getCashDeposit() {
        return cashDeposit;
    }

    public void setCashDeposit(Double cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public Double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(Double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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