package com.tiancaibao.pojo.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShopInterestCashCouponsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    private static final long serialVersionUID = 1L;

    public ShopInterestCashCouponsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(Integer value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Integer value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Integer value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Integer value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Integer value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Integer> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Integer> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Integer value1, Integer value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Integer value1, Integer value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(Integer value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(Integer value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(Integer value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(Integer value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(Integer value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<Integer> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<Integer> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(Integer value1, Integer value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("condition not between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
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

        public Criteria andStartlineIsNull() {
            addCriterion("startline is null");
            return (Criteria) this;
        }

        public Criteria andStartlineIsNotNull() {
            addCriterion("startline is not null");
            return (Criteria) this;
        }

        public Criteria andStartlineEqualTo(Date value) {
            addCriterionForJDBCDate("startline =", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("startline <>", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineGreaterThan(Date value) {
            addCriterionForJDBCDate("startline >", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startline >=", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineLessThan(Date value) {
            addCriterionForJDBCDate("startline <", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startline <=", value, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineIn(List<Date> values) {
            addCriterionForJDBCDate("startline in", values, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("startline not in", values, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startline between", value1, value2, "startline");
            return (Criteria) this;
        }

        public Criteria andStartlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startline not between", value1, value2, "startline");
            return (Criteria) this;
        }

        public Criteria andShopClassIdIsNull() {
            addCriterion("shop_class_id is null");
            return (Criteria) this;
        }

        public Criteria andShopClassIdIsNotNull() {
            addCriterion("shop_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopClassIdEqualTo(Long value) {
            addCriterion("shop_class_id =", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdNotEqualTo(Long value) {
            addCriterion("shop_class_id <>", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdGreaterThan(Long value) {
            addCriterion("shop_class_id >", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_class_id >=", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdLessThan(Long value) {
            addCriterion("shop_class_id <", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_class_id <=", value, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdIn(List<Long> values) {
            addCriterion("shop_class_id in", values, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdNotIn(List<Long> values) {
            addCriterion("shop_class_id not in", values, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdBetween(Long value1, Long value2) {
            addCriterion("shop_class_id between", value1, value2, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andShopClassIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_class_id not between", value1, value2, "shopClassId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNull() {
            addCriterion("shop_num is null");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNotNull() {
            addCriterion("shop_num is not null");
            return (Criteria) this;
        }

        public Criteria andShopNumEqualTo(Integer value) {
            addCriterion("shop_num =", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotEqualTo(Integer value) {
            addCriterion("shop_num <>", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThan(Integer value) {
            addCriterion("shop_num >", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_num >=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThan(Integer value) {
            addCriterion("shop_num <", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThanOrEqualTo(Integer value) {
            addCriterion("shop_num <=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumIn(List<Integer> values) {
            addCriterion("shop_num in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotIn(List<Integer> values) {
            addCriterion("shop_num not in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumBetween(Integer value1, Integer value2) {
            addCriterion("shop_num between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_num not between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andCnumIsNull() {
            addCriterion("cnum is null");
            return (Criteria) this;
        }

        public Criteria andCnumIsNotNull() {
            addCriterion("cnum is not null");
            return (Criteria) this;
        }

        public Criteria andCnumEqualTo(Integer value) {
            addCriterion("cnum =", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotEqualTo(Integer value) {
            addCriterion("cnum <>", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThan(Integer value) {
            addCriterion("cnum >", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cnum >=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThan(Integer value) {
            addCriterion("cnum <", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThanOrEqualTo(Integer value) {
            addCriterion("cnum <=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumIn(List<Integer> values) {
            addCriterion("cnum in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotIn(List<Integer> values) {
            addCriterion("cnum not in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumBetween(Integer value1, Integer value2) {
            addCriterion("cnum between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotBetween(Integer value1, Integer value2) {
            addCriterion("cnum not between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andSpicIsNull() {
            addCriterion("spic is null");
            return (Criteria) this;
        }

        public Criteria andSpicIsNotNull() {
            addCriterion("spic is not null");
            return (Criteria) this;
        }

        public Criteria andSpicEqualTo(String value) {
            addCriterion("spic =", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotEqualTo(String value) {
            addCriterion("spic <>", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicGreaterThan(String value) {
            addCriterion("spic >", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicGreaterThanOrEqualTo(String value) {
            addCriterion("spic >=", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLessThan(String value) {
            addCriterion("spic <", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLessThanOrEqualTo(String value) {
            addCriterion("spic <=", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLike(String value) {
            addCriterion("spic like", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotLike(String value) {
            addCriterion("spic not like", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicIn(List<String> values) {
            addCriterion("spic in", values, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotIn(List<String> values) {
            addCriterion("spic not in", values, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicBetween(String value1, String value2) {
            addCriterion("spic between", value1, value2, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotBetween(String value1, String value2) {
            addCriterion("spic not between", value1, value2, "spic");
            return (Criteria) this;
        }

        public Criteria andSimgIsNull() {
            addCriterion("simg is null");
            return (Criteria) this;
        }

        public Criteria andSimgIsNotNull() {
            addCriterion("simg is not null");
            return (Criteria) this;
        }

        public Criteria andSimgEqualTo(String value) {
            addCriterion("simg =", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgNotEqualTo(String value) {
            addCriterion("simg <>", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgGreaterThan(String value) {
            addCriterion("simg >", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgGreaterThanOrEqualTo(String value) {
            addCriterion("simg >=", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgLessThan(String value) {
            addCriterion("simg <", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgLessThanOrEqualTo(String value) {
            addCriterion("simg <=", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgLike(String value) {
            addCriterion("simg like", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgNotLike(String value) {
            addCriterion("simg not like", value, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgIn(List<String> values) {
            addCriterion("simg in", values, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgNotIn(List<String> values) {
            addCriterion("simg not in", values, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgBetween(String value1, String value2) {
            addCriterion("simg between", value1, value2, "simg");
            return (Criteria) this;
        }

        public Criteria andSimgNotBetween(String value1, String value2) {
            addCriterion("simg not between", value1, value2, "simg");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNull() {
            addCriterion("sprice is null");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNotNull() {
            addCriterion("sprice is not null");
            return (Criteria) this;
        }

        public Criteria andSpriceEqualTo(Long value) {
            addCriterion("sprice =", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotEqualTo(Long value) {
            addCriterion("sprice <>", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThan(Long value) {
            addCriterion("sprice >", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sprice >=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThan(Long value) {
            addCriterion("sprice <", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThanOrEqualTo(Long value) {
            addCriterion("sprice <=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceIn(List<Long> values) {
            addCriterion("sprice in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotIn(List<Long> values) {
            addCriterion("sprice not in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceBetween(Long value1, Long value2) {
            addCriterion("sprice between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotBetween(Long value1, Long value2) {
            addCriterion("sprice not between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("stime is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("stime is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(Date value) {
            addCriterion("stime =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(Date value) {
            addCriterion("stime <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(Date value) {
            addCriterion("stime >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stime >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(Date value) {
            addCriterion("stime <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(Date value) {
            addCriterion("stime <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<Date> values) {
            addCriterion("stime in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<Date> values) {
            addCriterion("stime not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(Date value1, Date value2) {
            addCriterion("stime between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(Date value1, Date value2) {
            addCriterion("stime not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andSisshopIsNull() {
            addCriterion("sisshop is null");
            return (Criteria) this;
        }

        public Criteria andSisshopIsNotNull() {
            addCriterion("sisshop is not null");
            return (Criteria) this;
        }

        public Criteria andSisshopEqualTo(Boolean value) {
            addCriterion("sisshop =", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotEqualTo(Boolean value) {
            addCriterion("sisshop <>", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopGreaterThan(Boolean value) {
            addCriterion("sisshop >", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sisshop >=", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopLessThan(Boolean value) {
            addCriterion("sisshop <", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopLessThanOrEqualTo(Boolean value) {
            addCriterion("sisshop <=", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopIn(List<Boolean> values) {
            addCriterion("sisshop in", values, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotIn(List<Boolean> values) {
            addCriterion("sisshop not in", values, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopBetween(Boolean value1, Boolean value2) {
            addCriterion("sisshop between", value1, value2, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sisshop not between", value1, value2, "sisshop");
            return (Criteria) this;
        }

        public Criteria andScountIsNull() {
            addCriterion("scount is null");
            return (Criteria) this;
        }

        public Criteria andScountIsNotNull() {
            addCriterion("scount is not null");
            return (Criteria) this;
        }

        public Criteria andScountEqualTo(Integer value) {
            addCriterion("scount =", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountNotEqualTo(Integer value) {
            addCriterion("scount <>", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountGreaterThan(Integer value) {
            addCriterion("scount >", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scount >=", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountLessThan(Integer value) {
            addCriterion("scount <", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountLessThanOrEqualTo(Integer value) {
            addCriterion("scount <=", value, "scount");
            return (Criteria) this;
        }

        public Criteria andScountIn(List<Integer> values) {
            addCriterion("scount in", values, "scount");
            return (Criteria) this;
        }

        public Criteria andScountNotIn(List<Integer> values) {
            addCriterion("scount not in", values, "scount");
            return (Criteria) this;
        }

        public Criteria andScountBetween(Integer value1, Integer value2) {
            addCriterion("scount between", value1, value2, "scount");
            return (Criteria) this;
        }

        public Criteria andScountNotBetween(Integer value1, Integer value2) {
            addCriterion("scount not between", value1, value2, "scount");
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

        public Criteria andSorderIsNull() {
            addCriterion("sorder is null");
            return (Criteria) this;
        }

        public Criteria andSorderIsNotNull() {
            addCriterion("sorder is not null");
            return (Criteria) this;
        }

        public Criteria andSorderEqualTo(Integer value) {
            addCriterion("sorder =", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderNotEqualTo(Integer value) {
            addCriterion("sorder <>", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderGreaterThan(Integer value) {
            addCriterion("sorder >", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sorder >=", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderLessThan(Integer value) {
            addCriterion("sorder <", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderLessThanOrEqualTo(Integer value) {
            addCriterion("sorder <=", value, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderIn(List<Integer> values) {
            addCriterion("sorder in", values, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderNotIn(List<Integer> values) {
            addCriterion("sorder not in", values, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderBetween(Integer value1, Integer value2) {
            addCriterion("sorder between", value1, value2, "sorder");
            return (Criteria) this;
        }

        public Criteria andSorderNotBetween(Integer value1, Integer value2) {
            addCriterion("sorder not between", value1, value2, "sorder");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNull() {
            addCriterion("limit_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNotNull() {
            addCriterion("limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeEqualTo(Integer value) {
            addCriterion("limit_time =", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotEqualTo(Integer value) {
            addCriterion("limit_time <>", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThan(Integer value) {
            addCriterion("limit_time >", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_time >=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThan(Integer value) {
            addCriterion("limit_time <", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("limit_time <=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIn(List<Integer> values) {
            addCriterion("limit_time in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotIn(List<Integer> values) {
            addCriterion("limit_time not in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeBetween(Integer value1, Integer value2) {
            addCriterion("limit_time between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_time not between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andSquareImgIsNull() {
            addCriterion("square_img is null");
            return (Criteria) this;
        }

        public Criteria andSquareImgIsNotNull() {
            addCriterion("square_img is not null");
            return (Criteria) this;
        }

        public Criteria andSquareImgEqualTo(String value) {
            addCriterion("square_img =", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgNotEqualTo(String value) {
            addCriterion("square_img <>", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgGreaterThan(String value) {
            addCriterion("square_img >", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgGreaterThanOrEqualTo(String value) {
            addCriterion("square_img >=", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgLessThan(String value) {
            addCriterion("square_img <", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgLessThanOrEqualTo(String value) {
            addCriterion("square_img <=", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgLike(String value) {
            addCriterion("square_img like", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgNotLike(String value) {
            addCriterion("square_img not like", value, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgIn(List<String> values) {
            addCriterion("square_img in", values, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgNotIn(List<String> values) {
            addCriterion("square_img not in", values, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgBetween(String value1, String value2) {
            addCriterion("square_img between", value1, value2, "squareImg");
            return (Criteria) this;
        }

        public Criteria andSquareImgNotBetween(String value1, String value2) {
            addCriterion("square_img not between", value1, value2, "squareImg");
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