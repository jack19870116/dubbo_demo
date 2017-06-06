package com.tiancaibao.pojo.debt;

import java.io.Serializable;
import java.util.Date;

public class DebtAgencys implements Serializable {
    /**   id **/
    private Long id;

    /** 机构名称  name **/
    private String name;

    /** 机构行业类型  type **/
    private String type;

    /** 机构行业类型  rank **/
    private String rank;

    /** 联系方式  phone **/
    private String phone;

    /** 官方网站  website **/
    private String website;

    /** 其他自定义的字段  other_info **/
    private String otherInfo;

    /**   deleted_at **/
    private Date deletedAt;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /** 机构资质  qualification **/
    private String qualification;

    /**   tableName: debt_agencys   **/
    private static final long serialVersionUID = 1L;

    /**     id   **/
    public Long getId() {
        return id;
    }

    /**     id   **/
    public void setId(Long id) {
        this.id = id;
    }

    /**   机构名称  name   **/
    public String getName() {
        return name;
    }

    /**   机构名称  name   **/
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**   机构行业类型  type   **/
    public String getType() {
        return type;
    }

    /**   机构行业类型  type   **/
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**   机构行业类型  rank   **/
    public String getRank() {
        return rank;
    }

    /**   机构行业类型  rank   **/
    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    /**   联系方式  phone   **/
    public String getPhone() {
        return phone;
    }

    /**   联系方式  phone   **/
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**   官方网站  website   **/
    public String getWebsite() {
        return website;
    }

    /**   官方网站  website   **/
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**   其他自定义的字段  other_info   **/
    public String getOtherInfo() {
        return otherInfo;
    }

    /**   其他自定义的字段  other_info   **/
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

    /**   机构资质  qualification   **/
    public String getQualification() {
        return qualification;
    }

    /**   机构资质  qualification   **/
    public void setQualification(String qualification) {
        this.qualification = qualification == null ? null : qualification.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", rank=").append(rank);
        sb.append(", phone=").append(phone);
        sb.append(", website=").append(website);
        sb.append(", otherInfo=").append(otherInfo);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", qualification=").append(qualification);
        sb.append("]");
        return sb.toString();
    }
}