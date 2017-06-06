package com.tiancaibao.pojo.coupons;

import java.io.Serializable;
import java.util.Date;

public class CouponsFixedInterestCoupons implements Serializable {
    private Long id;

    private Long userId;

    private Double value;

    /**
     * ʹ������
     */
    private Date usedAt;

    private String status;

    /**
     * 1��Ԥ����δʹ�ã�1��3��6��12���¶��ڣ���2��3��6��12���¶��ڣ�3��6��12���¶��ڣ�4��12���¶���
     */
    private Long type;

    /**
     * ��ʼʱ��
     */
    private Date startline;

    /**
     * ����ʱ��
     */
    private Date deadline;

    private Date deletedAt;

    private Date createdAt;

    private Date updatedAt;

    /**
     * ��ע?Ͷ��id
     */
    private String remark;

    /**
     * ��Ϣȯ��Դ��1ע�ᣬ2���룬3��һǧ��4����ǧ��5����ǧ��6������7�
     */
    private String source;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", value=").append(value);
        sb.append(", usedAt=").append(usedAt);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", startline=").append(startline);
        sb.append(", deadline=").append(deadline);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", remark=").append(remark);
        sb.append(", source=").append(source);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}