package com.ddcar.entity;

import java.io.Serializable;

public class TbInout implements Serializable {

    private Long inoutId;
    private Long vehicleId;
    private TbVehicle vehicle;
    private Integer fromId;
    private String state;
    private Long toId;
    private Integer type;
    private Integer inoutType;
    private Integer deleteFlag;
    private String createBy;
    private String createTime;
    private String modifyBy;
    private String modifyTime;

    public Long getInoutId() {
        return inoutId;
    }

    public void setInoutId(Long inoutId) {
        this.inoutId = inoutId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public TbVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(TbVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getInoutType() {
        return inoutType;
    }

    public void setInoutType(Integer inoutType) {
        this.inoutType = inoutType;
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
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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