package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TenderInvestBills implements Serializable {
    private Long id;

    private Long userId;

    private Long amount;

    private String status;

    private String yborderid;

    private Date confirmedAt;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Long days;

    private String orderCode;

    private Integer couponId;

    private Byte isAutoInvest;

    private String ip;

    private String ipInfo;

    private String ipRegion;

    private String client;

    private Integer reinvest;

    private Integer rate;

    private Long interest;

    private Long productSign;

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

    public String getYborderid() {
        return yborderid;
    }

    public void setYborderid(String yborderid) {
        this.yborderid = yborderid == null ? null : yborderid.trim();
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

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Byte getIsAutoInvest() {
        return isAutoInvest;
    }

    public void setIsAutoInvest(Byte isAutoInvest) {
        this.isAutoInvest = isAutoInvest;
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

    public String getIpRegion() {
        return ipRegion;
    }

    public void setIpRegion(String ipRegion) {
        this.ipRegion = ipRegion == null ? null : ipRegion.trim();
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public Integer getReinvest() {
        return reinvest;
    }

    public void setReinvest(Integer reinvest) {
        this.reinvest = reinvest;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getProductSign() {
        return productSign;
    }

    public void setProductSign(Long productSign) {
        this.productSign = productSign;
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
        sb.append(", yborderid=").append(yborderid);
        sb.append(", confirmedAt=").append(confirmedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", days=").append(days);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", couponId=").append(couponId);
        sb.append(", isAutoInvest=").append(isAutoInvest);
        sb.append(", ip=").append(ip);
        sb.append(", ipInfo=").append(ipInfo);
        sb.append(", ipRegion=").append(ipRegion);
        sb.append(", client=").append(client);
        sb.append(", reinvest=").append(reinvest);
        sb.append(", rate=").append(rate);
        sb.append(", interest=").append(interest);
        sb.append(", productSign=").append(productSign);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}