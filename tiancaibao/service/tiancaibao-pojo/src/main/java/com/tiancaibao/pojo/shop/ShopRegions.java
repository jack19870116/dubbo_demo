package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ShopRegions implements Serializable {
    private Short regionId;

    private Short parentId;

    private String regionName;

    private Boolean regionType;

    private Short agencyId;

    private Date deletedAt;
    
    private List<ShopRegions> list;
    
    public List<ShopRegions> getList() {
		return list;
	}

	public void setList(List<ShopRegions> list) {
		this.list = list;
	}

	private static final long serialVersionUID = 1L;

    public Short getRegionId() {
        return regionId;
    }

    public void setRegionId(Short regionId) {
        this.regionId = regionId;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Boolean getRegionType() {
        return regionType;
    }

    public void setRegionType(Boolean regionType) {
        this.regionType = regionType;
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
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
        sb.append(", regionId=").append(regionId);
        sb.append(", parentId=").append(parentId);
        sb.append(", regionName=").append(regionName);
        sb.append(", regionType=").append(regionType);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}