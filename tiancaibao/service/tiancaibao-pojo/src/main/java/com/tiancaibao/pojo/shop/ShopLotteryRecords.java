package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopLotteryRecords implements Serializable {
    private Long id;

    private Long userId;

    private Integer goodsId;

    private String goodsName;

    private Integer lotteryType;

    private Double lotteryValue;

    private Integer gquantity;

    private Long gtotalPrice;

    private Integer activityId;

    private Long lotteryBillId;

    private String gname;

    private Byte gzone;

    private String gaddr;

    private String gpostcode;

    private String gphone;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private String orderNumber;

    private Integer orderStatus;

    private String expressName;

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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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

    public Integer getGquantity() {
        return gquantity;
    }

    public void setGquantity(Integer gquantity) {
        this.gquantity = gquantity;
    }

    public Long getGtotalPrice() {
        return gtotalPrice;
    }

    public void setGtotalPrice(Long gtotalPrice) {
        this.gtotalPrice = gtotalPrice;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Long getLotteryBillId() {
        return lotteryBillId;
    }

    public void setLotteryBillId(Long lotteryBillId) {
        this.lotteryBillId = lotteryBillId;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Byte getGzone() {
        return gzone;
    }

    public void setGzone(Byte gzone) {
        this.gzone = gzone;
    }

    public String getGaddr() {
        return gaddr;
    }

    public void setGaddr(String gaddr) {
        this.gaddr = gaddr == null ? null : gaddr.trim();
    }

    public String getGpostcode() {
        return gpostcode;
    }

    public void setGpostcode(String gpostcode) {
        this.gpostcode = gpostcode == null ? null : gpostcode.trim();
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone == null ? null : gphone.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", lotteryValue=").append(lotteryValue);
        sb.append(", gquantity=").append(gquantity);
        sb.append(", gtotalPrice=").append(gtotalPrice);
        sb.append(", activityId=").append(activityId);
        sb.append(", lotteryBillId=").append(lotteryBillId);
        sb.append(", gname=").append(gname);
        sb.append(", gzone=").append(gzone);
        sb.append(", gaddr=").append(gaddr);
        sb.append(", gpostcode=").append(gpostcode);
        sb.append(", gphone=").append(gphone);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", expressName=").append(expressName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}