package com.wnxy.hospital.mims.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.wnxy.hospital.mims.entity.AuthorityExample.Criteria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpExample() {
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

        public Criteria andOfficeIdIsNull() {
            addCriterion("office_id is null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIsNotNull() {
            addCriterion("office_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdEqualTo(String value) {
            addCriterion("office_id =", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotEqualTo(String value) {
            addCriterion("office_id <>", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThan(String value) {
            addCriterion("office_id >", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThanOrEqualTo(String value) {
            addCriterion("office_id >=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThan(String value) {
            addCriterion("office_id <", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThanOrEqualTo(String value) {
            addCriterion("office_id <=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLike(String value) {
            addCriterion("office_id like", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotLike(String value) {
            addCriterion("office_id not like", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIn(List<String> values) {
            addCriterion("office_id in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotIn(List<String> values) {
            addCriterion("office_id not in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdBetween(String value1, String value2) {
            addCriterion("office_id between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotBetween(String value1, String value2) {
            addCriterion("office_id not between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNull() {
            addCriterion("dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(String value) {
            addCriterion("dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(String value) {
            addCriterion("dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(String value) {
            addCriterion("dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(String value) {
            addCriterion("dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(String value) {
            addCriterion("dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(String value) {
            addCriterion("dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLike(String value) {
            addCriterion("dep_id like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotLike(String value) {
            addCriterion("dep_id not like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<String> values) {
            addCriterion("dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<String> values) {
            addCriterion("dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(String value1, String value2) {
            addCriterion("dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(String value1, String value2) {
            addCriterion("dep_id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityIsNull() {
            addCriterion("emp_identity is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityIsNotNull() {
            addCriterion("emp_identity is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityEqualTo(String value) {
            addCriterion("emp_identity =", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityNotEqualTo(String value) {
            addCriterion("emp_identity <>", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityGreaterThan(String value) {
            addCriterion("emp_identity >", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("emp_identity >=", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityLessThan(String value) {
            addCriterion("emp_identity <", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityLessThanOrEqualTo(String value) {
            addCriterion("emp_identity <=", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityLike(String value) {
            addCriterion("emp_identity like", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityNotLike(String value) {
            addCriterion("emp_identity not like", value, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityIn(List<String> values) {
            addCriterion("emp_identity in", values, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityNotIn(List<String> values) {
            addCriterion("emp_identity not in", values, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityBetween(String value1, String value2) {
            addCriterion("emp_identity between", value1, value2, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpIdentityNotBetween(String value1, String value2) {
            addCriterion("emp_identity not between", value1, value2, "empIdentity");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSexEqualTo(String value) {
            addCriterion("emp_sex =", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotEqualTo(String value) {
            addCriterion("emp_sex <>", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThan(String value) {
            addCriterion("emp_sex >", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sex >=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThan(String value) {
            addCriterion("emp_sex <", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThanOrEqualTo(String value) {
            addCriterion("emp_sex <=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLike(String value) {
            addCriterion("emp_sex like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotLike(String value) {
            addCriterion("emp_sex not like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexIn(List<String> values) {
            addCriterion("emp_sex in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotIn(List<String> values) {
            addCriterion("emp_sex not in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexBetween(String value1, String value2) {
            addCriterion("emp_sex between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotBetween(String value1, String value2) {
            addCriterion("emp_sex not between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNull() {
            addCriterion("emp_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNotNull() {
            addCriterion("emp_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressEqualTo(String value) {
            addCriterion("emp_address =", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotEqualTo(String value) {
            addCriterion("emp_address <>", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThan(String value) {
            addCriterion("emp_address >", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_address >=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThan(String value) {
            addCriterion("emp_address <", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_address <=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLike(String value) {
            addCriterion("emp_address like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotLike(String value) {
            addCriterion("emp_address not like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIn(List<String> values) {
            addCriterion("emp_address in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotIn(List<String> values) {
            addCriterion("emp_address not in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressBetween(String value1, String value2) {
            addCriterion("emp_address between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotBetween(String value1, String value2) {
            addCriterion("emp_address not between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNull() {
            addCriterion("emp_email is null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNotNull() {
            addCriterion("emp_email is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailEqualTo(String value) {
            addCriterion("emp_email =", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotEqualTo(String value) {
            addCriterion("emp_email <>", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThan(String value) {
            addCriterion("emp_email >", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_email >=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThan(String value) {
            addCriterion("emp_email <", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThanOrEqualTo(String value) {
            addCriterion("emp_email <=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLike(String value) {
            addCriterion("emp_email like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotLike(String value) {
            addCriterion("emp_email not like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIn(List<String> values) {
            addCriterion("emp_email in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotIn(List<String> values) {
            addCriterion("emp_email not in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailBetween(String value1, String value2) {
            addCriterion("emp_email between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotBetween(String value1, String value2) {
            addCriterion("emp_email not between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpBirthIsNull() {
            addCriterion("emp_birth is null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthIsNotNull() {
            addCriterion("emp_birth is not null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birth =", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birth <>", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("emp_birth >", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birth >=", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthLessThan(Date value) {
            addCriterionForJDBCDate("emp_birth <", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birth <=", value, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthIn(List<Date> values) {
            addCriterionForJDBCDate("emp_birth in", values, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("emp_birth not in", values, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_birth between", value1, value2, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_birth not between", value1, value2, "empBirth");
            return (Criteria) this;
        }

        public Criteria andEmpNationIsNull() {
            addCriterion("emp_nation is null");
            return (Criteria) this;
        }

        public Criteria andEmpNationIsNotNull() {
            addCriterion("emp_nation is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNationEqualTo(String value) {
            addCriterion("emp_nation =", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationNotEqualTo(String value) {
            addCriterion("emp_nation <>", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationGreaterThan(String value) {
            addCriterion("emp_nation >", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationGreaterThanOrEqualTo(String value) {
            addCriterion("emp_nation >=", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationLessThan(String value) {
            addCriterion("emp_nation <", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationLessThanOrEqualTo(String value) {
            addCriterion("emp_nation <=", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationLike(String value) {
            addCriterion("emp_nation like", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationNotLike(String value) {
            addCriterion("emp_nation not like", value, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationIn(List<String> values) {
            addCriterion("emp_nation in", values, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationNotIn(List<String> values) {
            addCriterion("emp_nation not in", values, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationBetween(String value1, String value2) {
            addCriterion("emp_nation between", value1, value2, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpNationNotBetween(String value1, String value2) {
            addCriterion("emp_nation not between", value1, value2, "empNation");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayIsNull() {
            addCriterion("emp_hireday is null");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayIsNotNull() {
            addCriterion("emp_hireday is not null");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayEqualTo(Date value) {
            addCriterionForJDBCDate("emp_hireday =", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayNotEqualTo(Date value) {
            addCriterionForJDBCDate("emp_hireday <>", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayGreaterThan(Date value) {
            addCriterionForJDBCDate("emp_hireday >", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_hireday >=", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayLessThan(Date value) {
            addCriterionForJDBCDate("emp_hireday <", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_hireday <=", value, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayIn(List<Date> values) {
            addCriterionForJDBCDate("emp_hireday in", values, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayNotIn(List<Date> values) {
            addCriterionForJDBCDate("emp_hireday not in", values, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_hireday between", value1, value2, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpHiredayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_hireday not between", value1, value2, "empHireday");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoIsNull() {
            addCriterion("emp_photo is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoIsNotNull() {
            addCriterion("emp_photo is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoEqualTo(String value) {
            addCriterion("emp_photo =", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoNotEqualTo(String value) {
            addCriterion("emp_photo <>", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoGreaterThan(String value) {
            addCriterion("emp_photo >", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("emp_photo >=", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoLessThan(String value) {
            addCriterion("emp_photo <", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoLessThanOrEqualTo(String value) {
            addCriterion("emp_photo <=", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoLike(String value) {
            addCriterion("emp_photo like", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoNotLike(String value) {
            addCriterion("emp_photo not like", value, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoIn(List<String> values) {
            addCriterion("emp_photo in", values, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoNotIn(List<String> values) {
            addCriterion("emp_photo not in", values, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoBetween(String value1, String value2) {
            addCriterion("emp_photo between", value1, value2, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoNotBetween(String value1, String value2) {
            addCriterion("emp_photo not between", value1, value2, "empPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("emp_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("emp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("emp_phone =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("emp_phone <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("emp_phone >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_phone >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("emp_phone <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_phone <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("emp_phone like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("emp_phone not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("emp_phone in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("emp_phone not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("emp_phone between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("emp_phone not between", value1, value2, "empPhone");
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