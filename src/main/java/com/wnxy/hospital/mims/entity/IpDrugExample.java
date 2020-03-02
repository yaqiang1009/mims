package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IpDrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpDrugExample() {
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

        public Criteria andDrugIdIsNull() {
            addCriterion("drug_id is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNotNull() {
            addCriterion("drug_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdEqualTo(String value) {
            addCriterion("drug_id =", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotEqualTo(String value) {
            addCriterion("drug_id <>", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThan(String value) {
            addCriterion("drug_id >", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThanOrEqualTo(String value) {
            addCriterion("drug_id >=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThan(String value) {
            addCriterion("drug_id <", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThanOrEqualTo(String value) {
            addCriterion("drug_id <=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLike(String value) {
            addCriterion("drug_id like", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotLike(String value) {
            addCriterion("drug_id not like", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIn(List<String> values) {
            addCriterion("drug_id in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotIn(List<String> values) {
            addCriterion("drug_id not in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdBetween(String value1, String value2) {
            addCriterion("drug_id between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotBetween(String value1, String value2) {
            addCriterion("drug_id not between", value1, value2, "drugId");
            return (Criteria) this;
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

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andDrugStatusIsNull() {
            addCriterion("drug_status is null");
            return (Criteria) this;
        }

        public Criteria andDrugStatusIsNotNull() {
            addCriterion("drug_status is not null");
            return (Criteria) this;
        }

        public Criteria andDrugStatusEqualTo(String value) {
            addCriterion("drug_status =", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusNotEqualTo(String value) {
            addCriterion("drug_status <>", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusGreaterThan(String value) {
            addCriterion("drug_status >", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusGreaterThanOrEqualTo(String value) {
            addCriterion("drug_status >=", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusLessThan(String value) {
            addCriterion("drug_status <", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusLessThanOrEqualTo(String value) {
            addCriterion("drug_status <=", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusLike(String value) {
            addCriterion("drug_status like", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusNotLike(String value) {
            addCriterion("drug_status not like", value, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusIn(List<String> values) {
            addCriterion("drug_status in", values, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusNotIn(List<String> values) {
            addCriterion("drug_status not in", values, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusBetween(String value1, String value2) {
            addCriterion("drug_status between", value1, value2, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugStatusNotBetween(String value1, String value2) {
            addCriterion("drug_status not between", value1, value2, "drugStatus");
            return (Criteria) this;
        }

        public Criteria andDrugDateIsNull() {
            addCriterion("drug_date is null");
            return (Criteria) this;
        }

        public Criteria andDrugDateIsNotNull() {
            addCriterion("drug_date is not null");
            return (Criteria) this;
        }

        public Criteria andDrugDateEqualTo(Date value) {
            addCriterionForJDBCDate("drug_date =", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("drug_date <>", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateGreaterThan(Date value) {
            addCriterionForJDBCDate("drug_date >", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("drug_date >=", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateLessThan(Date value) {
            addCriterionForJDBCDate("drug_date <", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("drug_date <=", value, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateIn(List<Date> values) {
            addCriterionForJDBCDate("drug_date in", values, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("drug_date not in", values, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("drug_date between", value1, value2, "drugDate");
            return (Criteria) this;
        }

        public Criteria andDrugDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("drug_date not between", value1, value2, "drugDate");
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