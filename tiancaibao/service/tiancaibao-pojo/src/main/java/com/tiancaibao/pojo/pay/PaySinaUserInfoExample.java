package com.tiancaibao.pojo.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaySinaUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public PaySinaUserInfoExample() {
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

        public Criteria andSinapayUidIsNull() {
            addCriterion("sinapay_uid is null");
            return (Criteria) this;
        }

        public Criteria andSinapayUidIsNotNull() {
            addCriterion("sinapay_uid is not null");
            return (Criteria) this;
        }

        public Criteria andSinapayUidEqualTo(Long value) {
            addCriterion("sinapay_uid =", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidNotEqualTo(Long value) {
            addCriterion("sinapay_uid <>", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidGreaterThan(Long value) {
            addCriterion("sinapay_uid >", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidGreaterThanOrEqualTo(Long value) {
            addCriterion("sinapay_uid >=", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidLessThan(Long value) {
            addCriterion("sinapay_uid <", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidLessThanOrEqualTo(Long value) {
            addCriterion("sinapay_uid <=", value, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidIn(List<Long> values) {
            addCriterion("sinapay_uid in", values, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidNotIn(List<Long> values) {
            addCriterion("sinapay_uid not in", values, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidBetween(Long value1, Long value2) {
            addCriterion("sinapay_uid between", value1, value2, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayUidNotBetween(Long value1, Long value2) {
            addCriterion("sinapay_uid not between", value1, value2, "sinapayUid");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardIsNull() {
            addCriterion("sinapay_bank_card is null");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardIsNotNull() {
            addCriterion("sinapay_bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardEqualTo(String value) {
            addCriterion("sinapay_bank_card =", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardNotEqualTo(String value) {
            addCriterion("sinapay_bank_card <>", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardGreaterThan(String value) {
            addCriterion("sinapay_bank_card >", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("sinapay_bank_card >=", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardLessThan(String value) {
            addCriterion("sinapay_bank_card <", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardLessThanOrEqualTo(String value) {
            addCriterion("sinapay_bank_card <=", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardLike(String value) {
            addCriterion("sinapay_bank_card like", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardNotLike(String value) {
            addCriterion("sinapay_bank_card not like", value, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardIn(List<String> values) {
            addCriterion("sinapay_bank_card in", values, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardNotIn(List<String> values) {
            addCriterion("sinapay_bank_card not in", values, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardBetween(String value1, String value2) {
            addCriterion("sinapay_bank_card between", value1, value2, "sinapayBankCard");
            return (Criteria) this;
        }

        public Criteria andSinapayBankCardNotBetween(String value1, String value2) {
            addCriterion("sinapay_bank_card not between", value1, value2, "sinapayBankCard");
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

        public Criteria andSinapayAmountIsNull() {
            addCriterion("sinapay_amount is null");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountIsNotNull() {
            addCriterion("sinapay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountEqualTo(Long value) {
            addCriterion("sinapay_amount =", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountNotEqualTo(Long value) {
            addCriterion("sinapay_amount <>", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountGreaterThan(Long value) {
            addCriterion("sinapay_amount >", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("sinapay_amount >=", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountLessThan(Long value) {
            addCriterion("sinapay_amount <", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountLessThanOrEqualTo(Long value) {
            addCriterion("sinapay_amount <=", value, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountIn(List<Long> values) {
            addCriterion("sinapay_amount in", values, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountNotIn(List<Long> values) {
            addCriterion("sinapay_amount not in", values, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountBetween(Long value1, Long value2) {
            addCriterion("sinapay_amount between", value1, value2, "sinapayAmount");
            return (Criteria) this;
        }

        public Criteria andSinapayAmountNotBetween(Long value1, Long value2) {
            addCriterion("sinapay_amount not between", value1, value2, "sinapayAmount");
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

        public Criteria andVerifyTicketIsNull() {
            addCriterion("verify_ticket is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketIsNotNull() {
            addCriterion("verify_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketEqualTo(String value) {
            addCriterion("verify_ticket =", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketNotEqualTo(String value) {
            addCriterion("verify_ticket <>", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketGreaterThan(String value) {
            addCriterion("verify_ticket >", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketGreaterThanOrEqualTo(String value) {
            addCriterion("verify_ticket >=", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketLessThan(String value) {
            addCriterion("verify_ticket <", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketLessThanOrEqualTo(String value) {
            addCriterion("verify_ticket <=", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketLike(String value) {
            addCriterion("verify_ticket like", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketNotLike(String value) {
            addCriterion("verify_ticket not like", value, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketIn(List<String> values) {
            addCriterion("verify_ticket in", values, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketNotIn(List<String> values) {
            addCriterion("verify_ticket not in", values, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketBetween(String value1, String value2) {
            addCriterion("verify_ticket between", value1, value2, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andVerifyTicketNotBetween(String value1, String value2) {
            addCriterion("verify_ticket not between", value1, value2, "verifyTicket");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNull() {
            addCriterion("bank_phone is null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNotNull() {
            addCriterion("bank_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneEqualTo(String value) {
            addCriterion("bank_phone =", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotEqualTo(String value) {
            addCriterion("bank_phone <>", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThan(String value) {
            addCriterion("bank_phone >", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("bank_phone >=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThan(String value) {
            addCriterion("bank_phone <", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThanOrEqualTo(String value) {
            addCriterion("bank_phone <=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLike(String value) {
            addCriterion("bank_phone like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotLike(String value) {
            addCriterion("bank_phone not like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIn(List<String> values) {
            addCriterion("bank_phone in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotIn(List<String> values) {
            addCriterion("bank_phone not in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneBetween(String value1, String value2) {
            addCriterion("bank_phone between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotBetween(String value1, String value2) {
            addCriterion("bank_phone not between", value1, value2, "bankPhone");
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