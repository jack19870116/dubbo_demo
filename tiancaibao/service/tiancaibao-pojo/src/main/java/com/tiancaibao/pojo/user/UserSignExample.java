package com.tiancaibao.pojo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserSignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserSignExample() {
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
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
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

        public Criteria andActiveIdIsNull() {
            addCriterion("active_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("active_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(Integer value) {
            addCriterion("active_id =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(Integer value) {
            addCriterion("active_id <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(Integer value) {
            addCriterion("active_id >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_id >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(Integer value) {
            addCriterion("active_id <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("active_id <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<Integer> values) {
            addCriterion("active_id in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<Integer> values) {
            addCriterion("active_id not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("active_id between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("active_id not between", value1, value2, "activeId");
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

        public Criteria andHitSumIsNull() {
            addCriterion("hit_sum is null");
            return (Criteria) this;
        }

        public Criteria andHitSumIsNotNull() {
            addCriterion("hit_sum is not null");
            return (Criteria) this;
        }

        public Criteria andHitSumEqualTo(Short value) {
            addCriterion("hit_sum =", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumNotEqualTo(Short value) {
            addCriterion("hit_sum <>", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumGreaterThan(Short value) {
            addCriterion("hit_sum >", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumGreaterThanOrEqualTo(Short value) {
            addCriterion("hit_sum >=", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumLessThan(Short value) {
            addCriterion("hit_sum <", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumLessThanOrEqualTo(Short value) {
            addCriterion("hit_sum <=", value, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumIn(List<Short> values) {
            addCriterion("hit_sum in", values, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumNotIn(List<Short> values) {
            addCriterion("hit_sum not in", values, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumBetween(Short value1, Short value2) {
            addCriterion("hit_sum between", value1, value2, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitSumNotBetween(Short value1, Short value2) {
            addCriterion("hit_sum not between", value1, value2, "hitSum");
            return (Criteria) this;
        }

        public Criteria andHitCurIsNull() {
            addCriterion("hit_cur is null");
            return (Criteria) this;
        }

        public Criteria andHitCurIsNotNull() {
            addCriterion("hit_cur is not null");
            return (Criteria) this;
        }

        public Criteria andHitCurEqualTo(Short value) {
            addCriterion("hit_cur =", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurNotEqualTo(Short value) {
            addCriterion("hit_cur <>", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurGreaterThan(Short value) {
            addCriterion("hit_cur >", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurGreaterThanOrEqualTo(Short value) {
            addCriterion("hit_cur >=", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurLessThan(Short value) {
            addCriterion("hit_cur <", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurLessThanOrEqualTo(Short value) {
            addCriterion("hit_cur <=", value, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurIn(List<Short> values) {
            addCriterion("hit_cur in", values, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurNotIn(List<Short> values) {
            addCriterion("hit_cur not in", values, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurBetween(Short value1, Short value2) {
            addCriterion("hit_cur between", value1, value2, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitCurNotBetween(Short value1, Short value2) {
            addCriterion("hit_cur not between", value1, value2, "hitCur");
            return (Criteria) this;
        }

        public Criteria andHitMaxIsNull() {
            addCriterion("hit_max is null");
            return (Criteria) this;
        }

        public Criteria andHitMaxIsNotNull() {
            addCriterion("hit_max is not null");
            return (Criteria) this;
        }

        public Criteria andHitMaxEqualTo(Short value) {
            addCriterion("hit_max =", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxNotEqualTo(Short value) {
            addCriterion("hit_max <>", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxGreaterThan(Short value) {
            addCriterion("hit_max >", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxGreaterThanOrEqualTo(Short value) {
            addCriterion("hit_max >=", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxLessThan(Short value) {
            addCriterion("hit_max <", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxLessThanOrEqualTo(Short value) {
            addCriterion("hit_max <=", value, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxIn(List<Short> values) {
            addCriterion("hit_max in", values, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxNotIn(List<Short> values) {
            addCriterion("hit_max not in", values, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxBetween(Short value1, Short value2) {
            addCriterion("hit_max between", value1, value2, "hitMax");
            return (Criteria) this;
        }

        public Criteria andHitMaxNotBetween(Short value1, Short value2) {
            addCriterion("hit_max not between", value1, value2, "hitMax");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNull() {
            addCriterion("modified_date is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNotNull() {
            addCriterion("modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateEqualTo(Date value) {
            addCriterionForJDBCDate("modified_date =", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("modified_date <>", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThan(Date value) {
            addCriterionForJDBCDate("modified_date >", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modified_date >=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThan(Date value) {
            addCriterionForJDBCDate("modified_date <", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modified_date <=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIn(List<Date> values) {
            addCriterionForJDBCDate("modified_date in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("modified_date not in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modified_date between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modified_date not between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andListsIsNull() {
            addCriterion("lists is null");
            return (Criteria) this;
        }

        public Criteria andListsIsNotNull() {
            addCriterion("lists is not null");
            return (Criteria) this;
        }

        public Criteria andListsEqualTo(String value) {
            addCriterion("lists =", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsNotEqualTo(String value) {
            addCriterion("lists <>", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsGreaterThan(String value) {
            addCriterion("lists >", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsGreaterThanOrEqualTo(String value) {
            addCriterion("lists >=", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsLessThan(String value) {
            addCriterion("lists <", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsLessThanOrEqualTo(String value) {
            addCriterion("lists <=", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsLike(String value) {
            addCriterion("lists like", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsNotLike(String value) {
            addCriterion("lists not like", value, "lists");
            return (Criteria) this;
        }

        public Criteria andListsIn(List<String> values) {
            addCriterion("lists in", values, "lists");
            return (Criteria) this;
        }

        public Criteria andListsNotIn(List<String> values) {
            addCriterion("lists not in", values, "lists");
            return (Criteria) this;
        }

        public Criteria andListsBetween(String value1, String value2) {
            addCriterion("lists between", value1, value2, "lists");
            return (Criteria) this;
        }

        public Criteria andListsNotBetween(String value1, String value2) {
            addCriterion("lists not between", value1, value2, "lists");
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