package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopLottery implements Serializable {
    private Long id;

    private String goodsName;

    private Integer probability;

    private Byte lotteryLevel;

    private Integer lotteryOrder;

    private Integer lotteryStatus;

    private Integer lotteryType;

    private Double lotteryValue;

    private Integer activityId;

    private String lotteryImage;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Byte getLotteryLevel() {
        return lotteryLevel;
    }

    public void setLotteryLevel(Byte lotteryLevel) {
        this.lotteryLevel = lotteryLevel;
    }

    public Integer getLotteryOrder() {
        return lotteryOrder;
    }

    public void setLotteryOrder(Integer lotteryOrder) {
        this.lotteryOrder = lotteryOrder;
    }

    public Integer getLotteryStatus() {
        return lotteryStatus;
    }

    public void setLotteryStatus(Integer lotteryStatus) {
        this.lotteryStatus = lotteryStatus;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Double getLotteryValue() {
        return lotteryValue;
    }

    public void setLotteryValue(Double lotteryValue) {
        this.lotteryValue = lotteryValue;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getLotteryImage() {
        return lotteryImage;
    }

    public void setLotteryImage(String lotteryImage) {
        this.lotteryImage = lotteryImage == null ? null : lotteryImage.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", probability=").append(probability);
        sb.append(", lotteryLevel=").append(lotteryLevel);
        sb.append(", lotteryOrder=").append(lotteryOrder);
        sb.append(", lotteryStatus=").append(lotteryStatus);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", lotteryValue=").append(lotteryValue);
        sb.append(", activityId=").append(activityId);
        sb.append(", lotteryImage=").append(lotteryImage);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}