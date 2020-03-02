package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpTreatmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpTreatmentExample() {
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

        public Criteria andTmIdIsNull() {
            addCriterion("tm_id is null");
            return (Criteria) this;
        }

        public Criteria andTmIdIsNotNull() {
            addCriterion("tm_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmIdEqualTo(String value) {
            addCriterion("tm_id =", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdNotEqualTo(String value) {
            addCriterion("tm_id <>", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdGreaterThan(String value) {
            addCriterion("tm_id >", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdGreaterThanOrEqualTo(String value) {
            addCriterion("tm_id >=", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdLessThan(String value) {
            addCriterion("tm_id <", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdLessThanOrEqualTo(String value) {
            addCriterion("tm_id <=", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdLike(String value) {
            addCriterion("tm_id like", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdNotLike(String value) {
            addCriterion("tm_id not like", value, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdIn(List<String> values) {
            addCriterion("tm_id in", values, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdNotIn(List<String> values) {
            addCriterion("tm_id not in", values, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdBetween(String value1, String value2) {
            addCriterion("tm_id between", value1, value2, "tmId");
            return (Criteria) this;
        }

        public Criteria andTmIdNotBetween(String value1, String value2) {
            addCriterion("tm_id not between", value1, value2, "tmId");
            return (Criteria) this;
        }

        public Criteria andSchemeIsNull() {
            addCriterion("scheme is null");
            return (Criteria) this;
        }

        public Criteria andSchemeIsNotNull() {
            addCriterion("scheme is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeEqualTo(Integer value) {
            addCriterion("scheme =", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeNotEqualTo(Integer value) {
            addCriterion("scheme <>", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeGreaterThan(Integer value) {
            addCriterion("scheme >", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scheme >=", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeLessThan(Integer value) {
            addCriterion("scheme <", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeLessThanOrEqualTo(Integer value) {
            addCriterion("scheme <=", value, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeIn(List<Integer> values) {
            addCriterion("scheme in", values, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeNotIn(List<Integer> values) {
            addCriterion("scheme not in", values, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeBetween(Integer value1, Integer value2) {
            addCriterion("scheme between", value1, value2, "scheme");
            return (Criteria) this;
        }

        public Criteria andSchemeNotBetween(Integer value1, Integer value2) {
            addCriterion("scheme not between", value1, value2, "scheme");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
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