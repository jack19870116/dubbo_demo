package com.tiancaibao.pojo.integral;

import java.io.Serializable;
import java.util.Date;

public class IntegralTalentRecords implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 变化之
     */
    private Long value;

    /**
     * 变更后，用户当前天才值
     */
    private Long userCurrentValue;

    /**
     * 变更日期
     */
    private Date date;

    private Date createdAt;

    private Date updatedAt;

    private Integer sourceId;

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

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getUserCurrentValue() {
        return userCurrentValue;
    }

    public void setUserCurrentValue(Long userCurrentValue) {
        this.userCurrentValue = userCurrentValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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
        sb.append(", value=").append(value);
        sb.append(", userCurrentValue=").append(userCurrentValue);
        sb.append(", date=").append(date);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}