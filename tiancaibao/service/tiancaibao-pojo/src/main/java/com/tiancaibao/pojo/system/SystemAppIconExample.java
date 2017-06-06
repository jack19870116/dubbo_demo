package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemAppIconExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    protected String fields;

    private static final long serialVersionUID = 1L;

    public SystemAppIconExample() {
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

        public Criteria andIconServiceBbsIsNull() {
            addCriterion("icon_service_bbs is null");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsIsNotNull() {
            addCriterion("icon_service_bbs is not null");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsEqualTo(String value) {
            addCriterion("icon_service_bbs =", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsNotEqualTo(String value) {
            addCriterion("icon_service_bbs <>", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsGreaterThan(String value) {
            addCriterion("icon_service_bbs >", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsGreaterThanOrEqualTo(String value) {
            addCriterion("icon_service_bbs >=", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsLessThan(String value) {
            addCriterion("icon_service_bbs <", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsLessThanOrEqualTo(String value) {
            addCriterion("icon_service_bbs <=", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsLike(String value) {
            addCriterion("icon_service_bbs like", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsNotLike(String value) {
            addCriterion("icon_service_bbs not like", value, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsIn(List<String> values) {
            addCriterion("icon_service_bbs in", values, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsNotIn(List<String> values) {
            addCriterion("icon_service_bbs not in", values, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsBetween(String value1, String value2) {
            addCriterion("icon_service_bbs between", value1, value2, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceBbsNotBetween(String value1, String value2) {
            addCriterion("icon_service_bbs not between", value1, value2, "iconServiceBbs");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskIsNull() {
            addCriterion("icon_service_task is null");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskIsNotNull() {
            addCriterion("icon_service_task is not null");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskEqualTo(String value) {
            addCriterion("icon_service_task =", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskNotEqualTo(String value) {
            addCriterion("icon_service_task <>", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskGreaterThan(String value) {
            addCriterion("icon_service_task >", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskGreaterThanOrEqualTo(String value) {
            addCriterion("icon_service_task >=", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskLessThan(String value) {
            addCriterion("icon_service_task <", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskLessThanOrEqualTo(String value) {
            addCriterion("icon_service_task <=", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskLike(String value) {
            addCriterion("icon_service_task like", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskNotLike(String value) {
            addCriterion("icon_service_task not like", value, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskIn(List<String> values) {
            addCriterion("icon_service_task in", values, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskNotIn(List<String> values) {
            addCriterion("icon_service_task not in", values, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskBetween(String value1, String value2) {
            addCriterion("icon_service_task between", value1, value2, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceTaskNotBetween(String value1, String value2) {
            addCriterion("icon_service_task not between", value1, value2, "iconServiceTask");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingIsNull() {
            addCriterion("icon_service_doing is null");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingIsNotNull() {
            addCriterion("icon_service_doing is not null");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingEqualTo(String value) {
            addCriterion("icon_service_doing =", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingNotEqualTo(String value) {
            addCriterion("icon_service_doing <>", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingGreaterThan(String value) {
            addCriterion("icon_service_doing >", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingGreaterThanOrEqualTo(String value) {
            addCriterion("icon_service_doing >=", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingLessThan(String value) {
            addCriterion("icon_service_doing <", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingLessThanOrEqualTo(String value) {
            addCriterion("icon_service_doing <=", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingLike(String value) {
            addCriterion("icon_service_doing like", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingNotLike(String value) {
            addCriterion("icon_service_doing not like", value, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingIn(List<String> values) {
            addCriterion("icon_service_doing in", values, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingNotIn(List<String> values) {
            addCriterion("icon_service_doing not in", values, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingBetween(String value1, String value2) {
            addCriterion("icon_service_doing between", value1, value2, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceDoingNotBetween(String value1, String value2) {
            addCriterion("icon_service_doing not between", value1, value2, "iconServiceDoing");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayIsNull() {
            addCriterion("icon_service_vipday is null");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayIsNotNull() {
            addCriterion("icon_service_vipday is not null");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayEqualTo(String value) {
            addCriterion("icon_service_vipday =", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayNotEqualTo(String value) {
            addCriterion("icon_service_vipday <>", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayGreaterThan(String value) {
            addCriterion("icon_service_vipday >", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayGreaterThanOrEqualTo(String value) {
            addCriterion("icon_service_vipday >=", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayLessThan(String value) {
            addCriterion("icon_service_vipday <", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayLessThanOrEqualTo(String value) {
            addCriterion("icon_service_vipday <=", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayLike(String value) {
            addCriterion("icon_service_vipday like", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayNotLike(String value) {
            addCriterion("icon_service_vipday not like", value, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayIn(List<String> values) {
            addCriterion("icon_service_vipday in", values, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayNotIn(List<String> values) {
            addCriterion("icon_service_vipday not in", values, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayBetween(String value1, String value2) {
            addCriterion("icon_service_vipday between", value1, value2, "iconServiceVipday");
            return (Criteria) this;
        }

        public Criteria andIconServiceVipdayNotBetween(String value1, String value2) {
            addCriterion("icon_service_vipday not between", value1, value2, "iconServiceVipday");
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

        public Criteria andIconMyVipdayEnableIsNull() {
            addCriterion("icon_my_vipday_enable is null");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableIsNotNull() {
            addCriterion("icon_my_vipday_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableEqualTo(String value) {
            addCriterion("icon_my_vipday_enable =", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableNotEqualTo(String value) {
            addCriterion("icon_my_vipday_enable <>", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableGreaterThan(String value) {
            addCriterion("icon_my_vipday_enable >", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableGreaterThanOrEqualTo(String value) {
            addCriterion("icon_my_vipday_enable >=", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableLessThan(String value) {
            addCriterion("icon_my_vipday_enable <", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableLessThanOrEqualTo(String value) {
            addCriterion("icon_my_vipday_enable <=", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableLike(String value) {
            addCriterion("icon_my_vipday_enable like", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableNotLike(String value) {
            addCriterion("icon_my_vipday_enable not like", value, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableIn(List<String> values) {
            addCriterion("icon_my_vipday_enable in", values, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableNotIn(List<String> values) {
            addCriterion("icon_my_vipday_enable not in", values, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableBetween(String value1, String value2) {
            addCriterion("icon_my_vipday_enable between", value1, value2, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayEnableNotBetween(String value1, String value2) {
            addCriterion("icon_my_vipday_enable not between", value1, value2, "iconMyVipdayEnable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableIsNull() {
            addCriterion("icon_my_vipday_disable is null");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableIsNotNull() {
            addCriterion("icon_my_vipday_disable is not null");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableEqualTo(String value) {
            addCriterion("icon_my_vipday_disable =", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableNotEqualTo(String value) {
            addCriterion("icon_my_vipday_disable <>", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableGreaterThan(String value) {
            addCriterion("icon_my_vipday_disable >", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableGreaterThanOrEqualTo(String value) {
            addCriterion("icon_my_vipday_disable >=", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableLessThan(String value) {
            addCriterion("icon_my_vipday_disable <", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableLessThanOrEqualTo(String value) {
            addCriterion("icon_my_vipday_disable <=", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableLike(String value) {
            addCriterion("icon_my_vipday_disable like", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableNotLike(String value) {
            addCriterion("icon_my_vipday_disable not like", value, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableIn(List<String> values) {
            addCriterion("icon_my_vipday_disable in", values, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableNotIn(List<String> values) {
            addCriterion("icon_my_vipday_disable not in", values, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableBetween(String value1, String value2) {
            addCriterion("icon_my_vipday_disable between", value1, value2, "iconMyVipdayDisable");
            return (Criteria) this;
        }

        public Criteria andIconMyVipdayDisableNotBetween(String value1, String value2) {
            addCriterion("icon_my_vipday_disable not between", value1, value2, "iconMyVipdayDisable");
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