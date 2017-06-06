package com.tiancaibao.pojo.debt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DebtOriginalAssetBillsExample {
    /**   tableName: debt_original_asset_bills   **/
    protected String orderByClause;

    /**   tableName: debt_original_asset_bills   **/
    protected boolean distinct;

    /**   tableName: debt_original_asset_bills   **/
    protected List<Criteria> oredCriteria;

    public DebtOriginalAssetBillsExample() {
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

    /** debt_original_asset_bills **/
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

        public Criteria andShowNameIsNull() {
            addCriterion("show_name is null");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNotNull() {
            addCriterion("show_name is not null");
            return (Criteria) this;
        }

        public Criteria andShowNameEqualTo(String value) {
            addCriterion("show_name =", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotEqualTo(String value) {
            addCriterion("show_name <>", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThan(String value) {
            addCriterion("show_name >", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("show_name >=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThan(String value) {
            addCriterion("show_name <", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            addCriterion("show_name <=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLike(String value) {
            addCriterion("show_name like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotLike(String value) {
            addCriterion("show_name not like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameIn(List<String> values) {
            addCriterion("show_name in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotIn(List<String> values) {
            addCriterion("show_name not in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            addCriterion("show_name between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            addCriterion("show_name not between", value1, value2, "showName");
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

        public Criteria andAgencyIdIsNull() {
            addCriterion("agency_id is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNotNull() {
            addCriterion("agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdEqualTo(Long value) {
            addCriterion("agency_id =", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotEqualTo(Long value) {
            addCriterion("agency_id <>", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThan(Long value) {
            addCriterion("agency_id >", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agency_id >=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThan(Long value) {
            addCriterion("agency_id <", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThanOrEqualTo(Long value) {
            addCriterion("agency_id <=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIn(List<Long> values) {
            addCriterion("agency_id in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotIn(List<Long> values) {
            addCriterion("agency_id not in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdBetween(Long value1, Long value2) {
            addCriterion("agency_id between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotBetween(Long value1, Long value2) {
            addCriterion("agency_id not between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAssetClassIsNull() {
            addCriterion("asset_class is null");
            return (Criteria) this;
        }

        public Criteria andAssetClassIsNotNull() {
            addCriterion("asset_class is not null");
            return (Criteria) this;
        }

        public Criteria andAssetClassEqualTo(String value) {
            addCriterion("asset_class =", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassNotEqualTo(String value) {
            addCriterion("asset_class <>", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassGreaterThan(String value) {
            addCriterion("asset_class >", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassGreaterThanOrEqualTo(String value) {
            addCriterion("asset_class >=", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassLessThan(String value) {
            addCriterion("asset_class <", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassLessThanOrEqualTo(String value) {
            addCriterion("asset_class <=", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassLike(String value) {
            addCriterion("asset_class like", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassNotLike(String value) {
            addCriterion("asset_class not like", value, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassIn(List<String> values) {
            addCriterion("asset_class in", values, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassNotIn(List<String> values) {
            addCriterion("asset_class not in", values, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassBetween(String value1, String value2) {
            addCriterion("asset_class between", value1, value2, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetClassNotBetween(String value1, String value2) {
            addCriterion("asset_class not between", value1, value2, "assetClass");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(String value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(String value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(String value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(String value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(String value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLike(String value) {
            addCriterion("asset_type like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotLike(String value) {
            addCriterion("asset_type not like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<String> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<String> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(String value1, String value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(String value1, String value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNull() {
            addCriterion("repayment_type is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIsNotNull() {
            addCriterion("repayment_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeEqualTo(String value) {
            addCriterion("repayment_type =", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotEqualTo(String value) {
            addCriterion("repayment_type <>", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThan(String value) {
            addCriterion("repayment_type >", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_type >=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThan(String value) {
            addCriterion("repayment_type <", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("repayment_type <=", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeLike(String value) {
            addCriterion("repayment_type like", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotLike(String value) {
            addCriterion("repayment_type not like", value, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeIn(List<String> values) {
            addCriterion("repayment_type in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotIn(List<String> values) {
            addCriterion("repayment_type not in", values, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeBetween(String value1, String value2) {
            addCriterion("repayment_type between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andRepaymentTypeNotBetween(String value1, String value2) {
            addCriterion("repayment_type not between", value1, value2, "repaymentType");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIsNull() {
            addCriterion("buy_amount is null");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIsNotNull() {
            addCriterion("buy_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBuyAmountEqualTo(Long value) {
            addCriterion("buy_amount =", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotEqualTo(Long value) {
            addCriterion("buy_amount <>", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountGreaterThan(Long value) {
            addCriterion("buy_amount >", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("buy_amount >=", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountLessThan(Long value) {
            addCriterion("buy_amount <", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountLessThanOrEqualTo(Long value) {
            addCriterion("buy_amount <=", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIn(List<Long> values) {
            addCriterion("buy_amount in", values, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotIn(List<Long> values) {
            addCriterion("buy_amount not in", values, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountBetween(Long value1, Long value2) {
            addCriterion("buy_amount between", value1, value2, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotBetween(Long value1, Long value2) {
            addCriterion("buy_amount not between", value1, value2, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountIsNull() {
            addCriterion("group_amount is null");
            return (Criteria) this;
        }

        public Criteria andGroupAmountIsNotNull() {
            addCriterion("group_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGroupAmountEqualTo(Long value) {
            addCriterion("group_amount =", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountNotEqualTo(Long value) {
            addCriterion("group_amount <>", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountGreaterThan(Long value) {
            addCriterion("group_amount >", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("group_amount >=", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountLessThan(Long value) {
            addCriterion("group_amount <", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountLessThanOrEqualTo(Long value) {
            addCriterion("group_amount <=", value, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountIn(List<Long> values) {
            addCriterion("group_amount in", values, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountNotIn(List<Long> values) {
            addCriterion("group_amount not in", values, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountBetween(Long value1, Long value2) {
            addCriterion("group_amount between", value1, value2, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andGroupAmountNotBetween(Long value1, Long value2) {
            addCriterion("group_amount not between", value1, value2, "groupAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountIsNull() {
            addCriterion("finance_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountIsNotNull() {
            addCriterion("finance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountEqualTo(Long value) {
            addCriterion("finance_amount =", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountNotEqualTo(Long value) {
            addCriterion("finance_amount <>", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountGreaterThan(Long value) {
            addCriterion("finance_amount >", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("finance_amount >=", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountLessThan(Long value) {
            addCriterion("finance_amount <", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountLessThanOrEqualTo(Long value) {
            addCriterion("finance_amount <=", value, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountIn(List<Long> values) {
            addCriterion("finance_amount in", values, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountNotIn(List<Long> values) {
            addCriterion("finance_amount not in", values, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountBetween(Long value1, Long value2) {
            addCriterion("finance_amount between", value1, value2, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andFinanceAmountNotBetween(Long value1, Long value2) {
            addCriterion("finance_amount not between", value1, value2, "financeAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountIsNull() {
            addCriterion("arrival_amount is null");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountIsNotNull() {
            addCriterion("arrival_amount is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountEqualTo(Long value) {
            addCriterion("arrival_amount =", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountNotEqualTo(Long value) {
            addCriterion("arrival_amount <>", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountGreaterThan(Long value) {
            addCriterion("arrival_amount >", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("arrival_amount >=", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountLessThan(Long value) {
            addCriterion("arrival_amount <", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountLessThanOrEqualTo(Long value) {
            addCriterion("arrival_amount <=", value, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountIn(List<Long> values) {
            addCriterion("arrival_amount in", values, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountNotIn(List<Long> values) {
            addCriterion("arrival_amount not in", values, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountBetween(Long value1, Long value2) {
            addCriterion("arrival_amount between", value1, value2, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andArrivalAmountNotBetween(Long value1, Long value2) {
            addCriterion("arrival_amount not between", value1, value2, "arrivalAmount");
            return (Criteria) this;
        }

        public Criteria andBuyFeeIsNull() {
            addCriterion("buy_fee is null");
            return (Criteria) this;
        }

        public Criteria andBuyFeeIsNotNull() {
            addCriterion("buy_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBuyFeeEqualTo(Long value) {
            addCriterion("buy_fee =", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeNotEqualTo(Long value) {
            addCriterion("buy_fee <>", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeGreaterThan(Long value) {
            addCriterion("buy_fee >", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("buy_fee >=", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeLessThan(Long value) {
            addCriterion("buy_fee <", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeLessThanOrEqualTo(Long value) {
            addCriterion("buy_fee <=", value, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeIn(List<Long> values) {
            addCriterion("buy_fee in", values, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeNotIn(List<Long> values) {
            addCriterion("buy_fee not in", values, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeBetween(Long value1, Long value2) {
            addCriterion("buy_fee between", value1, value2, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyFeeNotBetween(Long value1, Long value2) {
            addCriterion("buy_fee not between", value1, value2, "buyFee");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeIsNull() {
            addCriterion("buy_rate_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeIsNotNull() {
            addCriterion("buy_rate_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeEqualTo(String value) {
            addCriterion("buy_rate_type =", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeNotEqualTo(String value) {
            addCriterion("buy_rate_type <>", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeGreaterThan(String value) {
            addCriterion("buy_rate_type >", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_rate_type >=", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeLessThan(String value) {
            addCriterion("buy_rate_type <", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeLessThanOrEqualTo(String value) {
            addCriterion("buy_rate_type <=", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeLike(String value) {
            addCriterion("buy_rate_type like", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeNotLike(String value) {
            addCriterion("buy_rate_type not like", value, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeIn(List<String> values) {
            addCriterion("buy_rate_type in", values, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeNotIn(List<String> values) {
            addCriterion("buy_rate_type not in", values, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeBetween(String value1, String value2) {
            addCriterion("buy_rate_type between", value1, value2, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andBuyRateTypeNotBetween(String value1, String value2) {
            addCriterion("buy_rate_type not between", value1, value2, "buyRateType");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlIsNull() {
            addCriterion("rate_sync_url is null");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlIsNotNull() {
            addCriterion("rate_sync_url is not null");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlEqualTo(String value) {
            addCriterion("rate_sync_url =", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlNotEqualTo(String value) {
            addCriterion("rate_sync_url <>", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlGreaterThan(String value) {
            addCriterion("rate_sync_url >", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rate_sync_url >=", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlLessThan(String value) {
            addCriterion("rate_sync_url <", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlLessThanOrEqualTo(String value) {
            addCriterion("rate_sync_url <=", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlLike(String value) {
            addCriterion("rate_sync_url like", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlNotLike(String value) {
            addCriterion("rate_sync_url not like", value, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlIn(List<String> values) {
            addCriterion("rate_sync_url in", values, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlNotIn(List<String> values) {
            addCriterion("rate_sync_url not in", values, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlBetween(String value1, String value2) {
            addCriterion("rate_sync_url between", value1, value2, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andRateSyncUrlNotBetween(String value1, String value2) {
            addCriterion("rate_sync_url not between", value1, value2, "rateSyncUrl");
            return (Criteria) this;
        }

        public Criteria andBuyRateIsNull() {
            addCriterion("buy_rate is null");
            return (Criteria) this;
        }

        public Criteria andBuyRateIsNotNull() {
            addCriterion("buy_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBuyRateEqualTo(Long value) {
            addCriterion("buy_rate =", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateNotEqualTo(Long value) {
            addCriterion("buy_rate <>", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateGreaterThan(Long value) {
            addCriterion("buy_rate >", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateGreaterThanOrEqualTo(Long value) {
            addCriterion("buy_rate >=", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateLessThan(Long value) {
            addCriterion("buy_rate <", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateLessThanOrEqualTo(Long value) {
            addCriterion("buy_rate <=", value, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateIn(List<Long> values) {
            addCriterion("buy_rate in", values, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateNotIn(List<Long> values) {
            addCriterion("buy_rate not in", values, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateBetween(Long value1, Long value2) {
            addCriterion("buy_rate between", value1, value2, "buyRate");
            return (Criteria) this;
        }

        public Criteria andBuyRateNotBetween(Long value1, Long value2) {
            addCriterion("buy_rate not between", value1, value2, "buyRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateIsNull() {
            addCriterion("group_rate is null");
            return (Criteria) this;
        }

        public Criteria andGroupRateIsNotNull() {
            addCriterion("group_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGroupRateEqualTo(Long value) {
            addCriterion("group_rate =", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateNotEqualTo(Long value) {
            addCriterion("group_rate <>", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateGreaterThan(Long value) {
            addCriterion("group_rate >", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateGreaterThanOrEqualTo(Long value) {
            addCriterion("group_rate >=", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateLessThan(Long value) {
            addCriterion("group_rate <", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateLessThanOrEqualTo(Long value) {
            addCriterion("group_rate <=", value, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateIn(List<Long> values) {
            addCriterion("group_rate in", values, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateNotIn(List<Long> values) {
            addCriterion("group_rate not in", values, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateBetween(Long value1, Long value2) {
            addCriterion("group_rate between", value1, value2, "groupRate");
            return (Criteria) this;
        }

        public Criteria andGroupRateNotBetween(Long value1, Long value2) {
            addCriterion("group_rate not between", value1, value2, "groupRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateIsNull() {
            addCriterion("sale_rate is null");
            return (Criteria) this;
        }

        public Criteria andSaleRateIsNotNull() {
            addCriterion("sale_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSaleRateEqualTo(Long value) {
            addCriterion("sale_rate =", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateNotEqualTo(Long value) {
            addCriterion("sale_rate <>", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateGreaterThan(Long value) {
            addCriterion("sale_rate >", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateGreaterThanOrEqualTo(Long value) {
            addCriterion("sale_rate >=", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateLessThan(Long value) {
            addCriterion("sale_rate <", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateLessThanOrEqualTo(Long value) {
            addCriterion("sale_rate <=", value, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateIn(List<Long> values) {
            addCriterion("sale_rate in", values, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateNotIn(List<Long> values) {
            addCriterion("sale_rate not in", values, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateBetween(Long value1, Long value2) {
            addCriterion("sale_rate between", value1, value2, "saleRate");
            return (Criteria) this;
        }

        public Criteria andSaleRateNotBetween(Long value1, Long value2) {
            addCriterion("sale_rate not between", value1, value2, "saleRate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateIsNull() {
            addCriterion("interest_start_date is null");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateIsNotNull() {
            addCriterion("interest_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("interest_start_date =", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("interest_start_date <>", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("interest_start_date >", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("interest_start_date >=", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateLessThan(Date value) {
            addCriterionForJDBCDate("interest_start_date <", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("interest_start_date <=", value, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("interest_start_date in", values, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("interest_start_date not in", values, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("interest_start_date between", value1, value2, "interestStartDate");
            return (Criteria) this;
        }

        public Criteria andInterestStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("interest_start_date not between", value1, value2, "interestStartDate");
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
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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

        public Criteria andIsTreatedIsNull() {
            addCriterion("is_treated is null");
            return (Criteria) this;
        }

        public Criteria andIsTreatedIsNotNull() {
            addCriterion("is_treated is not null");
            return (Criteria) this;
        }

        public Criteria andIsTreatedEqualTo(Byte value) {
            addCriterion("is_treated =", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedNotEqualTo(Byte value) {
            addCriterion("is_treated <>", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedGreaterThan(Byte value) {
            addCriterion("is_treated >", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_treated >=", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedLessThan(Byte value) {
            addCriterion("is_treated <", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedLessThanOrEqualTo(Byte value) {
            addCriterion("is_treated <=", value, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedIn(List<Byte> values) {
            addCriterion("is_treated in", values, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedNotIn(List<Byte> values) {
            addCriterion("is_treated not in", values, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedBetween(Byte value1, Byte value2) {
            addCriterion("is_treated between", value1, value2, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsTreatedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_treated not between", value1, value2, "isTreated");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolIsNull() {
            addCriterion("is_asset_pool is null");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolIsNotNull() {
            addCriterion("is_asset_pool is not null");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolEqualTo(Byte value) {
            addCriterion("is_asset_pool =", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolNotEqualTo(Byte value) {
            addCriterion("is_asset_pool <>", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolGreaterThan(Byte value) {
            addCriterion("is_asset_pool >", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_asset_pool >=", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolLessThan(Byte value) {
            addCriterion("is_asset_pool <", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolLessThanOrEqualTo(Byte value) {
            addCriterion("is_asset_pool <=", value, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolIn(List<Byte> values) {
            addCriterion("is_asset_pool in", values, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolNotIn(List<Byte> values) {
            addCriterion("is_asset_pool not in", values, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolBetween(Byte value1, Byte value2) {
            addCriterion("is_asset_pool between", value1, value2, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andIsAssetPoolNotBetween(Byte value1, Byte value2) {
            addCriterion("is_asset_pool not between", value1, value2, "isAssetPool");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeIsNull() {
            addCriterion("redeem_fee is null");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeIsNotNull() {
            addCriterion("redeem_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeEqualTo(Long value) {
            addCriterion("redeem_fee =", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeNotEqualTo(Long value) {
            addCriterion("redeem_fee <>", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeGreaterThan(Long value) {
            addCriterion("redeem_fee >", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("redeem_fee >=", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeLessThan(Long value) {
            addCriterion("redeem_fee <", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeLessThanOrEqualTo(Long value) {
            addCriterion("redeem_fee <=", value, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeIn(List<Long> values) {
            addCriterion("redeem_fee in", values, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeNotIn(List<Long> values) {
            addCriterion("redeem_fee not in", values, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeBetween(Long value1, Long value2) {
            addCriterion("redeem_fee between", value1, value2, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andRedeemFeeNotBetween(Long value1, Long value2) {
            addCriterion("redeem_fee not between", value1, value2, "redeemFee");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIsNull() {
            addCriterion("total_debt_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIsNotNull() {
            addCriterion("total_debt_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountEqualTo(Long value) {
            addCriterion("total_debt_amount =", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotEqualTo(Long value) {
            addCriterion("total_debt_amount <>", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountGreaterThan(Long value) {
            addCriterion("total_debt_amount >", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_debt_amount >=", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountLessThan(Long value) {
            addCriterion("total_debt_amount <", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_debt_amount <=", value, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountIn(List<Long> values) {
            addCriterion("total_debt_amount in", values, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotIn(List<Long> values) {
            addCriterion("total_debt_amount not in", values, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountBetween(Long value1, Long value2) {
            addCriterion("total_debt_amount between", value1, value2, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDebtAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_debt_amount not between", value1, value2, "totalDebtAmount");
            return (Criteria) this;
        }

        public Criteria andMarginRateIsNull() {
            addCriterion("margin_rate is null");
            return (Criteria) this;
        }

        public Criteria andMarginRateIsNotNull() {
            addCriterion("margin_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMarginRateEqualTo(Integer value) {
            addCriterion("margin_rate =", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateNotEqualTo(Integer value) {
            addCriterion("margin_rate <>", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateGreaterThan(Integer value) {
            addCriterion("margin_rate >", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("margin_rate >=", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateLessThan(Integer value) {
            addCriterion("margin_rate <", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateLessThanOrEqualTo(Integer value) {
            addCriterion("margin_rate <=", value, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateIn(List<Integer> values) {
            addCriterion("margin_rate in", values, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateNotIn(List<Integer> values) {
            addCriterion("margin_rate not in", values, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateBetween(Integer value1, Integer value2) {
            addCriterion("margin_rate between", value1, value2, "marginRate");
            return (Criteria) this;
        }

        public Criteria andMarginRateNotBetween(Integer value1, Integer value2) {
            addCriterion("margin_rate not between", value1, value2, "marginRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateIsNull() {
            addCriterion("risk_reserve_rate is null");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateIsNotNull() {
            addCriterion("risk_reserve_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateEqualTo(Integer value) {
            addCriterion("risk_reserve_rate =", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateNotEqualTo(Integer value) {
            addCriterion("risk_reserve_rate <>", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateGreaterThan(Integer value) {
            addCriterion("risk_reserve_rate >", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("risk_reserve_rate >=", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateLessThan(Integer value) {
            addCriterion("risk_reserve_rate <", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateLessThanOrEqualTo(Integer value) {
            addCriterion("risk_reserve_rate <=", value, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateIn(List<Integer> values) {
            addCriterion("risk_reserve_rate in", values, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateNotIn(List<Integer> values) {
            addCriterion("risk_reserve_rate not in", values, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateBetween(Integer value1, Integer value2) {
            addCriterion("risk_reserve_rate between", value1, value2, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andRiskReserveRateNotBetween(Integer value1, Integer value2) {
            addCriterion("risk_reserve_rate not between", value1, value2, "riskReserveRate");
            return (Criteria) this;
        }

        public Criteria andLoanNameIsNull() {
            addCriterion("loan_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanNameIsNotNull() {
            addCriterion("loan_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNameEqualTo(String value) {
            addCriterion("loan_name =", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotEqualTo(String value) {
            addCriterion("loan_name <>", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThan(String value) {
            addCriterion("loan_name >", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_name >=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThan(String value) {
            addCriterion("loan_name <", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThanOrEqualTo(String value) {
            addCriterion("loan_name <=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLike(String value) {
            addCriterion("loan_name like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotLike(String value) {
            addCriterion("loan_name not like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameIn(List<String> values) {
            addCriterion("loan_name in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotIn(List<String> values) {
            addCriterion("loan_name not in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameBetween(String value1, String value2) {
            addCriterion("loan_name between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotBetween(String value1, String value2) {
            addCriterion("loan_name not between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIsNull() {
            addCriterion("loan_usage is null");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIsNotNull() {
            addCriterion("loan_usage is not null");
            return (Criteria) this;
        }

        public Criteria andLoanUsageEqualTo(String value) {
            addCriterion("loan_usage =", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotEqualTo(String value) {
            addCriterion("loan_usage <>", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageGreaterThan(String value) {
            addCriterion("loan_usage >", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageGreaterThanOrEqualTo(String value) {
            addCriterion("loan_usage >=", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLessThan(String value) {
            addCriterion("loan_usage <", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLessThanOrEqualTo(String value) {
            addCriterion("loan_usage <=", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLike(String value) {
            addCriterion("loan_usage like", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotLike(String value) {
            addCriterion("loan_usage not like", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIn(List<String> values) {
            addCriterion("loan_usage in", values, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotIn(List<String> values) {
            addCriterion("loan_usage not in", values, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageBetween(String value1, String value2) {
            addCriterion("loan_usage between", value1, value2, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotBetween(String value1, String value2) {
            addCriterion("loan_usage not between", value1, value2, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceIsNull() {
            addCriterion("repayment_source is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceIsNotNull() {
            addCriterion("repayment_source is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceEqualTo(String value) {
            addCriterion("repayment_source =", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceNotEqualTo(String value) {
            addCriterion("repayment_source <>", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceGreaterThan(String value) {
            addCriterion("repayment_source >", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_source >=", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceLessThan(String value) {
            addCriterion("repayment_source <", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceLessThanOrEqualTo(String value) {
            addCriterion("repayment_source <=", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceLike(String value) {
            addCriterion("repayment_source like", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceNotLike(String value) {
            addCriterion("repayment_source not like", value, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceIn(List<String> values) {
            addCriterion("repayment_source in", values, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceNotIn(List<String> values) {
            addCriterion("repayment_source not in", values, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceBetween(String value1, String value2) {
            addCriterion("repayment_source between", value1, value2, "repaymentSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentSourceNotBetween(String value1, String value2) {
            addCriterion("repayment_source not between", value1, value2, "repaymentSource");
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

        public Criteria andLoanImgIsNull() {
            addCriterion("loan_img is null");
            return (Criteria) this;
        }

        public Criteria andLoanImgIsNotNull() {
            addCriterion("loan_img is not null");
            return (Criteria) this;
        }

        public Criteria andLoanImgEqualTo(String value) {
            addCriterion("loan_img =", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgNotEqualTo(String value) {
            addCriterion("loan_img <>", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgGreaterThan(String value) {
            addCriterion("loan_img >", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgGreaterThanOrEqualTo(String value) {
            addCriterion("loan_img >=", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgLessThan(String value) {
            addCriterion("loan_img <", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgLessThanOrEqualTo(String value) {
            addCriterion("loan_img <=", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgLike(String value) {
            addCriterion("loan_img like", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgNotLike(String value) {
            addCriterion("loan_img not like", value, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgIn(List<String> values) {
            addCriterion("loan_img in", values, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgNotIn(List<String> values) {
            addCriterion("loan_img not in", values, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgBetween(String value1, String value2) {
            addCriterion("loan_img between", value1, value2, "loanImg");
            return (Criteria) this;
        }

        public Criteria andLoanImgNotBetween(String value1, String value2) {
            addCriterion("loan_img not between", value1, value2, "loanImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonIsNull() {
            addCriterion("guarantee_person is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonIsNotNull() {
            addCriterion("guarantee_person is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonEqualTo(String value) {
            addCriterion("guarantee_person =", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonNotEqualTo(String value) {
            addCriterion("guarantee_person <>", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonGreaterThan(String value) {
            addCriterion("guarantee_person >", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_person >=", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonLessThan(String value) {
            addCriterion("guarantee_person <", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonLessThanOrEqualTo(String value) {
            addCriterion("guarantee_person <=", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonLike(String value) {
            addCriterion("guarantee_person like", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonNotLike(String value) {
            addCriterion("guarantee_person not like", value, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonIn(List<String> values) {
            addCriterion("guarantee_person in", values, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonNotIn(List<String> values) {
            addCriterion("guarantee_person not in", values, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonBetween(String value1, String value2) {
            addCriterion("guarantee_person between", value1, value2, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andGuaranteePersonNotBetween(String value1, String value2) {
            addCriterion("guarantee_person not between", value1, value2, "guaranteePerson");
            return (Criteria) this;
        }

        public Criteria andAgreementImgIsNull() {
            addCriterion("agreement_img is null");
            return (Criteria) this;
        }

        public Criteria andAgreementImgIsNotNull() {
            addCriterion("agreement_img is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementImgEqualTo(String value) {
            addCriterion("agreement_img =", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgNotEqualTo(String value) {
            addCriterion("agreement_img <>", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgGreaterThan(String value) {
            addCriterion("agreement_img >", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_img >=", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgLessThan(String value) {
            addCriterion("agreement_img <", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgLessThanOrEqualTo(String value) {
            addCriterion("agreement_img <=", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgLike(String value) {
            addCriterion("agreement_img like", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgNotLike(String value) {
            addCriterion("agreement_img not like", value, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgIn(List<String> values) {
            addCriterion("agreement_img in", values, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgNotIn(List<String> values) {
            addCriterion("agreement_img not in", values, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgBetween(String value1, String value2) {
            addCriterion("agreement_img between", value1, value2, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andAgreementImgNotBetween(String value1, String value2) {
            addCriterion("agreement_img not between", value1, value2, "agreementImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgIsNull() {
            addCriterion("guarantee_img is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgIsNotNull() {
            addCriterion("guarantee_img is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgEqualTo(String value) {
            addCriterion("guarantee_img =", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgNotEqualTo(String value) {
            addCriterion("guarantee_img <>", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgGreaterThan(String value) {
            addCriterion("guarantee_img >", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_img >=", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgLessThan(String value) {
            addCriterion("guarantee_img <", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgLessThanOrEqualTo(String value) {
            addCriterion("guarantee_img <=", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgLike(String value) {
            addCriterion("guarantee_img like", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgNotLike(String value) {
            addCriterion("guarantee_img not like", value, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgIn(List<String> values) {
            addCriterion("guarantee_img in", values, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgNotIn(List<String> values) {
            addCriterion("guarantee_img not in", values, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgBetween(String value1, String value2) {
            addCriterion("guarantee_img between", value1, value2, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgNotBetween(String value1, String value2) {
            addCriterion("guarantee_img not between", value1, value2, "guaranteeImg");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoIsNull() {
            addCriterion("guarantee_info is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoIsNotNull() {
            addCriterion("guarantee_info is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoEqualTo(String value) {
            addCriterion("guarantee_info =", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoNotEqualTo(String value) {
            addCriterion("guarantee_info <>", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoGreaterThan(String value) {
            addCriterion("guarantee_info >", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_info >=", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoLessThan(String value) {
            addCriterion("guarantee_info <", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoLessThanOrEqualTo(String value) {
            addCriterion("guarantee_info <=", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoLike(String value) {
            addCriterion("guarantee_info like", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoNotLike(String value) {
            addCriterion("guarantee_info not like", value, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoIn(List<String> values) {
            addCriterion("guarantee_info in", values, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoNotIn(List<String> values) {
            addCriterion("guarantee_info not in", values, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoBetween(String value1, String value2) {
            addCriterion("guarantee_info between", value1, value2, "guaranteeInfo");
            return (Criteria) this;
        }

        public Criteria andGuaranteeInfoNotBetween(String value1, String value2) {
            addCriterion("guarantee_info not between", value1, value2, "guaranteeInfo");
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

        public Criteria andOriginalAssetIdIsNull() {
            addCriterion("original_asset_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdIsNotNull() {
            addCriterion("original_asset_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdEqualTo(Long value) {
            addCriterion("original_asset_id =", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdNotEqualTo(Long value) {
            addCriterion("original_asset_id <>", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdGreaterThan(Long value) {
            addCriterion("original_asset_id >", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("original_asset_id >=", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdLessThan(Long value) {
            addCriterion("original_asset_id <", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdLessThanOrEqualTo(Long value) {
            addCriterion("original_asset_id <=", value, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdIn(List<Long> values) {
            addCriterion("original_asset_id in", values, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdNotIn(List<Long> values) {
            addCriterion("original_asset_id not in", values, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdBetween(Long value1, Long value2) {
            addCriterion("original_asset_id between", value1, value2, "originalAssetId");
            return (Criteria) this;
        }

        public Criteria andOriginalAssetIdNotBetween(Long value1, Long value2) {
            addCriterion("original_asset_id not between", value1, value2, "originalAssetId");
            return (Criteria) this;
        }
    }

    /**  tableName: debt_original_asset_bills   **/
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /** debt_original_asset_bills **/
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