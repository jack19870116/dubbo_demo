package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserSign implements Serializable {
    private Long id;

    private Integer activeId;

    private Long userId;

    /**
     * 签到计数器
     */
    private Short hitSum;

    /**
     * 当前累积的连续签到次数
     */
    private Short hitCur;

    /**
     * 最大连续签到次数
     */
    private Short hitMax;

    private Date modifiedDate;

    private String lists;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getHitSum() {
        return hitSum;
    }

    public void setHitSum(Short hitSum) {
        this.hitSum = hitSum;
    }

    public Short getHitCur() {
        return hitCur;
    }

    public void setHitCur(Short hitCur) {
        this.hitCur = hitCur;
    }

    public Short getHitMax() {
        return hitMax;
    }

    public void setHitMax(Short hitMax) {
        this.hitMax = hitMax;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getLists() {
        return lists;
    }

    public void setLists(String lists) {
        this.lists = lists == null ? null : lists.trim();
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
        sb.append(", activeId=").append(activeId);
        sb.append(", userId=").append(userId);
        sb.append(", hitSum=").append(hitSum);
        sb.append(", hitCur=").append(hitCur);
        sb.append(", hitMax=").append(hitMax);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", lists=").append(lists);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}