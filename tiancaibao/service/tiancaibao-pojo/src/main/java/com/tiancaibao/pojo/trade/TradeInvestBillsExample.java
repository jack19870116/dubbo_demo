package com.tiancaibao.pojo.trade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeInvestBillsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    protected String fields;

    private static final long serialVersionUID = 1L;

    public TradeInvestBillsExample() {
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

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andYborderidIsNull() {
            addCriterion("yborderid is null");
            return (Criteria) this;
        }

        public Criteria andYborderidIsNotNull() {
            addCriterion("yborderid is not null");
            return (Criteria) this;
        }

        public Criteria andYborderidEqualTo(String value) {
            addCriterion("yborderid =", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidNotEqualTo(String value) {
            addCriterion("yborderid <>", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidGreaterThan(String value) {
            addCriterion("yborderid >", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidGreaterThanOrEqualTo(String value) {
            addCriterion("yborderid >=", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidLessThan(String value) {
            addCriterion("yborderid <", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidLessThanOrEqualTo(String value) {
            addCriterion("yborderid <=", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidLike(String value) {
            addCriterion("yborderid like", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidNotLike(String value) {
            addCriterion("yborderid not like", value, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidIn(List<String> values) {
            addCriterion("yborderid in", values, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidNotIn(List<String> values) {
            addCriterion("yborderid not in", values, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidBetween(String value1, String value2) {
            addCriterion("yborderid between", value1, value2, "yborderid");
            return (Criteria) this;
        }

        public Criteria andYborderidNotBetween(String value1, String value2) {
            addCriterion("yborderid not between", value1, value2, "yborderid");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtIsNull() {
            addCriterion("confirmed_at is null");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtIsNotNull() {
            addCriterion("confirmed_at is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtEqualTo(Date value) {
            addCriterion("confirmed_at =", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtNotEqualTo(Date value) {
            addCriterion("confirmed_at <>", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtGreaterThan(Date value) {
            addCriterion("confirmed_at >", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("confirmed_at >=", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtLessThan(Date value) {
            addCriterion("confirmed_at <", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtLessThanOrEqualTo(Date value) {
            addCriterion("confirmed_at <=", value, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtIn(List<Date> values) {
            addCriterion("confirmed_at in", values, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtNotIn(List<Date> values) {
            addCriterion("confirmed_at not in", values, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtBetween(Date value1, Date value2) {
            addCriterion("confirmed_at between", value1, value2, "confirmedAt");
            return (Criteria) this;
        }

        public Criteria andConfirmedAtNotBetween(Date value1, Date value2) {
            addCriterion("confirmed_at not between", value1, value2, "confirmedAt");
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

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Long value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Long value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Long value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Long value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Long value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Long value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Long> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Long> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Long value1, Long value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Long value1, Long value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andInterestIdIsNull() {
            addCriterion("interest_id is null");
            return (Criteria) this;
        }

        public Criteria andInterestIdIsNotNull() {
            addCriterion("interest_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterestIdEqualTo(Integer value) {
            addCriterion("interest_id =", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdNotEqualTo(Integer value) {
            addCriterion("interest_id <>", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdGreaterThan(Integer value) {
            addCriterion("interest_id >", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("interest_id >=", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdLessThan(Integer value) {
            addCriterion("interest_id <", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdLessThanOrEqualTo(Integer value) {
            addCriterion("interest_id <=", value, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdIn(List<Integer> values) {
            addCriterion("interest_id in", values, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdNotIn(List<Integer> values) {
            addCriterion("interest_id not in", values, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdBetween(Integer value1, Integer value2) {
            addCriterion("interest_id between", value1, value2, "interestId");
            return (Criteria) this;
        }

        public Criteria andInterestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("interest_id not between", value1, value2, "interestId");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestIsNull() {
            addCriterion("is_auto_invest is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestIsNotNull() {
            addCriterion("is_auto_invest is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestEqualTo(Byte value) {
            addCriterion("is_auto_invest =", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestNotEqualTo(Byte value) {
            addCriterion("is_auto_invest <>", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestGreaterThan(Byte value) {
            addCriterion("is_auto_invest >", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_auto_invest >=", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestLessThan(Byte value) {
            addCriterion("is_auto_invest <", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestLessThanOrEqualTo(Byte value) {
            addCriterion("is_auto_invest <=", value, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestIn(List<Byte> values) {
            addCriterion("is_auto_invest in", values, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestNotIn(List<Byte> values) {
            addCriterion("is_auto_invest not in", values, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestBetween(Byte value1, Byte value2) {
            addCriterion("is_auto_invest between", value1, value2, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIsAutoInvestNotBetween(Byte value1, Byte value2) {
            addCriterion("is_auto_invest not between", value1, value2, "isAutoInvest");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpInfoIsNull() {
            addCriterion("ip_info is null");
            return (Criteria) this;
        }

        public Criteria andIpInfoIsNotNull() {
            addCriterion("ip_info is not null");
            return (Criteria) this;
        }

        public Criteria andIpInfoEqualTo(String value) {
            addCriterion("ip_info =", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoNotEqualTo(String value) {
            addCriterion("ip_info <>", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoGreaterThan(String value) {
            addCriterion("ip_info >", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ip_info >=", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoLessThan(String value) {
            addCriterion("ip_info <", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoLessThanOrEqualTo(String value) {
            addCriterion("ip_info <=", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoLike(String value) {
            addCriterion("ip_info like", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoNotLike(String value) {
            addCriterion("ip_info not like", value, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoIn(List<String> values) {
            addCriterion("ip_info in", values, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoNotIn(List<String> values) {
            addCriterion("ip_info not in", values, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoBetween(String value1, String value2) {
            addCriterion("ip_info between", value1, value2, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpInfoNotBetween(String value1, String value2) {
            addCriterion("ip_info not between", value1, value2, "ipInfo");
            return (Criteria) this;
        }

        public Criteria andIpRegionIsNull() {
            addCriterion("ip_region is null");
            return (Criteria) this;
        }

        public Criteria andIpRegionIsNotNull() {
            addCriterion("ip_region is not null");
            return (Criteria) this;
        }

        public Criteria andIpRegionEqualTo(String value) {
            addCriterion("ip_region =", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionNotEqualTo(String value) {
            addCriterion("ip_region <>", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionGreaterThan(String value) {
            addCriterion("ip_region >", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionGreaterThanOrEqualTo(String value) {
            addCriterion("ip_region >=", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionLessThan(String value) {
            addCriterion("ip_region <", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionLessThanOrEqualTo(String value) {
            addCriterion("ip_region <=", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionLike(String value) {
            addCriterion("ip_region like", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionNotLike(String value) {
            addCriterion("ip_region not like", value, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionIn(List<String> values) {
            addCriterion("ip_region in", values, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionNotIn(List<String> values) {
            addCriterion("ip_region not in", values, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionBetween(String value1, String value2) {
            addCriterion("ip_region between", value1, value2, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andIpRegionNotBetween(String value1, String value2) {
            addCriterion("ip_region not between", value1, value2, "ipRegion");
            return (Criteria) this;
        }

        public Criteria andClientIsNull() {
            addCriterion("client is null");
            return (Criteria) this;
        }

        public Criteria andClientIsNotNull() {
            addCriterion("client is not null");
            return (Criteria) this;
        }

        public Criteria andClientEqualTo(String value) {
            addCriterion("client =", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotEqualTo(String value) {
            addCriterion("client <>", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThan(String value) {
            addCriterion("client >", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThanOrEqualTo(String value) {
            addCriterion("client >=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThan(String value) {
            addCriterion("client <", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThanOrEqualTo(String value) {
            addCriterion("client <=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLike(String value) {
            addCriterion("client like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotLike(String value) {
            addCriterion("client not like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientIn(List<String> values) {
            addCriterion("client in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotIn(List<String> values) {
            addCriterion("client not in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientBetween(String value1, String value2) {
            addCriterion("client between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotBetween(String value1, String value2) {
            addCriterion("client not between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andReinvestIsNull() {
            addCriterion("reinvest is null");
            return (Criteria) this;
        }

        public Criteria andReinvestIsNotNull() {
            addCriterion("reinvest is not null");
            return (Criteria) this;
        }

        public Criteria andReinvestEqualTo(Integer value) {
            addCriterion("reinvest =", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestNotEqualTo(Integer value) {
            addCriterion("reinvest <>", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestGreaterThan(Integer value) {
            addCriterion("reinvest >", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestGreaterThanOrEqualTo(Integer value) {
            addCriterion("reinvest >=", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestLessThan(Integer value) {
            addCriterion("reinvest <", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestLessThanOrEqualTo(Integer value) {
            addCriterion("reinvest <=", value, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestIn(List<Integer> values) {
            addCriterion("reinvest in", values, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestNotIn(List<Integer> values) {
            addCriterion("reinvest not in", values, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestBetween(Integer value1, Integer value2) {
            addCriterion("reinvest between", value1, value2, "reinvest");
            return (Criteria) this;
        }

        public Criteria andReinvestNotBetween(Integer value1, Integer value2) {
            addCriterion("reinvest not between", value1, value2, "reinvest");
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