package com.tiancaibao.pojo.integral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntegralRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public IntegralRecordsExample() {
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

        public Criteria andShopindentIdIsNull() {
            addCriterion("shopindent_id is null");
            return (Criteria) this;
        }

        public Criteria andShopindentIdIsNotNull() {
            addCriterion("shopindent_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopindentIdEqualTo(Integer value) {
            addCriterion("shopindent_id =", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdNotEqualTo(Integer value) {
            addCriterion("shopindent_id <>", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdGreaterThan(Integer value) {
            addCriterion("shopindent_id >", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopindent_id >=", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdLessThan(Integer value) {
            addCriterion("shopindent_id <", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdLessThanOrEqualTo(Integer value) {
            addCriterion("shopindent_id <=", value, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdIn(List<Integer> values) {
            addCriterion("shopindent_id in", values, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdNotIn(List<Integer> values) {
            addCriterion("shopindent_id not in", values, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdBetween(Integer value1, Integer value2) {
            addCriterion("shopindent_id between", value1, value2, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andShopindentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shopindent_id not between", value1, value2, "shopindentId");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralIsNull() {
            addCriterion("user_current_integral is null");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralIsNotNull() {
            addCriterion("user_current_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralEqualTo(Integer value) {
            addCriterion("user_current_integral =", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralNotEqualTo(Integer value) {
            addCriterion("user_current_integral <>", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralGreaterThan(Integer value) {
            addCriterion("user_current_integral >", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_current_integral >=", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralLessThan(Integer value) {
            addCriterion("user_current_integral <", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("user_current_integral <=", value, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralIn(List<Integer> values) {
            addCriterion("user_current_integral in", values, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralNotIn(List<Integer> values) {
            addCriterion("user_current_integral not in", values, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralBetween(Integer value1, Integer value2) {
            addCriterion("user_current_integral between", value1, value2, "userCurrentIntegral");
            return (Criteria) this;
        }

        public Criteria andUserCurrentIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("user_current_integral not between", value1, value2, "userCurrentIntegral");
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

        public Criteria andElectronicCouponCategoryIdIsNull() {
            addCriterion("electronic_coupon_category_id is null");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdIsNotNull() {
            addCriterion("electronic_coupon_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdEqualTo(Integer value) {
            addCriterion("electronic_coupon_category_id =", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdNotEqualTo(Integer value) {
            addCriterion("electronic_coupon_category_id <>", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdGreaterThan(Integer value) {
            addCriterion("electronic_coupon_category_id >", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("electronic_coupon_category_id >=", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdLessThan(Integer value) {
            addCriterion("electronic_coupon_category_id <", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("electronic_coupon_category_id <=", value, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdIn(List<Integer> values) {
            addCriterion("electronic_coupon_category_id in", values, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdNotIn(List<Integer> values) {
            addCriterion("electronic_coupon_category_id not in", values, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("electronic_coupon_category_id between", value1, value2, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andElectronicCouponCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("electronic_coupon_category_id not between", value1, value2, "electronicCouponCategoryId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdIsNull() {
            addCriterion("add_interest_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdIsNotNull() {
            addCriterion("add_interest_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdEqualTo(Integer value) {
            addCriterion("add_interest_coupon_id =", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdNotEqualTo(Integer value) {
            addCriterion("add_interest_coupon_id <>", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdGreaterThan(Integer value) {
            addCriterion("add_interest_coupon_id >", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_interest_coupon_id >=", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdLessThan(Integer value) {
            addCriterion("add_interest_coupon_id <", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("add_interest_coupon_id <=", value, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdIn(List<Integer> values) {
            addCriterion("add_interest_coupon_id in", values, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdNotIn(List<Integer> values) {
            addCriterion("add_interest_coupon_id not in", values, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("add_interest_coupon_id between", value1, value2, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andAddInterestCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("add_interest_coupon_id not between", value1, value2, "addInterestCouponId");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
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