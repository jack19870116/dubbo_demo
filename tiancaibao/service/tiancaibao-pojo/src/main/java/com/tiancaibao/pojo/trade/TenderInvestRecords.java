package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TenderInvestRecords implements Serializable {
    private Long id;

    private Long invitedByUserId;

    private Long userId;

    private Long investBillId;

    private Long amount;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Integer days;

    private Long rate;

    private Date expireDate;

    private Long interest;

    private String productSign;

    private String status;

    private Integer couponId;

    private String orderCode;

    private String contractsCode;

    private Byte isAutoInvest;

    private String ip;

    private Integer reinvest;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvitedByUserId() {
        return invitedByUserId;
    }

    public void setInvitedByUserId(Long invitedByUserId) {
        this.invitedByUserId = invitedByUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvestBillId() {
        return investBillId;
    }

    public void setInvestBillId(Long investBillId) {
        this.investBillId = investBillId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public String getProductSign() {
        return productSign;
    }

    public void setProductSign(String productSign) {
        this.productSign = productSign == null ? null : productSign.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getContractsCode() {
        return contractsCode;
    }

    public void setContractsCode(String contractsCode) {
        this.contractsCode = contractsCode == null ? null : contractsCode.trim();
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

    public Integer getReinvest() {
        return reinvest;
    }

    public void setReinvest(Integer reinvest) {
        this.reinvest = reinvest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", invitedByUserId=").append(invitedByUserId);
        sb.append(", userId=").append(userId);
        sb.append(", investBillId=").append(investBillId);
        sb.append(", amount=").append(amount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", days=").append(days);
        sb.append(", rate=").append(rate);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", interest=").append(interest);
        sb.append(", productSign=").append(productSign);
        sb.append(", status=").append(status);
        sb.append(", couponId=").append(couponId);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", contractsCode=").append(contractsCode);
        sb.append(", isAutoInvest=").append(isAutoInvest);
        sb.append(", ip=").append(ip);
        sb.append(", reinvest=").append(reinvest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}