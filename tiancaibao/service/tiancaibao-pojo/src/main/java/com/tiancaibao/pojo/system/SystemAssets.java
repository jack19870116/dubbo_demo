package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemAssets implements Serializable {
    private Long id;

    /**
     * 剩余份额
     */
    private Long remainAmount;

    /**
     * 冻结份额
     */
    private Long freezeAmount;

    /**
     * 天才宝总的份额，用户持有份额+剩余份额
     */
    private Long amount;

    /**
     * 今日利率
     */
    private Long rate;

    private Date deletedAt;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 产品标识
     */
    private String productSign;

    /**
     * 产品计息时间，活期为1天
     */
    private Integer days;
    
    /**
     * 当前利率
     */
    private Double interest;
    
    /**
     * 按需求添加属性   购买功能用
     */
    private String withdraw_day;
    
    private Double extra_rate;
    
    private Long total_amount;
    
    
    
    
    public Long getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Long total_amount) {
		this.total_amount = total_amount;
	}

	public Double getExtra_rate() {
		return extra_rate;
	}

	public void setExtra_rate(Double extra_rate) {
		this.extra_rate = extra_rate;
	}

	private static final long serialVersionUID = 1L;
    
    
    public String getWithdraw_day() {
		return withdraw_day;
	}

	public void setWithdraw_day(String withdraw_day) {
		this.withdraw_day = withdraw_day;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Long remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Long getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProductSign() {
        return productSign;
    }

    public void setProductSign(String productSign) {
        this.productSign = productSign == null ? null : productSign.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", remainAmount=").append(remainAmount);
        sb.append(", freezeAmount=").append(freezeAmount);
        sb.append(", amount=").append(amount);
        sb.append(", rate=").append(rate);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", productSign=").append(productSign);
        sb.append(", days=").append(days);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}