package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogUserMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public CatalogUserMapExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeIsNull() {
            addCriterion("catalog_code is null");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeIsNotNull() {
            addCriterion("catalog_code is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeEqualTo(String value) {
            addCriterion("catalog_code =", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotEqualTo(String value) {
            addCriterion("catalog_code <>", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeGreaterThan(String value) {
            addCriterion("catalog_code >", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_code >=", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLessThan(String value) {
            addCriterion("catalog_code <", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLessThanOrEqualTo(String value) {
            addCriterion("catalog_code <=", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLike(String value) {
            addCriterion("catalog_code like", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotLike(String value) {
            addCriterion("catalog_code not like", value, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeIn(List<String> values) {
            addCriterion("catalog_code in", values, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotIn(List<String> values) {
            addCriterion("catalog_code not in", values, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeBetween(String value1, String value2) {
            addCriterion("catalog_code between", value1, value2, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeNotBetween(String value1, String value2) {
            addCriterion("catalog_code not between", value1, value2, "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNull() {
            addCriterion("catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("catalog_name =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("catalog_name <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("catalog_name >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_name >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("catalog_name <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("catalog_name <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("catalog_name like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("catalog_name not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("catalog_name in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("catalog_name not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("catalog_name between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("catalog_name not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(userid) like", value.toUpperCase(), "userid");
            return (Criteria) this;
        }

        public Criteria andCatalogCodeLikeInsensitive(String value) {
            addCriterion("upper(catalog_code) like", value.toUpperCase(), "catalogCode");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLikeInsensitive(String value) {
            addCriterion("upper(catalog_name) like", value.toUpperCase(), "catalogName");
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