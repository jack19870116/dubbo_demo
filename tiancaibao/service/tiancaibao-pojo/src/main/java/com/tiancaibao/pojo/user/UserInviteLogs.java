package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserInviteLogs implements Serializable {
    private Long id;

    private Long inviterId;

    private Long beInviterId;

    private String name;

    private Byte type;

    private String addConponsName;

    private Integer addIntegral;

    private Date createdAt;

    private Date updatedAt;

    private String remark;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public Long getBeInviterId() {
        return beInviterId;
    }

    public void setBeInviterId(Long beInviterId) {
        this.beInviterId = beInviterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getAddConponsName() {
        return addConponsName;
    }

    public void setAddConponsName(String addConponsName) {
        this.addConponsName = addConponsName == null ? null : addConponsName.trim();
    }

    public Integer getAddIntegral() {
        return addIntegral;
    }

    public void setAddIntegral(Integer addIntegral) {
        this.addIntegral = addIntegral;
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
        sb.append(", inviterId=").append(inviterId);
        sb.append(", beInviterId=").append(beInviterId);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", addConponsName=").append(addConponsName);
        sb.append(", addIntegral=").append(addIntegral);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", remark=").append(remark);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}