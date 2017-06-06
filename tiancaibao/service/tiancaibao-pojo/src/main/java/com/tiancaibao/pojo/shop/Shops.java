package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class Shops implements Serializable {
    private Long id;

    /**
     * 商品种类
     */
    private Long shopClassId;

    /**
     * 商品子类ID
     */
    private Long childClassId;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 库存
     */
    private Integer shopNum;

    private Integer cnum;

    /**
     * 商品缩略图
     */
    private String spic;

    /**
     * 商品大图
     */
    private String simg;

    /**
     * 商品价格
     */
    private Long sprice;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 上架时间
     */
    private Date stime;

    /**
     * 下架时间
     */
    private Date endTime;

    /**
     * 是否上架（  1  上  架，  0  下架）
     */
    private Integer sisshop;

    /**
     * 购买次数
     */
    private Integer scount;

    /**
     * 排序
     */
    private Integer sorder;

    /**
     * 是否推荐0:不推荐1:推荐
     */
    private Long isRecommend;

    private Date deletedAt;

    /**
     * 电子卡券类别Id
     */
    private Integer electronicCouponCategoryId;

    /**
     * 兑换地址
     */
    private String redirectUrl;

    /**
     * 详情图片地址
     */
    private String dataUrl;

    private String squareImg;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopClassId() {
        return shopClassId;
    }

    public void setShopClassId(Long shopClassId) {
        this.shopClassId = shopClassId;
    }

    public Long getChildClassId() {
        return childClassId;
    }

    public void setChildClassId(Long childClassId) {
        this.childClassId = childClassId;
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

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSisshop() {
        return sisshop;
    }

    public void setSisshop(Integer sisshop) {
        this.sisshop = sisshop;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }

    public Integer getSorder() {
        return sorder;
    }

    public void setSorder(Integer sorder) {
        this.sorder = sorder;
    }

    public Long getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getElectronicCouponCategoryId() {
        return electronicCouponCategoryId;
    }

    public void setElectronicCouponCategoryId(Integer electronicCouponCategoryId) {
        this.electronicCouponCategoryId = electronicCouponCategoryId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl == null ? null : dataUrl.trim();
    }

    public String getSquareImg() {
        return squareImg;
    }

    public void setSquareImg(String squareImg) {
        this.squareImg = squareImg == null ? null : squareImg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopClassId=").append(shopClassId);
        sb.append(", childClassId=").append(childClassId);
        sb.append(", name=").append(name);
        sb.append(", shopNum=").append(shopNum);
        sb.append(", cnum=").append(cnum);
        sb.append(", spic=").append(spic);
        sb.append(", simg=").append(simg);
        sb.append(", sprice=").append(sprice);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", stime=").append(stime);
        sb.append(", endTime=").append(endTime);
        sb.append(", sisshop=").append(sisshop);
        sb.append(", scount=").append(scount);
        sb.append(", sorder=").append(sorder);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", electronicCouponCategoryId=").append(electronicCouponCategoryId);
        sb.append(", redirectUrl=").append(redirectUrl);
        sb.append(", dataUrl=").append(dataUrl);
        sb.append(", squareImg=").append(squareImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}