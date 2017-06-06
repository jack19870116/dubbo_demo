package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopLotteryExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    private static final long serialVersionUID = 1L;

    public ShopLotteryExample() {
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

        public Criteria andProbabilityIsNull() {
            addCriterion("probability is null");
            return (Criteria) this;
        }

        public Criteria andProbabilityIsNotNull() {
            addCriterion("probability is not null");
            return (Criteria) this;
        }

        public Criteria andProbabilityEqualTo(Integer value) {
            addCriterion("probability =", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotEqualTo(Integer value) {
            addCriterion("probability <>", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThan(Integer value) {
            addCriterion("probability >", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityGreaterThanOrEqualTo(Integer value) {
            addCriterion("probability >=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThan(Integer value) {
            addCriterion("probability <", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityLessThanOrEqualTo(Integer value) {
            addCriterion("probability <=", value, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityIn(List<Integer> values) {
            addCriterion("probability in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotIn(List<Integer> values) {
            addCriterion("probability not in", values, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityBetween(Integer value1, Integer value2) {
            addCriterion("probability between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andProbabilityNotBetween(Integer value1, Integer value2) {
            addCriterion("probability not between", value1, value2, "probability");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelIsNull() {
            addCriterion("lottery_level is null");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelIsNotNull() {
            addCriterion("lottery_level is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelEqualTo(Byte value) {
            addCriterion("lottery_level =", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelNotEqualTo(Byte value) {
            addCriterion("lottery_level <>", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelGreaterThan(Byte value) {
            addCriterion("lottery_level >", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("lottery_level >=", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelLessThan(Byte value) {
            addCriterion("lottery_level <", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelLessThanOrEqualTo(Byte value) {
            addCriterion("lottery_level <=", value, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelIn(List<Byte> values) {
            addCriterion("lottery_level in", values, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelNotIn(List<Byte> values) {
            addCriterion("lottery_level not in", values, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelBetween(Byte value1, Byte value2) {
            addCriterion("lottery_level between", value1, value2, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("lottery_level not between", value1, value2, "lotteryLevel");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderIsNull() {
            addCriterion("lottery_order is null");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderIsNotNull() {
            addCriterion("lottery_order is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderEqualTo(Integer value) {
            addCriterion("lottery_order =", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderNotEqualTo(Integer value) {
            addCriterion("lottery_order <>", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderGreaterThan(Integer value) {
            addCriterion("lottery_order >", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_order >=", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderLessThan(Integer value) {
            addCriterion("lottery_order <", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_order <=", value, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderIn(List<Integer> values) {
            addCriterion("lottery_order in", values, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderNotIn(List<Integer> values) {
            addCriterion("lottery_order not in", values, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderBetween(Integer value1, Integer value2) {
            addCriterion("lottery_order between", value1, value2, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_order not between", value1, value2, "lotteryOrder");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusIsNull() {
            addCriterion("lottery_status is null");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusIsNotNull() {
            addCriterion("lottery_status is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusEqualTo(Integer value) {
            addCriterion("lottery_status =", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusNotEqualTo(Integer value) {
            addCriterion("lottery_status <>", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusGreaterThan(Integer value) {
            addCriterion("lottery_status >", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_status >=", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusLessThan(Integer value) {
            addCriterion("lottery_status <", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_status <=", value, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusIn(List<Integer> values) {
            addCriterion("lottery_status in", values, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusNotIn(List<Integer> values) {
            addCriterion("lottery_status not in", values, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusBetween(Integer value1, Integer value2) {
            addCriterion("lottery_status between", value1, value2, "lotteryStatus");
            return (Criteria) this;
        }

        public Criteria andLotteryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_status not between", value1, value2, "lotteryStatus");
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

        public Criteria andLotteryImageIsNull() {
            addCriterion("lottery_image is null");
            return (Criteria) this;
        }

        public Criteria andLotteryImageIsNotNull() {
            addCriterion("lottery_image is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryImageEqualTo(String value) {
            addCriterion("lottery_image =", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageNotEqualTo(String value) {
            addCriterion("lottery_image <>", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageGreaterThan(String value) {
            addCriterion("lottery_image >", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_image >=", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageLessThan(String value) {
            addCriterion("lottery_image <", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageLessThanOrEqualTo(String value) {
            addCriterion("lottery_image <=", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageLike(String value) {
            addCriterion("lottery_image like", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageNotLike(String value) {
            addCriterion("lottery_image not like", value, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageIn(List<String> values) {
            addCriterion("lottery_image in", values, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageNotIn(List<String> values) {
            addCriterion("lottery_image not in", values, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageBetween(String value1, String value2) {
            addCriterion("lottery_image between", value1, value2, "lotteryImage");
            return (Criteria) this;
        }

        public Criteria andLotteryImageNotBetween(String value1, String value2) {
            addCriterion("lottery_image not between", value1, value2, "lotteryImage");
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