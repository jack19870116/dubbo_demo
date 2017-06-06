package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TradeRedeemBills implements Serializable {
    private Long id;

    private String client;

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

    private String investid;

    private String ip;

    /**
     * 是否是复投 0不是 1是复投
     */
    private Integer reinvest;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
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

    public String getInvestid() {
        return investid;
    }

    public void setInvestid(String investid) {
        this.investid = investid == null ? null : investid.trim();
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
        sb.append(", client=").append(client);
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
        sb.append(", investid=").append(investid);
        sb.append(", ip=").append(ip);
        sb.append(", reinvest=").append(reinvest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}