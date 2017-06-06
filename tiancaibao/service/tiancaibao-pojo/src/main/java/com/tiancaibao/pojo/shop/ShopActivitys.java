package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopActivitys implements Serializable {
    /**   id **/
    private Integer id;

    /** 活动主题  name **/
    private String name;

    /** 活动链接  url **/
    private String url;

    /** 1:开启;2:关闭  is_close **/
    private Boolean isClose;

    /**   order **/
    private Integer order;

    /**   use_integral **/
    private Long useIntegral;

    /**   every_day_num **/
    private Long everyDayNum;

    /**   created_at **/
    private Date createdAt;

    /**   updated_at **/
    private Date updatedAt;

    /**   deleted_at **/
    private Date deletedAt;

    /**   tableName: shop_activitys   **/
    private static final long serialVersionUID = 1L;

    /**     id   **/
    public Integer getId() {
        return id;
    }

    /**     id   **/
    public void setId(Integer id) {
        this.id = id;
    }

    /**   活动主题  name   **/
    public String getName() {
        return name;
    }

    /**   活动主题  name   **/
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**   活动链接  url   **/
    public String getUrl() {
        return url;
    }

    /**   活动链接  url   **/
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**   1:开启;2:关闭  is_close   **/
    public Boolean getIsClose() {
        return isClose;
    }

    /**   1:开启;2:关闭  is_close   **/
    public void setIsClose(Boolean isClose) {
        this.isClose = isClose;
    }

    /**     order   **/
    public Integer getOrder() {
        return order;
    }

    /**     order   **/
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**     use_integral   **/
    public Long getUseIntegral() {
        return useIntegral;
    }

    /**     use_integral   **/
    public void setUseIntegral(Long useIntegral) {
        this.useIntegral = useIntegral;
    }

    /**     every_day_num   **/
    public Long getEveryDayNum() {
        return everyDayNum;
    }

    /**     every_day_num   **/
    public void setEveryDayNum(Long everyDayNum) {
        this.everyDayNum = everyDayNum;
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

    /**     deleted_at   **/
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**     deleted_at   **/
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
        sb.append(", url=").append(url);
        sb.append(", isClose=").append(isClose);
        sb.append(", order=").append(order);
        sb.append(", useIntegral=").append(useIntegral);
        sb.append(", everyDayNum=").append(everyDayNum);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append("]");
        return sb.toString();
    }
}