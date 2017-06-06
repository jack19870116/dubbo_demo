package com.tiancaibao.pojo.wechat;

import java.io.Serializable;
import java.util.Date;

public class WeixinMenu implements Serializable {
    private Integer id;

    /**
     * 菜单名称
     */
    private String menuname;

    /**
     * 是否是子菜单
     */
    private String issonMenu;

    /**
     * 所属父菜单id
     */
    private Long parentId;

    /**
     * 菜单权重最小排最左
     */
    private Long menuWeigh;

    /**
     * 子菜单链接或key根据子菜单类型决定
     */
    private String sonmenuUrl;

    /**
     * 菜单类型
     */
    private String sonmenuType;

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

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getIssonMenu() {
        return issonMenu;
    }

    public void setIssonMenu(String issonMenu) {
        this.issonMenu = issonMenu == null ? null : issonMenu.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getMenuWeigh() {
        return menuWeigh;
    }

    public void setMenuWeigh(Long menuWeigh) {
        this.menuWeigh = menuWeigh;
    }

    public String getSonmenuUrl() {
        return sonmenuUrl;
    }

    public void setSonmenuUrl(String sonmenuUrl) {
        this.sonmenuUrl = sonmenuUrl == null ? null : sonmenuUrl.trim();
    }

    public String getSonmenuType() {
        return sonmenuType;
    }

    public void setSonmenuType(String sonmenuType) {
        this.sonmenuType = sonmenuType == null ? null : sonmenuType.trim();
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
        sb.append(", menuname=").append(menuname);
        sb.append(", issonMenu=").append(issonMenu);
        sb.append(", parentId=").append(parentId);
        sb.append(", menuWeigh=").append(menuWeigh);
        sb.append(", sonmenuUrl=").append(sonmenuUrl);
        sb.append(", sonmenuType=").append(sonmenuType);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}