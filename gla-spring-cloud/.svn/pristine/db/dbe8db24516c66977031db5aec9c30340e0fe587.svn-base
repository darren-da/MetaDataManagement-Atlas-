package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParmsApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public ParmsApiExample() {
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

    public void setPage(Pager page) {
        this.page=page;
    }

    public Pager getPage() {
        return page;
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNull() {
            addCriterion("API_ID is null");
            return (Criteria) this;
        }

        public Criteria andApiIdIsNotNull() {
            addCriterion("API_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApiIdEqualTo(String value) {
            addCriterion("API_ID =", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotEqualTo(String value) {
            addCriterion("API_ID <>", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThan(String value) {
            addCriterion("API_ID >", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdGreaterThanOrEqualTo(String value) {
            addCriterion("API_ID >=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThan(String value) {
            addCriterion("API_ID <", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLessThanOrEqualTo(String value) {
            addCriterion("API_ID <=", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdLike(String value) {
            addCriterion("API_ID like", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotLike(String value) {
            addCriterion("API_ID not like", value, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdIn(List<String> values) {
            addCriterion("API_ID in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotIn(List<String> values) {
            addCriterion("API_ID not in", values, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdBetween(String value1, String value2) {
            addCriterion("API_ID between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andApiIdNotBetween(String value1, String value2) {
            addCriterion("API_ID not between", value1, value2, "apiId");
            return (Criteria) this;
        }

        public Criteria andRealParmsIsNull() {
            addCriterion("REAL_PARMS is null");
            return (Criteria) this;
        }

        public Criteria andRealParmsIsNotNull() {
            addCriterion("REAL_PARMS is not null");
            return (Criteria) this;
        }

        public Criteria andRealParmsEqualTo(String value) {
            addCriterion("REAL_PARMS =", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsNotEqualTo(String value) {
            addCriterion("REAL_PARMS <>", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsGreaterThan(String value) {
            addCriterion("REAL_PARMS >", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_PARMS >=", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsLessThan(String value) {
            addCriterion("REAL_PARMS <", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsLessThanOrEqualTo(String value) {
            addCriterion("REAL_PARMS <=", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsLike(String value) {
            addCriterion("REAL_PARMS like", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsNotLike(String value) {
            addCriterion("REAL_PARMS not like", value, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsIn(List<String> values) {
            addCriterion("REAL_PARMS in", values, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsNotIn(List<String> values) {
            addCriterion("REAL_PARMS not in", values, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsBetween(String value1, String value2) {
            addCriterion("REAL_PARMS between", value1, value2, "realParms");
            return (Criteria) this;
        }

        public Criteria andRealParmsNotBetween(String value1, String value2) {
            addCriterion("REAL_PARMS not between", value1, value2, "realParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsIsNull() {
            addCriterion("SHAM_PARMS is null");
            return (Criteria) this;
        }

        public Criteria andShamParmsIsNotNull() {
            addCriterion("SHAM_PARMS is not null");
            return (Criteria) this;
        }

        public Criteria andShamParmsEqualTo(String value) {
            addCriterion("SHAM_PARMS =", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsNotEqualTo(String value) {
            addCriterion("SHAM_PARMS <>", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsGreaterThan(String value) {
            addCriterion("SHAM_PARMS >", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsGreaterThanOrEqualTo(String value) {
            addCriterion("SHAM_PARMS >=", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsLessThan(String value) {
            addCriterion("SHAM_PARMS <", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsLessThanOrEqualTo(String value) {
            addCriterion("SHAM_PARMS <=", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsLike(String value) {
            addCriterion("SHAM_PARMS like", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsNotLike(String value) {
            addCriterion("SHAM_PARMS not like", value, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsIn(List<String> values) {
            addCriterion("SHAM_PARMS in", values, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsNotIn(List<String> values) {
            addCriterion("SHAM_PARMS not in", values, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsBetween(String value1, String value2) {
            addCriterion("SHAM_PARMS between", value1, value2, "shamParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsNotBetween(String value1, String value2) {
            addCriterion("SHAM_PARMS not between", value1, value2, "shamParms");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("DEFAULT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("DEFAULT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("DEFAULT_VALUE =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("DEFAULT_VALUE >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("DEFAULT_VALUE <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("DEFAULT_VALUE like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("DEFAULT_VALUE not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("DEFAULT_VALUE in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("DEFAULT_VALUE not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDesriptionIsNull() {
            addCriterion("DESRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDesriptionIsNotNull() {
            addCriterion("DESRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDesriptionEqualTo(String value) {
            addCriterion("DESRIPTION =", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionNotEqualTo(String value) {
            addCriterion("DESRIPTION <>", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionGreaterThan(String value) {
            addCriterion("DESRIPTION >", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESRIPTION >=", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionLessThan(String value) {
            addCriterion("DESRIPTION <", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionLessThanOrEqualTo(String value) {
            addCriterion("DESRIPTION <=", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionLike(String value) {
            addCriterion("DESRIPTION like", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionNotLike(String value) {
            addCriterion("DESRIPTION not like", value, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionIn(List<String> values) {
            addCriterion("DESRIPTION in", values, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionNotIn(List<String> values) {
            addCriterion("DESRIPTION not in", values, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionBetween(String value1, String value2) {
            addCriterion("DESRIPTION between", value1, value2, "desription");
            return (Criteria) this;
        }

        public Criteria andDesriptionNotBetween(String value1, String value2) {
            addCriterion("DESRIPTION not between", value1, value2, "desription");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Integer value) {
            addCriterion("LENGTH =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Integer value) {
            addCriterion("LENGTH <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Integer value) {
            addCriterion("LENGTH >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("LENGTH >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Integer value) {
            addCriterion("LENGTH <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Integer value) {
            addCriterion("LENGTH <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Integer> values) {
            addCriterion("LENGTH in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Integer> values) {
            addCriterion("LENGTH not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("REQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("REQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(Byte value) {
            addCriterion("REQUIRED =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(Byte value) {
            addCriterion("REQUIRED <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(Byte value) {
            addCriterion("REQUIRED >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("REQUIRED >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(Byte value) {
            addCriterion("REQUIRED <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(Byte value) {
            addCriterion("REQUIRED <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<Byte> values) {
            addCriterion("REQUIRED in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<Byte> values) {
            addCriterion("REQUIRED not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(Byte value1, Byte value2) {
            addCriterion("REQUIRED between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(Byte value1, Byte value2) {
            addCriterion("REQUIRED not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andIsHeaderIsNull() {
            addCriterion("IS_HEADER is null");
            return (Criteria) this;
        }

        public Criteria andIsHeaderIsNotNull() {
            addCriterion("IS_HEADER is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeaderEqualTo(Byte value) {
            addCriterion("IS_HEADER =", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderNotEqualTo(Byte value) {
            addCriterion("IS_HEADER <>", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderGreaterThan(Byte value) {
            addCriterion("IS_HEADER >", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_HEADER >=", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderLessThan(Byte value) {
            addCriterion("IS_HEADER <", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderLessThanOrEqualTo(Byte value) {
            addCriterion("IS_HEADER <=", value, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderIn(List<Byte> values) {
            addCriterion("IS_HEADER in", values, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderNotIn(List<Byte> values) {
            addCriterion("IS_HEADER not in", values, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderBetween(Byte value1, Byte value2) {
            addCriterion("IS_HEADER between", value1, value2, "isHeader");
            return (Criteria) this;
        }

        public Criteria andIsHeaderNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_HEADER not between", value1, value2, "isHeader");
            return (Criteria) this;
        }

        public Criteria andParmsNoIsNull() {
            addCriterion("PARMS_NO is null");
            return (Criteria) this;
        }

        public Criteria andParmsNoIsNotNull() {
            addCriterion("PARMS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andParmsNoEqualTo(Integer value) {
            addCriterion("PARMS_NO =", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoNotEqualTo(Integer value) {
            addCriterion("PARMS_NO <>", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoGreaterThan(Integer value) {
            addCriterion("PARMS_NO >", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARMS_NO >=", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoLessThan(Integer value) {
            addCriterion("PARMS_NO <", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoLessThanOrEqualTo(Integer value) {
            addCriterion("PARMS_NO <=", value, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoIn(List<Integer> values) {
            addCriterion("PARMS_NO in", values, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoNotIn(List<Integer> values) {
            addCriterion("PARMS_NO not in", values, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoBetween(Integer value1, Integer value2) {
            addCriterion("PARMS_NO between", value1, value2, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andParmsNoNotBetween(Integer value1, Integer value2) {
            addCriterion("PARMS_NO not between", value1, value2, "parmsNo");
            return (Criteria) this;
        }

        public Criteria andPwdTypeIsNull() {
            addCriterion("PWD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPwdTypeIsNotNull() {
            addCriterion("PWD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPwdTypeEqualTo(Byte value) {
            addCriterion("PWD_TYPE =", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeNotEqualTo(Byte value) {
            addCriterion("PWD_TYPE <>", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeGreaterThan(Byte value) {
            addCriterion("PWD_TYPE >", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("PWD_TYPE >=", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeLessThan(Byte value) {
            addCriterion("PWD_TYPE <", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeLessThanOrEqualTo(Byte value) {
            addCriterion("PWD_TYPE <=", value, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeIn(List<Byte> values) {
            addCriterion("PWD_TYPE in", values, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeNotIn(List<Byte> values) {
            addCriterion("PWD_TYPE not in", values, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeBetween(Byte value1, Byte value2) {
            addCriterion("PWD_TYPE between", value1, value2, "pwdType");
            return (Criteria) this;
        }

        public Criteria andPwdTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("PWD_TYPE not between", value1, value2, "pwdType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIdtIsNull() {
            addCriterion("IDT is null");
            return (Criteria) this;
        }

        public Criteria andIdtIsNotNull() {
            addCriterion("IDT is not null");
            return (Criteria) this;
        }

        public Criteria andIdtEqualTo(Date value) {
            addCriterion("IDT =", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotEqualTo(Date value) {
            addCriterion("IDT <>", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtGreaterThan(Date value) {
            addCriterion("IDT >", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtGreaterThanOrEqualTo(Date value) {
            addCriterion("IDT >=", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtLessThan(Date value) {
            addCriterion("IDT <", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtLessThanOrEqualTo(Date value) {
            addCriterion("IDT <=", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtIn(List<Date> values) {
            addCriterion("IDT in", values, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotIn(List<Date> values) {
            addCriterion("IDT not in", values, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtBetween(Date value1, Date value2) {
            addCriterion("IDT between", value1, value2, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotBetween(Date value1, Date value2) {
            addCriterion("IDT not between", value1, value2, "idt");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("CREATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("CREATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(String value) {
            addCriterion("CREATE_ID =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(String value) {
            addCriterion("CREATE_ID <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(String value) {
            addCriterion("CREATE_ID >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_ID >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(String value) {
            addCriterion("CREATE_ID <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_ID <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLike(String value) {
            addCriterion("CREATE_ID like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotLike(String value) {
            addCriterion("CREATE_ID not like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<String> values) {
            addCriterion("CREATE_ID in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<String> values) {
            addCriterion("CREATE_ID not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(String value1, String value2) {
            addCriterion("CREATE_ID between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_ID not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andUdtIsNull() {
            addCriterion("UDT is null");
            return (Criteria) this;
        }

        public Criteria andUdtIsNotNull() {
            addCriterion("UDT is not null");
            return (Criteria) this;
        }

        public Criteria andUdtEqualTo(Date value) {
            addCriterion("UDT =", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotEqualTo(Date value) {
            addCriterion("UDT <>", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThan(Date value) {
            addCriterion("UDT >", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("UDT >=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThan(Date value) {
            addCriterion("UDT <", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThanOrEqualTo(Date value) {
            addCriterion("UDT <=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtIn(List<Date> values) {
            addCriterion("UDT in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotIn(List<Date> values) {
            addCriterion("UDT not in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtBetween(Date value1, Date value2) {
            addCriterion("UDT between", value1, value2, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotBetween(Date value1, Date value2) {
            addCriterion("UDT not between", value1, value2, "udt");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("UPDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("UPDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(String value) {
            addCriterion("UPDATE_ID =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(String value) {
            addCriterion("UPDATE_ID <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(String value) {
            addCriterion("UPDATE_ID >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(String value) {
            addCriterion("UPDATE_ID <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLike(String value) {
            addCriterion("UPDATE_ID like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotLike(String value) {
            addCriterion("UPDATE_ID not like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<String> values) {
            addCriterion("UPDATE_ID in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<String> values) {
            addCriterion("UPDATE_ID not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(String value1, String value2) {
            addCriterion("UPDATE_ID between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_ID not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andRc1IsNull() {
            addCriterion("RC1 is null");
            return (Criteria) this;
        }

        public Criteria andRc1IsNotNull() {
            addCriterion("RC1 is not null");
            return (Criteria) this;
        }

        public Criteria andRc1EqualTo(String value) {
            addCriterion("RC1 =", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotEqualTo(String value) {
            addCriterion("RC1 <>", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1GreaterThan(String value) {
            addCriterion("RC1 >", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1GreaterThanOrEqualTo(String value) {
            addCriterion("RC1 >=", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1LessThan(String value) {
            addCriterion("RC1 <", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1LessThanOrEqualTo(String value) {
            addCriterion("RC1 <=", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1Like(String value) {
            addCriterion("RC1 like", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotLike(String value) {
            addCriterion("RC1 not like", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1In(List<String> values) {
            addCriterion("RC1 in", values, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotIn(List<String> values) {
            addCriterion("RC1 not in", values, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1Between(String value1, String value2) {
            addCriterion("RC1 between", value1, value2, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotBetween(String value1, String value2) {
            addCriterion("RC1 not between", value1, value2, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc2IsNull() {
            addCriterion("RC2 is null");
            return (Criteria) this;
        }

        public Criteria andRc2IsNotNull() {
            addCriterion("RC2 is not null");
            return (Criteria) this;
        }

        public Criteria andRc2EqualTo(String value) {
            addCriterion("RC2 =", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotEqualTo(String value) {
            addCriterion("RC2 <>", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2GreaterThan(String value) {
            addCriterion("RC2 >", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2GreaterThanOrEqualTo(String value) {
            addCriterion("RC2 >=", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2LessThan(String value) {
            addCriterion("RC2 <", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2LessThanOrEqualTo(String value) {
            addCriterion("RC2 <=", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2Like(String value) {
            addCriterion("RC2 like", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotLike(String value) {
            addCriterion("RC2 not like", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2In(List<String> values) {
            addCriterion("RC2 in", values, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotIn(List<String> values) {
            addCriterion("RC2 not in", values, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2Between(String value1, String value2) {
            addCriterion("RC2 between", value1, value2, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotBetween(String value1, String value2) {
            addCriterion("RC2 not between", value1, value2, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc3IsNull() {
            addCriterion("RC3 is null");
            return (Criteria) this;
        }

        public Criteria andRc3IsNotNull() {
            addCriterion("RC3 is not null");
            return (Criteria) this;
        }

        public Criteria andRc3EqualTo(Integer value) {
            addCriterion("RC3 =", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotEqualTo(Integer value) {
            addCriterion("RC3 <>", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThan(Integer value) {
            addCriterion("RC3 >", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThanOrEqualTo(Integer value) {
            addCriterion("RC3 >=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThan(Integer value) {
            addCriterion("RC3 <", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThanOrEqualTo(Integer value) {
            addCriterion("RC3 <=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3In(List<Integer> values) {
            addCriterion("RC3 in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotIn(List<Integer> values) {
            addCriterion("RC3 not in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3Between(Integer value1, Integer value2) {
            addCriterion("RC3 between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotBetween(Integer value1, Integer value2) {
            addCriterion("RC3 not between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc4IsNull() {
            addCriterion("RC4 is null");
            return (Criteria) this;
        }

        public Criteria andRc4IsNotNull() {
            addCriterion("RC4 is not null");
            return (Criteria) this;
        }

        public Criteria andRc4EqualTo(Date value) {
            addCriterion("RC4 =", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotEqualTo(Date value) {
            addCriterion("RC4 <>", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThan(Date value) {
            addCriterion("RC4 >", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThanOrEqualTo(Date value) {
            addCriterion("RC4 >=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThan(Date value) {
            addCriterion("RC4 <", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThanOrEqualTo(Date value) {
            addCriterion("RC4 <=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4In(List<Date> values) {
            addCriterion("RC4 in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotIn(List<Date> values) {
            addCriterion("RC4 not in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Between(Date value1, Date value2) {
            addCriterion("RC4 between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotBetween(Date value1, Date value2) {
            addCriterion("RC4 not between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andApiIdLikeInsensitive(String value) {
            addCriterion("upper(API_ID) like", value.toUpperCase(), "apiId");
            return (Criteria) this;
        }

        public Criteria andRealParmsLikeInsensitive(String value) {
            addCriterion("upper(REAL_PARMS) like", value.toUpperCase(), "realParms");
            return (Criteria) this;
        }

        public Criteria andShamParmsLikeInsensitive(String value) {
            addCriterion("upper(SHAM_PARMS) like", value.toUpperCase(), "shamParms");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLikeInsensitive(String value) {
            addCriterion("upper(DEFAULT_VALUE) like", value.toUpperCase(), "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDesriptionLikeInsensitive(String value) {
            addCriterion("upper(DESRIPTION) like", value.toUpperCase(), "desription");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andCreateIdLikeInsensitive(String value) {
            addCriterion("upper(CREATE_ID) like", value.toUpperCase(), "createId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLikeInsensitive(String value) {
            addCriterion("upper(UPDATE_ID) like", value.toUpperCase(), "updateId");
            return (Criteria) this;
        }

        public Criteria andRc1LikeInsensitive(String value) {
            addCriterion("upper(RC1) like", value.toUpperCase(), "rc1");
            return (Criteria) this;
        }

        public Criteria andRc2LikeInsensitive(String value) {
            addCriterion("upper(RC2) like", value.toUpperCase(), "rc2");
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