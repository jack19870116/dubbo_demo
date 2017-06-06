package com.tiancaibao.pojo.pay.sina;

public class QueryBalanceResponseParam extends SinaBaseResponseParam{
	
	private static final long serialVersionUID = 1L;

	private Double balance;
	
	private Double available_balance;
	
	private String bonus;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getAvailable_balance() {
		return available_balance;
	}

	public void setAvailable_balance(Double available_balance) {
		this.available_balance = available_balance;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "QueryBalanceResponseParam [" + (balance != null ? "balance=" + balance + ", " : "")
				+ (available_balance != null ? "available_balance=" + available_balance + ", " : "")
				+ (bonus != null ? "bonus=" + bonus + ", " : "")
				+ (getResponse_time() != null ? "getResponse_time()=" + getResponse_time() + ", " : "")
				+ (get_input_charset() != null ? "get_input_charset()=" + get_input_charset() + ", " : "")
				+ (getSign() != null ? "getSign()=" + getSign() + ", " : "")
				+ (getSign_type() != null ? "getSign_type()=" + getSign_type() + ", " : "")
				+ (getResponse_code() != null ? "getResponse_code()=" + getResponse_code() + ", " : "")
				+ (getPartner_id() != null ? "getPartner_id()=" + getPartner_id() + ", " : "")
				+ (getResponse_message() != null ? "getResponse_message()=" + getResponse_message() + ", " : "")
				+ (getMemo() != null ? "getMemo()=" + getMemo() + ", " : "")
				+ (getSign_version() != null ? "getSign_version()=" + getSign_version() : "") + "]";
	}
	
}
