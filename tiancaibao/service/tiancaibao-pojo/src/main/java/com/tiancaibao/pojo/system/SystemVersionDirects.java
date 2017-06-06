package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemVersionDirects implements Serializable {
    private Integer id;

    private String name;

    private Date publishTime;

    private String wapImage;

    private String pcImage;

    private String wapUrl;

    private String pcUrl;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getWapImage() {
        return wapImage;
    }

    public void setWapImage(String wapImage) {
        this.wapImage = wapImage == null ? null : wapImage.trim();
    }

    public String getPcImage() {
        return pcImage;
    }

    public void setPcImage(String pcImage) {
        this.pcImage = pcImage == null ? null : pcImage.trim();
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl == null ? null : wapUrl.trim();
    }

    public String getPcUrl() {
        return pcUrl;
    }

    public void setPcUrl(String pcUrl) {
        this.pcUrl = pcUrl == null ? null : pcUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", wapImage=").append(wapImage);
        sb.append(", pcImage=").append(pcImage);
        sb.append(", wapUrl=").append(wapUrl);
        sb.append(", pcUrl=").append(pcUrl);
        sb.append(", status=").append(status);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}