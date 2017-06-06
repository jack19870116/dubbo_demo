package com.tiancaibao.pojo.pay;

import java.io.Serializable;
import java.util.Date;

public class PayBankLimits implements Serializable {
    private Integer id;

    /**
     * 银行名
     */
    private String bankName;

    /**
     * 单笔限额
     */
    private String singleLimit;

    /**
     * 单日限额
     */
    private String dayLimit;

    private Date updatedAt;

    private Date deletedAt;

    private Date createdAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getSingleLimit() {
        return singleLimit;
    }

    public void setSingleLimit(String singleLimit) {
        this.singleLimit = singleLimit == null ? null : singleLimit.trim();
    }

    public String getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(String dayLimit) {
        this.dayLimit = dayLimit == null ? null : dayLimit.trim();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bankName=").append(bankName);
        sb.append(", singleLimit=").append(singleLimit);
        sb.append(", dayLimit=").append(dayLimit);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}