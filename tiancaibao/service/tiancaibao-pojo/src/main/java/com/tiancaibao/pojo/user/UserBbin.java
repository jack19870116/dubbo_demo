package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserBbin implements Serializable {
    private Long id;

    private Long userId;

    private Integer bbinAmount;

    private Long amount;

    private Date redeemAt;

    private Date createdAt;

    private Date updatedAt;

    private Byte type;

    private Date useBbinAt;

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

    public Integer getBbinAmount() {
        return bbinAmount;
    }

    public void setBbinAmount(Integer bbinAmount) {
        this.bbinAmount = bbinAmount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getRedeemAt() {
        return redeemAt;
    }

    public void setRedeemAt(Date redeemAt) {
        this.redeemAt = redeemAt;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getUseBbinAt() {
        return useBbinAt;
    }

    public void setUseBbinAt(Date useBbinAt) {
        this.useBbinAt = useBbinAt;
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
        sb.append(", bbinAmount=").append(bbinAmount);
        sb.append(", amount=").append(amount);
        sb.append(", redeemAt=").append(redeemAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", type=").append(type);
        sb.append(", useBbinAt=").append(useBbinAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}