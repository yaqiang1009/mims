package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.List;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpRoleExample() {
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

        public Criteria andErIdIsNull() {
            addCriterion("er_id is null");
            return (Criteria) this;
        }

        public Criteria andErIdIsNotNull() {
            addCriterion("er_id is not null");
            return (Criteria) this;
        }

        public Criteria andErIdEqualTo(String value) {
            addCriterion("er_id =", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdNotEqualTo(String value) {
            addCriterion("er_id <>", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdGreaterThan(String value) {
            addCriterion("er_id >", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdGreaterThanOrEqualTo(String value) {
            addCriterion("er_id >=", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdLessThan(String value) {
            addCriterion("er_id <", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdLessThanOrEqualTo(String value) {
            addCriterion("er_id <=", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdLike(String value) {
            addCriterion("er_id like", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdNotLike(String value) {
            addCriterion("er_id not like", value, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdIn(List<String> values) {
            addCriterion("er_id in", values, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdNotIn(List<String> values) {
            addCriterion("er_id not in", values, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdBetween(String value1, String value2) {
            addCriterion("er_id between", value1, value2, "erId");
            return (Criteria) this;
        }

        public Criteria andErIdNotBetween(String value1, String value2) {
            addCriterion("er_id not between", value1, value2, "erId");
            return (Criteria) this;
        }

        public Criteria andRolIdIsNull() {
            addCriterion("rol_id is null");
            return (Criteria) this;
        }

        public Criteria andRolIdIsNotNull() {
            addCriterion("rol_id is not null");
            return (Criteria) this;
        }

        public Criteria andRolIdEqualTo(String value) {
            addCriterion("rol_id =", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotEqualTo(String value) {
            addCriterion("rol_id <>", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdGreaterThan(String value) {
            addCriterion("rol_id >", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdGreaterThanOrEqualTo(String value) {
            addCriterion("rol_id >=", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdLessThan(String value) {
            addCriterion("rol_id <", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdLessThanOrEqualTo(String value) {
            addCriterion("rol_id <=", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdLike(String value) {
            addCriterion("rol_id like", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotLike(String value) {
            addCriterion("rol_id not like", value, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdIn(List<String> values) {
            addCriterion("rol_id in", values, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotIn(List<String> values) {
            addCriterion("rol_id not in", values, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdBetween(String value1, String value2) {
            addCriterion("rol_id between", value1, value2, "rolId");
            return (Criteria) this;
        }

        public Criteria andRolIdNotBetween(String value1, String value2) {
            addCriterion("rol_id not between", value1, value2, "rolId");
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