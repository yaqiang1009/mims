package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IpCashUseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpCashUseExample() {
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

        public Criteria andCashUseIdIsNull() {
            addCriterion("cash_use_id is null");
            return (Criteria) this;
        }

        public Criteria andCashUseIdIsNotNull() {
            addCriterion("cash_use_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashUseIdEqualTo(String value) {
            addCriterion("cash_use_id =", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdNotEqualTo(String value) {
            addCriterion("cash_use_id <>", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdGreaterThan(String value) {
            addCriterion("cash_use_id >", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdGreaterThanOrEqualTo(String value) {
            addCriterion("cash_use_id >=", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdLessThan(String value) {
            addCriterion("cash_use_id <", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdLessThanOrEqualTo(String value) {
            addCriterion("cash_use_id <=", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdLike(String value) {
            addCriterion("cash_use_id like", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdNotLike(String value) {
            addCriterion("cash_use_id not like", value, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdIn(List<String> values) {
            addCriterion("cash_use_id in", values, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdNotIn(List<String> values) {
            addCriterion("cash_use_id not in", values, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdBetween(String value1, String value2) {
            addCriterion("cash_use_id between", value1, value2, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashUseIdNotBetween(String value1, String value2) {
            addCriterion("cash_use_id not between", value1, value2, "cashUseId");
            return (Criteria) this;
        }

        public Criteria andCashIdIsNull() {
            addCriterion("cash_id is null");
            return (Criteria) this;
        }

        public Criteria andCashIdIsNotNull() {
            addCriterion("cash_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashIdEqualTo(String value) {
            addCriterion("cash_id =", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotEqualTo(String value) {
            addCriterion("cash_id <>", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdGreaterThan(String value) {
            addCriterion("cash_id >", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdGreaterThanOrEqualTo(String value) {
            addCriterion("cash_id >=", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdLessThan(String value) {
            addCriterion("cash_id <", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdLessThanOrEqualTo(String value) {
            addCriterion("cash_id <=", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdLike(String value) {
            addCriterion("cash_id like", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotLike(String value) {
            addCriterion("cash_id not like", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdIn(List<String> values) {
            addCriterion("cash_id in", values, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotIn(List<String> values) {
            addCriterion("cash_id not in", values, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdBetween(String value1, String value2) {
            addCriterion("cash_id between", value1, value2, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotBetween(String value1, String value2) {
            addCriterion("cash_id not between", value1, value2, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashUseDateIsNull() {
            addCriterion("cash_use_date is null");
            return (Criteria) this;
        }

        public Criteria andCashUseDateIsNotNull() {
            addCriterion("cash_use_date is not null");
            return (Criteria) this;
        }

        public Criteria andCashUseDateEqualTo(Date value) {
            addCriterionForJDBCDate("cash_use_date =", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("cash_use_date <>", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("cash_use_date >", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cash_use_date >=", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateLessThan(Date value) {
            addCriterionForJDBCDate("cash_use_date <", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cash_use_date <=", value, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateIn(List<Date> values) {
            addCriterionForJDBCDate("cash_use_date in", values, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("cash_use_date not in", values, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cash_use_date between", value1, value2, "cashUseDate");
            return (Criteria) this;
        }

        public Criteria andCashUseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cash_use_date not between", value1, value2, "cashUseDate");
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

        public Criteria andUseCashIsNull() {
            addCriterion("use_cash is null");
            return (Criteria) this;
        }

        public Criteria andUseCashIsNotNull() {
            addCriterion("use_cash is not null");
            return (Criteria) this;
        }

        public Criteria andUseCashEqualTo(Double value) {
            addCriterion("use_cash =", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashNotEqualTo(Double value) {
            addCriterion("use_cash <>", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashGreaterThan(Double value) {
            addCriterion("use_cash >", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashGreaterThanOrEqualTo(Double value) {
            addCriterion("use_cash >=", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashLessThan(Double value) {
            addCriterion("use_cash <", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashLessThanOrEqualTo(Double value) {
            addCriterion("use_cash <=", value, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashIn(List<Double> values) {
            addCriterion("use_cash in", values, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashNotIn(List<Double> values) {
            addCriterion("use_cash not in", values, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashBetween(Double value1, Double value2) {
            addCriterion("use_cash between", value1, value2, "useCash");
            return (Criteria) this;
        }

        public Criteria andUseCashNotBetween(Double value1, Double value2) {
            addCriterion("use_cash not between", value1, value2, "useCash");
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