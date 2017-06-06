package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TradeRedeemRecords implements Serializable {
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 赎回／到期份额
     */
    private Long amount;

    /**
     * 新浪订单号
     */
    private String sinaOrderId;

    /**
     * 产品计息时间，活期为1
     */
    private Integer days;

    /**
     * 产品标识
     */
    private String productSign;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    /**
     * 状态
     */
    private String status;

    private String orderCode;

    private String ip;

    /**
     * 是否是复投 0不是 1是复投
     */
    private Integer reinvest;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSinaOrderId() {
        return sinaOrderId;
    }

    public void setSinaOrderId(String sinaOrderId) {
        this.sinaOrderId = sinaOrderId == null ? null : sinaOrderId.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getProductSign() {
        return productSign;
    }

    public void setProductSign(String productSign) {
        this.productSign = productSign == null ? null : productSign.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", amount=").append(amount);
        sb.append(", sinaOrderId=").append(sinaOrderId);
        sb.append(", days=").append(days);
        sb.append(", productSign=").append(productSign);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", status=").append(status);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", ip=").append(ip);
        sb.append(", reinvest=").append(reinvest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}