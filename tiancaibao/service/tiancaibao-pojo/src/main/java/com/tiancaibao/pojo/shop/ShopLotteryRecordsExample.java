package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopLotteryRecordsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    private static final long serialVersionUID = 1L;

    public ShopLotteryRecordsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNull() {
            addCriterion("lottery_type is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNotNull() {
            addCriterion("lottery_type is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeEqualTo(Integer value) {
            addCriterion("lottery_type =", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotEqualTo(Integer value) {
            addCriterion("lottery_type <>", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThan(Integer value) {
            addCriterion("lottery_type >", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_type >=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThan(Integer value) {
            addCriterion("lottery_type <", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_type <=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIn(List<Integer> values) {
            addCriterion("lottery_type in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotIn(List<Integer> values) {
            addCriterion("lottery_type not in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type not between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryValueIsNull() {
            addCriterion("lottery_value is null");
            return (Criteria) this;
        }

        public Criteria andLotteryValueIsNotNull() {
            addCriterion("lottery_value is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryValueEqualTo(Double value) {
            addCriterion("lottery_value =", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueNotEqualTo(Double value) {
            addCriterion("lottery_value <>", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueGreaterThan(Double value) {
            addCriterion("lottery_value >", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueGreaterThanOrEqualTo(Double value) {
            addCriterion("lottery_value >=", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueLessThan(Double value) {
            addCriterion("lottery_value <", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueLessThanOrEqualTo(Double value) {
            addCriterion("lottery_value <=", value, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueIn(List<Double> values) {
            addCriterion("lottery_value in", values, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueNotIn(List<Double> values) {
            addCriterion("lottery_value not in", values, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueBetween(Double value1, Double value2) {
            addCriterion("lottery_value between", value1, value2, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andLotteryValueNotBetween(Double value1, Double value2) {
            addCriterion("lottery_value not between", value1, value2, "lotteryValue");
            return (Criteria) this;
        }

        public Criteria andGquantityIsNull() {
            addCriterion("gquantity is null");
            return (Criteria) this;
        }

        public Criteria andGquantityIsNotNull() {
            addCriterion("gquantity is not null");
            return (Criteria) this;
        }

        public Criteria andGquantityEqualTo(Integer value) {
            addCriterion("gquantity =", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityNotEqualTo(Integer value) {
            addCriterion("gquantity <>", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityGreaterThan(Integer value) {
            addCriterion("gquantity >", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("gquantity >=", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityLessThan(Integer value) {
            addCriterion("gquantity <", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityLessThanOrEqualTo(Integer value) {
            addCriterion("gquantity <=", value, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityIn(List<Integer> values) {
            addCriterion("gquantity in", values, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityNotIn(List<Integer> values) {
            addCriterion("gquantity not in", values, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityBetween(Integer value1, Integer value2) {
            addCriterion("gquantity between", value1, value2, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("gquantity not between", value1, value2, "gquantity");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceIsNull() {
            addCriterion("gtotal_price is null");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceIsNotNull() {
            addCriterion("gtotal_price is not null");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceEqualTo(Long value) {
            addCriterion("gtotal_price =", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceNotEqualTo(Long value) {
            addCriterion("gtotal_price <>", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceGreaterThan(Long value) {
            addCriterion("gtotal_price >", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("gtotal_price >=", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceLessThan(Long value) {
            addCriterion("gtotal_price <", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("gtotal_price <=", value, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceIn(List<Long> values) {
            addCriterion("gtotal_price in", values, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceNotIn(List<Long> values) {
            addCriterion("gtotal_price not in", values, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceBetween(Long value1, Long value2) {
            addCriterion("gtotal_price between", value1, value2, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andGtotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("gtotal_price not between", value1, value2, "gtotalPrice");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdIsNull() {
            addCriterion("lottery_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdIsNotNull() {
            addCriterion("lottery_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdEqualTo(Long value) {
            addCriterion("lottery_bill_id =", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdNotEqualTo(Long value) {
            addCriterion("lottery_bill_id <>", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdGreaterThan(Long value) {
            addCriterion("lottery_bill_id >", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lottery_bill_id >=", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdLessThan(Long value) {
            addCriterion("lottery_bill_id <", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdLessThanOrEqualTo(Long value) {
            addCriterion("lottery_bill_id <=", value, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdIn(List<Long> values) {
            addCriterion("lottery_bill_id in", values, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdNotIn(List<Long> values) {
            addCriterion("lottery_bill_id not in", values, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdBetween(Long value1, Long value2) {
            addCriterion("lottery_bill_id between", value1, value2, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andLotteryBillIdNotBetween(Long value1, Long value2) {
            addCriterion("lottery_bill_id not between", value1, value2, "lotteryBillId");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGzoneIsNull() {
            addCriterion("gzone is null");
            return (Criteria) this;
        }

        public Criteria andGzoneIsNotNull() {
            addCriterion("gzone is not null");
            return (Criteria) this;
        }

        public Criteria andGzoneEqualTo(Byte value) {
            addCriterion("gzone =", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneNotEqualTo(Byte value) {
            addCriterion("gzone <>", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneGreaterThan(Byte value) {
            addCriterion("gzone >", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneGreaterThanOrEqualTo(Byte value) {
            addCriterion("gzone >=", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneLessThan(Byte value) {
            addCriterion("gzone <", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneLessThanOrEqualTo(Byte value) {
            addCriterion("gzone <=", value, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneIn(List<Byte> values) {
            addCriterion("gzone in", values, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneNotIn(List<Byte> values) {
            addCriterion("gzone not in", values, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneBetween(Byte value1, Byte value2) {
            addCriterion("gzone between", value1, value2, "gzone");
            return (Criteria) this;
        }

        public Criteria andGzoneNotBetween(Byte value1, Byte value2) {
            addCriterion("gzone not between", value1, value2, "gzone");
            return (Criteria) this;
        }

        public Criteria andGaddrIsNull() {
            addCriterion("gaddr is null");
            return (Criteria) this;
        }

        public Criteria andGaddrIsNotNull() {
            addCriterion("gaddr is not null");
            return (Criteria) this;
        }

        public Criteria andGaddrEqualTo(String value) {
            addCriterion("gaddr =", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrNotEqualTo(String value) {
            addCriterion("gaddr <>", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrGreaterThan(String value) {
            addCriterion("gaddr >", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrGreaterThanOrEqualTo(String value) {
            addCriterion("gaddr >=", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrLessThan(String value) {
            addCriterion("gaddr <", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrLessThanOrEqualTo(String value) {
            addCriterion("gaddr <=", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrLike(String value) {
            addCriterion("gaddr like", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrNotLike(String value) {
            addCriterion("gaddr not like", value, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrIn(List<String> values) {
            addCriterion("gaddr in", values, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrNotIn(List<String> values) {
            addCriterion("gaddr not in", values, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrBetween(String value1, String value2) {
            addCriterion("gaddr between", value1, value2, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGaddrNotBetween(String value1, String value2) {
            addCriterion("gaddr not between", value1, value2, "gaddr");
            return (Criteria) this;
        }

        public Criteria andGpostcodeIsNull() {
            addCriterion("gpostcode is null");
            return (Criteria) this;
        }

        public Criteria andGpostcodeIsNotNull() {
            addCriterion("gpostcode is not null");
            return (Criteria) this;
        }

        public Criteria andGpostcodeEqualTo(String value) {
            addCriterion("gpostcode =", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeNotEqualTo(String value) {
            addCriterion("gpostcode <>", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeGreaterThan(String value) {
            addCriterion("gpostcode >", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("gpostcode >=", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeLessThan(String value) {
            addCriterion("gpostcode <", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeLessThanOrEqualTo(String value) {
            addCriterion("gpostcode <=", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeLike(String value) {
            addCriterion("gpostcode like", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeNotLike(String value) {
            addCriterion("gpostcode not like", value, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeIn(List<String> values) {
            addCriterion("gpostcode in", values, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeNotIn(List<String> values) {
            addCriterion("gpostcode not in", values, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeBetween(String value1, String value2) {
            addCriterion("gpostcode between", value1, value2, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGpostcodeNotBetween(String value1, String value2) {
            addCriterion("gpostcode not between", value1, value2, "gpostcode");
            return (Criteria) this;
        }

        public Criteria andGphoneIsNull() {
            addCriterion("gphone is null");
            return (Criteria) this;
        }

        public Criteria andGphoneIsNotNull() {
            addCriterion("gphone is not null");
            return (Criteria) this;
        }

        public Criteria andGphoneEqualTo(String value) {
            addCriterion("gphone =", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotEqualTo(String value) {
            addCriterion("gphone <>", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneGreaterThan(String value) {
            addCriterion("gphone >", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneGreaterThanOrEqualTo(String value) {
            addCriterion("gphone >=", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLessThan(String value) {
            addCriterion("gphone <", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLessThanOrEqualTo(String value) {
            addCriterion("gphone <=", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLike(String value) {
            addCriterion("gphone like", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotLike(String value) {
            addCriterion("gphone not like", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneIn(List<String> values) {
            addCriterion("gphone in", values, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotIn(List<String> values) {
            addCriterion("gphone not in", values, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneBetween(String value1, String value2) {
            addCriterion("gphone between", value1, value2, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotBetween(String value1, String value2) {
            addCriterion("gphone not between", value1, value2, "gphone");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThan(Date value) {
            addCriterion("deleted_at <", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}