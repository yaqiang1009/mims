package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.List;

public class DamagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DamagesExample() {
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

        public Criteria andDamageIdIsNull() {
            addCriterion("damage_id is null");
            return (Criteria) this;
        }

        public Criteria andDamageIdIsNotNull() {
            addCriterion("damage_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamageIdEqualTo(String value) {
            addCriterion("damage_id =", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdNotEqualTo(String value) {
            addCriterion("damage_id <>", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdGreaterThan(String value) {
            addCriterion("damage_id >", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdGreaterThanOrEqualTo(String value) {
            addCriterion("damage_id >=", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdLessThan(String value) {
            addCriterion("damage_id <", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdLessThanOrEqualTo(String value) {
            addCriterion("damage_id <=", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdLike(String value) {
            addCriterion("damage_id like", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdNotLike(String value) {
            addCriterion("damage_id not like", value, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdIn(List<String> values) {
            addCriterion("damage_id in", values, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdNotIn(List<String> values) {
            addCriterion("damage_id not in", values, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdBetween(String value1, String value2) {
            addCriterion("damage_id between", value1, value2, "damageId");
            return (Criteria) this;
        }

        public Criteria andDamageIdNotBetween(String value1, String value2) {
            addCriterion("damage_id not between", value1, value2, "damageId");
            return (Criteria) this;
        }

        public Criteria andMedicineCountIsNull() {
            addCriterion("medicine_count is null");
            return (Criteria) this;
        }

        public Criteria andMedicineCountIsNotNull() {
            addCriterion("medicine_count is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineCountEqualTo(Integer value) {
            addCriterion("medicine_count =", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountNotEqualTo(Integer value) {
            addCriterion("medicine_count <>", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountGreaterThan(Integer value) {
            addCriterion("medicine_count >", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_count >=", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountLessThan(Integer value) {
            addCriterion("medicine_count <", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_count <=", value, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountIn(List<Integer> values) {
            addCriterion("medicine_count in", values, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountNotIn(List<Integer> values) {
            addCriterion("medicine_count not in", values, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountBetween(Integer value1, Integer value2) {
            addCriterion("medicine_count between", value1, value2, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andMedicineCountNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_count not between", value1, value2, "medicineCount");
            return (Criteria) this;
        }

        public Criteria andDamageReasonIsNull() {
            addCriterion("damage_reason is null");
            return (Criteria) this;
        }

        public Criteria andDamageReasonIsNotNull() {
            addCriterion("damage_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDamageReasonEqualTo(String value) {
            addCriterion("damage_reason =", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonNotEqualTo(String value) {
            addCriterion("damage_reason <>", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonGreaterThan(String value) {
            addCriterion("damage_reason >", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonGreaterThanOrEqualTo(String value) {
            addCriterion("damage_reason >=", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonLessThan(String value) {
            addCriterion("damage_reason <", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonLessThanOrEqualTo(String value) {
            addCriterion("damage_reason <=", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonLike(String value) {
            addCriterion("damage_reason like", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonNotLike(String value) {
            addCriterion("damage_reason not like", value, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonIn(List<String> values) {
            addCriterion("damage_reason in", values, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonNotIn(List<String> values) {
            addCriterion("damage_reason not in", values, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonBetween(String value1, String value2) {
            addCriterion("damage_reason between", value1, value2, "damageReason");
            return (Criteria) this;
        }

        public Criteria andDamageReasonNotBetween(String value1, String value2) {
            addCriterion("damage_reason not between", value1, value2, "damageReason");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNull() {
            addCriterion("medicine_name is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNotNull() {
            addCriterion("medicine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameEqualTo(String value) {
            addCriterion("medicine_name =", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotEqualTo(String value) {
            addCriterion("medicine_name <>", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThan(String value) {
            addCriterion("medicine_name >", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_name >=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThan(String value) {
            addCriterion("medicine_name <", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThanOrEqualTo(String value) {
            addCriterion("medicine_name <=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLike(String value) {
            addCriterion("medicine_name like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotLike(String value) {
            addCriterion("medicine_name not like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIn(List<String> values) {
            addCriterion("medicine_name in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotIn(List<String> values) {
            addCriterion("medicine_name not in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameBetween(String value1, String value2) {
            addCriterion("medicine_name between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotBetween(String value1, String value2) {
            addCriterion("medicine_name not between", value1, value2, "medicineName");
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