package com.tiancaibao.pojo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQuestionAnswersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserQuestionAnswersExample() {
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

        public Criteria andAnswer1IsNull() {
            addCriterion("answer_1 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer1IsNotNull() {
            addCriterion("answer_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer1EqualTo(String value) {
            addCriterion("answer_1 =", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1NotEqualTo(String value) {
            addCriterion("answer_1 <>", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1GreaterThan(String value) {
            addCriterion("answer_1 >", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1GreaterThanOrEqualTo(String value) {
            addCriterion("answer_1 >=", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1LessThan(String value) {
            addCriterion("answer_1 <", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1LessThanOrEqualTo(String value) {
            addCriterion("answer_1 <=", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1Like(String value) {
            addCriterion("answer_1 like", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1NotLike(String value) {
            addCriterion("answer_1 not like", value, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1In(List<String> values) {
            addCriterion("answer_1 in", values, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1NotIn(List<String> values) {
            addCriterion("answer_1 not in", values, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1Between(String value1, String value2) {
            addCriterion("answer_1 between", value1, value2, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer1NotBetween(String value1, String value2) {
            addCriterion("answer_1 not between", value1, value2, "answer1");
            return (Criteria) this;
        }

        public Criteria andAnswer2IsNull() {
            addCriterion("answer_2 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer2IsNotNull() {
            addCriterion("answer_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer2EqualTo(String value) {
            addCriterion("answer_2 =", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2NotEqualTo(String value) {
            addCriterion("answer_2 <>", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2GreaterThan(String value) {
            addCriterion("answer_2 >", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2GreaterThanOrEqualTo(String value) {
            addCriterion("answer_2 >=", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2LessThan(String value) {
            addCriterion("answer_2 <", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2LessThanOrEqualTo(String value) {
            addCriterion("answer_2 <=", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2Like(String value) {
            addCriterion("answer_2 like", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2NotLike(String value) {
            addCriterion("answer_2 not like", value, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2In(List<String> values) {
            addCriterion("answer_2 in", values, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2NotIn(List<String> values) {
            addCriterion("answer_2 not in", values, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2Between(String value1, String value2) {
            addCriterion("answer_2 between", value1, value2, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer2NotBetween(String value1, String value2) {
            addCriterion("answer_2 not between", value1, value2, "answer2");
            return (Criteria) this;
        }

        public Criteria andAnswer3IsNull() {
            addCriterion("answer_3 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer3IsNotNull() {
            addCriterion("answer_3 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer3EqualTo(String value) {
            addCriterion("answer_3 =", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3NotEqualTo(String value) {
            addCriterion("answer_3 <>", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3GreaterThan(String value) {
            addCriterion("answer_3 >", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3GreaterThanOrEqualTo(String value) {
            addCriterion("answer_3 >=", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3LessThan(String value) {
            addCriterion("answer_3 <", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3LessThanOrEqualTo(String value) {
            addCriterion("answer_3 <=", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3Like(String value) {
            addCriterion("answer_3 like", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3NotLike(String value) {
            addCriterion("answer_3 not like", value, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3In(List<String> values) {
            addCriterion("answer_3 in", values, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3NotIn(List<String> values) {
            addCriterion("answer_3 not in", values, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3Between(String value1, String value2) {
            addCriterion("answer_3 between", value1, value2, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer3NotBetween(String value1, String value2) {
            addCriterion("answer_3 not between", value1, value2, "answer3");
            return (Criteria) this;
        }

        public Criteria andAnswer4IsNull() {
            addCriterion("answer_4 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer4IsNotNull() {
            addCriterion("answer_4 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer4EqualTo(String value) {
            addCriterion("answer_4 =", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4NotEqualTo(String value) {
            addCriterion("answer_4 <>", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4GreaterThan(String value) {
            addCriterion("answer_4 >", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4GreaterThanOrEqualTo(String value) {
            addCriterion("answer_4 >=", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4LessThan(String value) {
            addCriterion("answer_4 <", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4LessThanOrEqualTo(String value) {
            addCriterion("answer_4 <=", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4Like(String value) {
            addCriterion("answer_4 like", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4NotLike(String value) {
            addCriterion("answer_4 not like", value, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4In(List<String> values) {
            addCriterion("answer_4 in", values, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4NotIn(List<String> values) {
            addCriterion("answer_4 not in", values, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4Between(String value1, String value2) {
            addCriterion("answer_4 between", value1, value2, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer4NotBetween(String value1, String value2) {
            addCriterion("answer_4 not between", value1, value2, "answer4");
            return (Criteria) this;
        }

        public Criteria andAnswer5IsNull() {
            addCriterion("answer_5 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer5IsNotNull() {
            addCriterion("answer_5 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer5EqualTo(String value) {
            addCriterion("answer_5 =", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5NotEqualTo(String value) {
            addCriterion("answer_5 <>", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5GreaterThan(String value) {
            addCriterion("answer_5 >", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5GreaterThanOrEqualTo(String value) {
            addCriterion("answer_5 >=", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5LessThan(String value) {
            addCriterion("answer_5 <", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5LessThanOrEqualTo(String value) {
            addCriterion("answer_5 <=", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5Like(String value) {
            addCriterion("answer_5 like", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5NotLike(String value) {
            addCriterion("answer_5 not like", value, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5In(List<String> values) {
            addCriterion("answer_5 in", values, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5NotIn(List<String> values) {
            addCriterion("answer_5 not in", values, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5Between(String value1, String value2) {
            addCriterion("answer_5 between", value1, value2, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer5NotBetween(String value1, String value2) {
            addCriterion("answer_5 not between", value1, value2, "answer5");
            return (Criteria) this;
        }

        public Criteria andAnswer6IsNull() {
            addCriterion("answer_6 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer6IsNotNull() {
            addCriterion("answer_6 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer6EqualTo(String value) {
            addCriterion("answer_6 =", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6NotEqualTo(String value) {
            addCriterion("answer_6 <>", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6GreaterThan(String value) {
            addCriterion("answer_6 >", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6GreaterThanOrEqualTo(String value) {
            addCriterion("answer_6 >=", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6LessThan(String value) {
            addCriterion("answer_6 <", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6LessThanOrEqualTo(String value) {
            addCriterion("answer_6 <=", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6Like(String value) {
            addCriterion("answer_6 like", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6NotLike(String value) {
            addCriterion("answer_6 not like", value, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6In(List<String> values) {
            addCriterion("answer_6 in", values, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6NotIn(List<String> values) {
            addCriterion("answer_6 not in", values, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6Between(String value1, String value2) {
            addCriterion("answer_6 between", value1, value2, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer6NotBetween(String value1, String value2) {
            addCriterion("answer_6 not between", value1, value2, "answer6");
            return (Criteria) this;
        }

        public Criteria andAnswer7IsNull() {
            addCriterion("answer_7 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer7IsNotNull() {
            addCriterion("answer_7 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer7EqualTo(String value) {
            addCriterion("answer_7 =", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7NotEqualTo(String value) {
            addCriterion("answer_7 <>", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7GreaterThan(String value) {
            addCriterion("answer_7 >", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7GreaterThanOrEqualTo(String value) {
            addCriterion("answer_7 >=", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7LessThan(String value) {
            addCriterion("answer_7 <", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7LessThanOrEqualTo(String value) {
            addCriterion("answer_7 <=", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7Like(String value) {
            addCriterion("answer_7 like", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7NotLike(String value) {
            addCriterion("answer_7 not like", value, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7In(List<String> values) {
            addCriterion("answer_7 in", values, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7NotIn(List<String> values) {
            addCriterion("answer_7 not in", values, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7Between(String value1, String value2) {
            addCriterion("answer_7 between", value1, value2, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer7NotBetween(String value1, String value2) {
            addCriterion("answer_7 not between", value1, value2, "answer7");
            return (Criteria) this;
        }

        public Criteria andAnswer8IsNull() {
            addCriterion("answer_8 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer8IsNotNull() {
            addCriterion("answer_8 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer8EqualTo(String value) {
            addCriterion("answer_8 =", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8NotEqualTo(String value) {
            addCriterion("answer_8 <>", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8GreaterThan(String value) {
            addCriterion("answer_8 >", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8GreaterThanOrEqualTo(String value) {
            addCriterion("answer_8 >=", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8LessThan(String value) {
            addCriterion("answer_8 <", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8LessThanOrEqualTo(String value) {
            addCriterion("answer_8 <=", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8Like(String value) {
            addCriterion("answer_8 like", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8NotLike(String value) {
            addCriterion("answer_8 not like", value, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8In(List<String> values) {
            addCriterion("answer_8 in", values, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8NotIn(List<String> values) {
            addCriterion("answer_8 not in", values, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8Between(String value1, String value2) {
            addCriterion("answer_8 between", value1, value2, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer8NotBetween(String value1, String value2) {
            addCriterion("answer_8 not between", value1, value2, "answer8");
            return (Criteria) this;
        }

        public Criteria andAnswer9IsNull() {
            addCriterion("answer_9 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer9IsNotNull() {
            addCriterion("answer_9 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer9EqualTo(String value) {
            addCriterion("answer_9 =", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9NotEqualTo(String value) {
            addCriterion("answer_9 <>", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9GreaterThan(String value) {
            addCriterion("answer_9 >", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9GreaterThanOrEqualTo(String value) {
            addCriterion("answer_9 >=", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9LessThan(String value) {
            addCriterion("answer_9 <", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9LessThanOrEqualTo(String value) {
            addCriterion("answer_9 <=", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9Like(String value) {
            addCriterion("answer_9 like", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9NotLike(String value) {
            addCriterion("answer_9 not like", value, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9In(List<String> values) {
            addCriterion("answer_9 in", values, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9NotIn(List<String> values) {
            addCriterion("answer_9 not in", values, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9Between(String value1, String value2) {
            addCriterion("answer_9 between", value1, value2, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer9NotBetween(String value1, String value2) {
            addCriterion("answer_9 not between", value1, value2, "answer9");
            return (Criteria) this;
        }

        public Criteria andAnswer10IsNull() {
            addCriterion("answer_10 is null");
            return (Criteria) this;
        }

        public Criteria andAnswer10IsNotNull() {
            addCriterion("answer_10 is not null");
            return (Criteria) this;
        }

        public Criteria andAnswer10EqualTo(String value) {
            addCriterion("answer_10 =", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10NotEqualTo(String value) {
            addCriterion("answer_10 <>", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10GreaterThan(String value) {
            addCriterion("answer_10 >", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10GreaterThanOrEqualTo(String value) {
            addCriterion("answer_10 >=", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10LessThan(String value) {
            addCriterion("answer_10 <", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10LessThanOrEqualTo(String value) {
            addCriterion("answer_10 <=", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10Like(String value) {
            addCriterion("answer_10 like", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10NotLike(String value) {
            addCriterion("answer_10 not like", value, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10In(List<String> values) {
            addCriterion("answer_10 in", values, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10NotIn(List<String> values) {
            addCriterion("answer_10 not in", values, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10Between(String value1, String value2) {
            addCriterion("answer_10 between", value1, value2, "answer10");
            return (Criteria) this;
        }

        public Criteria andAnswer10NotBetween(String value1, String value2) {
            addCriterion("answer_10 not between", value1, value2, "answer10");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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