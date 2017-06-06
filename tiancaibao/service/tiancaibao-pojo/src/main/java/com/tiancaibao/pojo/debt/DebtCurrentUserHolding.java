package com.tiancaibao.pojo.debt;

import java.io.Serializable;
import java.util.Date;

public class DebtCurrentUserHolding implements Serializable {
    /**   id **/
    private Long id;

    /**   user_id **/
    private Long userId;

    /** 投资记录id  invest_id **/
    private Long investId;

    /** 债权id  debt_original_asset_id **/
    private Long debtOriginalAssetId;

    /** 当前持有份额  current_count **/
    private Integer currentCount;

    /** 原有份额  original_count **/
    private Integer originalCount;

    /** 持有金额  amount **/
    private Long amount;

    /** 原持有金额  original_amount **/
    private Long originalAmount;

    /**   other_info1 **/
    private String otherInfo1;

    /**   other_info2 **/
    private String otherInfo2;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /**   deleted_at **/
    private Date deletedAt;

    /** 冻结的份额  frozen_count **/
    private Integer frozenCount;

    /** 债转id  transfer_id **/
    private Long transferId;

    /**   tableName: debt_current_user_holding   **/
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

    /**   债权id  debt_original_asset_id   **/
    public Long getDebtOriginalAssetId() {
        return debtOriginalAssetId;
    }

    /**   债权id  debt_original_asset_id   **/
    public void setDebtOriginalAssetId(Long debtOriginalAssetId) {
        this.debtOriginalAssetId = debtOriginalAssetId;
    }

    /**   当前持有份额  current_count   **/
    public Integer getCurrentCount() {
        return currentCount;
    }

    /**   当前持有份额  current_count   **/
    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    /**   原有份额  original_count   **/
    public Integer getOriginalCount() {
        return originalCount;
    }

    /**   原有份额  original_count   **/
    public void setOriginalCount(Integer originalCount) {
        this.originalCount = originalCount;
    }

    /**   持有金额  amount   **/
    public Long getAmount() {
        return amount;
    }

    /**   持有金额  amount   **/
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**   原持有金额  original_amount   **/
    public Long getOriginalAmount() {
        return originalAmount;
    }

    /**   原持有金额  original_amount   **/
    public void setOriginalAmount(Long originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**     other_info1   **/
    public String getOtherInfo1() {
        return otherInfo1;
    }

    /**     other_info1   **/
    public void setOtherInfo1(String otherInfo1) {
        this.otherInfo1 = otherInfo1 == null ? null : otherInfo1.trim();
    }

    /**     other_info2   **/
    public String getOtherInfo2() {
        return otherInfo2;
    }

    /**     other_info2   **/
    public void setOtherInfo2(String otherInfo2) {
        this.otherInfo2 = otherInfo2 == null ? null : otherInfo2.trim();
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

    /**   冻结的份额  frozen_count   **/
    public Integer getFrozenCount() {
        return frozenCount;
    }

    /**   冻结的份额  frozen_count   **/
    public void setFrozenCount(Integer frozenCount) {
        this.frozenCount = frozenCount;
    }

    /**   债转id  transfer_id   **/
    public Long getTransferId() {
        return transferId;
    }

    /**   债转id  transfer_id   **/
    public void setTransferId(Long transferId) {
        this.transferId = transferId;
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
        sb.append(", currentCount=").append(currentCount);
        sb.append(", originalCount=").append(originalCount);
        sb.append(", amount=").append(amount);
        sb.append(", originalAmount=").append(originalAmount);
        sb.append(", otherInfo1=").append(otherInfo1);
        sb.append(", otherInfo2=").append(otherInfo2);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", frozenCount=").append(frozenCount);
        sb.append(", transferId=").append(transferId);
        sb.append("]");
        return sb.toString();
    }
}