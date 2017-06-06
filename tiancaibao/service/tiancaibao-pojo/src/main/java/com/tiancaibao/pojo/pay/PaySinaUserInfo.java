package com.tiancaibao.pojo.pay;

import java.io.Serializable;
import java.util.Date;

public class PaySinaUserInfo implements Serializable {
    private Long id;

    private String sinaidcardnumber;
    
    private Long userId;

    private Long sinapayUid;

    private String sinapayBankCard;

    private String phone;

    private Long sinapayAmount;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String verifyTicket;

    private String cardId;

    private String bankPhone;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSinaidcardnumber() {
		return sinaidcardnumber;
	}

	public void setSinaidcardnumber(String sinaidcardnumber) {
		this.sinaidcardnumber = sinaidcardnumber;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSinapayUid() {
        return sinapayUid;
    }

    public void setSinapayUid(Long sinapayUid) {
        this.sinapayUid = sinapayUid;
    }

    public String getSinapayBankCard() {
        return sinapayBankCard;
    }

    public void setSinapayBankCard(String sinapayBankCard) {
        this.sinapayBankCard = sinapayBankCard == null ? null : sinapayBankCard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getSinapayAmount() {
        return sinapayAmount;
    }

    public void setSinapayAmount(Long sinapayAmount) {
        this.sinapayAmount = sinapayAmount;
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

    public String getVerifyTicket() {
        return verifyTicket;
    }

    public void setVerifyTicket(String verifyTicket) {
        this.verifyTicket = verifyTicket == null ? null : verifyTicket.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone == null ? null : bankPhone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", sinapayUid=").append(sinapayUid);
        sb.append(", sinapayBankCard=").append(sinapayBankCard);
        sb.append(", phone=").append(phone);
        sb.append(", sinapayAmount=").append(sinapayAmount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", verifyTicket=").append(verifyTicket);
        sb.append(", cardId=").append(cardId);
        sb.append(", bankPhone=").append(bankPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}