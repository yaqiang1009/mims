package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IpRemedyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpRemedyExample() {
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

        public Criteria andHospitalizedIdIsNull() {
            addCriterion("hospitalized_id is null");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdIsNotNull() {
            addCriterion("hospitalized_id is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdEqualTo(String value) {
            addCriterion("hospitalized_id =", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdNotEqualTo(String value) {
            addCriterion("hospitalized_id <>", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdGreaterThan(String value) {
            addCriterion("hospitalized_id >", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdGreaterThanOrEqualTo(String value) {
            addCriterion("hospitalized_id >=", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdLessThan(String value) {
            addCriterion("hospitalized_id <", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdLessThanOrEqualTo(String value) {
            addCriterion("hospitalized_id <=", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdLike(String value) {
            addCriterion("hospitalized_id like", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdNotLike(String value) {
            addCriterion("hospitalized_id not like", value, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdIn(List<String> values) {
            addCriterion("hospitalized_id in", values, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdNotIn(List<String> values) {
            addCriterion("hospitalized_id not in", values, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdBetween(String value1, String value2) {
            addCriterion("hospitalized_id between", value1, value2, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andHospitalizedIdNotBetween(String value1, String value2) {
            addCriterion("hospitalized_id not between", value1, value2, "hospitalizedId");
            return (Criteria) this;
        }

        public Criteria andWardIdIsNull() {
            addCriterion("ward_id is null");
            return (Criteria) this;
        }

        public Criteria andWardIdIsNotNull() {
            addCriterion("ward_id is not null");
            return (Criteria) this;
        }

        public Criteria andWardIdEqualTo(String value) {
            addCriterion("ward_id =", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotEqualTo(String value) {
            addCriterion("ward_id <>", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdGreaterThan(String value) {
            addCriterion("ward_id >", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdGreaterThanOrEqualTo(String value) {
            addCriterion("ward_id >=", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdLessThan(String value) {
            addCriterion("ward_id <", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdLessThanOrEqualTo(String value) {
            addCriterion("ward_id <=", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdLike(String value) {
            addCriterion("ward_id like", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotLike(String value) {
            addCriterion("ward_id not like", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdIn(List<String> values) {
            addCriterion("ward_id in", values, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotIn(List<String> values) {
            addCriterion("ward_id not in", values, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdBetween(String value1, String value2) {
            addCriterion("ward_id between", value1, value2, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotBetween(String value1, String value2) {
            addCriterion("ward_id not between", value1, value2, "wardId");
            return (Criteria) this;
        }

        public Criteria andBedIdIsNull() {
            addCriterion("bed_id is null");
            return (Criteria) this;
        }

        public Criteria andBedIdIsNotNull() {
            addCriterion("bed_id is not null");
            return (Criteria) this;
        }

        public Criteria andBedIdEqualTo(String value) {
            addCriterion("bed_id =", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotEqualTo(String value) {
            addCriterion("bed_id <>", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdGreaterThan(String value) {
            addCriterion("bed_id >", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdGreaterThanOrEqualTo(String value) {
            addCriterion("bed_id >=", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLessThan(String value) {
            addCriterion("bed_id <", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLessThanOrEqualTo(String value) {
            addCriterion("bed_id <=", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdLike(String value) {
            addCriterion("bed_id like", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotLike(String value) {
            addCriterion("bed_id not like", value, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdIn(List<String> values) {
            addCriterion("bed_id in", values, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotIn(List<String> values) {
            addCriterion("bed_id not in", values, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdBetween(String value1, String value2) {
            addCriterion("bed_id between", value1, value2, "bedId");
            return (Criteria) this;
        }

        public Criteria andBedIdNotBetween(String value1, String value2) {
            addCriterion("bed_id not between", value1, value2, "bedId");
            return (Criteria) this;
        }

        public Criteria andPtIdIsNull() {
            addCriterion("pt_id is null");
            return (Criteria) this;
        }

        public Criteria andPtIdIsNotNull() {
            addCriterion("pt_id is not null");
            return (Criteria) this;
        }

        public Criteria andPtIdEqualTo(String value) {
            addCriterion("pt_id =", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotEqualTo(String value) {
            addCriterion("pt_id <>", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThan(String value) {
            addCriterion("pt_id >", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThanOrEqualTo(String value) {
            addCriterion("pt_id >=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThan(String value) {
            addCriterion("pt_id <", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThanOrEqualTo(String value) {
            addCriterion("pt_id <=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLike(String value) {
            addCriterion("pt_id like", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotLike(String value) {
            addCriterion("pt_id not like", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdIn(List<String> values) {
            addCriterion("pt_id in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotIn(List<String> values) {
            addCriterion("pt_id not in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdBetween(String value1, String value2) {
            addCriterion("pt_id between", value1, value2, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotBetween(String value1, String value2) {
            addCriterion("pt_id not between", value1, value2, "ptId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(String value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(String value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(String value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(String value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(String value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLike(String value) {
            addCriterion("emp_id like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotLike(String value) {
            addCriterion("emp_id not like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<String> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<String> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(String value1, String value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(String value1, String value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andRemedyDateIsNull() {
            addCriterion("remedy_date is null");
            return (Criteria) this;
        }

        public Criteria andRemedyDateIsNotNull() {
            addCriterion("remedy_date is not null");
            return (Criteria) this;
        }

        public Criteria andRemedyDateEqualTo(Date value) {
            addCriterionForJDBCDate("remedy_date =", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("remedy_date <>", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("remedy_date >", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("remedy_date >=", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateLessThan(Date value) {
            addCriterionForJDBCDate("remedy_date <", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("remedy_date <=", value, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateIn(List<Date> values) {
            addCriterionForJDBCDate("remedy_date in", values, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("remedy_date not in", values, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("remedy_date between", value1, value2, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("remedy_date not between", value1, value2, "remedyDate");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusIsNull() {
            addCriterion("remedy_status is null");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusIsNotNull() {
            addCriterion("remedy_status is not null");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusEqualTo(String value) {
            addCriterion("remedy_status =", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusNotEqualTo(String value) {
            addCriterion("remedy_status <>", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusGreaterThan(String value) {
            addCriterion("remedy_status >", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("remedy_status >=", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusLessThan(String value) {
            addCriterion("remedy_status <", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusLessThanOrEqualTo(String value) {
            addCriterion("remedy_status <=", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusLike(String value) {
            addCriterion("remedy_status like", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusNotLike(String value) {
            addCriterion("remedy_status not like", value, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusIn(List<String> values) {
            addCriterion("remedy_status in", values, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusNotIn(List<String> values) {
            addCriterion("remedy_status not in", values, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusBetween(String value1, String value2) {
            addCriterion("remedy_status between", value1, value2, "remedyStatus");
            return (Criteria) this;
        }

        public Criteria andRemedyStatusNotBetween(String value1, String value2) {
            addCriterion("remedy_status not between", value1, value2, "remedyStatus");
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