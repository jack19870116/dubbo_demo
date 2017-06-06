package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TradeWithdrawBills implements Serializable {
    private Long id;

    private Long userId;

    private Long amount;

    private String status;

    private String huifuStatus;

    private Long isWeekend;

    private Float payFee;

    private Date confirmedAt;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String orderCode;

    private String paytypeid;

    private Long days;

    private String ip;

    private String ipInfo;

    private String client;

    private String currentCycle;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getHuifuStatus() {
        return huifuStatus;
    }

    public void setHuifuStatus(String huifuStatus) {
        this.huifuStatus = huifuStatus == null ? null : huifuStatus.trim();
    }

    public Long getIsWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(Long isWeekend) {
        this.isWeekend = isWeekend;
    }

    public Float getPayFee() {
        return payFee;
    }

    public void setPayFee(Float payFee) {
        this.payFee = payFee;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getPaytypeid() {
        return paytypeid;
    }

    public void setPaytypeid(String paytypeid) {
        this.paytypeid = paytypeid == null ? null : paytypeid.trim();
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo == null ? null : ipInfo.trim();
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public String getCurrentCycle() {
        return currentCycle;
    }

    public void setCurrentCycle(String currentCycle) {
        this.currentCycle = currentCycle == null ? null : currentCycle.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", huifuStatus=").append(huifuStatus);
        sb.append(", isWeekend=").append(isWeekend);
        sb.append(", payFee=").append(payFee);
        sb.append(", confirmedAt=").append(confirmedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", paytypeid=").append(paytypeid);
        sb.append(", days=").append(days);
        sb.append(", ip=").append(ip);
        sb.append(", ipInfo=").append(ipInfo);
        sb.append(", client=").append(client);
        sb.append(", currentCycle=").append(currentCycle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}