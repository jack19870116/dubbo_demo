package com.tiancaibao.pojo.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBlackListsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserBlackListsExample() {
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

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeIsNull() {
            addCriterion("blacklist_type is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeIsNotNull() {
            addCriterion("blacklist_type is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeEqualTo(Byte value) {
            addCriterion("blacklist_type =", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeNotEqualTo(Byte value) {
            addCriterion("blacklist_type <>", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeGreaterThan(Byte value) {
            addCriterion("blacklist_type >", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("blacklist_type >=", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeLessThan(Byte value) {
            addCriterion("blacklist_type <", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeLessThanOrEqualTo(Byte value) {
            addCriterion("blacklist_type <=", value, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeIn(List<Byte> values) {
            addCriterion("blacklist_type in", values, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeNotIn(List<Byte> values) {
            addCriterion("blacklist_type not in", values, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeBetween(Byte value1, Byte value2) {
            addCriterion("blacklist_type between", value1, value2, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBlacklistTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("blacklist_type not between", value1, value2, "blacklistType");
            return (Criteria) this;
        }

        public Criteria andBadAmountIsNull() {
            addCriterion("bad_amount is null");
            return (Criteria) this;
        }

        public Criteria andBadAmountIsNotNull() {
            addCriterion("bad_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBadAmountEqualTo(BigDecimal value) {
            addCriterion("bad_amount =", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountNotEqualTo(BigDecimal value) {
            addCriterion("bad_amount <>", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountGreaterThan(BigDecimal value) {
            addCriterion("bad_amount >", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bad_amount >=", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountLessThan(BigDecimal value) {
            addCriterion("bad_amount <", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bad_amount <=", value, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountIn(List<BigDecimal> values) {
            addCriterion("bad_amount in", values, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountNotIn(List<BigDecimal> values) {
            addCriterion("bad_amount not in", values, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bad_amount between", value1, value2, "badAmount");
            return (Criteria) this;
        }

        public Criteria andBadAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bad_amount not between", value1, value2, "badAmount");
            return (Criteria) this;
        }

        public Criteria andIserrorIsNull() {
            addCriterion("isError is null");
            return (Criteria) this;
        }

        public Criteria andIserrorIsNotNull() {
            addCriterion("isError is not null");
            return (Criteria) this;
        }

        public Criteria andIserrorEqualTo(Integer value) {
            addCriterion("isError =", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotEqualTo(Integer value) {
            addCriterion("isError <>", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorGreaterThan(Integer value) {
            addCriterion("isError >", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorGreaterThanOrEqualTo(Integer value) {
            addCriterion("isError >=", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorLessThan(Integer value) {
            addCriterion("isError <", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorLessThanOrEqualTo(Integer value) {
            addCriterion("isError <=", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorIn(List<Integer> values) {
            addCriterion("isError in", values, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotIn(List<Integer> values) {
            addCriterion("isError not in", values, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorBetween(Integer value1, Integer value2) {
            addCriterion("isError between", value1, value2, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotBetween(Integer value1, Integer value2) {
            addCriterion("isError not between", value1, value2, "iserror");
            return (Criteria) this;
        }

        public Criteria andLockAmountIsNull() {
            addCriterion("lock_amount is null");
            return (Criteria) this;
        }

        public Criteria andLockAmountIsNotNull() {
            addCriterion("lock_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLockAmountEqualTo(Long value) {
            addCriterion("lock_amount =", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountNotEqualTo(Long value) {
            addCriterion("lock_amount <>", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountGreaterThan(Long value) {
            addCriterion("lock_amount >", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("lock_amount >=", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountLessThan(Long value) {
            addCriterion("lock_amount <", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountLessThanOrEqualTo(Long value) {
            addCriterion("lock_amount <=", value, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountIn(List<Long> values) {
            addCriterion("lock_amount in", values, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountNotIn(List<Long> values) {
            addCriterion("lock_amount not in", values, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountBetween(Long value1, Long value2) {
            addCriterion("lock_amount between", value1, value2, "lockAmount");
            return (Criteria) this;
        }

        public Criteria andLockAmountNotBetween(Long value1, Long value2) {
            addCriterion("lock_amount not between", value1, value2, "lockAmount");
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