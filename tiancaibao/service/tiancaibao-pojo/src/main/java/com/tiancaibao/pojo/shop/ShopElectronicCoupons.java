package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopElectronicCoupons implements Serializable {
    private Integer id;

    private Integer electronicCouponCategoryId;

    private Integer amount;

    private Date startDate;

    private Date endDate;

    private String exchangeCdkey;

    private String source;

    private Date updatedAt;

    private Integer userId;

    /**
     * 激活码
     */
    private String activateCdkey;

    private Date createdAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getElectronicCouponCategoryId() {
        return electronicCouponCategoryId;
    }

    public void setElectronicCouponCategoryId(Integer electronicCouponCategoryId) {
        this.electronicCouponCategoryId = electronicCouponCategoryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getExchangeCdkey() {
        return exchangeCdkey;
    }

    public void setExchangeCdkey(String exchangeCdkey) {
        this.exchangeCdkey = exchangeCdkey == null ? null : exchangeCdkey.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivateCdkey() {
        return activateCdkey;
    }

    public void setActivateCdkey(String activateCdkey) {
        this.activateCdkey = activateCdkey == null ? null : activateCdkey.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", electronicCouponCategoryId=").append(electronicCouponCategoryId);
        sb.append(", amount=").append(amount);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", exchangeCdkey=").append(exchangeCdkey);
        sb.append(", source=").append(source);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", userId=").append(userId);
        sb.append(", activateCdkey=").append(activateCdkey);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}