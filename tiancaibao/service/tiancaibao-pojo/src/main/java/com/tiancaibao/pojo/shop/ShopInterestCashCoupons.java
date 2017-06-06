package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopInterestCashCoupons implements Serializable {
    private Integer id;

    private Integer value;

    private Integer condition;

    private Integer source;

    private Date deadline;

    private String type;

    private Integer days;

    private Date updatedAt;

    private Date deletedAt;

    private Date startline;

    private Long shopClassId;

    private String name;

    private Integer shopNum;

    private Integer cnum;

    private String spic;

    private String simg;

    private Long sprice;

    private Date stime;

    private Boolean sisshop;

    private Integer scount;

    private Date createdAt;

    private Integer sorder;

    private Integer limitTime;

    private String squareImg;

    private String sinfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
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

    public Date getStartline() {
        return startline;
    }

    public void setStartline(Date startline) {
        this.startline = startline;
    }

    public Long getShopClassId() {
        return shopClassId;
    }

    public void setShopClassId(Long shopClassId) {
        this.shopClassId = shopClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getSpic() {
        return spic;
    }

    public void setSpic(String spic) {
        this.spic = spic == null ? null : spic.trim();
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg == null ? null : simg.trim();
    }

    public Long getSprice() {
        return sprice;
    }

    public void setSprice(Long sprice) {
        this.sprice = sprice;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Boolean getSisshop() {
        return sisshop;
    }

    public void setSisshop(Boolean sisshop) {
        this.sisshop = sisshop;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getSorder() {
        return sorder;
    }

    public void setSorder(Integer sorder) {
        this.sorder = sorder;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public String getSquareImg() {
        return squareImg;
    }

    public void setSquareImg(String squareImg) {
        this.squareImg = squareImg == null ? null : squareImg.trim();
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo == null ? null : sinfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", value=").append(value);
        sb.append(", condition=").append(condition);
        sb.append(", source=").append(source);
        sb.append(", deadline=").append(deadline);
        sb.append(", type=").append(type);
        sb.append(", days=").append(days);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", startline=").append(startline);
        sb.append(", shopClassId=").append(shopClassId);
        sb.append(", name=").append(name);
        sb.append(", shopNum=").append(shopNum);
        sb.append(", cnum=").append(cnum);
        sb.append(", spic=").append(spic);
        sb.append(", simg=").append(simg);
        sb.append(", sprice=").append(sprice);
        sb.append(", stime=").append(stime);
        sb.append(", sisshop=").append(sisshop);
        sb.append(", scount=").append(scount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", sorder=").append(sorder);
        sb.append(", limitTime=").append(limitTime);
        sb.append(", squareImg=").append(squareImg);
        sb.append(", sinfo=").append(sinfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}