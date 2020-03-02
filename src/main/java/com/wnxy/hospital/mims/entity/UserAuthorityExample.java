package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.List;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAuthorityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAuthorityExample() {
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

        public Criteria andUaIdIsNull() {
            addCriterion("ua_id is null");
            return (Criteria) this;
        }

        public Criteria andUaIdIsNotNull() {
            addCriterion("ua_id is not null");
            return (Criteria) this;
        }

        public Criteria andUaIdEqualTo(String value) {
            addCriterion("ua_id =", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotEqualTo(String value) {
            addCriterion("ua_id <>", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdGreaterThan(String value) {
            addCriterion("ua_id >", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdGreaterThanOrEqualTo(String value) {
            addCriterion("ua_id >=", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdLessThan(String value) {
            addCriterion("ua_id <", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdLessThanOrEqualTo(String value) {
            addCriterion("ua_id <=", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdLike(String value) {
            addCriterion("ua_id like", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotLike(String value) {
            addCriterion("ua_id not like", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdIn(List<String> values) {
            addCriterion("ua_id in", values, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotIn(List<String> values) {
            addCriterion("ua_id not in", values, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdBetween(String value1, String value2) {
            addCriterion("ua_id between", value1, value2, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotBetween(String value1, String value2) {
            addCriterion("ua_id not between", value1, value2, "uaId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIsNull() {
            addCriterion("authority_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIsNotNull() {
            addCriterion("authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdEqualTo(String value) {
            addCriterion("authority_id =", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotEqualTo(String value) {
            addCriterion("authority_id <>", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThan(String value) {
            addCriterion("authority_id >", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThanOrEqualTo(String value) {
            addCriterion("authority_id >=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThan(String value) {
            addCriterion("authority_id <", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThanOrEqualTo(String value) {
            addCriterion("authority_id <=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLike(String value) {
            addCriterion("authority_id like", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotLike(String value) {
            addCriterion("authority_id not like", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIn(List<String> values) {
            addCriterion("authority_id in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotIn(List<String> values) {
            addCriterion("authority_id not in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdBetween(String value1, String value2) {
            addCriterion("authority_id between", value1, value2, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotBetween(String value1, String value2) {
            addCriterion("authority_id not between", value1, value2, "authorityId");
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