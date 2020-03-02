package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IpIllnessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpIllnessExample() {
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

        public Criteria andIllnessIdIsNull() {
            addCriterion("illness_id is null");
            return (Criteria) this;
        }

        public Criteria andIllnessIdIsNotNull() {
            addCriterion("illness_id is not null");
            return (Criteria) this;
        }

        public Criteria andIllnessIdEqualTo(String value) {
            addCriterion("illness_id =", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdNotEqualTo(String value) {
            addCriterion("illness_id <>", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdGreaterThan(String value) {
            addCriterion("illness_id >", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdGreaterThanOrEqualTo(String value) {
            addCriterion("illness_id >=", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdLessThan(String value) {
            addCriterion("illness_id <", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdLessThanOrEqualTo(String value) {
            addCriterion("illness_id <=", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdLike(String value) {
            addCriterion("illness_id like", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdNotLike(String value) {
            addCriterion("illness_id not like", value, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdIn(List<String> values) {
            addCriterion("illness_id in", values, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdNotIn(List<String> values) {
            addCriterion("illness_id not in", values, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdBetween(String value1, String value2) {
            addCriterion("illness_id between", value1, value2, "illnessId");
            return (Criteria) this;
        }

        public Criteria andIllnessIdNotBetween(String value1, String value2) {
            addCriterion("illness_id not between", value1, value2, "illnessId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdIsNull() {
            addCriterion("remedy_id is null");
            return (Criteria) this;
        }

        public Criteria andRemedyIdIsNotNull() {
            addCriterion("remedy_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemedyIdEqualTo(String value) {
            addCriterion("remedy_id =", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdNotEqualTo(String value) {
            addCriterion("remedy_id <>", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdGreaterThan(String value) {
            addCriterion("remedy_id >", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdGreaterThanOrEqualTo(String value) {
            addCriterion("remedy_id >=", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdLessThan(String value) {
            addCriterion("remedy_id <", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdLessThanOrEqualTo(String value) {
            addCriterion("remedy_id <=", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdLike(String value) {
            addCriterion("remedy_id like", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdNotLike(String value) {
            addCriterion("remedy_id not like", value, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdIn(List<String> values) {
            addCriterion("remedy_id in", values, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdNotIn(List<String> values) {
            addCriterion("remedy_id not in", values, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdBetween(String value1, String value2) {
            addCriterion("remedy_id between", value1, value2, "remedyId");
            return (Criteria) this;
        }

        public Criteria andRemedyIdNotBetween(String value1, String value2) {
            addCriterion("remedy_id not between", value1, value2, "remedyId");
            return (Criteria) this;
        }

        public Criteria andIllnessIsNull() {
            addCriterion("illness is null");
            return (Criteria) this;
        }

        public Criteria andIllnessIsNotNull() {
            addCriterion("illness is not null");
            return (Criteria) this;
        }

        public Criteria andIllnessEqualTo(String value) {
            addCriterion("illness =", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotEqualTo(String value) {
            addCriterion("illness <>", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessGreaterThan(String value) {
            addCriterion("illness >", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("illness >=", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLessThan(String value) {
            addCriterion("illness <", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLessThanOrEqualTo(String value) {
            addCriterion("illness <=", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLike(String value) {
            addCriterion("illness like", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotLike(String value) {
            addCriterion("illness not like", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessIn(List<String> values) {
            addCriterion("illness in", values, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotIn(List<String> values) {
            addCriterion("illness not in", values, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessBetween(String value1, String value2) {
            addCriterion("illness between", value1, value2, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotBetween(String value1, String value2) {
            addCriterion("illness not between", value1, value2, "illness");
            return (Criteria) this;
        }

        public Criteria andCautionIsNull() {
            addCriterion("caution is null");
            return (Criteria) this;
        }

        public Criteria andCautionIsNotNull() {
            addCriterion("caution is not null");
            return (Criteria) this;
        }

        public Criteria andCautionEqualTo(String value) {
            addCriterion("caution =", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionNotEqualTo(String value) {
            addCriterion("caution <>", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionGreaterThan(String value) {
            addCriterion("caution >", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionGreaterThanOrEqualTo(String value) {
            addCriterion("caution >=", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionLessThan(String value) {
            addCriterion("caution <", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionLessThanOrEqualTo(String value) {
            addCriterion("caution <=", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionLike(String value) {
            addCriterion("caution like", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionNotLike(String value) {
            addCriterion("caution not like", value, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionIn(List<String> values) {
            addCriterion("caution in", values, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionNotIn(List<String> values) {
            addCriterion("caution not in", values, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionBetween(String value1, String value2) {
            addCriterion("caution between", value1, value2, "caution");
            return (Criteria) this;
        }

        public Criteria andCautionNotBetween(String value1, String value2) {
            addCriterion("caution not between", value1, value2, "caution");
            return (Criteria) this;
        }

        public Criteria andIllnessDateIsNull() {
            addCriterion("illness_date is null");
            return (Criteria) this;
        }

        public Criteria andIllnessDateIsNotNull() {
            addCriterion("illness_date is not null");
            return (Criteria) this;
        }

        public Criteria andIllnessDateEqualTo(Date value) {
            addCriterionForJDBCDate("illness_date =", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("illness_date <>", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateGreaterThan(Date value) {
            addCriterionForJDBCDate("illness_date >", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("illness_date >=", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateLessThan(Date value) {
            addCriterionForJDBCDate("illness_date <", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("illness_date <=", value, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateIn(List<Date> values) {
            addCriterionForJDBCDate("illness_date in", values, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("illness_date not in", values, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("illness_date between", value1, value2, "illnessDate");
            return (Criteria) this;
        }

        public Criteria andIllnessDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("illness_date not between", value1, value2, "illnessDate");
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