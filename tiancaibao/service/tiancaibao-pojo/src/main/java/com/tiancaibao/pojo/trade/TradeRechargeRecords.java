package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TradeRechargeRecords implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 充值bill id
     */
    private Long rechargeBillId;

    /**
     * 充值金额
     */
    private Long amount;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 是汇付确认的订单
     */
    private Integer isHuifu;

    private String orderCode;

    private Date deletedAt;

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

    public Long getRechargeBillId() {
        return rechargeBillId;
    }

    public void setRechargeBillId(Long rechargeBillId) {
        this.rechargeBillId = rechargeBillId;
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

    public Integer getIsHuifu() {
        return isHuifu;
    }

    public void setIsHuifu(Integer isHuifu) {
        this.isHuifu = isHuifu;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", rechargeBillId=").append(rechargeBillId);
        sb.append(", amount=").append(amount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", isHuifu=").append(isHuifu);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}