package com.tiancaibao.pojo.debt;

import java.io.Serializable;

public class DebtOriginalAssetBillsWithBLOBs extends DebtOriginalAssetBills implements Serializable {
    /** 提前到期的原因  ahead_end_reason **/
    private String aheadEndReason;

    /** 借款人全图  loan_all_img **/
    private String loanAllImg;

    /**   tableName: debt_original_asset_bills   **/
    private static final long serialVersionUID = 1L;

    /**   提前到期的原因  ahead_end_reason   **/
    public String getAheadEndReason() {
        return aheadEndReason;
    }

    /**   提前到期的原因  ahead_end_reason   **/
    public void setAheadEndReason(String aheadEndReason) {
        this.aheadEndReason = aheadEndReason == null ? null : aheadEndReason.trim();
    }

    /**   借款人全图  loan_all_img   **/
    public String getLoanAllImg() {
        return loanAllImg;
    }

    /**   借款人全图  loan_all_img   **/
    public void setLoanAllImg(String loanAllImg) {
        this.loanAllImg = loanAllImg == null ? null : loanAllImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aheadEndReason=").append(aheadEndReason);
        sb.append(", loanAllImg=").append(loanAllImg);
        sb.append("]");
        return sb.toString();
    }
}