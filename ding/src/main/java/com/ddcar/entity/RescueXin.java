package com.ddcar.entity;

public class RescueXin {
    private String rescueAddress;
    private String createTime;
    private int status;
    private String branchPhone;
    private String branchaaddr;
    private String branchName;
    private String modifyTime;
    private String repairName;
    private String repairPhone;
    private long rescueId;

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public long getRescueId() {
        return rescueId;
    }

    public void setRescueId(long rescueId) {
        this.rescueId = rescueId;
    }

    public String getRescueAddress() {
        return rescueAddress;
    }

    public void setRescueAddress(String rescueAddress) {
        this.rescueAddress = rescueAddress;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }

    public String getBranchaaddr() {
        return branchaaddr;
    }

    public void setBranchaaddr(String branchaaddr) {
        this.branchaaddr = branchaaddr;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
