package com.tiancaibao.pojo.debt;

import java.io.Serializable;
import java.util.Date;

public class DebtCurrentTransfer implements Serializable {
    /**   id **/
    private Long id;

    /**   user_id **/
    private Long userId;

    /** 投资记录id  invest_id **/
    private Long investId;

    /** 对接债权id  debt_original_asset_id **/
    private Long debtOriginalAssetId;

    /** 债权利率  rate **/
    private Integer rate;

    /** 状态(1.生成记录2.部分转让3.全部转让)  status **/
    private Integer status;

    /** 原债权金额  original_amount **/
    private Long originalAmount;

    /** 当前持有债权金额  amount **/
    private Long amount;

    /** 原始持有份额  original_count **/
    private Integer originalCount;

    /** 当前持有份额  count **/
    private Integer count;

    /** 债权到期时间  end_date **/
    private Date endDate;

    /** 备用  other_info **/
    private String otherInfo;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /**   deleted_at **/
    private Date deletedAt;

    /** 0 未锁定 1 锁定  lock_status **/
    private Integer lockStatus;

    /** 用户持有表对应的ID  user_holding_id **/
    private Integer userHoldingId;

    /**   tableName: debt_current_transfer   **/
    private static final long serialVersionUID = 1L;

    /**     id   **/
    public Long getId() {
        return id;
    }

    /**     id   **/
    public void setId(Long id) {
        this.id = id;
    }

    /**     user_id   **/
    public Long getUserId() {
        return userId;
    }

    /**     user_id   **/
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**   投资记录id  invest_id   **/
    public Long getInvestId() {
        return investId;
    }

    /**   投资记录id  invest_id   **/
    public void setInvestId(Long investId) {
        this.investId = investId;
    }

    /**   对接债权id  debt_original_asset_id   **/
    public Long getDebtOriginalAssetId() {
        return debtOriginalAssetId;
    }

    /**   对接债权id  debt_original_asset_id   **/
    public void setDebtOriginalAssetId(Long debtOriginalAssetId) {
        this.debtOriginalAssetId = debtOriginalAssetId;
    }

    /**   债权利率  rate   **/
    public Integer getRate() {
        return rate;
    }

    /**   债权利率  rate   **/
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**   状态(1.生成记录2.部分转让3.全部转让)  status   **/
    public Integer getStatus() {
        return status;
    }

    /**   状态(1.生成记录2.部分转让3.全部转让)  status   **/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**   原债权金额  original_amount   **/
    public Long getOriginalAmount() {
        return originalAmount;
    }

    /**   原债权金额  original_amount   **/
    public void setOriginalAmount(Long originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**   当前持有债权金额  amount   **/
    public Long getAmount() {
        return amount;
    }

    /**   当前持有债权金额  amount   **/
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**   原始持有份额  original_count   **/
    public Integer getOriginalCount() {
        return originalCount;
    }

    /**   原始持有份额  original_count   **/
    public void setOriginalCount(Integer originalCount) {
        this.originalCount = originalCount;
    }

    /**   当前持有份额  count   **/
    public Integer getCount() {
        return count;
    }

    /**   当前持有份额  count   **/
    public void setCount(Integer count) {
        this.count = count;
    }

    /**   债权到期时间  end_date   **/
    public Date getEndDate() {
        return endDate;
    }

    /**   债权到期时间  end_date   **/
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**   备用  other_info   **/
    public String getOtherInfo() {
        return otherInfo;
    }

    /**   备用  other_info   **/
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    /**     created_at   **/
    public Date getCreatedAt() {
        return createdAt;
    }

    /**     created_at   **/
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**     updated_at   **/
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**     updated_at   **/
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**     deleted_at   **/
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**     deleted_at   **/
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**   0 未锁定 1 锁定  lock_status   **/
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**   0 未锁定 1 锁定  lock_status   **/
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**   用户持有表对应的ID  user_holding_id   **/
    public Integer getUserHoldingId() {
        return userHoldingId;
    }

    /**   用户持有表对应的ID  user_holding_id   **/
    public void setUserHoldingId(Integer userHoldingId) {
        this.userHoldingId = userHoldingId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", investId=").append(investId);
        sb.append(", debtOriginalAssetId=").append(debtOriginalAssetId);
        sb.append(", rate=").append(rate);
        sb.append(", status=").append(status);
        sb.append(", originalAmount=").append(originalAmount);
        sb.append(", amount=").append(amount);
        sb.append(", originalCount=").append(originalCount);
        sb.append(", count=").append(count);
        sb.append(", endDate=").append(endDate);
        sb.append(", otherInfo=").append(otherInfo);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", lockStatus=").append(lockStatus);
        sb.append(", userHoldingId=").append(userHoldingId);
        sb.append("]");
        return sb.toString();
    }
}