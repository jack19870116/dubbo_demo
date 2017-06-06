package com.tiancaibao.pojo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UsersExample() {
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

        public Criteria andIdcardNameIsNull() {
            addCriterion("idcard_name is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNameIsNotNull() {
            addCriterion("idcard_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNameEqualTo(String value) {
            addCriterion("idcard_name =", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameNotEqualTo(String value) {
            addCriterion("idcard_name <>", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameGreaterThan(String value) {
            addCriterion("idcard_name >", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_name >=", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameLessThan(String value) {
            addCriterion("idcard_name <", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameLessThanOrEqualTo(String value) {
            addCriterion("idcard_name <=", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameLike(String value) {
            addCriterion("idcard_name like", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameNotLike(String value) {
            addCriterion("idcard_name not like", value, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameIn(List<String> values) {
            addCriterion("idcard_name in", values, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameNotIn(List<String> values) {
            addCriterion("idcard_name not in", values, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameBetween(String value1, String value2) {
            addCriterion("idcard_name between", value1, value2, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNameNotBetween(String value1, String value2) {
            addCriterion("idcard_name not between", value1, value2, "idcardName");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberIsNull() {
            addCriterion("idcard_number is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberIsNotNull() {
            addCriterion("idcard_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberEqualTo(String value) {
            addCriterion("idcard_number =", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberNotEqualTo(String value) {
            addCriterion("idcard_number <>", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberGreaterThan(String value) {
            addCriterion("idcard_number >", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_number >=", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberLessThan(String value) {
            addCriterion("idcard_number <", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberLessThanOrEqualTo(String value) {
            addCriterion("idcard_number <=", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberLike(String value) {
            addCriterion("idcard_number like", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberNotLike(String value) {
            addCriterion("idcard_number not like", value, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberIn(List<String> values) {
            addCriterion("idcard_number in", values, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberNotIn(List<String> values) {
            addCriterion("idcard_number not in", values, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberBetween(String value1, String value2) {
            addCriterion("idcard_number between", value1, value2, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andIdcardNumberNotBetween(String value1, String value2) {
            addCriterion("idcard_number not between", value1, value2, "idcardNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdIsNull() {
            addCriterion("invited_by_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdIsNotNull() {
            addCriterion("invited_by_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdEqualTo(Long value) {
            addCriterion("invited_by_user_id =", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdNotEqualTo(Long value) {
            addCriterion("invited_by_user_id <>", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdGreaterThan(Long value) {
            addCriterion("invited_by_user_id >", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invited_by_user_id >=", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdLessThan(Long value) {
            addCriterion("invited_by_user_id <", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdLessThanOrEqualTo(Long value) {
            addCriterion("invited_by_user_id <=", value, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdIn(List<Long> values) {
            addCriterion("invited_by_user_id in", values, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdNotIn(List<Long> values) {
            addCriterion("invited_by_user_id not in", values, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdBetween(Long value1, Long value2) {
            addCriterion("invited_by_user_id between", value1, value2, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andInvitedByUserIdNotBetween(Long value1, Long value2) {
            addCriterion("invited_by_user_id not between", value1, value2, "invitedByUserId");
            return (Criteria) this;
        }

        public Criteria andTalentValueIsNull() {
            addCriterion("talent_value is null");
            return (Criteria) this;
        }

        public Criteria andTalentValueIsNotNull() {
            addCriterion("talent_value is not null");
            return (Criteria) this;
        }

        public Criteria andTalentValueEqualTo(Long value) {
            addCriterion("talent_value =", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueNotEqualTo(Long value) {
            addCriterion("talent_value <>", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueGreaterThan(Long value) {
            addCriterion("talent_value >", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueGreaterThanOrEqualTo(Long value) {
            addCriterion("talent_value >=", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueLessThan(Long value) {
            addCriterion("talent_value <", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueLessThanOrEqualTo(Long value) {
            addCriterion("talent_value <=", value, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueIn(List<Long> values) {
            addCriterion("talent_value in", values, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueNotIn(List<Long> values) {
            addCriterion("talent_value not in", values, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueBetween(Long value1, Long value2) {
            addCriterion("talent_value between", value1, value2, "talentValue");
            return (Criteria) this;
        }

        public Criteria andTalentValueNotBetween(Long value1, Long value2) {
            addCriterion("talent_value not between", value1, value2, "talentValue");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordIsNull() {
            addCriterion("trading_password is null");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordIsNotNull() {
            addCriterion("trading_password is not null");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordEqualTo(String value) {
            addCriterion("trading_password =", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordNotEqualTo(String value) {
            addCriterion("trading_password <>", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordGreaterThan(String value) {
            addCriterion("trading_password >", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("trading_password >=", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordLessThan(String value) {
            addCriterion("trading_password <", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordLessThanOrEqualTo(String value) {
            addCriterion("trading_password <=", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordLike(String value) {
            addCriterion("trading_password like", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordNotLike(String value) {
            addCriterion("trading_password not like", value, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordIn(List<String> values) {
            addCriterion("trading_password in", values, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordNotIn(List<String> values) {
            addCriterion("trading_password not in", values, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordBetween(String value1, String value2) {
            addCriterion("trading_password between", value1, value2, "tradingPassword");
            return (Criteria) this;
        }

        public Criteria andTradingPasswordNotBetween(String value1, String value2) {
            addCriterion("trading_password not between", value1, value2, "tradingPassword");
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

        public Criteria andOneThousandAtIsNull() {
            addCriterion("one_thousand_at is null");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtIsNotNull() {
            addCriterion("one_thousand_at is not null");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtEqualTo(Date value) {
            addCriterion("one_thousand_at =", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtNotEqualTo(Date value) {
            addCriterion("one_thousand_at <>", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtGreaterThan(Date value) {
            addCriterion("one_thousand_at >", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtGreaterThanOrEqualTo(Date value) {
            addCriterion("one_thousand_at >=", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtLessThan(Date value) {
            addCriterion("one_thousand_at <", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtLessThanOrEqualTo(Date value) {
            addCriterion("one_thousand_at <=", value, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtIn(List<Date> values) {
            addCriterion("one_thousand_at in", values, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtNotIn(List<Date> values) {
            addCriterion("one_thousand_at not in", values, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtBetween(Date value1, Date value2) {
            addCriterion("one_thousand_at between", value1, value2, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andOneThousandAtNotBetween(Date value1, Date value2) {
            addCriterion("one_thousand_at not between", value1, value2, "oneThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtIsNull() {
            addCriterion("two_thousand_at is null");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtIsNotNull() {
            addCriterion("two_thousand_at is not null");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtEqualTo(Date value) {
            addCriterion("two_thousand_at =", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtNotEqualTo(Date value) {
            addCriterion("two_thousand_at <>", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtGreaterThan(Date value) {
            addCriterion("two_thousand_at >", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtGreaterThanOrEqualTo(Date value) {
            addCriterion("two_thousand_at >=", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtLessThan(Date value) {
            addCriterion("two_thousand_at <", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtLessThanOrEqualTo(Date value) {
            addCriterion("two_thousand_at <=", value, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtIn(List<Date> values) {
            addCriterion("two_thousand_at in", values, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtNotIn(List<Date> values) {
            addCriterion("two_thousand_at not in", values, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtBetween(Date value1, Date value2) {
            addCriterion("two_thousand_at between", value1, value2, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andTwoThousandAtNotBetween(Date value1, Date value2) {
            addCriterion("two_thousand_at not between", value1, value2, "twoThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtIsNull() {
            addCriterion("five_thousand_at is null");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtIsNotNull() {
            addCriterion("five_thousand_at is not null");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtEqualTo(Date value) {
            addCriterion("five_thousand_at =", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtNotEqualTo(Date value) {
            addCriterion("five_thousand_at <>", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtGreaterThan(Date value) {
            addCriterion("five_thousand_at >", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtGreaterThanOrEqualTo(Date value) {
            addCriterion("five_thousand_at >=", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtLessThan(Date value) {
            addCriterion("five_thousand_at <", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtLessThanOrEqualTo(Date value) {
            addCriterion("five_thousand_at <=", value, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtIn(List<Date> values) {
            addCriterion("five_thousand_at in", values, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtNotIn(List<Date> values) {
            addCriterion("five_thousand_at not in", values, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtBetween(Date value1, Date value2) {
            addCriterion("five_thousand_at between", value1, value2, "fiveThousandAt");
            return (Criteria) this;
        }

        public Criteria andFiveThousandAtNotBetween(Date value1, Date value2) {
            addCriterion("five_thousand_at not between", value1, value2, "fiveThousandAt");
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

        public Criteria andRememberTokenIsNull() {
            addCriterion("remember_token is null");
            return (Criteria) this;
        }

        public Criteria andRememberTokenIsNotNull() {
            addCriterion("remember_token is not null");
            return (Criteria) this;
        }

        public Criteria andRememberTokenEqualTo(String value) {
            addCriterion("remember_token =", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenNotEqualTo(String value) {
            addCriterion("remember_token <>", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenGreaterThan(String value) {
            addCriterion("remember_token >", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenGreaterThanOrEqualTo(String value) {
            addCriterion("remember_token >=", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenLessThan(String value) {
            addCriterion("remember_token <", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenLessThanOrEqualTo(String value) {
            addCriterion("remember_token <=", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenLike(String value) {
            addCriterion("remember_token like", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenNotLike(String value) {
            addCriterion("remember_token not like", value, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenIn(List<String> values) {
            addCriterion("remember_token in", values, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenNotIn(List<String> values) {
            addCriterion("remember_token not in", values, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenBetween(String value1, String value2) {
            addCriterion("remember_token between", value1, value2, "rememberToken");
            return (Criteria) this;
        }

        public Criteria andRememberTokenNotBetween(String value1, String value2) {
            addCriterion("remember_token not between", value1, value2, "rememberToken");
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIsNull() {
            addCriterion("fixed_amount is null");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIsNotNull() {
            addCriterion("fixed_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFixedAmountEqualTo(Long value) {
            addCriterion("fixed_amount =", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotEqualTo(Long value) {
            addCriterion("fixed_amount <>", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountGreaterThan(Long value) {
            addCriterion("fixed_amount >", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("fixed_amount >=", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountLessThan(Long value) {
            addCriterion("fixed_amount <", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountLessThanOrEqualTo(Long value) {
            addCriterion("fixed_amount <=", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIn(List<Long> values) {
            addCriterion("fixed_amount in", values, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotIn(List<Long> values) {
            addCriterion("fixed_amount not in", values, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountBetween(Long value1, Long value2) {
            addCriterion("fixed_amount between", value1, value2, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotBetween(Long value1, Long value2) {
            addCriterion("fixed_amount not between", value1, value2, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountIsNull() {
            addCriterion("account_amount is null");
            return (Criteria) this;
        }

        public Criteria andAccountAmountIsNotNull() {
            addCriterion("account_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAmountEqualTo(Long value) {
            addCriterion("account_amount =", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountNotEqualTo(Long value) {
            addCriterion("account_amount <>", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountGreaterThan(Long value) {
            addCriterion("account_amount >", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("account_amount >=", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountLessThan(Long value) {
            addCriterion("account_amount <", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountLessThanOrEqualTo(Long value) {
            addCriterion("account_amount <=", value, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountIn(List<Long> values) {
            addCriterion("account_amount in", values, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountNotIn(List<Long> values) {
            addCriterion("account_amount not in", values, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountBetween(Long value1, Long value2) {
            addCriterion("account_amount between", value1, value2, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAccountAmountNotBetween(Long value1, Long value2) {
            addCriterion("account_amount not between", value1, value2, "accountAmount");
            return (Criteria) this;
        }

        public Criteria andAgentNumIsNull() {
            addCriterion("agent_num is null");
            return (Criteria) this;
        }

        public Criteria andAgentNumIsNotNull() {
            addCriterion("agent_num is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNumEqualTo(String value) {
            addCriterion("agent_num =", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumNotEqualTo(String value) {
            addCriterion("agent_num <>", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumGreaterThan(String value) {
            addCriterion("agent_num >", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumGreaterThanOrEqualTo(String value) {
            addCriterion("agent_num >=", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumLessThan(String value) {
            addCriterion("agent_num <", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumLessThanOrEqualTo(String value) {
            addCriterion("agent_num <=", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumLike(String value) {
            addCriterion("agent_num like", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumNotLike(String value) {
            addCriterion("agent_num not like", value, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumIn(List<String> values) {
            addCriterion("agent_num in", values, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumNotIn(List<String> values) {
            addCriterion("agent_num not in", values, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumBetween(String value1, String value2) {
            addCriterion("agent_num between", value1, value2, "agentNum");
            return (Criteria) this;
        }

        public Criteria andAgentNumNotBetween(String value1, String value2) {
            addCriterion("agent_num not between", value1, value2, "agentNum");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordIsNull() {
            addCriterion("huifu_password is null");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordIsNotNull() {
            addCriterion("huifu_password is not null");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordEqualTo(String value) {
            addCriterion("huifu_password =", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordNotEqualTo(String value) {
            addCriterion("huifu_password <>", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordGreaterThan(String value) {
            addCriterion("huifu_password >", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("huifu_password >=", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordLessThan(String value) {
            addCriterion("huifu_password <", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordLessThanOrEqualTo(String value) {
            addCriterion("huifu_password <=", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordLike(String value) {
            addCriterion("huifu_password like", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordNotLike(String value) {
            addCriterion("huifu_password not like", value, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordIn(List<String> values) {
            addCriterion("huifu_password in", values, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordNotIn(List<String> values) {
            addCriterion("huifu_password not in", values, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordBetween(String value1, String value2) {
            addCriterion("huifu_password between", value1, value2, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andHuifuPasswordNotBetween(String value1, String value2) {
            addCriterion("huifu_password not between", value1, value2, "huifuPassword");
            return (Criteria) this;
        }

        public Criteria andYbBankcardIsNull() {
            addCriterion("yb_bankcard is null");
            return (Criteria) this;
        }

        public Criteria andYbBankcardIsNotNull() {
            addCriterion("yb_bankcard is not null");
            return (Criteria) this;
        }

        public Criteria andYbBankcardEqualTo(String value) {
            addCriterion("yb_bankcard =", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardNotEqualTo(String value) {
            addCriterion("yb_bankcard <>", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardGreaterThan(String value) {
            addCriterion("yb_bankcard >", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardGreaterThanOrEqualTo(String value) {
            addCriterion("yb_bankcard >=", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardLessThan(String value) {
            addCriterion("yb_bankcard <", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardLessThanOrEqualTo(String value) {
            addCriterion("yb_bankcard <=", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardLike(String value) {
            addCriterion("yb_bankcard like", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardNotLike(String value) {
            addCriterion("yb_bankcard not like", value, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardIn(List<String> values) {
            addCriterion("yb_bankcard in", values, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardNotIn(List<String> values) {
            addCriterion("yb_bankcard not in", values, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardBetween(String value1, String value2) {
            addCriterion("yb_bankcard between", value1, value2, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankcardNotBetween(String value1, String value2) {
            addCriterion("yb_bankcard not between", value1, value2, "ybBankcard");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoIsNull() {
            addCriterion("yb_bankinfo is null");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoIsNotNull() {
            addCriterion("yb_bankinfo is not null");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoEqualTo(String value) {
            addCriterion("yb_bankinfo =", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoNotEqualTo(String value) {
            addCriterion("yb_bankinfo <>", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoGreaterThan(String value) {
            addCriterion("yb_bankinfo >", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoGreaterThanOrEqualTo(String value) {
            addCriterion("yb_bankinfo >=", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoLessThan(String value) {
            addCriterion("yb_bankinfo <", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoLessThanOrEqualTo(String value) {
            addCriterion("yb_bankinfo <=", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoLike(String value) {
            addCriterion("yb_bankinfo like", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoNotLike(String value) {
            addCriterion("yb_bankinfo not like", value, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoIn(List<String> values) {
            addCriterion("yb_bankinfo in", values, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoNotIn(List<String> values) {
            addCriterion("yb_bankinfo not in", values, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoBetween(String value1, String value2) {
            addCriterion("yb_bankinfo between", value1, value2, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andYbBankinfoNotBetween(String value1, String value2) {
            addCriterion("yb_bankinfo not between", value1, value2, "ybBankinfo");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Integer> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Integer> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNull() {
            addCriterion("is_deal is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("is_deal is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(Integer value) {
            addCriterion("is_deal =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(Integer value) {
            addCriterion("is_deal <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(Integer value) {
            addCriterion("is_deal >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deal >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(Integer value) {
            addCriterion("is_deal <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(Integer value) {
            addCriterion("is_deal <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<Integer> values) {
            addCriterion("is_deal in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<Integer> values) {
            addCriterion("is_deal not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(Integer value1, Integer value2) {
            addCriterion("is_deal between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deal not between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNull() {
            addCriterion("is_send is null");
            return (Criteria) this;
        }

        public Criteria andIsSendIsNotNull() {
            addCriterion("is_send is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendEqualTo(Integer value) {
            addCriterion("is_send =", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotEqualTo(Integer value) {
            addCriterion("is_send <>", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThan(Integer value) {
            addCriterion("is_send >", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_send >=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThan(Integer value) {
            addCriterion("is_send <", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendLessThanOrEqualTo(Integer value) {
            addCriterion("is_send <=", value, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendIn(List<Integer> values) {
            addCriterion("is_send in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotIn(List<Integer> values) {
            addCriterion("is_send not in", values, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendBetween(Integer value1, Integer value2) {
            addCriterion("is_send between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andIsSendNotBetween(Integer value1, Integer value2) {
            addCriterion("is_send not between", value1, value2, "isSend");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Short value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Short value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Short value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Short value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Short value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Short value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Short> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Short> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Short value1, Short value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Short value1, Short value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andSignNumIsNull() {
            addCriterion("sign_num is null");
            return (Criteria) this;
        }

        public Criteria andSignNumIsNotNull() {
            addCriterion("sign_num is not null");
            return (Criteria) this;
        }

        public Criteria andSignNumEqualTo(Integer value) {
            addCriterion("sign_num =", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotEqualTo(Integer value) {
            addCriterion("sign_num <>", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumGreaterThan(Integer value) {
            addCriterion("sign_num >", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_num >=", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumLessThan(Integer value) {
            addCriterion("sign_num <", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumLessThanOrEqualTo(Integer value) {
            addCriterion("sign_num <=", value, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumIn(List<Integer> values) {
            addCriterion("sign_num in", values, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotIn(List<Integer> values) {
            addCriterion("sign_num not in", values, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumBetween(Integer value1, Integer value2) {
            addCriterion("sign_num between", value1, value2, "signNum");
            return (Criteria) this;
        }

        public Criteria andSignNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_num not between", value1, value2, "signNum");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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