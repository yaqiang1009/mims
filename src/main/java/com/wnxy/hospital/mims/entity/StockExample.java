package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andStockIdIsNull() {
            addCriterion("stock_id is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(String value) {
            addCriterion("stock_id =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(String value) {
            addCriterion("stock_id <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(String value) {
            addCriterion("stock_id >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_id >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(String value) {
            addCriterion("stock_id <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(String value) {
            addCriterion("stock_id <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLike(String value) {
            addCriterion("stock_id like", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotLike(String value) {
            addCriterion("stock_id not like", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<String> values) {
            addCriterion("stock_id in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<String> values) {
            addCriterion("stock_id not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(String value1, String value2) {
            addCriterion("stock_id between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(String value1, String value2) {
            addCriterion("stock_id not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNull() {
            addCriterion("medicine_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNotNull() {
            addCriterion("medicine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdEqualTo(String value) {
            addCriterion("medicine_id =", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotEqualTo(String value) {
            addCriterion("medicine_id <>", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThan(String value) {
            addCriterion("medicine_id >", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_id >=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThan(String value) {
            addCriterion("medicine_id <", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThanOrEqualTo(String value) {
            addCriterion("medicine_id <=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLike(String value) {
            addCriterion("medicine_id like", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotLike(String value) {
            addCriterion("medicine_id not like", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIn(List<String> values) {
            addCriterion("medicine_id in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotIn(List<String> values) {
            addCriterion("medicine_id not in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdBetween(String value1, String value2) {
            addCriterion("medicine_id between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotBetween(String value1, String value2) {
            addCriterion("medicine_id not between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiIsNull() {
            addCriterion("medicine_danwei is null");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiIsNotNull() {
            addCriterion("medicine_danwei is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiEqualTo(String value) {
            addCriterion("medicine_danwei =", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiNotEqualTo(String value) {
            addCriterion("medicine_danwei <>", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiGreaterThan(String value) {
            addCriterion("medicine_danwei >", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_danwei >=", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiLessThan(String value) {
            addCriterion("medicine_danwei <", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiLessThanOrEqualTo(String value) {
            addCriterion("medicine_danwei <=", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiLike(String value) {
            addCriterion("medicine_danwei like", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiNotLike(String value) {
            addCriterion("medicine_danwei not like", value, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiIn(List<String> values) {
            addCriterion("medicine_danwei in", values, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiNotIn(List<String> values) {
            addCriterion("medicine_danwei not in", values, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiBetween(String value1, String value2) {
            addCriterion("medicine_danwei between", value1, value2, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineDanweiNotBetween(String value1, String value2) {
            addCriterion("medicine_danwei not between", value1, value2, "medicineDanwei");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIsNull() {
            addCriterion("medicine_num is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIsNotNull() {
            addCriterion("medicine_num is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNumEqualTo(Integer value) {
            addCriterion("medicine_num =", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotEqualTo(Integer value) {
            addCriterion("medicine_num <>", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumGreaterThan(Integer value) {
            addCriterion("medicine_num >", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_num >=", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumLessThan(Integer value) {
            addCriterion("medicine_num <", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_num <=", value, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumIn(List<Integer> values) {
            addCriterion("medicine_num in", values, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotIn(List<Integer> values) {
            addCriterion("medicine_num not in", values, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumBetween(Integer value1, Integer value2) {
            addCriterion("medicine_num between", value1, value2, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineNumNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_num not between", value1, value2, "medicineNum");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeIsNull() {
            addCriterion("medicine_type is null");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeIsNotNull() {
            addCriterion("medicine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeEqualTo(String value) {
            addCriterion("medicine_type =", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotEqualTo(String value) {
            addCriterion("medicine_type <>", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeGreaterThan(String value) {
            addCriterion("medicine_type >", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_type >=", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLessThan(String value) {
            addCriterion("medicine_type <", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLessThanOrEqualTo(String value) {
            addCriterion("medicine_type <=", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeLike(String value) {
            addCriterion("medicine_type like", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotLike(String value) {
            addCriterion("medicine_type not like", value, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeIn(List<String> values) {
            addCriterion("medicine_type in", values, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotIn(List<String> values) {
            addCriterion("medicine_type not in", values, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeBetween(String value1, String value2) {
            addCriterion("medicine_type between", value1, value2, "medicineType");
            return (Criteria) this;
        }

        public Criteria andMedicineTypeNotBetween(String value1, String value2) {
            addCriterion("medicine_type not between", value1, value2, "medicineType");
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