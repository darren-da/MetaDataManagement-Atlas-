package com.limp.framework.boss.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.List;

public class ServicesParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public ServicesParamsExample() {
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

        public Criteria andServiceidIsNull() {
            addCriterion("SERVICEID is null");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNotNull() {
            addCriterion("SERVICEID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceidEqualTo(String value) {
            addCriterion("SERVICEID =", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotEqualTo(String value) {
            addCriterion("SERVICEID <>", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThan(String value) {
            addCriterion("SERVICEID >", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICEID >=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThan(String value) {
            addCriterion("SERVICEID <", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThanOrEqualTo(String value) {
            addCriterion("SERVICEID <=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLike(String value) {
            addCriterion("SERVICEID like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotLike(String value) {
            addCriterion("SERVICEID not like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIn(List<String> values) {
            addCriterion("SERVICEID in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotIn(List<String> values) {
            addCriterion("SERVICEID not in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidBetween(String value1, String value2) {
            addCriterion("SERVICEID between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotBetween(String value1, String value2) {
            addCriterion("SERVICEID not between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("PARAM_NAME =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("PARAM_NAME <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("PARAM_NAME >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("PARAM_NAME <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("PARAM_NAME like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("PARAM_NAME not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("PARAM_NAME in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("PARAM_NAME not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("PARAM_NAME between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("PARAM_NAME not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamSortIsNull() {
            addCriterion("PARAM_SORT is null");
            return (Criteria) this;
        }

        public Criteria andParamSortIsNotNull() {
            addCriterion("PARAM_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andParamSortEqualTo(Short value) {
            addCriterion("PARAM_SORT =", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotEqualTo(Short value) {
            addCriterion("PARAM_SORT <>", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortGreaterThan(Short value) {
            addCriterion("PARAM_SORT >", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortGreaterThanOrEqualTo(Short value) {
            addCriterion("PARAM_SORT >=", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortLessThan(Short value) {
            addCriterion("PARAM_SORT <", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortLessThanOrEqualTo(Short value) {
            addCriterion("PARAM_SORT <=", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortIn(List<Short> values) {
            addCriterion("PARAM_SORT in", values, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotIn(List<Short> values) {
            addCriterion("PARAM_SORT not in", values, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortBetween(Short value1, Short value2) {
            addCriterion("PARAM_SORT between", value1, value2, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotBetween(Short value1, Short value2) {
            addCriterion("PARAM_SORT not between", value1, value2, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNull() {
            addCriterion("PARAM_KEY is null");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNotNull() {
            addCriterion("PARAM_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andParamKeyEqualTo(String value) {
            addCriterion("PARAM_KEY =", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotEqualTo(String value) {
            addCriterion("PARAM_KEY <>", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThan(String value) {
            addCriterion("PARAM_KEY >", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY >=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThan(String value) {
            addCriterion("PARAM_KEY <", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY <=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLike(String value) {
            addCriterion("PARAM_KEY like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotLike(String value) {
            addCriterion("PARAM_KEY not like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyIn(List<String> values) {
            addCriterion("PARAM_KEY in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotIn(List<String> values) {
            addCriterion("PARAM_KEY not in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyBetween(String value1, String value2) {
            addCriterion("PARAM_KEY between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotBetween(String value1, String value2) {
            addCriterion("PARAM_KEY not between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNull() {
            addCriterion("PARAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("PARAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(String value) {
            addCriterion("PARAM_TYPE =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(String value) {
            addCriterion("PARAM_TYPE <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(String value) {
            addCriterion("PARAM_TYPE >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(String value) {
            addCriterion("PARAM_TYPE <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLike(String value) {
            addCriterion("PARAM_TYPE like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotLike(String value) {
            addCriterion("PARAM_TYPE not like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<String> values) {
            addCriterion("PARAM_TYPE in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<String> values) {
            addCriterion("PARAM_TYPE not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamFormatterIsNull() {
            addCriterion("PARAM_FORMATTER is null");
            return (Criteria) this;
        }

        public Criteria andParamFormatterIsNotNull() {
            addCriterion("PARAM_FORMATTER is not null");
            return (Criteria) this;
        }

        public Criteria andParamFormatterEqualTo(String value) {
            addCriterion("PARAM_FORMATTER =", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterNotEqualTo(String value) {
            addCriterion("PARAM_FORMATTER <>", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterGreaterThan(String value) {
            addCriterion("PARAM_FORMATTER >", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_FORMATTER >=", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterLessThan(String value) {
            addCriterion("PARAM_FORMATTER <", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterLessThanOrEqualTo(String value) {
            addCriterion("PARAM_FORMATTER <=", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterLike(String value) {
            addCriterion("PARAM_FORMATTER like", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterNotLike(String value) {
            addCriterion("PARAM_FORMATTER not like", value, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterIn(List<String> values) {
            addCriterion("PARAM_FORMATTER in", values, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterNotIn(List<String> values) {
            addCriterion("PARAM_FORMATTER not in", values, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterBetween(String value1, String value2) {
            addCriterion("PARAM_FORMATTER between", value1, value2, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamFormatterNotBetween(String value1, String value2) {
            addCriterion("PARAM_FORMATTER not between", value1, value2, "paramFormatter");
            return (Criteria) this;
        }

        public Criteria andParamStateIsNull() {
            addCriterion("PARAM_STATE is null");
            return (Criteria) this;
        }

        public Criteria andParamStateIsNotNull() {
            addCriterion("PARAM_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andParamStateEqualTo(Short value) {
            addCriterion("PARAM_STATE =", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateNotEqualTo(Short value) {
            addCriterion("PARAM_STATE <>", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateGreaterThan(Short value) {
            addCriterion("PARAM_STATE >", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateGreaterThanOrEqualTo(Short value) {
            addCriterion("PARAM_STATE >=", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateLessThan(Short value) {
            addCriterion("PARAM_STATE <", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateLessThanOrEqualTo(Short value) {
            addCriterion("PARAM_STATE <=", value, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateIn(List<Short> values) {
            addCriterion("PARAM_STATE in", values, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateNotIn(List<Short> values) {
            addCriterion("PARAM_STATE not in", values, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateBetween(Short value1, Short value2) {
            addCriterion("PARAM_STATE between", value1, value2, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamStateNotBetween(Short value1, Short value2) {
            addCriterion("PARAM_STATE not between", value1, value2, "paramState");
            return (Criteria) this;
        }

        public Criteria andParamMustIsNull() {
            addCriterion("PARAM_MUST is null");
            return (Criteria) this;
        }

        public Criteria andParamMustIsNotNull() {
            addCriterion("PARAM_MUST is not null");
            return (Criteria) this;
        }

        public Criteria andParamMustEqualTo(Short value) {
            addCriterion("PARAM_MUST =", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustNotEqualTo(Short value) {
            addCriterion("PARAM_MUST <>", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustGreaterThan(Short value) {
            addCriterion("PARAM_MUST >", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustGreaterThanOrEqualTo(Short value) {
            addCriterion("PARAM_MUST >=", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustLessThan(Short value) {
            addCriterion("PARAM_MUST <", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustLessThanOrEqualTo(Short value) {
            addCriterion("PARAM_MUST <=", value, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustIn(List<Short> values) {
            addCriterion("PARAM_MUST in", values, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustNotIn(List<Short> values) {
            addCriterion("PARAM_MUST not in", values, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustBetween(Short value1, Short value2) {
            addCriterion("PARAM_MUST between", value1, value2, "paramMust");
            return (Criteria) this;
        }

        public Criteria andParamMustNotBetween(Short value1, Short value2) {
            addCriterion("PARAM_MUST not between", value1, value2, "paramMust");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andServiceidLikeInsensitive(String value) {
            addCriterion("upper(SERVICEID) like", value.toUpperCase(), "serviceid");
            return (Criteria) this;
        }

        public Criteria andParamNameLikeInsensitive(String value) {
            addCriterion("upper(PARAM_NAME) like", value.toUpperCase(), "paramName");
            return (Criteria) this;
        }

        public Criteria andParamKeyLikeInsensitive(String value) {
            addCriterion("upper(PARAM_KEY) like", value.toUpperCase(), "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamTypeLikeInsensitive(String value) {
            addCriterion("upper(PARAM_TYPE) like", value.toUpperCase(), "paramType");
            return (Criteria) this;
        }

        public Criteria andParamFormatterLikeInsensitive(String value) {
            addCriterion("upper(PARAM_FORMATTER) like", value.toUpperCase(), "paramFormatter");
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