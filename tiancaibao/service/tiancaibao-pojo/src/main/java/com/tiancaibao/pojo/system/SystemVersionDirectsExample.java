package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemVersionDirectsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    protected String fields;

    private static final long serialVersionUID = 1L;

    public SystemVersionDirectsExample() {
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
        this.pageNo = pageNo;
this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields = fields;
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

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andWapImageIsNull() {
            addCriterion("wap_image is null");
            return (Criteria) this;
        }

        public Criteria andWapImageIsNotNull() {
            addCriterion("wap_image is not null");
            return (Criteria) this;
        }

        public Criteria andWapImageEqualTo(String value) {
            addCriterion("wap_image =", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageNotEqualTo(String value) {
            addCriterion("wap_image <>", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageGreaterThan(String value) {
            addCriterion("wap_image >", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageGreaterThanOrEqualTo(String value) {
            addCriterion("wap_image >=", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageLessThan(String value) {
            addCriterion("wap_image <", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageLessThanOrEqualTo(String value) {
            addCriterion("wap_image <=", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageLike(String value) {
            addCriterion("wap_image like", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageNotLike(String value) {
            addCriterion("wap_image not like", value, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageIn(List<String> values) {
            addCriterion("wap_image in", values, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageNotIn(List<String> values) {
            addCriterion("wap_image not in", values, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageBetween(String value1, String value2) {
            addCriterion("wap_image between", value1, value2, "wapImage");
            return (Criteria) this;
        }

        public Criteria andWapImageNotBetween(String value1, String value2) {
            addCriterion("wap_image not between", value1, value2, "wapImage");
            return (Criteria) this;
        }

        public Criteria andPcImageIsNull() {
            addCriterion("pc_image is null");
            return (Criteria) this;
        }

        public Criteria andPcImageIsNotNull() {
            addCriterion("pc_image is not null");
            return (Criteria) this;
        }

        public Criteria andPcImageEqualTo(String value) {
            addCriterion("pc_image =", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageNotEqualTo(String value) {
            addCriterion("pc_image <>", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageGreaterThan(String value) {
            addCriterion("pc_image >", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageGreaterThanOrEqualTo(String value) {
            addCriterion("pc_image >=", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageLessThan(String value) {
            addCriterion("pc_image <", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageLessThanOrEqualTo(String value) {
            addCriterion("pc_image <=", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageLike(String value) {
            addCriterion("pc_image like", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageNotLike(String value) {
            addCriterion("pc_image not like", value, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageIn(List<String> values) {
            addCriterion("pc_image in", values, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageNotIn(List<String> values) {
            addCriterion("pc_image not in", values, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageBetween(String value1, String value2) {
            addCriterion("pc_image between", value1, value2, "pcImage");
            return (Criteria) this;
        }

        public Criteria andPcImageNotBetween(String value1, String value2) {
            addCriterion("pc_image not between", value1, value2, "pcImage");
            return (Criteria) this;
        }

        public Criteria andWapUrlIsNull() {
            addCriterion("wap_url is null");
            return (Criteria) this;
        }

        public Criteria andWapUrlIsNotNull() {
            addCriterion("wap_url is not null");
            return (Criteria) this;
        }

        public Criteria andWapUrlEqualTo(String value) {
            addCriterion("wap_url =", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlNotEqualTo(String value) {
            addCriterion("wap_url <>", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlGreaterThan(String value) {
            addCriterion("wap_url >", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wap_url >=", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlLessThan(String value) {
            addCriterion("wap_url <", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlLessThanOrEqualTo(String value) {
            addCriterion("wap_url <=", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlLike(String value) {
            addCriterion("wap_url like", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlNotLike(String value) {
            addCriterion("wap_url not like", value, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlIn(List<String> values) {
            addCriterion("wap_url in", values, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlNotIn(List<String> values) {
            addCriterion("wap_url not in", values, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlBetween(String value1, String value2) {
            addCriterion("wap_url between", value1, value2, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andWapUrlNotBetween(String value1, String value2) {
            addCriterion("wap_url not between", value1, value2, "wapUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlIsNull() {
            addCriterion("pc_url is null");
            return (Criteria) this;
        }

        public Criteria andPcUrlIsNotNull() {
            addCriterion("pc_url is not null");
            return (Criteria) this;
        }

        public Criteria andPcUrlEqualTo(String value) {
            addCriterion("pc_url =", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlNotEqualTo(String value) {
            addCriterion("pc_url <>", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlGreaterThan(String value) {
            addCriterion("pc_url >", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pc_url >=", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlLessThan(String value) {
            addCriterion("pc_url <", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlLessThanOrEqualTo(String value) {
            addCriterion("pc_url <=", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlLike(String value) {
            addCriterion("pc_url like", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlNotLike(String value) {
            addCriterion("pc_url not like", value, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlIn(List<String> values) {
            addCriterion("pc_url in", values, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlNotIn(List<String> values) {
            addCriterion("pc_url not in", values, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlBetween(String value1, String value2) {
            addCriterion("pc_url between", value1, value2, "pcUrl");
            return (Criteria) this;
        }

        public Criteria andPcUrlNotBetween(String value1, String value2) {
            addCriterion("pc_url not between", value1, value2, "pcUrl");
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