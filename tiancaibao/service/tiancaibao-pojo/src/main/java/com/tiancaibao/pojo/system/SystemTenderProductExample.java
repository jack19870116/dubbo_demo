package com.tiancaibao.pojo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemTenderProductExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo=1;

    protected Integer startRow;

    protected Integer pageSize=10;

    private static final long serialVersionUID = 1L;

    public SystemTenderProductExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIsNull() {
            addCriterion("loan_phone is null");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIsNotNull() {
            addCriterion("loan_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneEqualTo(String value) {
            addCriterion("loan_phone =", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotEqualTo(String value) {
            addCriterion("loan_phone <>", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneGreaterThan(String value) {
            addCriterion("loan_phone >", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("loan_phone >=", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLessThan(String value) {
            addCriterion("loan_phone <", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLessThanOrEqualTo(String value) {
            addCriterion("loan_phone <=", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneLike(String value) {
            addCriterion("loan_phone like", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotLike(String value) {
            addCriterion("loan_phone not like", value, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneIn(List<String> values) {
            addCriterion("loan_phone in", values, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotIn(List<String> values) {
            addCriterion("loan_phone not in", values, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneBetween(String value1, String value2) {
            addCriterion("loan_phone between", value1, value2, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanPhoneNotBetween(String value1, String value2) {
            addCriterion("loan_phone not between", value1, value2, "loanPhone");
            return (Criteria) this;
        }

        public Criteria andLoanObjectIsNull() {
            addCriterion("loan_object is null");
            return (Criteria) this;
        }

        public Criteria andLoanObjectIsNotNull() {
            addCriterion("loan_object is not null");
            return (Criteria) this;
        }

        public Criteria andLoanObjectEqualTo(String value) {
            addCriterion("loan_object =", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectNotEqualTo(String value) {
            addCriterion("loan_object <>", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectGreaterThan(String value) {
            addCriterion("loan_object >", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectGreaterThanOrEqualTo(String value) {
            addCriterion("loan_object >=", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectLessThan(String value) {
            addCriterion("loan_object <", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectLessThanOrEqualTo(String value) {
            addCriterion("loan_object <=", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectLike(String value) {
            addCriterion("loan_object like", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectNotLike(String value) {
            addCriterion("loan_object not like", value, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectIn(List<String> values) {
            addCriterion("loan_object in", values, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectNotIn(List<String> values) {
            addCriterion("loan_object not in", values, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectBetween(String value1, String value2) {
            addCriterion("loan_object between", value1, value2, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanObjectNotBetween(String value1, String value2) {
            addCriterion("loan_object not between", value1, value2, "loanObject");
            return (Criteria) this;
        }

        public Criteria andLoanRouteIsNull() {
            addCriterion("loan_route is null");
            return (Criteria) this;
        }

        public Criteria andLoanRouteIsNotNull() {
            addCriterion("loan_route is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRouteEqualTo(String value) {
            addCriterion("loan_route =", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteNotEqualTo(String value) {
            addCriterion("loan_route <>", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteGreaterThan(String value) {
            addCriterion("loan_route >", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteGreaterThanOrEqualTo(String value) {
            addCriterion("loan_route >=", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteLessThan(String value) {
            addCriterion("loan_route <", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteLessThanOrEqualTo(String value) {
            addCriterion("loan_route <=", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteLike(String value) {
            addCriterion("loan_route like", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteNotLike(String value) {
            addCriterion("loan_route not like", value, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteIn(List<String> values) {
            addCriterion("loan_route in", values, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteNotIn(List<String> values) {
            addCriterion("loan_route not in", values, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteBetween(String value1, String value2) {
            addCriterion("loan_route between", value1, value2, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanRouteNotBetween(String value1, String value2) {
            addCriterion("loan_route not between", value1, value2, "loanRoute");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNull() {
            addCriterion("loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(Long value) {
            addCriterion("loan_amount =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(Long value) {
            addCriterion("loan_amount <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(Long value) {
            addCriterion("loan_amount >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("loan_amount >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(Long value) {
            addCriterion("loan_amount <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(Long value) {
            addCriterion("loan_amount <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<Long> values) {
            addCriterion("loan_amount in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<Long> values) {
            addCriterion("loan_amount not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(Long value1, Long value2) {
            addCriterion("loan_amount between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(Long value1, Long value2) {
            addCriterion("loan_amount not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andCountLimitIsNull() {
            addCriterion("count_limit is null");
            return (Criteria) this;
        }

        public Criteria andCountLimitIsNotNull() {
            addCriterion("count_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCountLimitEqualTo(Integer value) {
            addCriterion("count_limit =", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitNotEqualTo(Integer value) {
            addCriterion("count_limit <>", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitGreaterThan(Integer value) {
            addCriterion("count_limit >", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_limit >=", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitLessThan(Integer value) {
            addCriterion("count_limit <", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitLessThanOrEqualTo(Integer value) {
            addCriterion("count_limit <=", value, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitIn(List<Integer> values) {
            addCriterion("count_limit in", values, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitNotIn(List<Integer> values) {
            addCriterion("count_limit not in", values, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitBetween(Integer value1, Integer value2) {
            addCriterion("count_limit between", value1, value2, "countLimit");
            return (Criteria) this;
        }

        public Criteria andCountLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("count_limit not between", value1, value2, "countLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitIsNull() {
            addCriterion("money_limit is null");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitIsNotNull() {
            addCriterion("money_limit is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitEqualTo(Long value) {
            addCriterion("money_limit =", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitNotEqualTo(Long value) {
            addCriterion("money_limit <>", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitGreaterThan(Long value) {
            addCriterion("money_limit >", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("money_limit >=", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitLessThan(Long value) {
            addCriterion("money_limit <", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitLessThanOrEqualTo(Long value) {
            addCriterion("money_limit <=", value, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitIn(List<Long> values) {
            addCriterion("money_limit in", values, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitNotIn(List<Long> values) {
            addCriterion("money_limit not in", values, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitBetween(Long value1, Long value2) {
            addCriterion("money_limit between", value1, value2, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andMoneyLimitNotBetween(Long value1, Long value2) {
            addCriterion("money_limit not between", value1, value2, "moneyLimit");
            return (Criteria) this;
        }

        public Criteria andAnnualRateIsNull() {
            addCriterion("annual_rate is null");
            return (Criteria) this;
        }

        public Criteria andAnnualRateIsNotNull() {
            addCriterion("annual_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualRateEqualTo(Long value) {
            addCriterion("annual_rate =", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateNotEqualTo(Long value) {
            addCriterion("annual_rate <>", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateGreaterThan(Long value) {
            addCriterion("annual_rate >", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateGreaterThanOrEqualTo(Long value) {
            addCriterion("annual_rate >=", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateLessThan(Long value) {
            addCriterion("annual_rate <", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateLessThanOrEqualTo(Long value) {
            addCriterion("annual_rate <=", value, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateIn(List<Long> values) {
            addCriterion("annual_rate in", values, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateNotIn(List<Long> values) {
            addCriterion("annual_rate not in", values, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateBetween(Long value1, Long value2) {
            addCriterion("annual_rate between", value1, value2, "annualRate");
            return (Criteria) this;
        }

        public Criteria andAnnualRateNotBetween(Long value1, Long value2) {
            addCriterion("annual_rate not between", value1, value2, "annualRate");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNull() {
            addCriterion("surplus_amount is null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNotNull() {
            addCriterion("surplus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountEqualTo(Long value) {
            addCriterion("surplus_amount =", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotEqualTo(Long value) {
            addCriterion("surplus_amount <>", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThan(Long value) {
            addCriterion("surplus_amount >", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("surplus_amount >=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThan(Long value) {
            addCriterion("surplus_amount <", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThanOrEqualTo(Long value) {
            addCriterion("surplus_amount <=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIn(List<Long> values) {
            addCriterion("surplus_amount in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotIn(List<Long> values) {
            addCriterion("surplus_amount not in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountBetween(Long value1, Long value2) {
            addCriterion("surplus_amount between", value1, value2, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotBetween(Long value1, Long value2) {
            addCriterion("surplus_amount not between", value1, value2, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andExtraRateIsNull() {
            addCriterion("extra_rate is null");
            return (Criteria) this;
        }

        public Criteria andExtraRateIsNotNull() {
            addCriterion("extra_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExtraRateEqualTo(Long value) {
            addCriterion("extra_rate =", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateNotEqualTo(Long value) {
            addCriterion("extra_rate <>", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateGreaterThan(Long value) {
            addCriterion("extra_rate >", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateGreaterThanOrEqualTo(Long value) {
            addCriterion("extra_rate >=", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateLessThan(Long value) {
            addCriterion("extra_rate <", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateLessThanOrEqualTo(Long value) {
            addCriterion("extra_rate <=", value, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateIn(List<Long> values) {
            addCriterion("extra_rate in", values, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateNotIn(List<Long> values) {
            addCriterion("extra_rate not in", values, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateBetween(Long value1, Long value2) {
            addCriterion("extra_rate between", value1, value2, "extraRate");
            return (Criteria) this;
        }

        public Criteria andExtraRateNotBetween(Long value1, Long value2) {
            addCriterion("extra_rate not between", value1, value2, "extraRate");
            return (Criteria) this;
        }

        public Criteria andLoanUnitIsNull() {
            addCriterion("loan_unit is null");
            return (Criteria) this;
        }

        public Criteria andLoanUnitIsNotNull() {
            addCriterion("loan_unit is not null");
            return (Criteria) this;
        }

        public Criteria andLoanUnitEqualTo(String value) {
            addCriterion("loan_unit =", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitNotEqualTo(String value) {
            addCriterion("loan_unit <>", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitGreaterThan(String value) {
            addCriterion("loan_unit >", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitGreaterThanOrEqualTo(String value) {
            addCriterion("loan_unit >=", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitLessThan(String value) {
            addCriterion("loan_unit <", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitLessThanOrEqualTo(String value) {
            addCriterion("loan_unit <=", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitLike(String value) {
            addCriterion("loan_unit like", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitNotLike(String value) {
            addCriterion("loan_unit not like", value, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitIn(List<String> values) {
            addCriterion("loan_unit in", values, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitNotIn(List<String> values) {
            addCriterion("loan_unit not in", values, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitBetween(String value1, String value2) {
            addCriterion("loan_unit between", value1, value2, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanUnitNotBetween(String value1, String value2) {
            addCriterion("loan_unit not between", value1, value2, "loanUnit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitIsNull() {
            addCriterion("loan_limit is null");
            return (Criteria) this;
        }

        public Criteria andLoanLimitIsNotNull() {
            addCriterion("loan_limit is not null");
            return (Criteria) this;
        }

        public Criteria andLoanLimitEqualTo(Integer value) {
            addCriterion("loan_limit =", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitNotEqualTo(Integer value) {
            addCriterion("loan_limit <>", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitGreaterThan(Integer value) {
            addCriterion("loan_limit >", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_limit >=", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitLessThan(Integer value) {
            addCriterion("loan_limit <", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitLessThanOrEqualTo(Integer value) {
            addCriterion("loan_limit <=", value, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitIn(List<Integer> values) {
            addCriterion("loan_limit in", values, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitNotIn(List<Integer> values) {
            addCriterion("loan_limit not in", values, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitBetween(Integer value1, Integer value2) {
            addCriterion("loan_limit between", value1, value2, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andLoanLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_limit not between", value1, value2, "loanLimit");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeIsNull() {
            addCriterion("bid_deadtime is null");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeIsNotNull() {
            addCriterion("bid_deadtime is not null");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeEqualTo(Integer value) {
            addCriterion("bid_deadtime =", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeNotEqualTo(Integer value) {
            addCriterion("bid_deadtime <>", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeGreaterThan(Integer value) {
            addCriterion("bid_deadtime >", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_deadtime >=", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeLessThan(Integer value) {
            addCriterion("bid_deadtime <", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeLessThanOrEqualTo(Integer value) {
            addCriterion("bid_deadtime <=", value, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeIn(List<Integer> values) {
            addCriterion("bid_deadtime in", values, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeNotIn(List<Integer> values) {
            addCriterion("bid_deadtime not in", values, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeBetween(Integer value1, Integer value2) {
            addCriterion("bid_deadtime between", value1, value2, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andBidDeadtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_deadtime not between", value1, value2, "bidDeadtime");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountIsNull() {
            addCriterion("least_invest_amount is null");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountIsNotNull() {
            addCriterion("least_invest_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountEqualTo(Long value) {
            addCriterion("least_invest_amount =", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountNotEqualTo(Long value) {
            addCriterion("least_invest_amount <>", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountGreaterThan(Long value) {
            addCriterion("least_invest_amount >", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("least_invest_amount >=", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountLessThan(Long value) {
            addCriterion("least_invest_amount <", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountLessThanOrEqualTo(Long value) {
            addCriterion("least_invest_amount <=", value, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountIn(List<Long> values) {
            addCriterion("least_invest_amount in", values, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountNotIn(List<Long> values) {
            addCriterion("least_invest_amount not in", values, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountBetween(Long value1, Long value2) {
            addCriterion("least_invest_amount between", value1, value2, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andLeastInvestAmountNotBetween(Long value1, Long value2) {
            addCriterion("least_invest_amount not between", value1, value2, "leastInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountIsNull() {
            addCriterion("most_invest_amount is null");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountIsNotNull() {
            addCriterion("most_invest_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountEqualTo(Long value) {
            addCriterion("most_invest_amount =", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountNotEqualTo(Long value) {
            addCriterion("most_invest_amount <>", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountGreaterThan(Long value) {
            addCriterion("most_invest_amount >", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("most_invest_amount >=", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountLessThan(Long value) {
            addCriterion("most_invest_amount <", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountLessThanOrEqualTo(Long value) {
            addCriterion("most_invest_amount <=", value, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountIn(List<Long> values) {
            addCriterion("most_invest_amount in", values, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountNotIn(List<Long> values) {
            addCriterion("most_invest_amount not in", values, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountBetween(Long value1, Long value2) {
            addCriterion("most_invest_amount between", value1, value2, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andMostInvestAmountNotBetween(Long value1, Long value2) {
            addCriterion("most_invest_amount not between", value1, value2, "mostInvestAmount");
            return (Criteria) this;
        }

        public Criteria andProGroupIsNull() {
            addCriterion("pro_group is null");
            return (Criteria) this;
        }

        public Criteria andProGroupIsNotNull() {
            addCriterion("pro_group is not null");
            return (Criteria) this;
        }

        public Criteria andProGroupEqualTo(String value) {
            addCriterion("pro_group =", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotEqualTo(String value) {
            addCriterion("pro_group <>", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupGreaterThan(String value) {
            addCriterion("pro_group >", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupGreaterThanOrEqualTo(String value) {
            addCriterion("pro_group >=", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLessThan(String value) {
            addCriterion("pro_group <", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLessThanOrEqualTo(String value) {
            addCriterion("pro_group <=", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupLike(String value) {
            addCriterion("pro_group like", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotLike(String value) {
            addCriterion("pro_group not like", value, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupIn(List<String> values) {
            addCriterion("pro_group in", values, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotIn(List<String> values) {
            addCriterion("pro_group not in", values, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupBetween(String value1, String value2) {
            addCriterion("pro_group between", value1, value2, "proGroup");
            return (Criteria) this;
        }

        public Criteria andProGroupNotBetween(String value1, String value2) {
            addCriterion("pro_group not between", value1, value2, "proGroup");
            return (Criteria) this;
        }

        public Criteria andGroupDescIsNull() {
            addCriterion("group_desc is null");
            return (Criteria) this;
        }

        public Criteria andGroupDescIsNotNull() {
            addCriterion("group_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDescEqualTo(String value) {
            addCriterion("group_desc =", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescNotEqualTo(String value) {
            addCriterion("group_desc <>", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescGreaterThan(String value) {
            addCriterion("group_desc >", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescGreaterThanOrEqualTo(String value) {
            addCriterion("group_desc >=", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescLessThan(String value) {
            addCriterion("group_desc <", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescLessThanOrEqualTo(String value) {
            addCriterion("group_desc <=", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescLike(String value) {
            addCriterion("group_desc like", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescNotLike(String value) {
            addCriterion("group_desc not like", value, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescIn(List<String> values) {
            addCriterion("group_desc in", values, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescNotIn(List<String> values) {
            addCriterion("group_desc not in", values, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescBetween(String value1, String value2) {
            addCriterion("group_desc between", value1, value2, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andGroupDescNotBetween(String value1, String value2) {
            addCriterion("group_desc not between", value1, value2, "groupDesc");
            return (Criteria) this;
        }

        public Criteria andHotTagsIsNull() {
            addCriterion("hot_tags is null");
            return (Criteria) this;
        }

        public Criteria andHotTagsIsNotNull() {
            addCriterion("hot_tags is not null");
            return (Criteria) this;
        }

        public Criteria andHotTagsEqualTo(Integer value) {
            addCriterion("hot_tags =", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsNotEqualTo(Integer value) {
            addCriterion("hot_tags <>", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsGreaterThan(Integer value) {
            addCriterion("hot_tags >", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot_tags >=", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsLessThan(Integer value) {
            addCriterion("hot_tags <", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsLessThanOrEqualTo(Integer value) {
            addCriterion("hot_tags <=", value, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsIn(List<Integer> values) {
            addCriterion("hot_tags in", values, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsNotIn(List<Integer> values) {
            addCriterion("hot_tags not in", values, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsBetween(Integer value1, Integer value2) {
            addCriterion("hot_tags between", value1, value2, "hotTags");
            return (Criteria) this;
        }

        public Criteria andHotTagsNotBetween(Integer value1, Integer value2) {
            addCriterion("hot_tags not between", value1, value2, "hotTags");
            return (Criteria) this;
        }

        public Criteria andProImgPathIsNull() {
            addCriterion("pro_img_path is null");
            return (Criteria) this;
        }

        public Criteria andProImgPathIsNotNull() {
            addCriterion("pro_img_path is not null");
            return (Criteria) this;
        }

        public Criteria andProImgPathEqualTo(String value) {
            addCriterion("pro_img_path =", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathNotEqualTo(String value) {
            addCriterion("pro_img_path <>", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathGreaterThan(String value) {
            addCriterion("pro_img_path >", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("pro_img_path >=", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathLessThan(String value) {
            addCriterion("pro_img_path <", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathLessThanOrEqualTo(String value) {
            addCriterion("pro_img_path <=", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathLike(String value) {
            addCriterion("pro_img_path like", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathNotLike(String value) {
            addCriterion("pro_img_path not like", value, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathIn(List<String> values) {
            addCriterion("pro_img_path in", values, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathNotIn(List<String> values) {
            addCriterion("pro_img_path not in", values, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathBetween(String value1, String value2) {
            addCriterion("pro_img_path between", value1, value2, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andProImgPathNotBetween(String value1, String value2) {
            addCriterion("pro_img_path not between", value1, value2, "proImgPath");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("payment_method like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("payment_method not like", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andStatesIsNull() {
            addCriterion("states is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("states is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(Integer value) {
            addCriterion("states =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(Integer value) {
            addCriterion("states <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(Integer value) {
            addCriterion("states >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("states >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(Integer value) {
            addCriterion("states <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(Integer value) {
            addCriterion("states <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<Integer> values) {
            addCriterion("states in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<Integer> values) {
            addCriterion("states not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(Integer value1, Integer value2) {
            addCriterion("states between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(Integer value1, Integer value2) {
            addCriterion("states not between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
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

        public Criteria andInterestDateIsNull() {
            addCriterion("interest_date is null");
            return (Criteria) this;
        }

        public Criteria andInterestDateIsNotNull() {
            addCriterion("interest_date is not null");
            return (Criteria) this;
        }

        public Criteria andInterestDateEqualTo(Date value) {
            addCriterion("interest_date =", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateNotEqualTo(Date value) {
            addCriterion("interest_date <>", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateGreaterThan(Date value) {
            addCriterion("interest_date >", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateGreaterThanOrEqualTo(Date value) {
            addCriterion("interest_date >=", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateLessThan(Date value) {
            addCriterion("interest_date <", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateLessThanOrEqualTo(Date value) {
            addCriterion("interest_date <=", value, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateIn(List<Date> values) {
            addCriterion("interest_date in", values, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateNotIn(List<Date> values) {
            addCriterion("interest_date not in", values, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateBetween(Date value1, Date value2) {
            addCriterion("interest_date between", value1, value2, "interestDate");
            return (Criteria) this;
        }

        public Criteria andInterestDateNotBetween(Date value1, Date value2) {
            addCriterion("interest_date not between", value1, value2, "interestDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateIsNull() {
            addCriterion("last_repay_date is null");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateIsNotNull() {
            addCriterion("last_repay_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateEqualTo(Date value) {
            addCriterion("last_repay_date =", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateNotEqualTo(Date value) {
            addCriterion("last_repay_date <>", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateGreaterThan(Date value) {
            addCriterion("last_repay_date >", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_repay_date >=", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateLessThan(Date value) {
            addCriterion("last_repay_date <", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateLessThanOrEqualTo(Date value) {
            addCriterion("last_repay_date <=", value, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateIn(List<Date> values) {
            addCriterion("last_repay_date in", values, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateNotIn(List<Date> values) {
            addCriterion("last_repay_date not in", values, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateBetween(Date value1, Date value2) {
            addCriterion("last_repay_date between", value1, value2, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andLastRepayDateNotBetween(Date value1, Date value2) {
            addCriterion("last_repay_date not between", value1, value2, "lastRepayDate");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Integer value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Integer value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Integer value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Integer value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Integer value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Integer> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Integer> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Integer value1, Integer value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Integer value1, Integer value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermIsNull() {
            addCriterion("already_term is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermIsNotNull() {
            addCriterion("already_term is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermEqualTo(Integer value) {
            addCriterion("already_term =", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermNotEqualTo(Integer value) {
            addCriterion("already_term <>", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermGreaterThan(Integer value) {
            addCriterion("already_term >", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("already_term >=", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermLessThan(Integer value) {
            addCriterion("already_term <", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermLessThanOrEqualTo(Integer value) {
            addCriterion("already_term <=", value, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermIn(List<Integer> values) {
            addCriterion("already_term in", values, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermNotIn(List<Integer> values) {
            addCriterion("already_term not in", values, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermBetween(Integer value1, Integer value2) {
            addCriterion("already_term between", value1, value2, "alreadyTerm");
            return (Criteria) this;
        }

        public Criteria andAlreadyTermNotBetween(Integer value1, Integer value2) {
            addCriterion("already_term not between", value1, value2, "alreadyTerm");
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