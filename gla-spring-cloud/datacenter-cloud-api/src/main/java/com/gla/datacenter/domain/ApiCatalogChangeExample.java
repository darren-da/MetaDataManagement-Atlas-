package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiCatalogChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public ApiCatalogChangeExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApiCodeIsNull() {
            addCriterion("api_code is null");
            return (Criteria) this;
        }

        public Criteria andApiCodeIsNotNull() {
            addCriterion("api_code is not null");
            return (Criteria) this;
        }

        public Criteria andApiCodeEqualTo(String value) {
            addCriterion("api_code =", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotEqualTo(String value) {
            addCriterion("api_code <>", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeGreaterThan(String value) {
            addCriterion("api_code >", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("api_code >=", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLessThan(String value) {
            addCriterion("api_code <", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLessThanOrEqualTo(String value) {
            addCriterion("api_code <=", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeLike(String value) {
            addCriterion("api_code like", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotLike(String value) {
            addCriterion("api_code not like", value, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeIn(List<String> values) {
            addCriterion("api_code in", values, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotIn(List<String> values) {
            addCriterion("api_code not in", values, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeBetween(String value1, String value2) {
            addCriterion("api_code between", value1, value2, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCodeNotBetween(String value1, String value2) {
            addCriterion("api_code not between", value1, value2, "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeIsNull() {
            addCriterion("api_cata_code is null");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeIsNotNull() {
            addCriterion("api_cata_code is not null");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeEqualTo(String value) {
            addCriterion("api_cata_code =", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeNotEqualTo(String value) {
            addCriterion("api_cata_code <>", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeGreaterThan(String value) {
            addCriterion("api_cata_code >", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("api_cata_code >=", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeLessThan(String value) {
            addCriterion("api_cata_code <", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeLessThanOrEqualTo(String value) {
            addCriterion("api_cata_code <=", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeLike(String value) {
            addCriterion("api_cata_code like", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeNotLike(String value) {
            addCriterion("api_cata_code not like", value, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeIn(List<String> values) {
            addCriterion("api_cata_code in", values, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeNotIn(List<String> values) {
            addCriterion("api_cata_code not in", values, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeBetween(String value1, String value2) {
            addCriterion("api_cata_code between", value1, value2, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeNotBetween(String value1, String value2) {
            addCriterion("api_cata_code not between", value1, value2, "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("api_name is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("api_name is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("api_name =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("api_name <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("api_name >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("api_name >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("api_name <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("api_name <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("api_name like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("api_name not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("api_name in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("api_name not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("api_name between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("api_name not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andCataCodeIsNull() {
            addCriterion("cata_code is null");
            return (Criteria) this;
        }

        public Criteria andCataCodeIsNotNull() {
            addCriterion("cata_code is not null");
            return (Criteria) this;
        }

        public Criteria andCataCodeEqualTo(String value) {
            addCriterion("cata_code =", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeNotEqualTo(String value) {
            addCriterion("cata_code <>", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeGreaterThan(String value) {
            addCriterion("cata_code >", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cata_code >=", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeLessThan(String value) {
            addCriterion("cata_code <", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeLessThanOrEqualTo(String value) {
            addCriterion("cata_code <=", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeLike(String value) {
            addCriterion("cata_code like", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeNotLike(String value) {
            addCriterion("cata_code not like", value, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeIn(List<String> values) {
            addCriterion("cata_code in", values, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeNotIn(List<String> values) {
            addCriterion("cata_code not in", values, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeBetween(String value1, String value2) {
            addCriterion("cata_code between", value1, value2, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataCodeNotBetween(String value1, String value2) {
            addCriterion("cata_code not between", value1, value2, "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataNameIsNull() {
            addCriterion("cata_name is null");
            return (Criteria) this;
        }

        public Criteria andCataNameIsNotNull() {
            addCriterion("cata_name is not null");
            return (Criteria) this;
        }

        public Criteria andCataNameEqualTo(String value) {
            addCriterion("cata_name =", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameNotEqualTo(String value) {
            addCriterion("cata_name <>", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameGreaterThan(String value) {
            addCriterion("cata_name >", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameGreaterThanOrEqualTo(String value) {
            addCriterion("cata_name >=", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameLessThan(String value) {
            addCriterion("cata_name <", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameLessThanOrEqualTo(String value) {
            addCriterion("cata_name <=", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameLike(String value) {
            addCriterion("cata_name like", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameNotLike(String value) {
            addCriterion("cata_name not like", value, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameIn(List<String> values) {
            addCriterion("cata_name in", values, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameNotIn(List<String> values) {
            addCriterion("cata_name not in", values, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameBetween(String value1, String value2) {
            addCriterion("cata_name between", value1, value2, "cataName");
            return (Criteria) this;
        }

        public Criteria andCataNameNotBetween(String value1, String value2) {
            addCriterion("cata_name not between", value1, value2, "cataName");
            return (Criteria) this;
        }

        public Criteria andOperAccountIsNull() {
            addCriterion("oper_account is null");
            return (Criteria) this;
        }

        public Criteria andOperAccountIsNotNull() {
            addCriterion("oper_account is not null");
            return (Criteria) this;
        }

        public Criteria andOperAccountEqualTo(String value) {
            addCriterion("oper_account =", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountNotEqualTo(String value) {
            addCriterion("oper_account <>", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountGreaterThan(String value) {
            addCriterion("oper_account >", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountGreaterThanOrEqualTo(String value) {
            addCriterion("oper_account >=", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountLessThan(String value) {
            addCriterion("oper_account <", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountLessThanOrEqualTo(String value) {
            addCriterion("oper_account <=", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountLike(String value) {
            addCriterion("oper_account like", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountNotLike(String value) {
            addCriterion("oper_account not like", value, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountIn(List<String> values) {
            addCriterion("oper_account in", values, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountNotIn(List<String> values) {
            addCriterion("oper_account not in", values, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountBetween(String value1, String value2) {
            addCriterion("oper_account between", value1, value2, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperAccountNotBetween(String value1, String value2) {
            addCriterion("oper_account not between", value1, value2, "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("operation like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("operation not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("operation not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andIdtIsNull() {
            addCriterion("idt is null");
            return (Criteria) this;
        }

        public Criteria andIdtIsNotNull() {
            addCriterion("idt is not null");
            return (Criteria) this;
        }

        public Criteria andIdtEqualTo(Date value) {
            addCriterion("idt =", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotEqualTo(Date value) {
            addCriterion("idt <>", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtGreaterThan(Date value) {
            addCriterion("idt >", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtGreaterThanOrEqualTo(Date value) {
            addCriterion("idt >=", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtLessThan(Date value) {
            addCriterion("idt <", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtLessThanOrEqualTo(Date value) {
            addCriterion("idt <=", value, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtIn(List<Date> values) {
            addCriterion("idt in", values, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotIn(List<Date> values) {
            addCriterion("idt not in", values, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtBetween(Date value1, Date value2) {
            addCriterion("idt between", value1, value2, "idt");
            return (Criteria) this;
        }

        public Criteria andIdtNotBetween(Date value1, Date value2) {
            addCriterion("idt not between", value1, value2, "idt");
            return (Criteria) this;
        }

        public Criteria andUdtIsNull() {
            addCriterion("udt is null");
            return (Criteria) this;
        }

        public Criteria andUdtIsNotNull() {
            addCriterion("udt is not null");
            return (Criteria) this;
        }

        public Criteria andUdtEqualTo(Date value) {
            addCriterion("udt =", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotEqualTo(Date value) {
            addCriterion("udt <>", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThan(Date value) {
            addCriterion("udt >", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtGreaterThanOrEqualTo(Date value) {
            addCriterion("udt >=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThan(Date value) {
            addCriterion("udt <", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtLessThanOrEqualTo(Date value) {
            addCriterion("udt <=", value, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtIn(List<Date> values) {
            addCriterion("udt in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotIn(List<Date> values) {
            addCriterion("udt not in", values, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtBetween(Date value1, Date value2) {
            addCriterion("udt between", value1, value2, "udt");
            return (Criteria) this;
        }

        public Criteria andUdtNotBetween(Date value1, Date value2) {
            addCriterion("udt not between", value1, value2, "udt");
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

        public Criteria andRc4IsNull() {
            addCriterion("RC4 is null");
            return (Criteria) this;
        }

        public Criteria andRc4IsNotNull() {
            addCriterion("RC4 is not null");
            return (Criteria) this;
        }

        public Criteria andRc4EqualTo(Integer value) {
            addCriterion("RC4 =", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotEqualTo(Integer value) {
            addCriterion("RC4 <>", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThan(Integer value) {
            addCriterion("RC4 >", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThanOrEqualTo(Integer value) {
            addCriterion("RC4 >=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThan(Integer value) {
            addCriterion("RC4 <", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThanOrEqualTo(Integer value) {
            addCriterion("RC4 <=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4In(List<Integer> values) {
            addCriterion("RC4 in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotIn(List<Integer> values) {
            addCriterion("RC4 not in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Between(Integer value1, Integer value2) {
            addCriterion("RC4 between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotBetween(Integer value1, Integer value2) {
            addCriterion("RC4 not between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc5IsNull() {
            addCriterion("RC5 is null");
            return (Criteria) this;
        }

        public Criteria andRc5IsNotNull() {
            addCriterion("RC5 is not null");
            return (Criteria) this;
        }

        public Criteria andRc5EqualTo(Integer value) {
            addCriterion("RC5 =", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotEqualTo(Integer value) {
            addCriterion("RC5 <>", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThan(Integer value) {
            addCriterion("RC5 >", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThanOrEqualTo(Integer value) {
            addCriterion("RC5 >=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThan(Integer value) {
            addCriterion("RC5 <", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThanOrEqualTo(Integer value) {
            addCriterion("RC5 <=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5In(List<Integer> values) {
            addCriterion("RC5 in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotIn(List<Integer> values) {
            addCriterion("RC5 not in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Between(Integer value1, Integer value2) {
            addCriterion("RC5 between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotBetween(Integer value1, Integer value2) {
            addCriterion("RC5 not between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc6IsNull() {
            addCriterion("RC6 is null");
            return (Criteria) this;
        }

        public Criteria andRc6IsNotNull() {
            addCriterion("RC6 is not null");
            return (Criteria) this;
        }

        public Criteria andRc6EqualTo(Date value) {
            addCriterion("RC6 =", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotEqualTo(Date value) {
            addCriterion("RC6 <>", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThan(Date value) {
            addCriterion("RC6 >", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThanOrEqualTo(Date value) {
            addCriterion("RC6 >=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThan(Date value) {
            addCriterion("RC6 <", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThanOrEqualTo(Date value) {
            addCriterion("RC6 <=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6In(List<Date> values) {
            addCriterion("RC6 in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotIn(List<Date> values) {
            addCriterion("RC6 not in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6Between(Date value1, Date value2) {
            addCriterion("RC6 between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotBetween(Date value1, Date value2) {
            addCriterion("RC6 not between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andApiCodeLikeInsensitive(String value) {
            addCriterion("upper(api_code) like", value.toUpperCase(), "apiCode");
            return (Criteria) this;
        }

        public Criteria andApiCataCodeLikeInsensitive(String value) {
            addCriterion("upper(api_cata_code) like", value.toUpperCase(), "apiCataCode");
            return (Criteria) this;
        }

        public Criteria andApiNameLikeInsensitive(String value) {
            addCriterion("upper(api_name) like", value.toUpperCase(), "apiName");
            return (Criteria) this;
        }

        public Criteria andCataCodeLikeInsensitive(String value) {
            addCriterion("upper(cata_code) like", value.toUpperCase(), "cataCode");
            return (Criteria) this;
        }

        public Criteria andCataNameLikeInsensitive(String value) {
            addCriterion("upper(cata_name) like", value.toUpperCase(), "cataName");
            return (Criteria) this;
        }

        public Criteria andOperAccountLikeInsensitive(String value) {
            addCriterion("upper(oper_account) like", value.toUpperCase(), "operAccount");
            return (Criteria) this;
        }

        public Criteria andOperationLikeInsensitive(String value) {
            addCriterion("upper(operation) like", value.toUpperCase(), "operation");
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