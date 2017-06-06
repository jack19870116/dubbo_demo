package com.tiancaibao.pojo.themis;

import java.io.Serializable;
import java.util.Date;

public class ThemisContracts implements Serializable {
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 保全id
     */
    private Long preservationId;

    /**
     * 合同金额
     */
    private Long amount;

    /**
     * 订单号:合同号
     */
    private String orderCode;

    /**
     * 合同编号
     */
    private String contractsCode;

    private String phone;

    /**
     * 1:活期 2:定期 3:服务协议
     */
    private Byte type;

    /**
     * 签订日期
     */
    private Date expireDate;

    /**
     * 用户确认时间戳
     */
    private Long checkTime;

    /**
     * 合同状态 1:未确认 2已确认
     */
    private Byte status;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPreservationId() {
        return preservationId;
    }

    public void setPreservationId(Long preservationId) {
        this.preservationId = preservationId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        sb.append(", userId=").append(userId);
        sb.append(", preservationId=").append(preservationId);
        sb.append(", amount=").append(amount);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", contractsCode=").append(contractsCode);
        sb.append(", phone=").append(phone);
        sb.append(", type=").append(type);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}