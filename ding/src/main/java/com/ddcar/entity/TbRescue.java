package com.ddcar.entity;

import java.io.Serializable;

public class TbRescue implements Serializable {
    private Long rescueId;

    private Long userId;

    private String rescueAddress;

    private String rescueTime;

    private Integer branchId;

    private Long wangUserId;

    private Integer status;

    private String repairPhone;

    private String repairName;

    private String reasonMsg;

    private Integer deleteFlag;

    private String createBy;

    private String createTime;

    private String modifyBy;

    private String modifyTime;

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Long getRescueId() {
        return rescueId;
    }

    public void setRescueId(Long rescueId) {
        this.rescueId = rescueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRescueAddress() {
        return rescueAddress;
    }

    public void setRescueAddress(String rescueAddress) {
        this.rescueAddress = rescueAddress == null ? null : rescueAddress.trim();
    }

    public String getRescueTime() {
        return rescueTime;
    }

    public void setRescueTime(String rescueTime) {
        this.rescueTime = rescueTime == null ? null : rescueTime.trim();
    }

    public Long getWangUserId() {
        return wangUserId;
    }

    public void setWangUserId(Long wangUserId) {
        this.wangUserId = wangUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone == null ? null : repairPhone.trim();
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName == null ? null : repairName.trim();
    }

    public String getReasonMsg() {
        return reasonMsg;
    }

    public void setReasonMsg(String reasonMsg) {
        this.reasonMsg = reasonMsg == null ? null : reasonMsg.trim();
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