package com.tiancaibao.pojo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRiskAssessmentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserRiskAssessmentsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAnswerAIsNull() {
            addCriterion("answer_a is null");
            return (Criteria) this;
        }

        public Criteria andAnswerAIsNotNull() {
            addCriterion("answer_a is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerAEqualTo(String value) {
            addCriterion("answer_a =", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerANotEqualTo(String value) {
            addCriterion("answer_a <>", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerAGreaterThan(String value) {
            addCriterion("answer_a >", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerAGreaterThanOrEqualTo(String value) {
            addCriterion("answer_a >=", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerALessThan(String value) {
            addCriterion("answer_a <", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerALessThanOrEqualTo(String value) {
            addCriterion("answer_a <=", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerALike(String value) {
            addCriterion("answer_a like", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerANotLike(String value) {
            addCriterion("answer_a not like", value, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerAIn(List<String> values) {
            addCriterion("answer_a in", values, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerANotIn(List<String> values) {
            addCriterion("answer_a not in", values, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerABetween(String value1, String value2) {
            addCriterion("answer_a between", value1, value2, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerANotBetween(String value1, String value2) {
            addCriterion("answer_a not between", value1, value2, "answerA");
            return (Criteria) this;
        }

        public Criteria andAnswerBIsNull() {
            addCriterion("answer_b is null");
            return (Criteria) this;
        }

        public Criteria andAnswerBIsNotNull() {
            addCriterion("answer_b is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerBEqualTo(String value) {
            addCriterion("answer_b =", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBNotEqualTo(String value) {
            addCriterion("answer_b <>", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBGreaterThan(String value) {
            addCriterion("answer_b >", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBGreaterThanOrEqualTo(String value) {
            addCriterion("answer_b >=", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBLessThan(String value) {
            addCriterion("answer_b <", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBLessThanOrEqualTo(String value) {
            addCriterion("answer_b <=", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBLike(String value) {
            addCriterion("answer_b like", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBNotLike(String value) {
            addCriterion("answer_b not like", value, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBIn(List<String> values) {
            addCriterion("answer_b in", values, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBNotIn(List<String> values) {
            addCriterion("answer_b not in", values, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBBetween(String value1, String value2) {
            addCriterion("answer_b between", value1, value2, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerBNotBetween(String value1, String value2) {
            addCriterion("answer_b not between", value1, value2, "answerB");
            return (Criteria) this;
        }

        public Criteria andAnswerCIsNull() {
            addCriterion("answer_c is null");
            return (Criteria) this;
        }

        public Criteria andAnswerCIsNotNull() {
            addCriterion("answer_c is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerCEqualTo(String value) {
            addCriterion("answer_c =", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCNotEqualTo(String value) {
            addCriterion("answer_c <>", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCGreaterThan(String value) {
            addCriterion("answer_c >", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCGreaterThanOrEqualTo(String value) {
            addCriterion("answer_c >=", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCLessThan(String value) {
            addCriterion("answer_c <", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCLessThanOrEqualTo(String value) {
            addCriterion("answer_c <=", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCLike(String value) {
            addCriterion("answer_c like", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCNotLike(String value) {
            addCriterion("answer_c not like", value, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCIn(List<String> values) {
            addCriterion("answer_c in", values, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCNotIn(List<String> values) {
            addCriterion("answer_c not in", values, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCBetween(String value1, String value2) {
            addCriterion("answer_c between", value1, value2, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerCNotBetween(String value1, String value2) {
            addCriterion("answer_c not between", value1, value2, "answerC");
            return (Criteria) this;
        }

        public Criteria andAnswerDIsNull() {
            addCriterion("answer_d is null");
            return (Criteria) this;
        }

        public Criteria andAnswerDIsNotNull() {
            addCriterion("answer_d is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerDEqualTo(String value) {
            addCriterion("answer_d =", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDNotEqualTo(String value) {
            addCriterion("answer_d <>", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDGreaterThan(String value) {
            addCriterion("answer_d >", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDGreaterThanOrEqualTo(String value) {
            addCriterion("answer_d >=", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDLessThan(String value) {
            addCriterion("answer_d <", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDLessThanOrEqualTo(String value) {
            addCriterion("answer_d <=", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDLike(String value) {
            addCriterion("answer_d like", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDNotLike(String value) {
            addCriterion("answer_d not like", value, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDIn(List<String> values) {
            addCriterion("answer_d in", values, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDNotIn(List<String> values) {
            addCriterion("answer_d not in", values, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDBetween(String value1, String value2) {
            addCriterion("answer_d between", value1, value2, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerDNotBetween(String value1, String value2) {
            addCriterion("answer_d not between", value1, value2, "answerD");
            return (Criteria) this;
        }

        public Criteria andAnswerEIsNull() {
            addCriterion("answer_e is null");
            return (Criteria) this;
        }

        public Criteria andAnswerEIsNotNull() {
            addCriterion("answer_e is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEEqualTo(String value) {
            addCriterion("answer_e =", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerENotEqualTo(String value) {
            addCriterion("answer_e <>", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerEGreaterThan(String value) {
            addCriterion("answer_e >", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerEGreaterThanOrEqualTo(String value) {
            addCriterion("answer_e >=", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerELessThan(String value) {
            addCriterion("answer_e <", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerELessThanOrEqualTo(String value) {
            addCriterion("answer_e <=", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerELike(String value) {
            addCriterion("answer_e like", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerENotLike(String value) {
            addCriterion("answer_e not like", value, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerEIn(List<String> values) {
            addCriterion("answer_e in", values, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerENotIn(List<String> values) {
            addCriterion("answer_e not in", values, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerEBetween(String value1, String value2) {
            addCriterion("answer_e between", value1, value2, "answerE");
            return (Criteria) this;
        }

        public Criteria andAnswerENotBetween(String value1, String value2) {
            addCriterion("answer_e not between", value1, value2, "answerE");
            return (Criteria) this;
        }

        public Criteria andScoreAIsNull() {
            addCriterion("score_a is null");
            return (Criteria) this;
        }

        public Criteria andScoreAIsNotNull() {
            addCriterion("score_a is not null");
            return (Criteria) this;
        }

        public Criteria andScoreAEqualTo(Integer value) {
            addCriterion("score_a =", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreANotEqualTo(Integer value) {
            addCriterion("score_a <>", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreAGreaterThan(Integer value) {
            addCriterion("score_a >", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreAGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_a >=", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreALessThan(Integer value) {
            addCriterion("score_a <", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreALessThanOrEqualTo(Integer value) {
            addCriterion("score_a <=", value, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreAIn(List<Integer> values) {
            addCriterion("score_a in", values, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreANotIn(List<Integer> values) {
            addCriterion("score_a not in", values, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreABetween(Integer value1, Integer value2) {
            addCriterion("score_a between", value1, value2, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreANotBetween(Integer value1, Integer value2) {
            addCriterion("score_a not between", value1, value2, "scoreA");
            return (Criteria) this;
        }

        public Criteria andScoreBIsNull() {
            addCriterion("score_b is null");
            return (Criteria) this;
        }

        public Criteria andScoreBIsNotNull() {
            addCriterion("score_b is not null");
            return (Criteria) this;
        }

        public Criteria andScoreBEqualTo(Integer value) {
            addCriterion("score_b =", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBNotEqualTo(Integer value) {
            addCriterion("score_b <>", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBGreaterThan(Integer value) {
            addCriterion("score_b >", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_b >=", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBLessThan(Integer value) {
            addCriterion("score_b <", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBLessThanOrEqualTo(Integer value) {
            addCriterion("score_b <=", value, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBIn(List<Integer> values) {
            addCriterion("score_b in", values, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBNotIn(List<Integer> values) {
            addCriterion("score_b not in", values, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBBetween(Integer value1, Integer value2) {
            addCriterion("score_b between", value1, value2, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreBNotBetween(Integer value1, Integer value2) {
            addCriterion("score_b not between", value1, value2, "scoreB");
            return (Criteria) this;
        }

        public Criteria andScoreCIsNull() {
            addCriterion("score_c is null");
            return (Criteria) this;
        }

        public Criteria andScoreCIsNotNull() {
            addCriterion("score_c is not null");
            return (Criteria) this;
        }

        public Criteria andScoreCEqualTo(Integer value) {
            addCriterion("score_c =", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCNotEqualTo(Integer value) {
            addCriterion("score_c <>", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCGreaterThan(Integer value) {
            addCriterion("score_c >", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_c >=", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCLessThan(Integer value) {
            addCriterion("score_c <", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCLessThanOrEqualTo(Integer value) {
            addCriterion("score_c <=", value, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCIn(List<Integer> values) {
            addCriterion("score_c in", values, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCNotIn(List<Integer> values) {
            addCriterion("score_c not in", values, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCBetween(Integer value1, Integer value2) {
            addCriterion("score_c between", value1, value2, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreCNotBetween(Integer value1, Integer value2) {
            addCriterion("score_c not between", value1, value2, "scoreC");
            return (Criteria) this;
        }

        public Criteria andScoreDIsNull() {
            addCriterion("score_d is null");
            return (Criteria) this;
        }

        public Criteria andScoreDIsNotNull() {
            addCriterion("score_d is not null");
            return (Criteria) this;
        }

        public Criteria andScoreDEqualTo(Integer value) {
            addCriterion("score_d =", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDNotEqualTo(Integer value) {
            addCriterion("score_d <>", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDGreaterThan(Integer value) {
            addCriterion("score_d >", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_d >=", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDLessThan(Integer value) {
            addCriterion("score_d <", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDLessThanOrEqualTo(Integer value) {
            addCriterion("score_d <=", value, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDIn(List<Integer> values) {
            addCriterion("score_d in", values, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDNotIn(List<Integer> values) {
            addCriterion("score_d not in", values, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDBetween(Integer value1, Integer value2) {
            addCriterion("score_d between", value1, value2, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreDNotBetween(Integer value1, Integer value2) {
            addCriterion("score_d not between", value1, value2, "scoreD");
            return (Criteria) this;
        }

        public Criteria andScoreEIsNull() {
            addCriterion("score_e is null");
            return (Criteria) this;
        }

        public Criteria andScoreEIsNotNull() {
            addCriterion("score_e is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEEqualTo(Integer value) {
            addCriterion("score_e =", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreENotEqualTo(Integer value) {
            addCriterion("score_e <>", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreEGreaterThan(Integer value) {
            addCriterion("score_e >", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreEGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_e >=", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreELessThan(Integer value) {
            addCriterion("score_e <", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreELessThanOrEqualTo(Integer value) {
            addCriterion("score_e <=", value, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreEIn(List<Integer> values) {
            addCriterion("score_e in", values, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreENotIn(List<Integer> values) {
            addCriterion("score_e not in", values, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreEBetween(Integer value1, Integer value2) {
            addCriterion("score_e between", value1, value2, "scoreE");
            return (Criteria) this;
        }

        public Criteria andScoreENotBetween(Integer value1, Integer value2) {
            addCriterion("score_e not between", value1, value2, "scoreE");
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