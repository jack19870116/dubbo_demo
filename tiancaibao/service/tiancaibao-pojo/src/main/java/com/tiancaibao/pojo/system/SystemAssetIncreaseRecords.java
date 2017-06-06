package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemAssetIncreaseRecords implements Serializable {
    private Long id;

    private Long userId;

    private Long rate;

    private Long amount;

    private Long currentUserAmount;

    private Date date;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Long couponIncrease;

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

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCurrentUserAmount() {
        return currentUserAmount;
    }

    public void setCurrentUserAmount(Long currentUserAmount) {
        this.currentUserAmount = currentUserAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Long getCouponIncrease() {
        return couponIncrease;
    }

    public void setCouponIncrease(Long couponIncrease) {
        this.couponIncrease = couponIncrease;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", rate=").append(rate);
        sb.append(", amount=").append(amount);
        sb.append(", currentUserAmount=").append(currentUserAmount);
        sb.append(", date=").append(date);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", couponIncrease=").append(couponIncrease);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}