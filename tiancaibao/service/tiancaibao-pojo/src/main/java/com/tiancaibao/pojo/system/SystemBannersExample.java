package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemBannersExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    private static final long serialVersionUID = 1L;

    public SystemBannersExample() {
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

        public Criteria andRequiredLoginIsNull() {
            addCriterion("required_login is null");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginIsNotNull() {
            addCriterion("required_login is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginEqualTo(Byte value) {
            addCriterion("required_login =", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginNotEqualTo(Byte value) {
            addCriterion("required_login <>", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginGreaterThan(Byte value) {
            addCriterion("required_login >", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginGreaterThanOrEqualTo(Byte value) {
            addCriterion("required_login >=", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginLessThan(Byte value) {
            addCriterion("required_login <", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginLessThanOrEqualTo(Byte value) {
            addCriterion("required_login <=", value, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginIn(List<Byte> values) {
            addCriterion("required_login in", values, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginNotIn(List<Byte> values) {
            addCriterion("required_login not in", values, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginBetween(Byte value1, Byte value2) {
            addCriterion("required_login between", value1, value2, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andRequiredLoginNotBetween(Byte value1, Byte value2) {
            addCriterion("required_login not between", value1, value2, "requiredLogin");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
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

        public Criteria andRedirectPcUrlIsNull() {
            addCriterion("redirect_pc_url is null");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlIsNotNull() {
            addCriterion("redirect_pc_url is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlEqualTo(String value) {
            addCriterion("redirect_pc_url =", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlNotEqualTo(String value) {
            addCriterion("redirect_pc_url <>", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlGreaterThan(String value) {
            addCriterion("redirect_pc_url >", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("redirect_pc_url >=", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlLessThan(String value) {
            addCriterion("redirect_pc_url <", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlLessThanOrEqualTo(String value) {
            addCriterion("redirect_pc_url <=", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlLike(String value) {
            addCriterion("redirect_pc_url like", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlNotLike(String value) {
            addCriterion("redirect_pc_url not like", value, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlIn(List<String> values) {
            addCriterion("redirect_pc_url in", values, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlNotIn(List<String> values) {
            addCriterion("redirect_pc_url not in", values, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlBetween(String value1, String value2) {
            addCriterion("redirect_pc_url between", value1, value2, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andRedirectPcUrlNotBetween(String value1, String value2) {
            addCriterion("redirect_pc_url not between", value1, value2, "redirectPcUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlIsNull() {
            addCriterion("pc_image_url is null");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlIsNotNull() {
            addCriterion("pc_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlEqualTo(String value) {
            addCriterion("pc_image_url =", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlNotEqualTo(String value) {
            addCriterion("pc_image_url <>", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlGreaterThan(String value) {
            addCriterion("pc_image_url >", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pc_image_url >=", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlLessThan(String value) {
            addCriterion("pc_image_url <", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlLessThanOrEqualTo(String value) {
            addCriterion("pc_image_url <=", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlLike(String value) {
            addCriterion("pc_image_url like", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlNotLike(String value) {
            addCriterion("pc_image_url not like", value, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlIn(List<String> values) {
            addCriterion("pc_image_url in", values, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlNotIn(List<String> values) {
            addCriterion("pc_image_url not in", values, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlBetween(String value1, String value2) {
            addCriterion("pc_image_url between", value1, value2, "pcImageUrl");
            return (Criteria) this;
        }

        public Criteria andPcImageUrlNotBetween(String value1, String value2) {
            addCriterion("pc_image_url not between", value1, value2, "pcImageUrl");
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

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Byte value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Byte value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Byte value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Byte value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Byte value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Byte value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Byte> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Byte> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Byte value1, Byte value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Byte value1, Byte value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andInsetIsNull() {
            addCriterion("inset is null");
            return (Criteria) this;
        }

        public Criteria andInsetIsNotNull() {
            addCriterion("inset is not null");
            return (Criteria) this;
        }

        public Criteria andInsetEqualTo(Byte value) {
            addCriterion("inset =", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetNotEqualTo(Byte value) {
            addCriterion("inset <>", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetGreaterThan(Byte value) {
            addCriterion("inset >", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetGreaterThanOrEqualTo(Byte value) {
            addCriterion("inset >=", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetLessThan(Byte value) {
            addCriterion("inset <", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetLessThanOrEqualTo(Byte value) {
            addCriterion("inset <=", value, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetIn(List<Byte> values) {
            addCriterion("inset in", values, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetNotIn(List<Byte> values) {
            addCriterion("inset not in", values, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetBetween(Byte value1, Byte value2) {
            addCriterion("inset between", value1, value2, "inset");
            return (Criteria) this;
        }

        public Criteria andInsetNotBetween(Byte value1, Byte value2) {
            addCriterion("inset not between", value1, value2, "inset");
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