package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemTenderProduct implements Serializable {
    private Long id;

    private Long projectId;

    private String projectName;

    private String loanPhone;

    private String loanObject;

    private String loanRoute;

    private Long loanAmount;

    private Integer countLimit;

    private Long moneyLimit;

    private Long annualRate;

    private Long surplusAmount;

    private Long extraRate;

    private String loanUnit;

    private Integer loanLimit;

    private Integer bidDeadtime;

    private Long leastInvestAmount;

    private Long mostInvestAmount;

    private String proGroup;

    private String groupDesc;

    private Integer hotTags;

    private String proImgPath;

    private String paymentMethod;

    private Integer states;

    private Date releaseTime;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Date interestDate;

    private Date lastRepayDate;

    private Integer term;

    private Integer alreadyTerm;

    private String loanDesc;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getLoanPhone() {
        return loanPhone;
    }

    public void setLoanPhone(String loanPhone) {
        this.loanPhone = loanPhone == null ? null : loanPhone.trim();
    }

    public String getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject == null ? null : loanObject.trim();
    }

    public String getLoanRoute() {
        return loanRoute;
    }

    public void setLoanRoute(String loanRoute) {
        this.loanRoute = loanRoute == null ? null : loanRoute.trim();
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(Integer countLimit) {
        this.countLimit = countLimit;
    }

    public Long getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(Long moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public Long getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(Long annualRate) {
        this.annualRate = annualRate;
    }

    public Long getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(Long surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public Long getExtraRate() {
        return extraRate;
    }

    public void setExtraRate(Long extraRate) {
        this.extraRate = extraRate;
    }

    public String getLoanUnit() {
        return loanUnit;
    }

    public void setLoanUnit(String loanUnit) {
        this.loanUnit = loanUnit == null ? null : loanUnit.trim();
    }

    public Integer getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Integer loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Integer getBidDeadtime() {
        return bidDeadtime;
    }

    public void setBidDeadtime(Integer bidDeadtime) {
        this.bidDeadtime = bidDeadtime;
    }

    public Long getLeastInvestAmount() {
        return leastInvestAmount;
    }

    public void setLeastInvestAmount(Long leastInvestAmount) {
        this.leastInvestAmount = leastInvestAmount;
    }

    public Long getMostInvestAmount() {
        return mostInvestAmount;
    }

    public void setMostInvestAmount(Long mostInvestAmount) {
        this.mostInvestAmount = mostInvestAmount;
    }

    public String getProGroup() {
        return proGroup;
    }

    public void setProGroup(String proGroup) {
        this.proGroup = proGroup == null ? null : proGroup.trim();
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc == null ? null : groupDesc.trim();
    }

    public Integer getHotTags() {
        return hotTags;
    }

    public void setHotTags(Integer hotTags) {
        this.hotTags = hotTags;
    }

    public String getProImgPath() {
        return proImgPath;
    }

    public void setProImgPath(String proImgPath) {
        this.proImgPath = proImgPath == null ? null : proImgPath.trim();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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

    public Date getInterestDate() {
        return interestDate;
    }

    public void setInterestDate(Date interestDate) {
        this.interestDate = interestDate;
    }

    public Date getLastRepayDate() {
        return lastRepayDate;
    }

    public void setLastRepayDate(Date lastRepayDate) {
        this.lastRepayDate = lastRepayDate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getAlreadyTerm() {
        return alreadyTerm;
    }

    public void setAlreadyTerm(Integer alreadyTerm) {
        this.alreadyTerm = alreadyTerm;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(String loanDesc) {
        this.loanDesc = loanDesc == null ? null : loanDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", loanPhone=").append(loanPhone);
        sb.append(", loanObject=").append(loanObject);
        sb.append(", loanRoute=").append(loanRoute);
        sb.append(", loanAmount=").append(loanAmount);
        sb.append(", countLimit=").append(countLimit);
        sb.append(", moneyLimit=").append(moneyLimit);
        sb.append(", annualRate=").append(annualRate);
        sb.append(", surplusAmount=").append(surplusAmount);
        sb.append(", extraRate=").append(extraRate);
        sb.append(", loanUnit=").append(loanUnit);
        sb.append(", loanLimit=").append(loanLimit);
        sb.append(", bidDeadtime=").append(bidDeadtime);
        sb.append(", leastInvestAmount=").append(leastInvestAmount);
        sb.append(", mostInvestAmount=").append(mostInvestAmount);
        sb.append(", proGroup=").append(proGroup);
        sb.append(", groupDesc=").append(groupDesc);
        sb.append(", hotTags=").append(hotTags);
        sb.append(", proImgPath=").append(proImgPath);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", states=").append(states);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", interestDate=").append(interestDate);
        sb.append(", lastRepayDate=").append(lastRepayDate);
        sb.append(", term=").append(term);
        sb.append(", alreadyTerm=").append(alreadyTerm);
        sb.append(", loanDesc=").append(loanDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}