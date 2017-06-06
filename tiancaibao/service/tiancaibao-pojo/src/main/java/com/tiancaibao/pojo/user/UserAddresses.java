package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserAddresses implements Serializable {
    private Integer addressId;

    private String addressName;

    private Integer userId;

    /**
     * 收货人名
     */
    private String name;

    private String address;

    private String zipcode;

    private String phone;

    private String bestTime;

    /**
     * 默认收货地址
     */
    private String isDefault;

    private Integer peisong;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private String about;

    private static final long serialVersionUID = 1L;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBestTime() {
        return bestTime;
    }

    public void setBestTime(String bestTime) {
        this.bestTime = bestTime == null ? null : bestTime.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public Integer getPeisong() {
        return peisong;
    }

    public void setPeisong(Integer peisong) {
        this.peisong = peisong;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", addressName=").append(addressName);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", phone=").append(phone);
        sb.append(", bestTime=").append(bestTime);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", peisong=").append(peisong);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", about=").append(about);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}