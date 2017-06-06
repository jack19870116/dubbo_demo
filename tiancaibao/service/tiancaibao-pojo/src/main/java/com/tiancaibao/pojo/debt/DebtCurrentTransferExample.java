package com.tiancaibao.pojo.debt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebtCurrentTransferExample {
    /**   tableName: debt_current_transfer   **/
    protected String orderByClause;

    /**   tableName: debt_current_transfer   **/
    protected boolean distinct;

    /**   tableName: debt_current_transfer   **/
    protected List<Criteria> oredCriteria;

    public DebtCurrentTransferExample() {
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

    /** debt_current_transfer **/
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

        public Criteria andInvestIdIsNull() {
            addCriterion("invest_id is null");
            return (Criteria) this;
        }

        public Criteria andInvestIdIsNotNull() {
            addCriterion("invest_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvestIdEqualTo(Long value) {
            addCriterion("invest_id =", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdNotEqualTo(Long value) {
            addCriterion("invest_id <>", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdGreaterThan(Long value) {
            addCriterion("invest_id >", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invest_id >=", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdLessThan(Long value) {
            addCriterion("invest_id <", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdLessThanOrEqualTo(Long value) {
            addCriterion("invest_id <=", value, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdIn(List<Long> values) {
            addCriterion("invest_id in", values, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdNotIn(List<Long> values) {
            addCriterion("invest_id not in", values, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdBetween(Long value1, Long value2) {
            addCriterion("invest_id between", value1, value2, "investId");
            return (Criteria) this;
        }

        public Criteria andInvestIdNotBetween(Long value1, Long value2) {
            addCriterion("invest_id not between", value1, value2, "investId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdIsNull() {
            addCriterion("debt_original_asset_id is null");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdIsNotNull() {
            addCriterion("debt_original_asset_id is not null");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdEqualTo(Long value) {
            addCriterion("debt_original_asset_id =", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdNotEqualTo(Long value) {
            addCriterion("debt_original_asset_id <>", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdGreaterThan(Long value) {
            addCriterion("debt_original_asset_id >", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("debt_original_asset_id >=", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdLessThan(Long value) {
            addCriterion("debt_original_asset_id <", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdLessThanOrEqualTo(Long value) {
            addCriterion("debt_original_asset_id <=", value, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdIn(List<Long> values) {
            addCriterion("debt_original_asset_id in", values, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdNotIn(List<Long> values) {
            addCriterion("debt_original_asset_id not in", values, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdBetween(Long value1, Long value2) {
            addCriterion("debt_original_asset_id between", value1, value2, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andDebtOriginalAssetIdNotBetween(Long value1, Long value2) {
            addCriterion("debt_original_asset_id not between", value1, value2, "debtOriginalAssetId");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Integer value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Integer value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Integer value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Integer value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Integer value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Integer> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Integer> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Integer value1, Integer value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Integer value1, Integer value2) {
            addCriterion("rate not between", value1, value2, "rate");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNull() {
            addCriterion("original_amount is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNotNull() {
            addCriterion("original_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountEqualTo(Long value) {
            addCriterion("original_amount =", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotEqualTo(Long value) {
            addCriterion("original_amount <>", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThan(Long value) {
            addCriterion("original_amount >", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("original_amount >=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThan(Long value) {
            addCriterion("original_amount <", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThanOrEqualTo(Long value) {
            addCriterion("original_amount <=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIn(List<Long> values) {
            addCriterion("original_amount in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotIn(List<Long> values) {
            addCriterion("original_amount not in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountBetween(Long value1, Long value2) {
            addCriterion("original_amount between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotBetween(Long value1, Long value2) {
            addCriterion("original_amount not between", value1, value2, "originalAmount");
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

        public Criteria andOriginalCountIsNull() {
            addCriterion("original_count is null");
            return (Criteria) this;
        }

        public Criteria andOriginalCountIsNotNull() {
            addCriterion("original_count is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalCountEqualTo(Integer value) {
            addCriterion("original_count =", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountNotEqualTo(Integer value) {
            addCriterion("original_count <>", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountGreaterThan(Integer value) {
            addCriterion("original_count >", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("original_count >=", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountLessThan(Integer value) {
            addCriterion("original_count <", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountLessThanOrEqualTo(Integer value) {
            addCriterion("original_count <=", value, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountIn(List<Integer> values) {
            addCriterion("original_count in", values, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountNotIn(List<Integer> values) {
            addCriterion("original_count not in", values, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountBetween(Integer value1, Integer value2) {
            addCriterion("original_count between", value1, value2, "originalCount");
            return (Criteria) this;
        }

        public Criteria andOriginalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("original_count not between", value1, value2, "originalCount");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNull() {
            addCriterion("other_info is null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNotNull() {
            addCriterion("other_info is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoEqualTo(String value) {
            addCriterion("other_info =", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotEqualTo(String value) {
            addCriterion("other_info <>", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThan(String value) {
            addCriterion("other_info >", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("other_info >=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThan(String value) {
            addCriterion("other_info <", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("other_info <=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLike(String value) {
            addCriterion("other_info like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotLike(String value) {
            addCriterion("other_info not like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIn(List<String> values) {
            addCriterion("other_info in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotIn(List<String> values) {
            addCriterion("other_info not in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoBetween(String value1, String value2) {
            addCriterion("other_info between", value1, value2, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotBetween(String value1, String value2) {
            addCriterion("other_info not between", value1, value2, "otherInfo");
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

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Integer value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Integer value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Integer value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Integer value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Integer> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Integer> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Integer value1, Integer value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdIsNull() {
            addCriterion("user_holding_id is null");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdIsNotNull() {
            addCriterion("user_holding_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdEqualTo(Integer value) {
            addCriterion("user_holding_id =", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdNotEqualTo(Integer value) {
            addCriterion("user_holding_id <>", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdGreaterThan(Integer value) {
            addCriterion("user_holding_id >", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_holding_id >=", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdLessThan(Integer value) {
            addCriterion("user_holding_id <", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_holding_id <=", value, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdIn(List<Integer> values) {
            addCriterion("user_holding_id in", values, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdNotIn(List<Integer> values) {
            addCriterion("user_holding_id not in", values, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdBetween(Integer value1, Integer value2) {
            addCriterion("user_holding_id between", value1, value2, "userHoldingId");
            return (Criteria) this;
        }

        public Criteria andUserHoldingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_holding_id not between", value1, value2, "userHoldingId");
            return (Criteria) this;
        }
    }

    /**  tableName: debt_current_transfer   **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /** debt_current_transfer **/
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