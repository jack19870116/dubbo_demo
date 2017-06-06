package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserBlackLists implements Serializable {
    private Integer id;

    /**
     * 黑名单UserID
     */
    private Integer userId;

    /**
     * 提现＝1
     */
    private Byte blacklistType;

    /**
     * 坏账
     */
    private BigDecimal badAmount;

    /**
     * 与程序员有关
     */
    private Integer iserror;

    private Long lockAmount;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getBlacklistType() {
        return blacklistType;
    }

    public void setBlacklistType(Byte blacklistType) {
        this.blacklistType = blacklistType;
    }

    public BigDecimal getBadAmount() {
        return badAmount;
    }

    public void setBadAmount(BigDecimal badAmount) {
        this.badAmount = badAmount;
    }

    public Integer getIserror() {
        return iserror;
    }

    public void setIserror(Integer iserror) {
        this.iserror = iserror;
    }

    public Long getLockAmount() {
        return lockAmount;
    }

    public void setLockAmount(Long lockAmount) {
        this.lockAmount = lockAmount;
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
        sb.append(", blacklistType=").append(blacklistType);
        sb.append(", badAmount=").append(badAmount);
        sb.append(", iserror=").append(iserror);
        sb.append(", lockAmount=").append(lockAmount);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}