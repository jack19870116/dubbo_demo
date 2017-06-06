package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.Date;

public class ShopIndents implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 兑换数量
     */
    private Integer gquantity;

    /**
     * 小计
     */
    private Long gtotalPrice;

    /**
     * 收货人姓名
     */
    private String gname;

    /**
     * 配送区域
     */
    private Byte gzone;

    /**
     * 详细地址
     */
    private String gaddr;

    /**
     * 邮政编码
     */
    private String gpostcode;

    /**
     * 手机号
     */
    private String gphone;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    /**
     * 商品id
     */
    private Integer sid;

    private Byte shopClassId;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 发货状态
     */
    private String orderStatus;

    /**
     * 快递公司
     */
    private String expressName;

    private Integer electronicCouponId;

    private Integer addInterestCouponId;

    private Integer addressId;

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

    public Integer getGquantity() {
        return gquantity;
    }

    public void setGquantity(Integer gquantity) {
        this.gquantity = gquantity;
    }

    public Long getGtotalPrice() {
        return gtotalPrice;
    }

    public void setGtotalPrice(Long gtotalPrice) {
        this.gtotalPrice = gtotalPrice;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Byte getGzone() {
        return gzone;
    }

    public void setGzone(Byte gzone) {
        this.gzone = gzone;
    }

    public String getGaddr() {
        return gaddr;
    }

    public void setGaddr(String gaddr) {
        this.gaddr = gaddr == null ? null : gaddr.trim();
    }

    public String getGpostcode() {
        return gpostcode;
    }

    public void setGpostcode(String gpostcode) {
        this.gpostcode = gpostcode == null ? null : gpostcode.trim();
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone == null ? null : gphone.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Byte getShopClassId() {
        return shopClassId;
    }

    public void setShopClassId(Byte shopClassId) {
        this.shopClassId = shopClassId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public Integer getElectronicCouponId() {
        return electronicCouponId;
    }

    public void setElectronicCouponId(Integer electronicCouponId) {
        this.electronicCouponId = electronicCouponId;
    }

    public Integer getAddInterestCouponId() {
        return addInterestCouponId;
    }

    public void setAddInterestCouponId(Integer addInterestCouponId) {
        this.addInterestCouponId = addInterestCouponId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", gquantity=").append(gquantity);
        sb.append(", gtotalPrice=").append(gtotalPrice);
        sb.append(", gname=").append(gname);
        sb.append(", gzone=").append(gzone);
        sb.append(", gaddr=").append(gaddr);
        sb.append(", gpostcode=").append(gpostcode);
        sb.append(", gphone=").append(gphone);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", sid=").append(sid);
        sb.append(", shopClassId=").append(shopClassId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", expressName=").append(expressName);
        sb.append(", electronicCouponId=").append(electronicCouponId);
        sb.append(", addInterestCouponId=").append(addInterestCouponId);
        sb.append(", addressId=").append(addressId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}