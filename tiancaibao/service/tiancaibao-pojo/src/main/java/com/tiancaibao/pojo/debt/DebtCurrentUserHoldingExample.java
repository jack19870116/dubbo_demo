package com.tiancaibao.pojo.debt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebtCurrentUserHoldingExample {
    /**   tableName: debt_current_user_holding   **/
    protected String orderByClause;

    /**   tableName: debt_current_user_holding   **/
    protected boolean distinct;

    /**   tableName: debt_current_user_holding   **/
    protected List<Criteria> oredCriteria;

    public DebtCurrentUserHoldingExample() {
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

    /** debt_current_user_holding **/
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

        public Criteria andCurrentCountIsNull() {
            addCriterion("current_count is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCountIsNotNull() {
            addCriterion("current_count is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCountEqualTo(Integer value) {
            addCriterion("current_count =", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotEqualTo(Integer value) {
            addCriterion("current_count <>", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountGreaterThan(Integer value) {
            addCriterion("current_count >", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_count >=", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountLessThan(Integer value) {
            addCriterion("current_count <", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountLessThanOrEqualTo(Integer value) {
            addCriterion("current_count <=", value, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountIn(List<Integer> values) {
            addCriterion("current_count in", values, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotIn(List<Integer> values) {
            addCriterion("current_count not in", values, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountBetween(Integer value1, Integer value2) {
            addCriterion("current_count between", value1, value2, "currentCount");
            return (Criteria) this;
        }

        public Criteria andCurrentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("current_count not between", value1, value2, "currentCount");
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

        public Criteria andOtherInfo1IsNull() {
            addCriterion("other_info1 is null");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1IsNotNull() {
            addCriterion("other_info1 is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1EqualTo(String value) {
            addCriterion("other_info1 =", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1NotEqualTo(String value) {
            addCriterion("other_info1 <>", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1GreaterThan(String value) {
            addCriterion("other_info1 >", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1GreaterThanOrEqualTo(String value) {
            addCriterion("other_info1 >=", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1LessThan(String value) {
            addCriterion("other_info1 <", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1LessThanOrEqualTo(String value) {
            addCriterion("other_info1 <=", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1Like(String value) {
            addCriterion("other_info1 like", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1NotLike(String value) {
            addCriterion("other_info1 not like", value, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1In(List<String> values) {
            addCriterion("other_info1 in", values, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1NotIn(List<String> values) {
            addCriterion("other_info1 not in", values, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1Between(String value1, String value2) {
            addCriterion("other_info1 between", value1, value2, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo1NotBetween(String value1, String value2) {
            addCriterion("other_info1 not between", value1, value2, "otherInfo1");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2IsNull() {
            addCriterion("other_info2 is null");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2IsNotNull() {
            addCriterion("other_info2 is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2EqualTo(String value) {
            addCriterion("other_info2 =", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2NotEqualTo(String value) {
            addCriterion("other_info2 <>", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2GreaterThan(String value) {
            addCriterion("other_info2 >", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2GreaterThanOrEqualTo(String value) {
            addCriterion("other_info2 >=", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2LessThan(String value) {
            addCriterion("other_info2 <", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2LessThanOrEqualTo(String value) {
            addCriterion("other_info2 <=", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2Like(String value) {
            addCriterion("other_info2 like", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2NotLike(String value) {
            addCriterion("other_info2 not like", value, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2In(List<String> values) {
            addCriterion("other_info2 in", values, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2NotIn(List<String> values) {
            addCriterion("other_info2 not in", values, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2Between(String value1, String value2) {
            addCriterion("other_info2 between", value1, value2, "otherInfo2");
            return (Criteria) this;
        }

        public Criteria andOtherInfo2NotBetween(String value1, String value2) {
            addCriterion("other_info2 not between", value1, value2, "otherInfo2");
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

        public Criteria andFrozenCountIsNull() {
            addCriterion("frozen_count is null");
            return (Criteria) this;
        }

        public Criteria andFrozenCountIsNotNull() {
            addCriterion("frozen_count is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenCountEqualTo(Integer value) {
            addCriterion("frozen_count =", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountNotEqualTo(Integer value) {
            addCriterion("frozen_count <>", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountGreaterThan(Integer value) {
            addCriterion("frozen_count >", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("frozen_count >=", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountLessThan(Integer value) {
            addCriterion("frozen_count <", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountLessThanOrEqualTo(Integer value) {
            addCriterion("frozen_count <=", value, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountIn(List<Integer> values) {
            addCriterion("frozen_count in", values, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountNotIn(List<Integer> values) {
            addCriterion("frozen_count not in", values, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountBetween(Integer value1, Integer value2) {
            addCriterion("frozen_count between", value1, value2, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andFrozenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("frozen_count not between", value1, value2, "frozenCount");
            return (Criteria) this;
        }

        public Criteria andTransferIdIsNull() {
            addCriterion("transfer_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferIdIsNotNull() {
            addCriterion("transfer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferIdEqualTo(Long value) {
            addCriterion("transfer_id =", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotEqualTo(Long value) {
            addCriterion("transfer_id <>", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdGreaterThan(Long value) {
            addCriterion("transfer_id >", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_id >=", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdLessThan(Long value) {
            addCriterion("transfer_id <", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdLessThanOrEqualTo(Long value) {
            addCriterion("transfer_id <=", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdIn(List<Long> values) {
            addCriterion("transfer_id in", values, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotIn(List<Long> values) {
            addCriterion("transfer_id not in", values, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdBetween(Long value1, Long value2) {
            addCriterion("transfer_id between", value1, value2, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotBetween(Long value1, Long value2) {
            addCriterion("transfer_id not between", value1, value2, "transferId");
            return (Criteria) this;
        }
    }

    /**  tableName: debt_current_user_holding   **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /** debt_current_user_holding **/
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