package com.tiancaibao.pojo.coupons;

import java.io.Serializable;
import java.util.Date;

public class CouponsFixedCashCoupons implements Serializable {
	private Long id;

	private Long userId;

	private Long value;

	private Integer conditions;

	private Date usedAt;

	private String status;

	private Date startline;

	private Date deadline;

	private Date createdAt;

	private Date updatedAt;

	private String remark;

	private String source;

	private Integer days;

	private Date deletedAt;

	// 不用记录数据库 临时字段
	private String expired;

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Integer getConditions() {
		return conditions;
	}

	public void setConditions(Integer conditions) {
		this.conditions = conditions;
	}

	public Date getUsedAt() {
		return usedAt;
	}

	public void setUsedAt(Date usedAt) {
		this.usedAt = usedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getStartline() {
		return startline;
	}

	public void setStartline(Date startline) {
		this.startline = startline;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
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
		sb.append(", value=").append(value);
		sb.append(", conditions=").append(conditions);
		sb.append(", usedAt=").append(usedAt);
		sb.append(", status=").append(status);
		sb.append(", startline=").append(startline);
		sb.append(", deadline=").append(deadline);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", updatedAt=").append(updatedAt);
		sb.append(", remark=").append(remark);
		sb.append(", source=").append(source);
		sb.append(", days=").append(days);
		sb.append(", deletedAt=").append(deletedAt);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}