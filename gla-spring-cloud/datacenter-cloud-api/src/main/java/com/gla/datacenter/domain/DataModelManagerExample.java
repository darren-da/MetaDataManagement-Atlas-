package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataModelManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public DataModelManagerExample() {
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

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("MODEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("MODEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("MODEL_CODE =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("MODEL_CODE <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("MODEL_CODE >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_CODE >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("MODEL_CODE <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("MODEL_CODE <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("MODEL_CODE like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("MODEL_CODE not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("MODEL_CODE in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("MODEL_CODE not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("MODEL_CODE between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("MODEL_CODE not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdIsNull() {
            addCriterion("MODEL_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdIsNotNull() {
            addCriterion("MODEL_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdEqualTo(String value) {
            addCriterion("MODEL_TYPE_ID =", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdNotEqualTo(String value) {
            addCriterion("MODEL_TYPE_ID <>", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdGreaterThan(String value) {
            addCriterion("MODEL_TYPE_ID >", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_TYPE_ID >=", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdLessThan(String value) {
            addCriterion("MODEL_TYPE_ID <", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdLessThanOrEqualTo(String value) {
            addCriterion("MODEL_TYPE_ID <=", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdLike(String value) {
            addCriterion("MODEL_TYPE_ID like", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdNotLike(String value) {
            addCriterion("MODEL_TYPE_ID not like", value, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdIn(List<String> values) {
            addCriterion("MODEL_TYPE_ID in", values, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdNotIn(List<String> values) {
            addCriterion("MODEL_TYPE_ID not in", values, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdBetween(String value1, String value2) {
            addCriterion("MODEL_TYPE_ID between", value1, value2, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdNotBetween(String value1, String value2) {
            addCriterion("MODEL_TYPE_ID not between", value1, value2, "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelDescribeIsNull() {
            addCriterion("MODEL_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andModelDescribeIsNotNull() {
            addCriterion("MODEL_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andModelDescribeEqualTo(String value) {
            addCriterion("MODEL_DESCRIBE =", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeNotEqualTo(String value) {
            addCriterion("MODEL_DESCRIBE <>", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeGreaterThan(String value) {
            addCriterion("MODEL_DESCRIBE >", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_DESCRIBE >=", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeLessThan(String value) {
            addCriterion("MODEL_DESCRIBE <", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeLessThanOrEqualTo(String value) {
            addCriterion("MODEL_DESCRIBE <=", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeLike(String value) {
            addCriterion("MODEL_DESCRIBE like", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andAlltill(String value1){
            addCriterion("( MODEL_NAME like '%" + value1 + "%' OR MODEL_CODE =  '" + value1 + "' OR MODEL_DESCRIBE LIKE '%" + value1 + "%') AND 1=", "1", "apiName");
            return (Criteria) this;
        }

        public Criteria andModelDescribeNotLike(String value) {
            addCriterion("MODEL_DESCRIBE not like", value, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeIn(List<String> values) {
            addCriterion("MODEL_DESCRIBE in", values, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeNotIn(List<String> values) {
            addCriterion("MODEL_DESCRIBE not in", values, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeBetween(String value1, String value2) {
            addCriterion("MODEL_DESCRIBE between", value1, value2, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelDescribeNotBetween(String value1, String value2) {
            addCriterion("MODEL_DESCRIBE not between", value1, value2, "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleIsNull() {
            addCriterion("MODEL_UPDATE_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleIsNotNull() {
            addCriterion("MODEL_UPDATE_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleEqualTo(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE =", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleNotEqualTo(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE <>", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleGreaterThan(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE >", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE >=", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleLessThan(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE <", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_UPDATE_CYCLE <=", value, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleIn(List<Integer> values) {
            addCriterion("MODEL_UPDATE_CYCLE in", values, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleNotIn(List<Integer> values) {
            addCriterion("MODEL_UPDATE_CYCLE not in", values, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_UPDATE_CYCLE between", value1, value2, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUpdateCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_UPDATE_CYCLE not between", value1, value2, "modelUpdateCycle");
            return (Criteria) this;
        }

        public Criteria andModelUnitsIsNull() {
            addCriterion("MODEL_UNITS is null");
            return (Criteria) this;
        }

        public Criteria andModelUnitsIsNotNull() {
            addCriterion("MODEL_UNITS is not null");
            return (Criteria) this;
        }

        public Criteria andModelUnitsEqualTo(String value) {
            addCriterion("MODEL_UNITS =", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsNotEqualTo(String value) {
            addCriterion("MODEL_UNITS <>", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsGreaterThan(String value) {
            addCriterion("MODEL_UNITS >", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_UNITS >=", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsLessThan(String value) {
            addCriterion("MODEL_UNITS <", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsLessThanOrEqualTo(String value) {
            addCriterion("MODEL_UNITS <=", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsLike(String value) {
            addCriterion("MODEL_UNITS like", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsNotLike(String value) {
            addCriterion("MODEL_UNITS not like", value, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsIn(List<String> values) {
            addCriterion("MODEL_UNITS in", values, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsNotIn(List<String> values) {
            addCriterion("MODEL_UNITS not in", values, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsBetween(String value1, String value2) {
            addCriterion("MODEL_UNITS between", value1, value2, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andModelUnitsNotBetween(String value1, String value2) {
            addCriterion("MODEL_UNITS not between", value1, value2, "modelUnits");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPublicFlagIsNull() {
            addCriterion("PUBLIC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPublicFlagIsNotNull() {
            addCriterion("PUBLIC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPublicFlagEqualTo(Integer value) {
            addCriterion("PUBLIC_FLAG =", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagNotEqualTo(Integer value) {
            addCriterion("PUBLIC_FLAG <>", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagGreaterThan(Integer value) {
            addCriterion("PUBLIC_FLAG >", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLIC_FLAG >=", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagLessThan(Integer value) {
            addCriterion("PUBLIC_FLAG <", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLIC_FLAG <=", value, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagIn(List<Integer> values) {
            addCriterion("PUBLIC_FLAG in", values, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagNotIn(List<Integer> values) {
            addCriterion("PUBLIC_FLAG not in", values, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagBetween(Integer value1, Integer value2) {
            addCriterion("PUBLIC_FLAG between", value1, value2, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andPublicFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLIC_FLAG not between", value1, value2, "publicFlag");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andModelNameLikeInsensitive(String value) {
            addCriterion("upper(MODEL_NAME) like", value.toUpperCase(), "modelName");
            return (Criteria) this;
        }

        public Criteria andModelCodeLikeInsensitive(String value) {
            addCriterion("upper(MODEL_CODE) like", value.toUpperCase(), "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelTypeIdLikeInsensitive(String value) {
            addCriterion("upper(MODEL_TYPE_ID) like", value.toUpperCase(), "modelTypeId");
            return (Criteria) this;
        }

        public Criteria andModelDescribeLikeInsensitive(String value) {
            addCriterion("upper(MODEL_DESCRIBE) like", value.toUpperCase(), "modelDescribe");
            return (Criteria) this;
        }

        public Criteria andModelUnitsLikeInsensitive(String value) {
            addCriterion("upper(MODEL_UNITS) like", value.toUpperCase(), "modelUnits");
            return (Criteria) this;
        }

        public Criteria andVersionLikeInsensitive(String value) {
            addCriterion("upper(VERSION) like", value.toUpperCase(), "version");
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