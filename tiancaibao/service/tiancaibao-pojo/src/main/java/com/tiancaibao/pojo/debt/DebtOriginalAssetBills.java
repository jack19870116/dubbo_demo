package com.tiancaibao.pojo.debt;

import java.io.Serializable;
import java.util.Date;

public class DebtOriginalAssetBills implements Serializable {
    /**   id **/
    private Long id;

    /** 用户id  user_id **/
    private Long userId;

    /** 资产名称  name **/
    private String name;

    /** 资产显示名称  show_name **/
    private String showName;

    /** EXCEED逾期,NORMAL正常,BAD坏账  status **/
    private String status;

    /** 所属机构/个人ID  agency_id **/
    private Long agencyId;

    /** 资产分类  asset_class **/
    private String assetClass;

    /** 资产类型  asset_type **/
    private String assetType;

    /** 还款方式  repayment_type **/
    private String repaymentType;

    /** 买入金额  buy_amount **/
    private Long buyAmount;

    /** 天才宝资产中自增以后的资产金额  group_amount **/
    private Long groupAmount;

    /** 已经融到的总金额  finance_amount **/
    private Long financeAmount;

    /** 第三方本息到账金额,不参与业务逻辑  arrival_amount **/
    private Long arrivalAmount;

    /** 买入手续费  buy_fee **/
    private Long buyFee;

    /** FIX为固定利率,CHANGE为变动利率  buy_rate_type **/
    private String buyRateType;

    /** 买入利率同步地址  rate_sync_url **/
    private String rateSyncUrl;

    /** 买入利率  buy_rate **/
    private Long buyRate;

    /** 加入到资产组合中的利率  group_rate **/
    private Long groupRate;

    /** 卖出利率  sale_rate **/
    private Long saleRate;

    /** 起始计息日期  interest_start_date **/
    private Date interestStartDate;

    /** 结束日期  end_date **/
    private Date endDate;

    /** 借款期限  days **/
    private Long days;

    /** 资产是否被处理过  is_treated **/
    private Byte isTreated;

    /** 是否在资产池中,默认是没有在资产池中的,-1表示该资产从资产池中被替换  is_asset_pool **/
    private Byte isAssetPool;

    /** 赎回手续费  redeem_fee **/
    private Long redeemFee;

    /** 债权总额  total_debt_amount **/
    private Long totalDebtAmount;

    /** 保证金率  margin_rate **/
    private Integer marginRate;

    /** 风险备用金率  risk_reserve_rate **/
    private Integer riskReserveRate;

    /** 借款人姓名  loan_name **/
    private String loanName;

    /** 借款用途  loan_usage **/
    private String loanUsage;

    /** 还款来源  repayment_source **/
    private String repaymentSource;

    /** 借款人手机号码  phone **/
    private String phone;

    /** 借款人身份证正面  loan_img **/
    private String loanImg;

    /** 担保人/担保机构  guarantee_person **/
    private String guaranteePerson;

    /** 协议图片  agreement_img **/
    private String agreementImg;

    /** 担保图片  guarantee_img **/
    private String guaranteeImg;

    /** 担保信息  guarantee_info **/
    private String guaranteeInfo;

    /** 其他属性  other_info **/
    private String otherInfo;

    /**   deleted_at **/
    private Date deletedAt;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /** 所属资产组合的id,-1表示从资产组合中已被替换掉  original_asset_id **/
    private Long originalAssetId;

    /**   tableName: debt_original_asset_bills   **/
    private static final long serialVersionUID = 1L;

    /**     id   **/
    public Long getId() {
        return id;
    }

    /**     id   **/
    public void setId(Long id) {
        this.id = id;
    }

    /**   用户id  user_id   **/
    public Long getUserId() {
        return userId;
    }

    /**   用户id  user_id   **/
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**   资产名称  name   **/
    public String getName() {
        return name;
    }

    /**   资产名称  name   **/
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**   资产显示名称  show_name   **/
    public String getShowName() {
        return showName;
    }

    /**   资产显示名称  show_name   **/
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    /**   EXCEED逾期,NORMAL正常,BAD坏账  status   **/
    public String getStatus() {
        return status;
    }

    /**   EXCEED逾期,NORMAL正常,BAD坏账  status   **/
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**   所属机构/个人ID  agency_id   **/
    public Long getAgencyId() {
        return agencyId;
    }

    /**   所属机构/个人ID  agency_id   **/
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    /**   资产分类  asset_class   **/
    public String getAssetClass() {
        return assetClass;
    }

