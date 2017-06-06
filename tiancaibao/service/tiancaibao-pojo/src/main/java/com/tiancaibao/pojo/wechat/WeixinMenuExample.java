package com.tiancaibao.pojo.wechat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeixinMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public WeixinMenuExample() {
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

        public Criteria andMenunameIsNull() {
            addCriterion("menuname is null");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNotNull() {
            addCriterion("menuname is not null");
            return (Criteria) this;
        }

        public Criteria andMenunameEqualTo(String value) {
            addCriterion("menuname =", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotEqualTo(String value) {
            addCriterion("menuname <>", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThan(String value) {
            addCriterion("menuname >", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThanOrEqualTo(String value) {
            addCriterion("menuname >=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThan(String value) {
            addCriterion("menuname <", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThanOrEqualTo(String value) {
            addCriterion("menuname <=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLike(String value) {
            addCriterion("menuname like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotLike(String value) {
            addCriterion("menuname not like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameIn(List<String> values) {
            addCriterion("menuname in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotIn(List<String> values) {
            addCriterion("menuname not in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameBetween(String value1, String value2) {
            addCriterion("menuname between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotBetween(String value1, String value2) {
            addCriterion("menuname not between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andIssonMenuIsNull() {
            addCriterion("isson_menu is null");
            return (Criteria) this;
        }

        public Criteria andIssonMenuIsNotNull() {
            addCriterion("isson_menu is not null");
            return (Criteria) this;
        }

        public Criteria andIssonMenuEqualTo(String value) {
            addCriterion("isson_menu =", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuNotEqualTo(String value) {
            addCriterion("isson_menu <>", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuGreaterThan(String value) {
            addCriterion("isson_menu >", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuGreaterThanOrEqualTo(String value) {
            addCriterion("isson_menu >=", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuLessThan(String value) {
            addCriterion("isson_menu <", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuLessThanOrEqualTo(String value) {
            addCriterion("isson_menu <=", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuLike(String value) {
            addCriterion("isson_menu like", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuNotLike(String value) {
            addCriterion("isson_menu not like", value, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuIn(List<String> values) {
            addCriterion("isson_menu in", values, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuNotIn(List<String> values) {
            addCriterion("isson_menu not in", values, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuBetween(String value1, String value2) {
            addCriterion("isson_menu between", value1, value2, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andIssonMenuNotBetween(String value1, String value2) {
            addCriterion("isson_menu not between", value1, value2, "issonMenu");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andMenuWeighIsNull() {
            addCriterion("menu_weigh is null");
            return (Criteria) this;
        }

        public Criteria andMenuWeighIsNotNull() {
            addCriterion("menu_weigh is not null");
            return (Criteria) this;
        }

        public Criteria andMenuWeighEqualTo(Long value) {
            addCriterion("menu_weigh =", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighNotEqualTo(Long value) {
            addCriterion("menu_weigh <>", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighGreaterThan(Long value) {
            addCriterion("menu_weigh >", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighGreaterThanOrEqualTo(Long value) {
            addCriterion("menu_weigh >=", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighLessThan(Long value) {
            addCriterion("menu_weigh <", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighLessThanOrEqualTo(Long value) {
            addCriterion("menu_weigh <=", value, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighIn(List<Long> values) {
            addCriterion("menu_weigh in", values, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighNotIn(List<Long> values) {
            addCriterion("menu_weigh not in", values, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighBetween(Long value1, Long value2) {
            addCriterion("menu_weigh between", value1, value2, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andMenuWeighNotBetween(Long value1, Long value2) {
            addCriterion("menu_weigh not between", value1, value2, "menuWeigh");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlIsNull() {
            addCriterion("sonmenu_url is null");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlIsNotNull() {
            addCriterion("sonmenu_url is not null");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlEqualTo(String value) {
            addCriterion("sonmenu_url =", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlNotEqualTo(String value) {
            addCriterion("sonmenu_url <>", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlGreaterThan(String value) {
            addCriterion("sonmenu_url >", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sonmenu_url >=", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlLessThan(String value) {
            addCriterion("sonmenu_url <", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlLessThanOrEqualTo(String value) {
            addCriterion("sonmenu_url <=", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlLike(String value) {
            addCriterion("sonmenu_url like", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlNotLike(String value) {
            addCriterion("sonmenu_url not like", value, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlIn(List<String> values) {
            addCriterion("sonmenu_url in", values, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlNotIn(List<String> values) {
            addCriterion("sonmenu_url not in", values, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlBetween(String value1, String value2) {
            addCriterion("sonmenu_url between", value1, value2, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuUrlNotBetween(String value1, String value2) {
            addCriterion("sonmenu_url not between", value1, value2, "sonmenuUrl");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeIsNull() {
            addCriterion("sonmenu_type is null");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeIsNotNull() {
            addCriterion("sonmenu_type is not null");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeEqualTo(String value) {
            addCriterion("sonmenu_type =", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeNotEqualTo(String value) {
            addCriterion("sonmenu_type <>", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeGreaterThan(String value) {
            addCriterion("sonmenu_type >", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sonmenu_type >=", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeLessThan(String value) {
            addCriterion("sonmenu_type <", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeLessThanOrEqualTo(String value) {
            addCriterion("sonmenu_type <=", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeLike(String value) {
            addCriterion("sonmenu_type like", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeNotLike(String value) {
            addCriterion("sonmenu_type not like", value, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeIn(List<String> values) {
            addCriterion("sonmenu_type in", values, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeNotIn(List<String> values) {
            addCriterion("sonmenu_type not in", values, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeBetween(String value1, String value2) {
            addCriterion("sonmenu_type between", value1, value2, "sonmenuType");
            return (Criteria) this;
        }

        public Criteria andSonmenuTypeNotBetween(String value1, String value2) {
            addCriterion("sonmenu_type not between", value1, value2, "sonmenuType");
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