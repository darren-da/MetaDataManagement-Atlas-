package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterInformationApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public FilterInformationApiExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFilterVisitIsNull() {
            addCriterion("FILTER_VISIT is null");
            return (Criteria) this;
        }

        public Criteria andFilterVisitIsNotNull() {
            addCriterion("FILTER_VISIT is not null");
            return (Criteria) this;
        }

        public Criteria andFilterVisitEqualTo(String value) {
            addCriterion("FILTER_VISIT =", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitNotEqualTo(String value) {
            addCriterion("FILTER_VISIT <>", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitGreaterThan(String value) {
            addCriterion("FILTER_VISIT >", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitGreaterThanOrEqualTo(String value) {
            addCriterion("FILTER_VISIT >=", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitLessThan(String value) {
            addCriterion("FILTER_VISIT <", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitLessThanOrEqualTo(String value) {
            addCriterion("FILTER_VISIT <=", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitLike(String value) {
            addCriterion("FILTER_VISIT like", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitNotLike(String value) {
            addCriterion("FILTER_VISIT not like", value, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitIn(List<String> values) {
            addCriterion("FILTER_VISIT in", values, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitNotIn(List<String> values) {
            addCriterion("FILTER_VISIT not in", values, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitBetween(String value1, String value2) {
            addCriterion("FILTER_VISIT between", value1, value2, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterVisitNotBetween(String value1, String value2) {
            addCriterion("FILTER_VISIT not between", value1, value2, "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterNameIsNull() {
            addCriterion("FILTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFilterNameIsNotNull() {
            addCriterion("FILTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFilterNameEqualTo(String value) {
            addCriterion("FILTER_NAME =", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameNotEqualTo(String value) {
            addCriterion("FILTER_NAME <>", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameGreaterThan(String value) {
            addCriterion("FILTER_NAME >", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILTER_NAME >=", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameLessThan(String value) {
            addCriterion("FILTER_NAME <", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameLessThanOrEqualTo(String value) {
            addCriterion("FILTER_NAME <=", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameLike(String value) {
            addCriterion("FILTER_NAME like", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameNotLike(String value) {
            addCriterion("FILTER_NAME not like", value, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameIn(List<String> values) {
            addCriterion("FILTER_NAME in", values, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameNotIn(List<String> values) {
            addCriterion("FILTER_NAME not in", values, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameBetween(String value1, String value2) {
            addCriterion("FILTER_NAME between", value1, value2, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterNameNotBetween(String value1, String value2) {
            addCriterion("FILTER_NAME not between", value1, value2, "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterDescIsNull() {
            addCriterion("FILTER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFilterDescIsNotNull() {
            addCriterion("FILTER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFilterDescEqualTo(String value) {
            addCriterion("FILTER_DESC =", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescNotEqualTo(String value) {
            addCriterion("FILTER_DESC <>", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescGreaterThan(String value) {
            addCriterion("FILTER_DESC >", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescGreaterThanOrEqualTo(String value) {
            addCriterion("FILTER_DESC >=", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescLessThan(String value) {
            addCriterion("FILTER_DESC <", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescLessThanOrEqualTo(String value) {
            addCriterion("FILTER_DESC <=", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescLike(String value) {
            addCriterion("FILTER_DESC like", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescNotLike(String value) {
            addCriterion("FILTER_DESC not like", value, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescIn(List<String> values) {
            addCriterion("FILTER_DESC in", values, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescNotIn(List<String> values) {
            addCriterion("FILTER_DESC not in", values, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescBetween(String value1, String value2) {
            addCriterion("FILTER_DESC between", value1, value2, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterDescNotBetween(String value1, String value2) {
            addCriterion("FILTER_DESC not between", value1, value2, "filterDesc");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNull() {
            addCriterion("FILTER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNotNull() {
            addCriterion("FILTER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeEqualTo(Integer value) {
            addCriterion("FILTER_TYPE =", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotEqualTo(Integer value) {
            addCriterion("FILTER_TYPE <>", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThan(Integer value) {
            addCriterion("FILTER_TYPE >", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILTER_TYPE >=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThan(Integer value) {
            addCriterion("FILTER_TYPE <", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThanOrEqualTo(Integer value) {
            addCriterion("FILTER_TYPE <=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIn(List<Integer> values) {
            addCriterion("FILTER_TYPE in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotIn(List<Integer> values) {
            addCriterion("FILTER_TYPE not in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeBetween(Integer value1, Integer value2) {
            addCriterion("FILTER_TYPE between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FILTER_TYPE not between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andListTypeIsNull() {
            addCriterion("LIST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andListTypeIsNotNull() {
            addCriterion("LIST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andListTypeEqualTo(Integer value) {
            addCriterion("LIST_TYPE =", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotEqualTo(Integer value) {
            addCriterion("LIST_TYPE <>", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThan(Integer value) {
            addCriterion("LIST_TYPE >", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIST_TYPE >=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThan(Integer value) {
            addCriterion("LIST_TYPE <", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LIST_TYPE <=", value, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeIn(List<Integer> values) {
            addCriterion("LIST_TYPE in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotIn(List<Integer> values) {
            addCriterion("LIST_TYPE not in", values, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeBetween(Integer value1, Integer value2) {
            addCriterion("LIST_TYPE between", value1, value2, "listType");
            return (Criteria) this;
        }

        public Criteria andListTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LIST_TYPE not between", value1, value2, "listType");
            return (Criteria) this;
        }

        public Criteria andAccountVisitIsNull() {
            addCriterion("ACCOUNT_VISIT is null");
            return (Criteria) this;
        }

        public Criteria andAccountVisitIsNotNull() {
            addCriterion("ACCOUNT_VISIT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountVisitEqualTo(String value) {
            addCriterion("ACCOUNT_VISIT =", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitNotEqualTo(String value) {
            addCriterion("ACCOUNT_VISIT <>", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitGreaterThan(String value) {
            addCriterion("ACCOUNT_VISIT >", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_VISIT >=", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitLessThan(String value) {
            addCriterion("ACCOUNT_VISIT <", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_VISIT <=", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitLike(String value) {
            addCriterion("ACCOUNT_VISIT like", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitNotLike(String value) {
            addCriterion("ACCOUNT_VISIT not like", value, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitIn(List<String> values) {
            addCriterion("ACCOUNT_VISIT in", values, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitNotIn(List<String> values) {
            addCriterion("ACCOUNT_VISIT not in", values, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitBetween(String value1, String value2) {
            addCriterion("ACCOUNT_VISIT between", value1, value2, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andAccountVisitNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_VISIT not between", value1, value2, "accountVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitIsNull() {
            addCriterion("DEPTNAME_VISIT is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitIsNotNull() {
            addCriterion("DEPTNAME_VISIT is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitEqualTo(String value) {
            addCriterion("DEPTNAME_VISIT =", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitNotEqualTo(String value) {
            addCriterion("DEPTNAME_VISIT <>", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitGreaterThan(String value) {
            addCriterion("DEPTNAME_VISIT >", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitGreaterThanOrEqualTo(String value) {
            addCriterion("DEPTNAME_VISIT >=", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitLessThan(String value) {
            addCriterion("DEPTNAME_VISIT <", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitLessThanOrEqualTo(String value) {
            addCriterion("DEPTNAME_VISIT <=", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitLike(String value) {
            addCriterion("DEPTNAME_VISIT like", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitNotLike(String value) {
            addCriterion("DEPTNAME_VISIT not like", value, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitIn(List<String> values) {
            addCriterion("DEPTNAME_VISIT in", values, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitNotIn(List<String> values) {
            addCriterion("DEPTNAME_VISIT not in", values, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitBetween(String value1, String value2) {
            addCriterion("DEPTNAME_VISIT between", value1, value2, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitNotBetween(String value1, String value2) {
            addCriterion("DEPTNAME_VISIT not between", value1, value2, "deptnameVisit");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Byte value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Byte value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Byte value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Byte value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Byte> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Byte> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Byte value1, Byte value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(USER_ID) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andFilterVisitLikeInsensitive(String value) {
            addCriterion("upper(FILTER_VISIT) like", value.toUpperCase(), "filterVisit");
            return (Criteria) this;
        }

        public Criteria andFilterNameLikeInsensitive(String value) {
            addCriterion("upper(FILTER_NAME) like", value.toUpperCase(), "filterName");
            return (Criteria) this;
        }

        public Criteria andFilterDescLikeInsensitive(String value) {
            addCriterion("upper(FILTER_DESC) like", value.toUpperCase(), "filterDesc");
            return (Criteria) this;
        }

        public Criteria andAccountVisitLikeInsensitive(String value) {
            addCriterion("upper(ACCOUNT_VISIT) like", value.toUpperCase(), "accountVisit");
            return (Criteria) this;
        }

        public Criteria andDeptnameVisitLikeInsensitive(String value) {
            addCriterion("upper(DEPTNAME_VISIT) like", value.toUpperCase(), "deptnameVisit");
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