    /**   资产分类  asset_class   **/
    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass == null ? null : assetClass.trim();
    }

    /**   资产类型  asset_type   **/
    public String getAssetType() {
        return assetType;
    }

    /**   资产类型  asset_type   **/
    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    /**   还款方式  repayment_type   **/
    public String getRepaymentType() {
        return repaymentType;
    }

    /**   还款方式  repayment_type   **/
    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    /**   买入金额  buy_amount   **/
    public Long getBuyAmount() {
        return buyAmount;
    }

    /**   买入金额  buy_amount   **/
    public void setBuyAmount(Long buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**   天才宝资产中自增以后的资产金额  group_amount   **/
    public Long getGroupAmount() {
        return groupAmount;
    }

    /**   天才宝资产中自增以后的资产金额  group_amount   **/
    public void setGroupAmount(Long groupAmount) {
        this.groupAmount = groupAmount;
    }

    /**   已经融到的总金额  finance_amount   **/
    public Long getFinanceAmount() {
        return financeAmount;
    }

    /**   已经融到的总金额  finance_amount   **/
    public void setFinanceAmount(Long financeAmount) {
        this.financeAmount = financeAmount;
    }

    /**   第三方本息到账金额,不参与业务逻辑  arrival_amount   **/
    public Long getArrivalAmount() {
        return arrivalAmount;
    }

    /**   第三方本息到账金额,不参与业务逻辑  arrival_amount   **/
    public void setArrivalAmount(Long arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    /**   买入手续费  buy_fee   **/
    public Long getBuyFee() {
        return buyFee;
    }

    /**   买入手续费  buy_fee   **/
    public void setBuyFee(Long buyFee) {
        this.buyFee = buyFee;
    }

    /**   FIX为固定利率,CHANGE为变动利率  buy_rate_type   **/
    public String getBuyRateType() {
        return buyRateType;
    }

    /**   FIX为固定利率,CHANGE为变动利率  buy_rate_type   **/
    public void setBuyRateType(String buyRateType) {
        this.buyRateType = buyRateType == null ? null : buyRateType.trim();
    }

    /**   买入利率同步地址  rate_sync_url   **/
    public String getRateSyncUrl() {
        return rateSyncUrl;
    }

    /**   买入利率同步地址  rate_sync_url   **/
    public void setRateSyncUrl(String rateSyncUrl) {
        this.rateSyncUrl = rateSyncUrl == null ? null : rateSyncUrl.trim();
    }

    /**   买入利率  buy_rate   **/
    public Long getBuyRate() {
        return buyRate;
    }

    /**   买入利率  buy_rate   **/
    public void setBuyRate(Long buyRate) {
        this.buyRate = buyRate;
    }

    /**   加入到资产组合中的利率  group_rate   **/
    public Long getGroupRate() {
        return groupRate;
    }

    /**   加入到资产组合中的利率  group_rate   **/
    public void setGroupRate(Long groupRate) {
        this.groupRate = groupRate;
    }

    /**   卖出利率  sale_rate   **/
    public Long getSaleRate() {
        return saleRate;
    }

    /**   卖出利率  sale_rate   **/
    public void setSaleRate(Long saleRate) {
        this.saleRate = saleRate;
    }

    /**   起始计息日期  interest_start_date   **/
    public Date getInterestStartDate() {
        return interestStartDate;
    }

    /**   起始计息日期  interest_start_date   **/
    public void setInterestStartDate(Date interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    /**   结束日期  end_date   **/
    public Date getEndDate() {
        return endDate;
    }

    /**   结束日期  end_date   **/
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**   借款期限  days   **/
    public Long getDays() {
        return days;
    }

    /**   借款期限  days   **/
    public void setDays(Long days) {
        this.days = days;
    }

    /**   资产是否被处理过  is_treated   **/
    public Byte getIsTreated() {
        return isTreated;
    }

    /**   资产是否被处理过  is_treated   **/
    public void setIsTreated(Byte isTreated) {
        this.isTreated = isTreated;
    }

    /**   是否在资产池中,默认是没有在资产池中的,-1表示该资产从资产池中被替换  is_asset_pool   **/
    public Byte getIsAssetPool() {
        return isAssetPool;
    }

    /**   是否在资产池中,默认是没有在资产池中的,-1表示该资产从资产池中被替换  is_asset_pool   **/
    public void setIsAssetPool(Byte isAssetPool) {
        this.isAssetPool = isAssetPool;
    }

    /**   赎回手续费  redeem_fee   **/
    public Long getRedeemFee() {
        return redeemFee;
    }

    /**   赎回手续费  redeem_fee   **/
    public void setRedeemFee(Long redeemFee) {
        this.redeemFee = redeemFee;
    }

    /**   债权总额  total_debt_amount   **/
    public Long getTotalDebtAmount() {
        return totalDebtAmount;
    }

    /**   债权总额  total_debt_amount   **/
    public void setTotalDebtAmount(Long totalDebtAmount) {
        this.totalDebtAmount = totalDebtAmount;
    }

    /**   保证金率  margin_rate   **/
    public Integer getMarginRate() {
        return marginRate;
    }

    /**   保证金率  margin_rate   **/
    public void setMarginRate(Integer marginRate) {
        this.marginRate = marginRate;
    }

    /**   风险备用金率  risk_reserve_rate   **/
    public Integer getRiskReserveRate() {
        return riskReserveRate;
    }

    /**   风险备用金率  risk_reserve_rate   **/
    public void setRiskReserveRate(Integer riskReserveRate) {
        this.riskReserveRate = riskReserveRate;
    }

    /**   借款人姓名  loan_name   **/
    public String getLoanName() {
        return loanName;
    }

    /**   借款人姓名  loan_name   **/
    public void setLoanName(String loanName) {
        this.loanName = loanName == null ? null : loanName.trim();
    }

    /**   借款用途  loan_usage   **/
    public String getLoanUsage() {
        return loanUsage;
    }

    /**   借款用途  loan_usage   **/
    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage == null ? null : loanUsage.trim();
    }

    /**   还款来源  repayment_source   **/
    public String getRepaymentSource() {
        return repaymentSource;
    }

    /**   还款来源  repayment_source   **/
    public void setRepaymentSource(String repaymentSource) {
        this.repaymentSource = repaymentSource == null ? null : repaymentSource.trim();
    }

    /**   借款人手机号码  phone   **/
    public String getPhone() {
        return phone;
    }

    /**   借款人手机号码  phone   **/
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**   借款人身份证正面  loan_img   **/
    public String getLoanImg() {
        return loanImg;
    }

    /**   借款人身份证正面  loan_img   **/
    public void setLoanImg(String loanImg) {
        this.loanImg = loanImg == null ? null : loanImg.trim();
    }

    /**   担保人/担保机构  guarantee_person   **/
    public String getGuaranteePerson() {
        return guaranteePerson;
    }

    /**   担保人/担保机构  guarantee_person   **/
    public void setGuaranteePerson(String guaranteePerson) {
        this.guaranteePerson = guaranteePerson == null ? null : guaranteePerson.trim();
    }

    /**   协议图片  agreement_img   **/
    public String getAgreementImg() {
        return agreementImg;
    }

    /**   协议图片  agreement_img   **/
    public void setAgreementImg(String agreementImg) {
        this.agreementImg = agreementImg == null ? null : agreementImg.trim();
    }

    /**   担保图片  guarantee_img   **/
    public String getGuaranteeImg() {
        return guaranteeImg;
    }

    /**   担保图片  guarantee_img   **/
    public void setGuaranteeImg(String guaranteeImg) {
        this.guaranteeImg = guaranteeImg == null ? null : guaranteeImg.trim();
    }

    /**   担保信息  guarantee_info   **/
    public String getGuaranteeInfo() {
        return guaranteeInfo;
    }

    /**   担保信息  guarantee_info   **/
    public void setGuaranteeInfo(String guaranteeInfo) {
        this.guaranteeInfo = guaranteeInfo == null ? null : guaranteeInfo.trim();
    }

    /**   其他属性  other_info   **/
    public String getOtherInfo() {
        return otherInfo;
    }

    /**   其他属性  other_info   **/
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    /**     deleted_at   **/
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**     deleted_at   **/
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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

    /**   所属资产组合的id,-1表示从资产组合中已被替换掉  original_asset_id   **/
    public Long getOriginalAssetId() {
        return originalAssetId;
    }

    /**   所属资产组合的id,-1表示从资产组合中已被替换掉  original_asset_id   **/
    public void setOriginalAssetId(Long originalAssetId) {
        this.originalAssetId = originalAssetId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", showName=").append(showName);
        sb.append(", status=").append(status);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", assetClass=").append(assetClass);
        sb.append(", assetType=").append(assetType);
        sb.append(", repaymentType=").append(repaymentType);
        sb.append(", buyAmount=").append(buyAmount);
        sb.append(", groupAmount=").append(groupAmount);
        sb.append(", financeAmount=").append(financeAmount);
        sb.append(", arrivalAmount=").append(arrivalAmount);
        sb.append(", buyFee=").append(buyFee);
        sb.append(", buyRateType=").append(buyRateType);
        sb.append(", rateSyncUrl=").append(rateSyncUrl);
        sb.append(", buyRate=").append(buyRate);
        sb.append(", groupRate=").append(groupRate);
        sb.append(", saleRate=").append(saleRate);
        sb.append(", interestStartDate=").append(interestStartDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", days=").append(days);
        sb.append(", isTreated=").append(isTreated);
        sb.append(", isAssetPool=").append(isAssetPool);
        sb.append(", redeemFee=").append(redeemFee);
        sb.append(", totalDebtAmount=").append(totalDebtAmount);
        sb.append(", marginRate=").append(marginRate);
        sb.append(", riskReserveRate=").append(riskReserveRate);
        sb.append(", loanName=").append(loanName);
        sb.append(", loanUsage=").append(loanUsage);
        sb.append(", repaymentSource=").append(repaymentSource);
        sb.append(", phone=").append(phone);
        sb.append(", loanImg=").append(loanImg);
        sb.append(", guaranteePerson=").append(guaranteePerson);
        sb.append(", agreementImg=").append(agreementImg);
        sb.append(", guaranteeImg=").append(guaranteeImg);
        sb.append(", guaranteeInfo=").append(guaranteeInfo);
        sb.append(", otherInfo=").append(otherInfo);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", originalAssetId=").append(originalAssetId);
        sb.append("]");
        return sb.toString();
    }
}