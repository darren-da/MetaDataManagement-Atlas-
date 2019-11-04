package com.limp.framework.boss.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.List;

public class ServicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public ServicesExample() {
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

        public Criteria andServiceNameIsNull() {
            addCriterion("SERVICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("SERVICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("SERVICE_NAME =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("SERVICE_NAME <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("SERVICE_NAME >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("SERVICE_NAME <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("SERVICE_NAME like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("SERVICE_NAME not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("SERVICE_NAME in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("SERVICE_NAME not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceKeyIsNull() {
            addCriterion("SERVICE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andServiceKeyIsNotNull() {
            addCriterion("SERVICE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceKeyEqualTo(String value) {
            addCriterion("SERVICE_KEY =", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyNotEqualTo(String value) {
            addCriterion("SERVICE_KEY <>", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyGreaterThan(String value) {
            addCriterion("SERVICE_KEY >", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_KEY >=", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyLessThan(String value) {
            addCriterion("SERVICE_KEY <", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_KEY <=", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyLike(String value) {
            addCriterion("SERVICE_KEY like", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyNotLike(String value) {
            addCriterion("SERVICE_KEY not like", value, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyIn(List<String> values) {
            addCriterion("SERVICE_KEY in", values, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyNotIn(List<String> values) {
            addCriterion("SERVICE_KEY not in", values, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyBetween(String value1, String value2) {
            addCriterion("SERVICE_KEY between", value1, value2, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServiceKeyNotBetween(String value1, String value2) {
            addCriterion("SERVICE_KEY not between", value1, value2, "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServicePackageIsNull() {
            addCriterion("SERVICE_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andServicePackageIsNotNull() {
            addCriterion("SERVICE_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andServicePackageEqualTo(String value) {
            addCriterion("SERVICE_PACKAGE =", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageNotEqualTo(String value) {
            addCriterion("SERVICE_PACKAGE <>", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageGreaterThan(String value) {
            addCriterion("SERVICE_PACKAGE >", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_PACKAGE >=", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageLessThan(String value) {
            addCriterion("SERVICE_PACKAGE <", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_PACKAGE <=", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageLike(String value) {
            addCriterion("SERVICE_PACKAGE like", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageNotLike(String value) {
            addCriterion("SERVICE_PACKAGE not like", value, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageIn(List<String> values) {
            addCriterion("SERVICE_PACKAGE in", values, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageNotIn(List<String> values) {
            addCriterion("SERVICE_PACKAGE not in", values, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageBetween(String value1, String value2) {
            addCriterion("SERVICE_PACKAGE between", value1, value2, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServicePackageNotBetween(String value1, String value2) {
            addCriterion("SERVICE_PACKAGE not between", value1, value2, "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServiceMethodIsNull() {
            addCriterion("SERVICE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andServiceMethodIsNotNull() {
            addCriterion("SERVICE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andServiceMethodEqualTo(String value) {
            addCriterion("SERVICE_METHOD =", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodNotEqualTo(String value) {
            addCriterion("SERVICE_METHOD <>", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodGreaterThan(String value) {
            addCriterion("SERVICE_METHOD >", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_METHOD >=", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodLessThan(String value) {
            addCriterion("SERVICE_METHOD <", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_METHOD <=", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodLike(String value) {
            addCriterion("SERVICE_METHOD like", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodNotLike(String value) {
            addCriterion("SERVICE_METHOD not like", value, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodIn(List<String> values) {
            addCriterion("SERVICE_METHOD in", values, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodNotIn(List<String> values) {
            addCriterion("SERVICE_METHOD not in", values, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodBetween(String value1, String value2) {
            addCriterion("SERVICE_METHOD between", value1, value2, "serviceMethod");
            return (Criteria) this;
        }

        public Criteria andServiceMethodNotBetween(String value1, String value2) {
            addCriterion("SERVICE_METHOD not between", value1, value2, "serviceMethod");
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

        public Criteria andRc3EqualTo(String value) {
            addCriterion("RC3 =", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotEqualTo(String value) {
            addCriterion("RC3 <>", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThan(String value) {
            addCriterion("RC3 >", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThanOrEqualTo(String value) {
            addCriterion("RC3 >=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThan(String value) {
            addCriterion("RC3 <", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThanOrEqualTo(String value) {
            addCriterion("RC3 <=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3Like(String value) {
            addCriterion("RC3 like", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotLike(String value) {
            addCriterion("RC3 not like", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3In(List<String> values) {
            addCriterion("RC3 in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotIn(List<String> values) {
            addCriterion("RC3 not in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3Between(String value1, String value2) {
            addCriterion("RC3 between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotBetween(String value1, String value2) {
            addCriterion("RC3 not between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andServiceNameLikeInsensitive(String value) {
            addCriterion("upper(SERVICE_NAME) like", value.toUpperCase(), "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceKeyLikeInsensitive(String value) {
            addCriterion("upper(SERVICE_KEY) like", value.toUpperCase(), "serviceKey");
            return (Criteria) this;
        }

        public Criteria andServicePackageLikeInsensitive(String value) {
            addCriterion("upper(SERVICE_PACKAGE) like", value.toUpperCase(), "servicePackage");
            return (Criteria) this;
        }

        public Criteria andServiceMethodLikeInsensitive(String value) {
            addCriterion("upper(SERVICE_METHOD) like", value.toUpperCase(), "serviceMethod");
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

        public Criteria andRc3LikeInsensitive(String value) {
            addCriterion("upper(RC3) like", value.toUpperCase(), "rc3");
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