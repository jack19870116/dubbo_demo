package com.tiancaibao.pojo.debt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebtCurrentReceiveExample {
    /**   tableName: debt_current_receive   **/
    protected String orderByClause;

    /**   tableName: debt_current_receive   **/
    protected boolean distinct;

    /**   tableName: debt_current_receive   **/
    protected List<Criteria> oredCriteria;

    public DebtCurrentReceiveExample() {
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

    /** debt_current_receive **/
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

        public Criteria andTransferUserIdIsNull() {
            addCriterion("transfer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdIsNotNull() {
            addCriterion("transfer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdEqualTo(Long value) {
            addCriterion("transfer_user_id =", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdNotEqualTo(Long value) {
            addCriterion("transfer_user_id <>", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdGreaterThan(Long value) {
            addCriterion("transfer_user_id >", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_user_id >=", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdLessThan(Long value) {
            addCriterion("transfer_user_id <", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdLessThanOrEqualTo(Long value) {
            addCriterion("transfer_user_id <=", value, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdIn(List<Long> values) {
            addCriterion("transfer_user_id in", values, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdNotIn(List<Long> values) {
            addCriterion("transfer_user_id not in", values, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdBetween(Long value1, Long value2) {
            addCriterion("transfer_user_id between", value1, value2, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andTransferUserIdNotBetween(Long value1, Long value2) {
            addCriterion("transfer_user_id not between", value1, value2, "transferUserId");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(Long value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(Long value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(Long value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(Long value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(Long value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(Long value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<Long> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<Long> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(Long value1, Long value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(Long value1, Long value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(Long value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(Long value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(Long value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(Long value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(Long value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(Long value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<Long> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<Long> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(Long value1, Long value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(Long value1, Long value2) {
            addCriterion("interest not between", value1, value2, "interest");
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

        public Criteria andRequestNoIsNull() {
            addCriterion("request_no is null");
            return (Criteria) this;
        }

        public Criteria andRequestNoIsNotNull() {
            addCriterion("request_no is not null");
            return (Criteria) this;
        }

        public Criteria andRequestNoEqualTo(String value) {
            addCriterion("request_no =", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotEqualTo(String value) {
            addCriterion("request_no <>", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThan(String value) {
            addCriterion("request_no >", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThanOrEqualTo(String value) {
            addCriterion("request_no >=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThan(String value) {
            addCriterion("request_no <", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThanOrEqualTo(String value) {
            addCriterion("request_no <=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLike(String value) {
            addCriterion("request_no like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotLike(String value) {
            addCriterion("request_no not like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoIn(List<String> values) {
            addCriterion("request_no in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotIn(List<String> values) {
            addCriterion("request_no not in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoBetween(String value1, String value2) {
            addCriterion("request_no between", value1, value2, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotBetween(String value1, String value2) {
            addCriterion("request_no not between", value1, value2, "requestNo");
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

    /**  tableName: debt_current_receive   **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /** debt_current_receive **/
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