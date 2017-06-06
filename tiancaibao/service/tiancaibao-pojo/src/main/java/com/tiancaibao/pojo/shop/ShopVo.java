package com.tiancaibao.pojo.shop;
/**
 * 用于实物兑换准备返回值
 * @author Mack
 *
 */
public class ShopVo {
	private Long id;
	private Long sprice;
	private Integer shop_num;
	private String simg;
	private String name;
	private Long shop_class_id;
	private Long gtotal_price;
	private Integer number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSprice() {
		return sprice;
	}
	public void setSprice(Long sprice) {
		this.sprice = sprice;
	}
	public Integer getShop_num() {
		return shop_num;
	}
	public void setShop_num(Integer shop_num) {
		this.shop_num = shop_num;
	}
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getShop_class_id() {
		return shop_class_id;
	}
	public void setShop_class_id(Long shop_class_id) {
		this.shop_class_id = shop_class_id;
	}
	public Long getGtotal_price() {
		return gtotal_price;
	}
	public void setGtotal_price(Long gtotal_price) {
		this.gtotal_price = gtotal_price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
