package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemAppIcon implements Serializable {
    private Integer id;

    private String iconServiceBbs;

    private String iconServiceTask;

    private String iconServiceDoing;

    private String iconServiceVipday;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String iconMyVipdayEnable;

    private String iconMyVipdayDisable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIconServiceBbs() {
        return iconServiceBbs;
    }

    public void setIconServiceBbs(String iconServiceBbs) {
        this.iconServiceBbs = iconServiceBbs == null ? null : iconServiceBbs.trim();
    }

    public String getIconServiceTask() {
        return iconServiceTask;
    }

    public void setIconServiceTask(String iconServiceTask) {
        this.iconServiceTask = iconServiceTask == null ? null : iconServiceTask.trim();
    }

    public String getIconServiceDoing() {
        return iconServiceDoing;
    }

    public void setIconServiceDoing(String iconServiceDoing) {
        this.iconServiceDoing = iconServiceDoing == null ? null : iconServiceDoing.trim();
    }

    public String getIconServiceVipday() {
        return iconServiceVipday;
    }

    public void setIconServiceVipday(String iconServiceVipday) {
        this.iconServiceVipday = iconServiceVipday == null ? null : iconServiceVipday.trim();
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

    public String getIconMyVipdayEnable() {
        return iconMyVipdayEnable;
    }

    public void setIconMyVipdayEnable(String iconMyVipdayEnable) {
        this.iconMyVipdayEnable = iconMyVipdayEnable == null ? null : iconMyVipdayEnable.trim();
    }

    public String getIconMyVipdayDisable() {
        return iconMyVipdayDisable;
    }

    public void setIconMyVipdayDisable(String iconMyVipdayDisable) {
        this.iconMyVipdayDisable = iconMyVipdayDisable == null ? null : iconMyVipdayDisable.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", iconServiceBbs=").append(iconServiceBbs);
        sb.append(", iconServiceTask=").append(iconServiceTask);
        sb.append(", iconServiceDoing=").append(iconServiceDoing);
        sb.append(", iconServiceVipday=").append(iconServiceVipday);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", iconMyVipdayEnable=").append(iconMyVipdayEnable);
        sb.append(", iconMyVipdayDisable=").append(iconMyVipdayDisable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}