package com.tiancaibao.pojo.integral;

import java.io.Serializable;
import java.util.Date;

public class IntegralRecords implements Serializable {
	private Long id;

	private Long userId;

	private Integer shopindentId;

	/**
	 * 变更后的用户积分
	 */
	private Integer userCurrentIntegral;

	private String source;

	private Integer integral;

	private Date createdAt;

	private Date updatedAt;

	private Integer electronicCouponCategoryId;

	private Integer addInterestCouponId;

	private Integer sid;

	private Date deletedAt;
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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

	public Integer getShopindentId() {
		return shopindentId;
	}

	public void setShopindentId(Integer shopindentId) {
		this.shopindentId = shopindentId;
	}

	public Integer getUserCurrentIntegral() {
		return userCurrentIntegral;
	}

	public void setUserCurrentIntegral(Integer userCurrentIntegral) {
		this.userCurrentIntegral = userCurrentIntegral;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
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

	public Integer getElectronicCouponCategoryId() {
		return electronicCouponCategoryId;
	}

	public void setElectronicCouponCategoryId(Integer electronicCouponCategoryId) {
		this.electronicCouponCategoryId = electronicCouponCategoryId;
	}

	public Integer getAddInterestCouponId() {
		return addInterestCouponId;
	}

	public void setAddInterestCouponId(Integer addInterestCouponId) {
		this.addInterestCouponId = addInterestCouponId;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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
		sb.append(", shopindentId=").append(shopindentId);
		sb.append(", userCurrentIntegral=").append(userCurrentIntegral);
		sb.append(", source=").append(source);
		sb.append(", integral=").append(integral);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", updatedAt=").append(updatedAt);
		sb.append(", electronicCouponCategoryId=").append(electronicCouponCategoryId);
		sb.append(", addInterestCouponId=").append(addInterestCouponId);
		sb.append(", sid=").append(sid);
		sb.append(", deletedAt=").append(deletedAt);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}