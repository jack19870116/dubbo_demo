package com.tiancaibao.pojo.debt;

import java.io.Serializable;
import java.util.Date;

public class DebtCurrentReceive implements Serializable {
    /**   id **/
    private Long id;

    /**   user_id **/
    private Long userId;

    /** 原债权id  debt_original_asset_id **/
    private Long debtOriginalAssetId;

    /** 投资记录id  invest_id **/
    private Long investId;

    /** 转让人id  transfer_user_id **/
    private Long transferUserId;

    /** 本金  principal **/
    private Long principal;

    /** 利息  interest **/
    private Long interest;

    /** 状态  status **/
    private Integer status;

    /** 新浪请求号  request_no **/
    private String requestNo;

    /** 承接份额  count **/
    private Integer count;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /**   deleted_at **/
    private Date deletedAt;

    /** 债转的id  transfer_id **/
    private Long transferId;

    /**   tableName: debt_current_receive   **/
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

    /**   原债权id  debt_original_asset_id   **/
    public Long getDebtOriginalAssetId() {
        return debtOriginalAssetId;
    }

    /**   原债权id  debt_original_asset_id   **/
    public void setDebtOriginalAssetId(Long debtOriginalAssetId) {
        this.debtOriginalAssetId = debtOriginalAssetId;
    }

    /**   投资记录id  invest_id   **/
    public Long getInvestId() {
        return investId;
    }

    /**   投资记录id  invest_id   **/
    public void setInvestId(Long investId) {
        this.investId = investId;
    }

    /**   转让人id  transfer_user_id   **/
    public Long getTransferUserId() {
        return transferUserId;
    }

    /**   转让人id  transfer_user_id   **/
    public void setTransferUserId(Long transferUserId) {
        this.transferUserId = transferUserId;
    }

    /**   本金  principal   **/
    public Long getPrincipal() {
        return principal;
    }

    /**   本金  principal   **/
    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    /**   利息  interest   **/
    public Long getInterest() {
        return interest;
    }

    /**   利息  interest   **/
    public void setInterest(Long interest) {
        this.interest = interest;
    }

    /**   状态  status   **/
    public Integer getStatus() {
        return status;
    }

    /**   状态  status   **/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**   新浪请求号  request_no   **/
    public String getRequestNo() {
        return requestNo;
    }

    /**   新浪请求号  request_no   **/
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**   承接份额  count   **/
    public Integer getCount() {
        return count;
    }

    /**   承接份额  count   **/
    public void setCount(Integer count) {
        this.count = count;
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

    /**   债转的id  transfer_id   **/
    public Long getTransferId() {
        return transferId;
    }

    /**   债转的id  transfer_id   **/
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
        sb.append(", debtOriginalAssetId=").append(debtOriginalAssetId);
        sb.append(", investId=").append(investId);
        sb.append(", transferUserId=").append(transferUserId);
        sb.append(", principal=").append(principal);
        sb.append(", interest=").append(interest);
        sb.append(", status=").append(status);
        sb.append(", requestNo=").append(requestNo);
        sb.append(", count=").append(count);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", transferId=").append(transferId);
        sb.append("]");
        return sb.toString();
    }
}