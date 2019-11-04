package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;
import java.util.ArrayList;
import java.util.List;

public class UserRoleMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public UserRoleMapExample() {
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

        public Criteria andUrmUseridIsNull() {
            addCriterion("URM_USERID is null");
            return (Criteria) this;
        }

        public Criteria andUrmUseridIsNotNull() {
            addCriterion("URM_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUrmUseridEqualTo(String value) {
            addCriterion("URM_USERID =", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridNotEqualTo(String value) {
            addCriterion("URM_USERID <>", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridGreaterThan(String value) {
            addCriterion("URM_USERID >", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridGreaterThanOrEqualTo(String value) {
            addCriterion("URM_USERID >=", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridLessThan(String value) {
            addCriterion("URM_USERID <", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridLessThanOrEqualTo(String value) {
            addCriterion("URM_USERID <=", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridLike(String value) {
            addCriterion("URM_USERID like", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridNotLike(String value) {
            addCriterion("URM_USERID not like", value, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridIn(List<String> values) {
            addCriterion("URM_USERID in", values, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridNotIn(List<String> values) {
            addCriterion("URM_USERID not in", values, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridBetween(String value1, String value2) {
            addCriterion("URM_USERID between", value1, value2, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridNotBetween(String value1, String value2) {
            addCriterion("URM_USERID not between", value1, value2, "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidIsNull() {
            addCriterion("URM_ROLEID is null");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidIsNotNull() {
            addCriterion("URM_ROLEID is not null");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidEqualTo(String value) {
            addCriterion("URM_ROLEID =", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidNotEqualTo(String value) {
            addCriterion("URM_ROLEID <>", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidGreaterThan(String value) {
            addCriterion("URM_ROLEID >", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("URM_ROLEID >=", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidLessThan(String value) {
            addCriterion("URM_ROLEID <", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidLessThanOrEqualTo(String value) {
            addCriterion("URM_ROLEID <=", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidLike(String value) {
            addCriterion("URM_ROLEID like", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidNotLike(String value) {
            addCriterion("URM_ROLEID not like", value, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidIn(List<String> values) {
            addCriterion("URM_ROLEID in", values, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidNotIn(List<String> values) {
            addCriterion("URM_ROLEID not in", values, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidBetween(String value1, String value2) {
            addCriterion("URM_ROLEID between", value1, value2, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidNotBetween(String value1, String value2) {
            addCriterion("URM_ROLEID not between", value1, value2, "urmRoleid");
            return (Criteria) this;
        }

        public Criteria andUrmUseridLikeInsensitive(String value) {
            addCriterion("upper(URM_USERID) like", value.toUpperCase(), "urmUserid");
            return (Criteria) this;
        }

        public Criteria andUrmRoleidLikeInsensitive(String value) {
            addCriterion("upper(URM_ROLEID) like", value.toUpperCase(), "urmRoleid");
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