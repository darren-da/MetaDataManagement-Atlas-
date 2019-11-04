package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public InformationApiExample() {
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

        public Criteria andApiNameDescriptionLike(String value1){
            addCriterion("( API_NAME like '" + value1 + "' OR DESCRIPTION like  '" + value1 + "') AND 1=", "1", "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("API_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("API_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("API_NAME =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("API_NAME <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("API_NAME >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("API_NAME >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("API_NAME <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("API_NAME <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("API_NAME like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("API_NAME not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("API_NAME in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("API_NAME not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("API_NAME between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("API_NAME not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiCodeIsNull() {
            addCriterion("API_CODE is null");
            return (Criteria) this;
        }

        public Criteria andApiCodeIsNotNull() {
            addCriterion("API_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andApiCodeEqualTo(String value) {
            addCriterion("API_CODE =", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotEqualTo(String value) {
            addCriterion("API_CODE <>", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeGreaterThan(String value) {
            addCriterion("API_CODE >", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("API_CODE >=", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLessThan(String value) {
            addCriterion("API_CODE <", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLessThanOrEqualTo(String value) {
            addCriterion("API_CODE <=", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLike(String value) {
            addCriterion("API_CODE like", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotLike(String value) {
            addCriterion("API_CODE not like", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeIn(List<String> values) {
            addCriterion("API_CODE in", values, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotIn(List<String> values) {
            addCriterion("API_CODE not in", values, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeBetween(String value1, String value2) {
            addCriterion("API_CODE between", value1, value2, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotBetween(String value1, String value2) {
            addCriterion("API_CODE not between", value1, value2, "apiCode");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("METHOD is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("METHOD =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("METHOD <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("METHOD >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("METHOD >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("METHOD <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("METHOD <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("METHOD like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("METHOD not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("METHOD in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("METHOD not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("METHOD between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("METHOD not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("REQUEST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("REQUEST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(Byte value) {
            addCriterion("REQUEST_TYPE =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(Byte value) {
            addCriterion("REQUEST_TYPE <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(Byte value) {
            addCriterion("REQUEST_TYPE >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("REQUEST_TYPE >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(Byte value) {
            addCriterion("REQUEST_TYPE <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(Byte value) {
            addCriterion("REQUEST_TYPE <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<Byte> values) {
            addCriterion("REQUEST_TYPE in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<Byte> values) {
            addCriterion("REQUEST_TYPE not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(Byte value1, Byte value2) {
            addCriterion("REQUEST_TYPE between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("REQUEST_TYPE not between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNull() {
            addCriterion("API_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNotNull() {
            addCriterion("API_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApiTypeEqualTo(Byte value) {
            addCriterion("API_TYPE =", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotEqualTo(Byte value) {
            addCriterion("API_TYPE <>", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThan(Byte value) {
            addCriterion("API_TYPE >", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("API_TYPE >=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThan(Byte value) {
            addCriterion("API_TYPE <", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThanOrEqualTo(Byte value) {
            addCriterion("API_TYPE <=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeIn(List<Byte> values) {
            addCriterion("API_TYPE in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotIn(List<Byte> values) {
            addCriterion("API_TYPE not in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeBetween(Byte value1, Byte value2) {
            addCriterion("API_TYPE between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("API_TYPE not between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiStatusIsNull() {
            addCriterion("API_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andApiStatusIsNotNull() {
            addCriterion("API_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andApiStatusEqualTo(Byte value) {
            addCriterion("API_STATUS =", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusNotEqualTo(Byte value) {
            addCriterion("API_STATUS <>", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusGreaterThan(Byte value) {
            addCriterion("API_STATUS >", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("API_STATUS >=", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusLessThan(Byte value) {
            addCriterion("API_STATUS <", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusLessThanOrEqualTo(Byte value) {
            addCriterion("API_STATUS <=", value, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusIn(List<Byte> values) {
            addCriterion("API_STATUS in", values, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusNotIn(List<Byte> values) {
            addCriterion("API_STATUS not in", values, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusBetween(Byte value1, Byte value2) {
            addCriterion("API_STATUS between", value1, value2, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andApiStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("API_STATUS not between", value1, value2, "apiStatus");
            return (Criteria) this;
        }

        public Criteria andProducerIdIsNull() {
            addCriterion("PRODUCER_ID is null");
            return (Criteria) this;
        }

        public Criteria andProducerIdIsNotNull() {
            addCriterion("PRODUCER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProducerIdEqualTo(String value) {
            addCriterion("PRODUCER_ID =", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotEqualTo(String value) {
            addCriterion("PRODUCER_ID <>", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdGreaterThan(String value) {
            addCriterion("PRODUCER_ID >", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ID >=", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdLessThan(String value) {
            addCriterion("PRODUCER_ID <", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ID <=", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdLike(String value) {
            addCriterion("PRODUCER_ID like", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotLike(String value) {
            addCriterion("PRODUCER_ID not like", value, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdIn(List<String> values) {
            addCriterion("PRODUCER_ID in", values, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotIn(List<String> values) {
            addCriterion("PRODUCER_ID not in", values, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdBetween(String value1, String value2) {
            addCriterion("PRODUCER_ID between", value1, value2, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCER_ID not between", value1, value2, "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdIsNull() {
            addCriterion("PRODUCER_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdIsNotNull() {
            addCriterion("PRODUCER_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdEqualTo(String value) {
            addCriterion("PRODUCER_ORG_ID =", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdNotEqualTo(String value) {
            addCriterion("PRODUCER_ORG_ID <>", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdGreaterThan(String value) {
            addCriterion("PRODUCER_ORG_ID >", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ORG_ID >=", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdLessThan(String value) {
            addCriterion("PRODUCER_ORG_ID <", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ORG_ID <=", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdLike(String value) {
            addCriterion("PRODUCER_ORG_ID like", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdNotLike(String value) {
            addCriterion("PRODUCER_ORG_ID not like", value, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdIn(List<String> values) {
            addCriterion("PRODUCER_ORG_ID in", values, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdNotIn(List<String> values) {
            addCriterion("PRODUCER_ORG_ID not in", values, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdBetween(String value1, String value2) {
            addCriterion("PRODUCER_ORG_ID between", value1, value2, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCER_ORG_ID not between", value1, value2, "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("CATEGORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("CATEGORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("CATEGORY_ID =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("CATEGORY_ID <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("CATEGORY_ID >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ID >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("CATEGORY_ID <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ID <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("CATEGORY_ID like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("CATEGORY_ID not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("CATEGORY_ID in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("CATEGORY_ID not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLableIsNull() {
            addCriterion("LABLE is null");
            return (Criteria) this;
        }

        public Criteria andLableIsNotNull() {
            addCriterion("LABLE is not null");
            return (Criteria) this;
        }

        public Criteria andLableEqualTo(String value) {
            addCriterion("LABLE =", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotEqualTo(String value) {
            addCriterion("LABLE <>", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableGreaterThan(String value) {
            addCriterion("LABLE >", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableGreaterThanOrEqualTo(String value) {
            addCriterion("LABLE >=", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLessThan(String value) {
            addCriterion("LABLE <", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLessThanOrEqualTo(String value) {
            addCriterion("LABLE <=", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableLike(String value) {
            addCriterion("LABLE like", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotLike(String value) {
            addCriterion("LABLE not like", value, "lable");
            return (Criteria) this;
        }

        public Criteria andLableIn(List<String> values) {
            addCriterion("LABLE in", values, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotIn(List<String> values) {
            addCriterion("LABLE not in", values, "lable");
            return (Criteria) this;
        }

        public Criteria andLableBetween(String value1, String value2) {
            addCriterion("LABLE between", value1, value2, "lable");
            return (Criteria) this;
        }

        public Criteria andLableNotBetween(String value1, String value2) {
            addCriterion("LABLE not between", value1, value2, "lable");
            return (Criteria) this;
        }

        public Criteria andShareLevelIsNull() {
            addCriterion("SHARE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andShareLevelIsNotNull() {
            addCriterion("SHARE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andShareLevelEqualTo(Byte value) {
            addCriterion("SHARE_LEVEL =", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelNotEqualTo(Byte value) {
            addCriterion("SHARE_LEVEL <>", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelGreaterThan(Byte value) {
            addCriterion("SHARE_LEVEL >", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("SHARE_LEVEL >=", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelLessThan(Byte value) {
            addCriterion("SHARE_LEVEL <", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelLessThanOrEqualTo(Byte value) {
            addCriterion("SHARE_LEVEL <=", value, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelIn(List<Byte> values) {
            addCriterion("SHARE_LEVEL in", values, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelNotIn(List<Byte> values) {
            addCriterion("SHARE_LEVEL not in", values, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_LEVEL between", value1, value2, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_LEVEL not between", value1, value2, "shareLevel");
            return (Criteria) this;
        }

        public Criteria andShareTypeIsNull() {
            addCriterion("SHARE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andShareTypeIsNotNull() {
            addCriterion("SHARE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andShareTypeEqualTo(Byte value) {
            addCriterion("SHARE_TYPE =", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotEqualTo(Byte value) {
            addCriterion("SHARE_TYPE <>", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThan(Byte value) {
            addCriterion("SHARE_TYPE >", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SHARE_TYPE >=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThan(Byte value) {
            addCriterion("SHARE_TYPE <", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SHARE_TYPE <=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeIn(List<Byte> values) {
            addCriterion("SHARE_TYPE in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotIn(List<Byte> values) {
            addCriterion("SHARE_TYPE not in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_TYPE between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_TYPE not between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareCodeIsNull() {
            addCriterion("SHARE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andShareCodeIsNotNull() {
            addCriterion("SHARE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andShareCodeEqualTo(String value) {
            addCriterion("SHARE_CODE =", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeNotEqualTo(String value) {
            addCriterion("SHARE_CODE <>", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeGreaterThan(String value) {
            addCriterion("SHARE_CODE >", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_CODE >=", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeLessThan(String value) {
            addCriterion("SHARE_CODE <", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeLessThanOrEqualTo(String value) {
            addCriterion("SHARE_CODE <=", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeLike(String value) {
            addCriterion("SHARE_CODE like", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeNotLike(String value) {
            addCriterion("SHARE_CODE not like", value, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeIn(List<String> values) {
            addCriterion("SHARE_CODE in", values, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeNotIn(List<String> values) {
            addCriterion("SHARE_CODE not in", values, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeBetween(String value1, String value2) {
            addCriterion("SHARE_CODE between", value1, value2, "shareCode");
            return (Criteria) this;
        }

        public Criteria andShareCodeNotBetween(String value1, String value2) {
            addCriterion("SHARE_CODE not between", value1, value2, "shareCode");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("CHECK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("CHECK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Byte value) {
            addCriterion("CHECK_STATUS =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Byte value) {
            addCriterion("CHECK_STATUS <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Byte value) {
            addCriterion("CHECK_STATUS >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("CHECK_STATUS >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Byte value) {
            addCriterion("CHECK_STATUS <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
            addCriterion("CHECK_STATUS <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Byte> values) {
            addCriterion("CHECK_STATUS in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Byte> values) {
            addCriterion("CHECK_STATUS not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
            addCriterion("CHECK_STATUS between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("CHECK_STATUS not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andParmsFlagIsNull() {
            addCriterion("PARMS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andParmsFlagIsNotNull() {
            addCriterion("PARMS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andParmsFlagEqualTo(Byte value) {
            addCriterion("PARMS_FLAG =", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagNotEqualTo(Byte value) {
            addCriterion("PARMS_FLAG <>", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagGreaterThan(Byte value) {
            addCriterion("PARMS_FLAG >", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("PARMS_FLAG >=", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagLessThan(Byte value) {
            addCriterion("PARMS_FLAG <", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagLessThanOrEqualTo(Byte value) {
            addCriterion("PARMS_FLAG <=", value, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagIn(List<Byte> values) {
            addCriterion("PARMS_FLAG in", values, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagNotIn(List<Byte> values) {
            addCriterion("PARMS_FLAG not in", values, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagBetween(Byte value1, Byte value2) {
            addCriterion("PARMS_FLAG between", value1, value2, "parmsFlag");
            return (Criteria) this;
        }

        public Criteria andParmsFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("PARMS_FLAG not between", value1, value2, "parmsFlag");
            return (Criteria) this;
        }

        //多条件筛选组合查询(可用、异常、过期)
        public Criteria orTermEqualTo(ArrayList<String> apiTerm){
            String str = "";
            if(apiTerm.contains("expire")){
                str += "OR EXPIRE_TIME < NOW() ";
            }
            if(apiTerm.contains("use")){
                str += "OR (API_STATUS = 0 AND (EXPIRE_TIME > NOW() OR EXPIRE_TIME IS NULL)) ";
            }
            if(apiTerm.contains("error")){
                str += "OR (API_STATUS = 1 AND (EXPIRE_TIME > NOW() OR EXPIRE_TIME IS NULL))";
            }
            if(str != null && str.length() > 0){
                str = str.substring(str.indexOf("OR") + "OR".length(),str.length());
            }
            addCriterion("( " + str + " ) AND 1=","1","apiTerm");
            return (Criteria) this;
        }

        public Criteria andExpireFlagIsNull() {
            addCriterion("EXPIRE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andExpireFlagIsNotNull() {
            addCriterion("EXPIRE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andExpireFlagEqualTo(Byte value) {
            addCriterion("EXPIRE_FLAG =", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagNotEqualTo(Byte value) {
            addCriterion("EXPIRE_FLAG <>", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagGreaterThan(Byte value) {
            addCriterion("EXPIRE_FLAG >", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("EXPIRE_FLAG >=", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagLessThan(Byte value) {
            addCriterion("EXPIRE_FLAG <", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagLessThanOrEqualTo(Byte value) {
            addCriterion("EXPIRE_FLAG <=", value, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagIn(List<Byte> values) {
            addCriterion("EXPIRE_FLAG in", values, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagNotIn(List<Byte> values) {
            addCriterion("EXPIRE_FLAG not in", values, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagBetween(Byte value1, Byte value2) {
            addCriterion("EXPIRE_FLAG between", value1, value2, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("EXPIRE_FLAG not between", value1, value2, "expireFlag");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("EXPIRE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("EXPIRE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("EXPIRE_TIME =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("EXPIRE_TIME >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("EXPIRE_TIME <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("EXPIRE_TIME in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("EXPIRE_TIME not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME not between", value1, value2, "expireTime");
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

        public Criteria andInterParamTypeIsNull() {
            addCriterion("INTER_PARAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeIsNotNull() {
            addCriterion("INTER_PARAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeEqualTo(String value) {
            addCriterion("INTER_PARAM_TYPE =", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeNotEqualTo(String value) {
            addCriterion("INTER_PARAM_TYPE <>", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeGreaterThan(String value) {
            addCriterion("INTER_PARAM_TYPE >", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INTER_PARAM_TYPE >=", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeLessThan(String value) {
            addCriterion("INTER_PARAM_TYPE <", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeLessThanOrEqualTo(String value) {
            addCriterion("INTER_PARAM_TYPE <=", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeLike(String value) {
            addCriterion("INTER_PARAM_TYPE like", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeNotLike(String value) {
            addCriterion("INTER_PARAM_TYPE not like", value, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeIn(List<String> values) {
            addCriterion("INTER_PARAM_TYPE in", values, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeNotIn(List<String> values) {
            addCriterion("INTER_PARAM_TYPE not in", values, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeBetween(String value1, String value2) {
            addCriterion("INTER_PARAM_TYPE between", value1, value2, "interParamType");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeNotBetween(String value1, String value2) {
            addCriterion("INTER_PARAM_TYPE not between", value1, value2, "interParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeIsNull() {
            addCriterion("OUTER_PARAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeIsNotNull() {
            addCriterion("OUTER_PARAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeEqualTo(String value) {
            addCriterion("OUTER_PARAM_TYPE =", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeNotEqualTo(String value) {
            addCriterion("OUTER_PARAM_TYPE <>", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeGreaterThan(String value) {
            addCriterion("OUTER_PARAM_TYPE >", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OUTER_PARAM_TYPE >=", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeLessThan(String value) {
            addCriterion("OUTER_PARAM_TYPE <", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeLessThanOrEqualTo(String value) {
            addCriterion("OUTER_PARAM_TYPE <=", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeLike(String value) {
            addCriterion("OUTER_PARAM_TYPE like", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeNotLike(String value) {
            addCriterion("OUTER_PARAM_TYPE not like", value, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeIn(List<String> values) {
            addCriterion("OUTER_PARAM_TYPE in", values, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeNotIn(List<String> values) {
            addCriterion("OUTER_PARAM_TYPE not in", values, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeBetween(String value1, String value2) {
            addCriterion("OUTER_PARAM_TYPE between", value1, value2, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeNotBetween(String value1, String value2) {
            addCriterion("OUTER_PARAM_TYPE not between", value1, value2, "outerParamType");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("HEADER is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("HEADER is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("HEADER =", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("HEADER <>", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("HEADER >", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("HEADER >=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("HEADER <", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("HEADER <=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("HEADER like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("HEADER not like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("HEADER in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("HEADER not in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("HEADER between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("HEADER not between", value1, value2, "header");
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

        public Criteria andApiNameLikeInsensitive(String value) {
            addCriterion("upper(API_NAME) like", value.toUpperCase(), "apiName");
            return (Criteria) this;
        }

        public Criteria andApiCodeLikeInsensitive(String value) {
            addCriterion("upper(API_CODE) like", value.toUpperCase(), "apiCode");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(URL) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andMethodLikeInsensitive(String value) {
            addCriterion("upper(METHOD) like", value.toUpperCase(), "method");
            return (Criteria) this;
        }

        public Criteria andProducerIdLikeInsensitive(String value) {
            addCriterion("upper(PRODUCER_ID) like", value.toUpperCase(), "producerId");
            return (Criteria) this;
        }

        public Criteria andProducerOrgIdLikeInsensitive(String value) {
            addCriterion("upper(PRODUCER_ORG_ID) like", value.toUpperCase(), "producerOrgId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLikeInsensitive(String value) {
            addCriterion("upper(CATEGORY_ID) like", value.toUpperCase(), "categoryId");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(DESCRIPTION) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andLableLikeInsensitive(String value) {
            addCriterion("upper(LABLE) like", value.toUpperCase(), "lable");
            return (Criteria) this;
        }

        public Criteria andShareCodeLikeInsensitive(String value) {
            addCriterion("upper(SHARE_CODE) like", value.toUpperCase(), "shareCode");
            return (Criteria) this;
        }

        public Criteria andInterParamTypeLikeInsensitive(String value) {
            addCriterion("upper(INTER_PARAM_TYPE) like", value.toUpperCase(), "interParamType");
            return (Criteria) this;
        }

        public Criteria andOuterParamTypeLikeInsensitive(String value) {
            addCriterion("upper(OUTER_PARAM_TYPE) like", value.toUpperCase(), "outerParamType");
            return (Criteria) this;
        }

        public Criteria andHeaderLikeInsensitive(String value) {
            addCriterion("upper(HEADER) like", value.toUpperCase(), "header");
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