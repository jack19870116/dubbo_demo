package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tiancaibao.utils.NumberFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable {
	private Long id;

	private String name;

	private String idcardName;

	private Long amount;

	private Long fixedAmount;

	private Long accountAmount;

	private String idcardNumber;

	private String idcardProvince;

	private String phone;

	private Long invitedByUserId;

	private Long talentValue;

	private Long tenderAmount;

	private String password;

	private Boolean isEncryption;

	private String tradingPassword;

	private Date oneThousandAt;

	private Date twoThousandAt;

	private Date fiveThousandAt;

	private Date deletedAt;

	private String rememberToken;

	private Date createdAt;

	private Date updatedAt;

	private String openId;

	private String agentNum;

	private String huifuPassword;

	private String ybBankcard;

	private String ybBankinfo;

	private Integer mark;

	private Integer isDeal;

	private Integer isSend;

	private Short groupId;

	private Integer channelId;

	private Integer integral;

	private Integer signNum;

	private String birthday;

	private Date realNameAt;

	private Short isPromoter;

	private String ip;

	private Byte errorCount;

	private Byte isLocking;

	private static final long serialVersionUID = 1L;

	public String getIdcardProvince() {
		return idcardProvince;
	}

	public void setIdcardProvince(String idcardProvince) {
		this.idcardProvince = idcardProvince;
	}

	public Boolean getIsEncryption() {
		return isEncryption;
	}

	public void setIsEncryption(Boolean isEncryption) {
		this.isEncryption = isEncryption;
	}

	public Date getRealNameAt() {
		return realNameAt;
	}

	public void setRealNameAt(Date realNameAt) {
		this.realNameAt = realNameAt;
	}

	public Short getIsPromoter() {
		return isPromoter;
	}

	public void setIsPromoter(Short isPromoter) {
		this.isPromoter = isPromoter;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Byte getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Byte errorCount) {
		this.errorCount = errorCount;
	}

	public Byte getIsLocking() {
		return isLocking;
	}

	public void setIsLocking(Byte isLocking) {
		this.isLocking = isLocking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getIdcardName() {
		return idcardName;
	}

	public void setIdcardName(String idcardName) {
		this.idcardName = idcardName == null ? null : idcardName.trim();
	}

	public String getIdcardNumber() {
		return idcardNumber;
	}

	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber == null ? null : idcardNumber.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public Long getInvitedByUserId() {
		return invitedByUserId;
	}

	public void setInvitedByUserId(Long invitedByUserId) {
		this.invitedByUserId = invitedByUserId;
	}

	public Long getTalentValue() {
		return talentValue;
	}

	public void setTalentValue(Long talentValue) {
		this.talentValue = talentValue;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getTradingPassword() {
		return tradingPassword;
	}

	public void setTradingPassword(String tradingPassword) {
		this.tradingPassword = tradingPassword == null ? null : tradingPassword.trim();
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getOneThousandAt() {
		return oneThousandAt;
	}

	public void setOneThousandAt(Date oneThousandAt) {
		this.oneThousandAt = oneThousandAt;
	}

	public Date getTwoThousandAt() {
		return twoThousandAt;
	}

	public void setTwoThousandAt(Date twoThousandAt) {
		this.twoThousandAt = twoThousandAt;
	}

	public Date getFiveThousandAt() {
		return fiveThousandAt;
	}

	public void setFiveThousandAt(Date fiveThousandAt) {
		this.fiveThousandAt = fiveThousandAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken == null ? null : rememberToken.trim();
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public Long getFixedAmount() {
		return fixedAmount;
	}

	public void setFixedAmount(Long fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public Long getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(Long accountAmount) {
		this.accountAmount = accountAmount;
	}

	public String getAgentNum() {
		return agentNum;
	}

	public void setAgentNum(String agentNum) {
		this.agentNum = agentNum == null ? null : agentNum.trim();
	}

	public String getHuifuPassword() {
		return huifuPassword;
	}

	public void setHuifuPassword(String huifuPassword) {
		this.huifuPassword = huifuPassword == null ? null : huifuPassword.trim();
	}

	public String getYbBankcard() {
		return ybBankcard;
	}

	public void setYbBankcard(String ybBankcard) {
		this.ybBankcard = ybBankcard == null ? null : ybBankcard.trim();
	}

	public String getYbBankinfo() {
		return ybBankinfo;
	}

	public void setYbBankinfo(String ybBankinfo) {
		this.ybBankinfo = ybBankinfo == null ? null : ybBankinfo.trim();
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}

	public Integer getIsSend() {
		return isSend;
	}

	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}

	public Short getGroupId() {
		return groupId;
	}

	public void setGroupId(Short groupId) {
		this.groupId = groupId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getSignNum() {
		return signNum;
	}

	public void setSignNum(Integer signNum) {
		this.signNum = signNum;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public Long getTenderAmount() {
		return tenderAmount;
	}

	public void setTenderAmount(Long tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", idcardName=" + idcardName + ", amount=" + amount
				+ ", fixedAmount=" + fixedAmount + ", accountAmount=" + accountAmount + ", idcardNumber=" + idcardNumber
				+ ", idcardProvince=" + idcardProvince + ", phone=" + phone + ", invitedByUserId=" + invitedByUserId
				+ ", talentValue=" + talentValue + ",tenderAmount=" + tenderAmount + ", password=" + password
				+ ", isEncryption=" + isEncryption + ", tradingPassword=" + tradingPassword + ", oneThousandAt="
				+ oneThousandAt + ", twoThousandAt=" + twoThousandAt + ", fiveThousandAt=" + fiveThousandAt
				+ ", deletedAt=" + deletedAt + ", rememberToken=" + rememberToken + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", openId=" + openId + ", agentNum=" + agentNum + ", huifuPassword="
				+ huifuPassword + ", ybBankcard=" + ybBankcard + ", ybBankinfo=" + ybBankinfo + ", mark=" + mark
				+ ", isDeal=" + isDeal + ", isSend=" + isSend + ", groupId=" + groupId + ", channelId=" + channelId
				+ ", integral=" + integral + ", signNum=" + signNum + ", birthday=" + birthday + ", realNameAt="
				+ realNameAt + ", isPromoter=" + isPromoter + ", ip=" + ip + ", errorCount=" + errorCount
				+ ", isLocking=" + isLocking + "]";
	}

	public Double credit() {
		Long credit = 0L;
		Long talent = this.talentValue;

		Long ownAmount = this.amount;

		if (talent <= 99) {
			credit = 0L;
		} else if (talent > 99 && talent <= 299) {
			credit = 50000 - ownAmount;
		} else if (talent > 299 && talent <= 599) {
			credit = 100000 - ownAmount;
		} else if (talent > 599 && talent <= 899) {
			credit = 150000 - ownAmount;
		} else {
			credit = 200000 - ownAmount;
		}

		return   NumberFormat.doubleSplitTwoDecimal(credit.doubleValue()<0?0.00:credit.doubleValue());

	}

	
	
	public static void main(String[] args) {
		Users user=new Users();
		user.setAmount(123L);
		user.setTalentValue(200L);
		System.out.println(user.credit());
		
	}
	
	
	
	
	
	
}