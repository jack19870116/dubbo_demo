package com.tiancaibao.pojo.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ShopsExample() {
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

        public Criteria andChildClassIdIsNull() {
            addCriterion("child_class_id is null");
            return (Criteria) this;
        }

        public Criteria andChildClassIdIsNotNull() {
            addCriterion("child_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andChildClassIdEqualTo(Long value) {
            addCriterion("child_class_id =", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdNotEqualTo(Long value) {
            addCriterion("child_class_id <>", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdGreaterThan(Long value) {
            addCriterion("child_class_id >", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("child_class_id >=", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdLessThan(Long value) {
            addCriterion("child_class_id <", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdLessThanOrEqualTo(Long value) {
            addCriterion("child_class_id <=", value, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdIn(List<Long> values) {
            addCriterion("child_class_id in", values, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdNotIn(List<Long> values) {
            addCriterion("child_class_id not in", values, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdBetween(Long value1, Long value2) {
            addCriterion("child_class_id between", value1, value2, "childClassId");
            return (Criteria) this;
        }

        public Criteria andChildClassIdNotBetween(Long value1, Long value2) {
            addCriterion("child_class_id not between", value1, value2, "childClassId");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andSisshopEqualTo(Integer value) {
            addCriterion("sisshop =", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotEqualTo(Integer value) {
            addCriterion("sisshop <>", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopGreaterThan(Integer value) {
            addCriterion("sisshop >", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopGreaterThanOrEqualTo(Integer value) {
            addCriterion("sisshop >=", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopLessThan(Integer value) {
            addCriterion("sisshop <", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopLessThanOrEqualTo(Integer value) {
            addCriterion("sisshop <=", value, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopIn(List<Integer> values) {
            addCriterion("sisshop in", values, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotIn(List<Integer> values) {
            addCriterion("sisshop not in", values, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopBetween(Integer value1, Integer value2) {
            addCriterion("sisshop between", value1, value2, "sisshop");
            return (Criteria) this;
        }

        public Criteria andSisshopNotBetween(Integer value1, Integer value2) {
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

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(Long value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(Long value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(Long value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(Long value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(Long value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(Long value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<Long> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<Long> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(Long value1, Long value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(Long value1, Long value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
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

        public Criteria andRedirectUrlIsNull() {
            addCriterion("redirect_url is null");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlIsNotNull() {
            addCriterion("redirect_url is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlEqualTo(String value) {
            addCriterion("redirect_url =", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotEqualTo(String value) {
            addCriterion("redirect_url <>", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlGreaterThan(String value) {
            addCriterion("redirect_url >", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("redirect_url >=", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLessThan(String value) {
            addCriterion("redirect_url <", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLessThanOrEqualTo(String value) {
            addCriterion("redirect_url <=", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlLike(String value) {
            addCriterion("redirect_url like", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotLike(String value) {
            addCriterion("redirect_url not like", value, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlIn(List<String> values) {
            addCriterion("redirect_url in", values, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotIn(List<String> values) {
            addCriterion("redirect_url not in", values, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlBetween(String value1, String value2) {
            addCriterion("redirect_url between", value1, value2, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectUrlNotBetween(String value1, String value2) {
            addCriterion("redirect_url not between", value1, value2, "redirectUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlIsNull() {
            addCriterion("data_url is null");
            return (Criteria) this;
        }

        public Criteria andDataUrlIsNotNull() {
            addCriterion("data_url is not null");
            return (Criteria) this;
        }

        public Criteria andDataUrlEqualTo(String value) {
            addCriterion("data_url =", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotEqualTo(String value) {
            addCriterion("data_url <>", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlGreaterThan(String value) {
            addCriterion("data_url >", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("data_url >=", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLessThan(String value) {
            addCriterion("data_url <", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLessThanOrEqualTo(String value) {
            addCriterion("data_url <=", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLike(String value) {
            addCriterion("data_url like", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotLike(String value) {
            addCriterion("data_url not like", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlIn(List<String> values) {
            addCriterion("data_url in", values, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotIn(List<String> values) {
            addCriterion("data_url not in", values, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlBetween(String value1, String value2) {
            addCriterion("data_url between", value1, value2, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotBetween(String value1, String value2) {
            addCriterion("data_url not between", value1, value2, "dataUrl");
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