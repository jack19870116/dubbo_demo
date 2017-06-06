package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.Date;

public class TradeRechargeBills implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 充值金额
     */
    private Long amount;

    private String status;

    /**
     * 支付orderid
     */
    private String orderid;

    private Date confirmedAt;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    /**
     * 汇付对账过
     */
    private Integer isHuifuChecked;

    private String paytypeid;

    private String orderCode;

    private Long days;

    private String ip;

    /**
     * 充值客户端
     */
    private String client;

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

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
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

    public Integer getIsHuifuChecked() {
        return isHuifuChecked;
    }

    public void setIsHuifuChecked(Integer isHuifuChecked) {
        this.isHuifuChecked = isHuifuChecked;
    }

    public String getPaytypeid() {
        return paytypeid;
    }

    public void setPaytypeid(String paytypeid) {
        this.paytypeid = paytypeid == null ? null : paytypeid.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
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
        sb.append(", orderid=").append(orderid);
        sb.append(", confirmedAt=").append(confirmedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", isHuifuChecked=").append(isHuifuChecked);
        sb.append(", paytypeid=").append(paytypeid);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", days=").append(days);
        sb.append(", ip=").append(ip);
        sb.append(", client=").append(client);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}