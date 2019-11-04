package com.limp.framework.boss.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public MenuExample() {
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
            addCriterion("MEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("MEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("MEN_ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("MEN_ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("MEN_ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("MEN_ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("MEN_ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("MEN_ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("MEN_ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("MEN_ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("MEN_ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("MEN_ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("MEN_ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSsmguidIsNull() {
            addCriterion("MEN_SSMGUID is null");
            return (Criteria) this;
        }

        public Criteria andSsmguidIsNotNull() {
            addCriterion("MEN_SSMGUID is not null");
            return (Criteria) this;
        }

        public Criteria andSsmguidEqualTo(String value) {
            addCriterion("MEN_SSMGUID =", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidNotEqualTo(String value) {
            addCriterion("MEN_SSMGUID <>", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidGreaterThan(String value) {
            addCriterion("MEN_SSMGUID >", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_SSMGUID >=", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidLessThan(String value) {
            addCriterion("MEN_SSMGUID <", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidLessThanOrEqualTo(String value) {
            addCriterion("MEN_SSMGUID <=", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidLike(String value) {
            addCriterion("MEN_SSMGUID like", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidNotLike(String value) {
            addCriterion("MEN_SSMGUID not like", value, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidIn(List<String> values) {
            addCriterion("MEN_SSMGUID in", values, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidNotIn(List<String> values) {
            addCriterion("MEN_SSMGUID not in", values, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidBetween(String value1, String value2) {
            addCriterion("MEN_SSMGUID between", value1, value2, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andSsmguidNotBetween(String value1, String value2) {
            addCriterion("MEN_SSMGUID not between", value1, value2, "ssmguid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("MEN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("MEN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("MEN_NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("MEN_NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("MEN_NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("MEN_NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("MEN_NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("MEN_NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("MEN_NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("MEN_NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("MEN_NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("MEN_NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("MEN_NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("MEN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("MEN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("MEN_DESC =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("MEN_DESC <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("MEN_DESC >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_DESC >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("MEN_DESC <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("MEN_DESC <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("MEN_DESC like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("MEN_DESC not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("MEN_DESC in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("MEN_DESC not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("MEN_DESC between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("MEN_DESC not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("MEN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("MEN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("MEN_TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("MEN_TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("MEN_TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("MEN_TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("MEN_TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("MEN_TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("MEN_TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("MEN_TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("MEN_TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("MEN_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("MEN_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("MEN_PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("MEN_PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("MEN_PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("MEN_PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("MEN_PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("MEN_PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("MEN_PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("MEN_PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("MEN_PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("MEN_PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("MEN_PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("MEN_URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("MEN_URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("MEN_URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("MEN_URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("MEN_URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("MEN_URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("MEN_URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("MEN_URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("MEN_URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("MEN_URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("MEN_URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("MEN_URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("MEN_URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("MEN_ICON is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("MEN_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("MEN_ICON =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("MEN_ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("MEN_ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("MEN_ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("MEN_ICON <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("MEN_ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("MEN_ICON not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("MEN_ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("MEN_ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("MEN_ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("MEN_ICON not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("MEN_SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("MEN_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Short value) {
            addCriterion("MEN_SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("MEN_SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("MEN_SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("MEN_SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("MEN_SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("MEN_SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("MEN_SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("MEN_SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("MEN_SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("MEN_CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("MEN_CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("MEN_CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("MEN_CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("MEN_CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("MEN_CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("MEN_CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("MEN_CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("MEN_CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("MEN_CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("MEN_CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("MEN_CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("MEN_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("MEN_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("MEN_UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("MEN_UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("MEN_UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MEN_UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("MEN_UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("MEN_UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("MEN_UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("MEN_UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("MEN_UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("MEN_UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andHintsIsNull() {
            addCriterion("MEN_HINTS is null");
            return (Criteria) this;
        }

        public Criteria andHintsIsNotNull() {
            addCriterion("MEN_HINTS is not null");
            return (Criteria) this;
        }

        public Criteria andHintsEqualTo(Short value) {
            addCriterion("MEN_HINTS =", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotEqualTo(Short value) {
            addCriterion("MEN_HINTS <>", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsGreaterThan(Short value) {
            addCriterion("MEN_HINTS >", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsGreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_HINTS >=", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsLessThan(Short value) {
            addCriterion("MEN_HINTS <", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsLessThanOrEqualTo(Short value) {
            addCriterion("MEN_HINTS <=", value, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsIn(List<Short> values) {
            addCriterion("MEN_HINTS in", values, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotIn(List<Short> values) {
            addCriterion("MEN_HINTS not in", values, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsBetween(Short value1, Short value2) {
            addCriterion("MEN_HINTS between", value1, value2, "hints");
            return (Criteria) this;
        }

        public Criteria andHintsNotBetween(Short value1, Short value2) {
            addCriterion("MEN_HINTS not between", value1, value2, "hints");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("MEN_STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("MEN_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("MEN_STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("MEN_STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("MEN_STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("MEN_STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("MEN_STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("MEN_STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("MEN_STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("MEN_STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("MEN_STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andFieldIsNull() {
            addCriterion("MEN_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull() {
            addCriterion("MEN_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(String value) {
            addCriterion("MEN_FIELD =", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(String value) {
            addCriterion("MEN_FIELD <>", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(String value) {
            addCriterion("MEN_FIELD >", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_FIELD >=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(String value) {
            addCriterion("MEN_FIELD <", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(String value) {
            addCriterion("MEN_FIELD <=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLike(String value) {
            addCriterion("MEN_FIELD like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(String value) {
            addCriterion("MEN_FIELD not like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldIn(List<String> values) {
            addCriterion("MEN_FIELD in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(List<String> values) {
            addCriterion("MEN_FIELD not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(String value1, String value2) {
            addCriterion("MEN_FIELD between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(String value1, String value2) {
            addCriterion("MEN_FIELD not between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("MEN_KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("MEN_KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("MEN_KEYWORD =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("MEN_KEYWORD <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("MEN_KEYWORD >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_KEYWORD >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("MEN_KEYWORD <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("MEN_KEYWORD <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("MEN_KEYWORD like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("MEN_KEYWORD not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("MEN_KEYWORD in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("MEN_KEYWORD not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("MEN_KEYWORD between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("MEN_KEYWORD not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNull() {
            addCriterion("MEN_DATASOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNotNull() {
            addCriterion("MEN_DATASOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceEqualTo(String value) {
            addCriterion("MEN_DATASOURCE =", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotEqualTo(String value) {
            addCriterion("MEN_DATASOURCE <>", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThan(String value) {
            addCriterion("MEN_DATASOURCE >", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_DATASOURCE >=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThan(String value) {
            addCriterion("MEN_DATASOURCE <", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThanOrEqualTo(String value) {
            addCriterion("MEN_DATASOURCE <=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLike(String value) {
            addCriterion("MEN_DATASOURCE like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotLike(String value) {
            addCriterion("MEN_DATASOURCE not like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceIn(List<String> values) {
            addCriterion("MEN_DATASOURCE in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotIn(List<String> values) {
            addCriterion("MEN_DATASOURCE not in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceBetween(String value1, String value2) {
            addCriterion("MEN_DATASOURCE between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotBetween(String value1, String value2) {
            addCriterion("MEN_DATASOURCE not between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andKeywordValueIsNull() {
            addCriterion("MEN_KEYWORD_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andKeywordValueIsNotNull() {
            addCriterion("MEN_KEYWORD_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordValueEqualTo(String value) {
            addCriterion("MEN_KEYWORD_VALUE =", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueNotEqualTo(String value) {
            addCriterion("MEN_KEYWORD_VALUE <>", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueGreaterThan(String value) {
            addCriterion("MEN_KEYWORD_VALUE >", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_KEYWORD_VALUE >=", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueLessThan(String value) {
            addCriterion("MEN_KEYWORD_VALUE <", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueLessThanOrEqualTo(String value) {
            addCriterion("MEN_KEYWORD_VALUE <=", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueLike(String value) {
            addCriterion("MEN_KEYWORD_VALUE like", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueNotLike(String value) {
            addCriterion("MEN_KEYWORD_VALUE not like", value, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueIn(List<String> values) {
            addCriterion("MEN_KEYWORD_VALUE in", values, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueNotIn(List<String> values) {
            addCriterion("MEN_KEYWORD_VALUE not in", values, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueBetween(String value1, String value2) {
            addCriterion("MEN_KEYWORD_VALUE between", value1, value2, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andKeywordValueNotBetween(String value1, String value2) {
            addCriterion("MEN_KEYWORD_VALUE not between", value1, value2, "keywordValue");
            return (Criteria) this;
        }

        public Criteria andRc1IsNull() {
            addCriterion("MEN_RC1 is null");
            return (Criteria) this;
        }

        public Criteria andRc1IsNotNull() {
            addCriterion("MEN_RC1 is not null");
            return (Criteria) this;
        }

        public Criteria andRc1EqualTo(String value) {
            addCriterion("MEN_RC1 =", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotEqualTo(String value) {
            addCriterion("MEN_RC1 <>", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1GreaterThan(String value) {
            addCriterion("MEN_RC1 >", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1GreaterThanOrEqualTo(String value) {
            addCriterion("MEN_RC1 >=", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1LessThan(String value) {
            addCriterion("MEN_RC1 <", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1LessThanOrEqualTo(String value) {
            addCriterion("MEN_RC1 <=", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1Like(String value) {
            addCriterion("MEN_RC1 like", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotLike(String value) {
            addCriterion("MEN_RC1 not like", value, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1In(List<String> values) {
            addCriterion("MEN_RC1 in", values, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotIn(List<String> values) {
            addCriterion("MEN_RC1 not in", values, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1Between(String value1, String value2) {
            addCriterion("MEN_RC1 between", value1, value2, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc1NotBetween(String value1, String value2) {
            addCriterion("MEN_RC1 not between", value1, value2, "rc1");
            return (Criteria) this;
        }

        public Criteria andRc2IsNull() {
            addCriterion("MEN_RC2 is null");
            return (Criteria) this;
        }

        public Criteria andRc2IsNotNull() {
            addCriterion("MEN_RC2 is not null");
            return (Criteria) this;
        }

        public Criteria andRc2EqualTo(String value) {
            addCriterion("MEN_RC2 =", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotEqualTo(String value) {
            addCriterion("MEN_RC2 <>", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2GreaterThan(String value) {
            addCriterion("MEN_RC2 >", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2GreaterThanOrEqualTo(String value) {
            addCriterion("MEN_RC2 >=", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2LessThan(String value) {
            addCriterion("MEN_RC2 <", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2LessThanOrEqualTo(String value) {
            addCriterion("MEN_RC2 <=", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2Like(String value) {
            addCriterion("MEN_RC2 like", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotLike(String value) {
            addCriterion("MEN_RC2 not like", value, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2In(List<String> values) {
            addCriterion("MEN_RC2 in", values, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotIn(List<String> values) {
            addCriterion("MEN_RC2 not in", values, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2Between(String value1, String value2) {
            addCriterion("MEN_RC2 between", value1, value2, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc2NotBetween(String value1, String value2) {
            addCriterion("MEN_RC2 not between", value1, value2, "rc2");
            return (Criteria) this;
        }

        public Criteria andRc3IsNull() {
            addCriterion("MEN_RC3 is null");
            return (Criteria) this;
        }

        public Criteria andRc3IsNotNull() {
            addCriterion("MEN_RC3 is not null");
            return (Criteria) this;
        }

        public Criteria andRc3EqualTo(String value) {
            addCriterion("MEN_RC3 =", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotEqualTo(String value) {
            addCriterion("MEN_RC3 <>", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThan(String value) {
            addCriterion("MEN_RC3 >", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3GreaterThanOrEqualTo(String value) {
            addCriterion("MEN_RC3 >=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThan(String value) {
            addCriterion("MEN_RC3 <", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3LessThanOrEqualTo(String value) {
            addCriterion("MEN_RC3 <=", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3Like(String value) {
            addCriterion("MEN_RC3 like", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotLike(String value) {
            addCriterion("MEN_RC3 not like", value, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3In(List<String> values) {
            addCriterion("MEN_RC3 in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotIn(List<String> values) {
            addCriterion("MEN_RC3 not in", values, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3Between(String value1, String value2) {
            addCriterion("MEN_RC3 between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc3NotBetween(String value1, String value2) {
            addCriterion("MEN_RC3 not between", value1, value2, "rc3");
            return (Criteria) this;
        }

        public Criteria andRc4IsNull() {
            addCriterion("MEN_RC4 is null");
            return (Criteria) this;
        }

        public Criteria andRc4IsNotNull() {
            addCriterion("MEN_RC4 is not null");
            return (Criteria) this;
        }

        public Criteria andRc4EqualTo(String value) {
            addCriterion("MEN_RC4 =", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotEqualTo(String value) {
            addCriterion("MEN_RC4 <>", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThan(String value) {
            addCriterion("MEN_RC4 >", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThanOrEqualTo(String value) {
            addCriterion("MEN_RC4 >=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThan(String value) {
            addCriterion("MEN_RC4 <", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThanOrEqualTo(String value) {
            addCriterion("MEN_RC4 <=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Like(String value) {
            addCriterion("MEN_RC4 like", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotLike(String value) {
            addCriterion("MEN_RC4 not like", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4In(List<String> values) {
            addCriterion("MEN_RC4 in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotIn(List<String> values) {
            addCriterion("MEN_RC4 not in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Between(String value1, String value2) {
            addCriterion("MEN_RC4 between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotBetween(String value1, String value2) {
            addCriterion("MEN_RC4 not between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc5IsNull() {
            addCriterion("MEN_RC5 is null");
            return (Criteria) this;
        }

        public Criteria andRc5IsNotNull() {
            addCriterion("MEN_RC5 is not null");
            return (Criteria) this;
        }

        public Criteria andRc5EqualTo(String value) {
            addCriterion("MEN_RC5 =", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotEqualTo(String value) {
            addCriterion("MEN_RC5 <>", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThan(String value) {
            addCriterion("MEN_RC5 >", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThanOrEqualTo(String value) {
            addCriterion("MEN_RC5 >=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThan(String value) {
            addCriterion("MEN_RC5 <", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThanOrEqualTo(String value) {
            addCriterion("MEN_RC5 <=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Like(String value) {
            addCriterion("MEN_RC5 like", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotLike(String value) {
            addCriterion("MEN_RC5 not like", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5In(List<String> values) {
            addCriterion("MEN_RC5 in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotIn(List<String> values) {
            addCriterion("MEN_RC5 not in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Between(String value1, String value2) {
            addCriterion("MEN_RC5 between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotBetween(String value1, String value2) {
            addCriterion("MEN_RC5 not between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc6IsNull() {
            addCriterion("MEN_RC6 is null");
            return (Criteria) this;
        }

        public Criteria andRc6IsNotNull() {
            addCriterion("MEN_RC6 is not null");
            return (Criteria) this;
        }

        public Criteria andRc6EqualTo(Short value) {
            addCriterion("MEN_RC6 =", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotEqualTo(Short value) {
            addCriterion("MEN_RC6 <>", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThan(Short value) {
            addCriterion("MEN_RC6 >", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_RC6 >=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThan(Short value) {
            addCriterion("MEN_RC6 <", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThanOrEqualTo(Short value) {
            addCriterion("MEN_RC6 <=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6In(List<Short> values) {
            addCriterion("MEN_RC6 in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotIn(List<Short> values) {
            addCriterion("MEN_RC6 not in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6Between(Short value1, Short value2) {
            addCriterion("MEN_RC6 between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotBetween(Short value1, Short value2) {
            addCriterion("MEN_RC6 not between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc7IsNull() {
            addCriterion("MEN_RC7 is null");
            return (Criteria) this;
        }

        public Criteria andRc7IsNotNull() {
            addCriterion("MEN_RC7 is not null");
            return (Criteria) this;
        }

        public Criteria andRc7EqualTo(Short value) {
            addCriterion("MEN_RC7 =", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7NotEqualTo(Short value) {
            addCriterion("MEN_RC7 <>", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7GreaterThan(Short value) {
            addCriterion("MEN_RC7 >", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7GreaterThanOrEqualTo(Short value) {
            addCriterion("MEN_RC7 >=", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7LessThan(Short value) {
            addCriterion("MEN_RC7 <", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7LessThanOrEqualTo(Short value) {
            addCriterion("MEN_RC7 <=", value, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7In(List<Short> values) {
            addCriterion("MEN_RC7 in", values, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7NotIn(List<Short> values) {
            addCriterion("MEN_RC7 not in", values, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7Between(Short value1, Short value2) {
            addCriterion("MEN_RC7 between", value1, value2, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc7NotBetween(Short value1, Short value2) {
            addCriterion("MEN_RC7 not between", value1, value2, "rc7");
            return (Criteria) this;
        }

        public Criteria andRc8IsNull() {
            addCriterion("MEN_RC8 is null");
            return (Criteria) this;
        }

        public Criteria andRc8IsNotNull() {
            addCriterion("MEN_RC8 is not null");
            return (Criteria) this;
        }

        public Criteria andRc8EqualTo(Date value) {
            addCriterion("MEN_RC8 =", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8NotEqualTo(Date value) {
            addCriterion("MEN_RC8 <>", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8GreaterThan(Date value) {
            addCriterion("MEN_RC8 >", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8GreaterThanOrEqualTo(Date value) {
            addCriterion("MEN_RC8 >=", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8LessThan(Date value) {
            addCriterion("MEN_RC8 <", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8LessThanOrEqualTo(Date value) {
            addCriterion("MEN_RC8 <=", value, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8In(List<Date> values) {
            addCriterion("MEN_RC8 in", values, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8NotIn(List<Date> values) {
            addCriterion("MEN_RC8 not in", values, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8Between(Date value1, Date value2) {
            addCriterion("MEN_RC8 between", value1, value2, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc8NotBetween(Date value1, Date value2) {
            addCriterion("MEN_RC8 not between", value1, value2, "rc8");
            return (Criteria) this;
        }

        public Criteria andRc9IsNull() {
            addCriterion("MEN_RC9 is null");
            return (Criteria) this;
        }

        public Criteria andRc9IsNotNull() {
            addCriterion("MEN_RC9 is not null");
            return (Criteria) this;
        }

        public Criteria andRc9EqualTo(Date value) {
            addCriterion("MEN_RC9 =", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9NotEqualTo(Date value) {
            addCriterion("MEN_RC9 <>", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9GreaterThan(Date value) {
            addCriterion("MEN_RC9 >", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9GreaterThanOrEqualTo(Date value) {
            addCriterion("MEN_RC9 >=", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9LessThan(Date value) {
            addCriterion("MEN_RC9 <", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9LessThanOrEqualTo(Date value) {
            addCriterion("MEN_RC9 <=", value, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9In(List<Date> values) {
            addCriterion("MEN_RC9 in", values, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9NotIn(List<Date> values) {
            addCriterion("MEN_RC9 not in", values, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9Between(Date value1, Date value2) {
            addCriterion("MEN_RC9 between", value1, value2, "rc9");
            return (Criteria) this;
        }

        public Criteria andRc9NotBetween(Date value1, Date value2) {
            addCriterion("MEN_RC9 not between", value1, value2, "rc9");
            return (Criteria) this;
        }

        public Criteria andPermsIsNull() {
            addCriterion("MEN_PERMS is null");
            return (Criteria) this;
        }

        public Criteria andPermsIsNotNull() {
            addCriterion("MEN_PERMS is not null");
            return (Criteria) this;
        }

        public Criteria andPermsEqualTo(String value) {
            addCriterion("MEN_PERMS =", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsNotEqualTo(String value) {
            addCriterion("MEN_PERMS <>", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsGreaterThan(String value) {
            addCriterion("MEN_PERMS >", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsGreaterThanOrEqualTo(String value) {
            addCriterion("MEN_PERMS >=", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsLessThan(String value) {
            addCriterion("MEN_PERMS <", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsLessThanOrEqualTo(String value) {
            addCriterion("MEN_PERMS <=", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsLike(String value) {
            addCriterion("MEN_PERMS like", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsNotLike(String value) {
            addCriterion("MEN_PERMS not like", value, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsIn(List<String> values) {
            addCriterion("MEN_PERMS in", values, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsNotIn(List<String> values) {
            addCriterion("MEN_PERMS not in", values, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsBetween(String value1, String value2) {
            addCriterion("MEN_PERMS between", value1, value2, "perms");
            return (Criteria) this;
        }

        public Criteria andPermsNotBetween(String value1, String value2) {
            addCriterion("MEN_PERMS not between", value1, value2, "perms");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(MEN_ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSsmguidLikeInsensitive(String value) {
            addCriterion("upper(MEN_SSMGUID) like", value.toUpperCase(), "ssmguid");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(MEN_NAME) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andDescLikeInsensitive(String value) {
            addCriterion("upper(MEN_DESC) like", value.toUpperCase(), "desc");
            return (Criteria) this;
        }

        public Criteria andParentIdLikeInsensitive(String value) {
            addCriterion("upper(MEN_PARENT_ID) like", value.toUpperCase(), "parentId");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(MEN_URL) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andIconLikeInsensitive(String value) {
            addCriterion("upper(MEN_ICON) like", value.toUpperCase(), "icon");
            return (Criteria) this;
        }

        public Criteria andFieldLikeInsensitive(String value) {
            addCriterion("upper(MEN_FIELD) like", value.toUpperCase(), "field");
            return (Criteria) this;
        }

        public Criteria andKeywordLikeInsensitive(String value) {
            addCriterion("upper(MEN_KEYWORD) like", value.toUpperCase(), "keyword");
            return (Criteria) this;
        }

        public Criteria andDatasourceLikeInsensitive(String value) {
            addCriterion("upper(MEN_DATASOURCE) like", value.toUpperCase(), "datasource");
            return (Criteria) this;
        }

        public Criteria andKeywordValueLikeInsensitive(String value) {
            addCriterion("upper(MEN_KEYWORD_VALUE) like", value.toUpperCase(), "keywordValue");
            return (Criteria) this;
        }

        public Criteria andRc1LikeInsensitive(String value) {
            addCriterion("upper(MEN_RC1) like", value.toUpperCase(), "rc1");
            return (Criteria) this;
        }

        public Criteria andRc2LikeInsensitive(String value) {
            addCriterion("upper(MEN_RC2) like", value.toUpperCase(), "rc2");
            return (Criteria) this;
        }

        public Criteria andRc3LikeInsensitive(String value) {
            addCriterion("upper(MEN_RC3) like", value.toUpperCase(), "rc3");
            return (Criteria) this;
        }

        public Criteria andRc4LikeInsensitive(String value) {
            addCriterion("upper(MEN_RC4) like", value.toUpperCase(), "rc4");
            return (Criteria) this;
        }

        public Criteria andRc5LikeInsensitive(String value) {
            addCriterion("upper(MEN_RC5) like", value.toUpperCase(), "rc5");
            return (Criteria) this;
        }

        public Criteria andPermsLikeInsensitive(String value) {
            addCriterion("upper(MEN_PERMS) like", value.toUpperCase(), "perms");
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