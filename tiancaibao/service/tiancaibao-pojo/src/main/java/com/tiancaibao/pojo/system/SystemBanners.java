package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.Date;

public class SystemBanners implements Serializable {
    private Integer id;

    private Byte requiredLogin;

    private String imageUrl;

    private String redirectUrl;

    private String redirectPcUrl;

    private String pcImageUrl;

    private Date deletedAt;

    private Date createdAt;

    private Date updatedAt;

    private Byte mark;

    private Byte inset;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getRequiredLogin() {
        return requiredLogin;
    }

    public void setRequiredLogin(Byte requiredLogin) {
        this.requiredLogin = requiredLogin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    public String getRedirectPcUrl() {
        return redirectPcUrl;
    }

    public void setRedirectPcUrl(String redirectPcUrl) {
        this.redirectPcUrl = redirectPcUrl == null ? null : redirectPcUrl.trim();
    }

    public String getPcImageUrl() {
        return pcImageUrl;
    }

    public void setPcImageUrl(String pcImageUrl) {
        this.pcImageUrl = pcImageUrl == null ? null : pcImageUrl.trim();
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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

    public Byte getMark() {
        return mark;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }

    public Byte getInset() {
        return inset;
    }

    public void setInset(Byte inset) {
        this.inset = inset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", requiredLogin=").append(requiredLogin);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", redirectUrl=").append(redirectUrl);
        sb.append(", redirectPcUrl=").append(redirectPcUrl);
        sb.append(", pcImageUrl=").append(pcImageUrl);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", mark=").append(mark);
        sb.append(", inset=").append(inset);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}