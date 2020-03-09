package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PhMedicineInventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhMedicineInventoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(String value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(String value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(String value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(String value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(String value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLike(String value) {
            addCriterion("class_id like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotLike(String value) {
            addCriterion("class_id not like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<String> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<String> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(String value1, String value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(String value1, String value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andCalssNameIsNull() {
            addCriterion("calss_name is null");
            return (Criteria) this;
        }

        public Criteria andCalssNameIsNotNull() {
            addCriterion("calss_name is not null");
            return (Criteria) this;
        }

        public Criteria andCalssNameEqualTo(String value) {
            addCriterion("calss_name =", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameNotEqualTo(String value) {
            addCriterion("calss_name <>", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameGreaterThan(String value) {
            addCriterion("calss_name >", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameGreaterThanOrEqualTo(String value) {
            addCriterion("calss_name >=", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameLessThan(String value) {
            addCriterion("calss_name <", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameLessThanOrEqualTo(String value) {
            addCriterion("calss_name <=", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameLike(String value) {
            addCriterion("calss_name like", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameNotLike(String value) {
            addCriterion("calss_name not like", value, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameIn(List<String> values) {
            addCriterion("calss_name in", values, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameNotIn(List<String> values) {
            addCriterion("calss_name not in", values, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameBetween(String value1, String value2) {
            addCriterion("calss_name between", value1, value2, "calssName");
            return (Criteria) this;
        }

        public Criteria andCalssNameNotBetween(String value1, String value2) {
            addCriterion("calss_name not between", value1, value2, "calssName");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andWarnValueIsNull() {
            addCriterion("warn_value is null");
            return (Criteria) this;
        }

        public Criteria andWarnValueIsNotNull() {
            addCriterion("warn_value is not null");
            return (Criteria) this;
        }

        public Criteria andWarnValueEqualTo(Integer value) {
            addCriterion("warn_value =", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueNotEqualTo(Integer value) {
            addCriterion("warn_value <>", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueGreaterThan(Integer value) {
            addCriterion("warn_value >", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("warn_value >=", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueLessThan(Integer value) {
            addCriterion("warn_value <", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueLessThanOrEqualTo(Integer value) {
            addCriterion("warn_value <=", value, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueIn(List<Integer> values) {
            addCriterion("warn_value in", values, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueNotIn(List<Integer> values) {
            addCriterion("warn_value not in", values, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueBetween(Integer value1, Integer value2) {
            addCriterion("warn_value between", value1, value2, "warnValue");
            return (Criteria) this;
        }

        public Criteria andWarnValueNotBetween(Integer value1, Integer value2) {
            addCriterion("warn_value not between", value1, value2, "warnValue");
            return (Criteria) this;
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

        public Criteria andDamageCountIsNull() {
            addCriterion("damage_count is null");
            return (Criteria) this;
        }

        public Criteria andDamageCountIsNotNull() {
            addCriterion("damage_count is not null");
            return (Criteria) this;
        }

        public Criteria andDamageCountEqualTo(Integer value) {
            addCriterion("damage_count =", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountNotEqualTo(Integer value) {
            addCriterion("damage_count <>", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountGreaterThan(Integer value) {
            addCriterion("damage_count >", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("damage_count >=", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountLessThan(Integer value) {
            addCriterion("damage_count <", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountLessThanOrEqualTo(Integer value) {
            addCriterion("damage_count <=", value, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountIn(List<Integer> values) {
            addCriterion("damage_count in", values, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountNotIn(List<Integer> values) {
            addCriterion("damage_count not in", values, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountBetween(Integer value1, Integer value2) {
            addCriterion("damage_count between", value1, value2, "damageCount");
            return (Criteria) this;
        }

        public Criteria andDamageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("damage_count not between", value1, value2, "damageCount");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNull() {
            addCriterion("produce_date is null");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNotNull() {
            addCriterion("produce_date is not null");
            return (Criteria) this;
        }

        public Criteria andProduceDateEqualTo(Date value) {
            addCriterionForJDBCDate("produce_date =", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("produce_date <>", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("produce_date >", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("produce_date >=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThan(Date value) {
            addCriterionForJDBCDate("produce_date <", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("produce_date <=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateIn(List<Date> values) {
            addCriterionForJDBCDate("produce_date in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("produce_date not in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("produce_date between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("produce_date not between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNull() {
            addCriterion("enter_date is null");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNotNull() {
            addCriterion("enter_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnterDateEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date =", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date <>", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("enter_date >", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date >=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThan(Date value) {
            addCriterionForJDBCDate("enter_date <", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date <=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateIn(List<Date> values) {
            addCriterionForJDBCDate("enter_date in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enter_date not in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enter_date between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enter_date not between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateIsNull() {
            addCriterion("disable_date is null");
            return (Criteria) this;
        }

        public Criteria andDisableDateIsNotNull() {
            addCriterion("disable_date is not null");
            return (Criteria) this;
        }

        public Criteria andDisableDateEqualTo(Date value) {
            addCriterionForJDBCDate("disable_date =", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("disable_date <>", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateGreaterThan(Date value) {
            addCriterionForJDBCDate("disable_date >", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disable_date >=", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateLessThan(Date value) {
            addCriterionForJDBCDate("disable_date <", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("disable_date <=", value, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateIn(List<Date> values) {
            addCriterionForJDBCDate("disable_date in", values, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("disable_date not in", values, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disable_date between", value1, value2, "disableDate");
            return (Criteria) this;
        }

        public Criteria andDisableDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("disable_date not between", value1, value2, "disableDate");
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