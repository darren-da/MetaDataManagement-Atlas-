package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public UserInfoExample() {
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
        this.page = page;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String parse = simpleDateFormat.format(value);
                addCriterion(condition, parse, property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountEqualToOrEmailEqualTo(String value) {
            addCriterion("( ACCOUNT = '"+value+"'OR EMAIL = '"+value+"') AND 1=","1", "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("MAC is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("MAC is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("MAC =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("MAC <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("MAC >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("MAC >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("MAC <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("MAC <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("MAC like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("MAC not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("MAC in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("MAC not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("MAC between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("MAC not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireIsNull() {
            addCriterion("ISAUTOEXPIRE is null");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireIsNotNull() {
            addCriterion("ISAUTOEXPIRE is not null");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireEqualTo(Integer value) {
            addCriterion("ISAUTOEXPIRE =", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireNotEqualTo(Integer value) {
            addCriterion("ISAUTOEXPIRE <>", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireGreaterThan(Integer value) {
            addCriterion("ISAUTOEXPIRE >", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISAUTOEXPIRE >=", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireLessThan(Integer value) {
            addCriterion("ISAUTOEXPIRE <", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireLessThanOrEqualTo(Integer value) {
            addCriterion("ISAUTOEXPIRE <=", value, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireIn(List<Integer> values) {
            addCriterion("ISAUTOEXPIRE in", values, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireNotIn(List<Integer> values) {
            addCriterion("ISAUTOEXPIRE not in", values, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireBetween(Integer value1, Integer value2) {
            addCriterion("ISAUTOEXPIRE between", value1, value2, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsautoexpireNotBetween(Integer value1, Integer value2) {
            addCriterion("ISAUTOEXPIRE not between", value1, value2, "isautoexpire");
            return (Criteria) this;
        }

        public Criteria andIsbindipIsNull() {
            addCriterion("ISBINDIP is null");
            return (Criteria) this;
        }

        public Criteria andIsbindipIsNotNull() {
            addCriterion("ISBINDIP is not null");
            return (Criteria) this;
        }

        public Criteria andIsbindipEqualTo(Integer value) {
            addCriterion("ISBINDIP =", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipNotEqualTo(Integer value) {
            addCriterion("ISBINDIP <>", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipGreaterThan(Integer value) {
            addCriterion("ISBINDIP >", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISBINDIP >=", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipLessThan(Integer value) {
            addCriterion("ISBINDIP <", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipLessThanOrEqualTo(Integer value) {
            addCriterion("ISBINDIP <=", value, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipIn(List<Integer> values) {
            addCriterion("ISBINDIP in", values, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipNotIn(List<Integer> values) {
            addCriterion("ISBINDIP not in", values, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipBetween(Integer value1, Integer value2) {
            addCriterion("ISBINDIP between", value1, value2, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindipNotBetween(Integer value1, Integer value2) {
            addCriterion("ISBINDIP not between", value1, value2, "isbindip");
            return (Criteria) this;
        }

        public Criteria andIsbindmacIsNull() {
            addCriterion("ISBINDMAC is null");
            return (Criteria) this;
        }

        public Criteria andIsbindmacIsNotNull() {
            addCriterion("ISBINDMAC is not null");
            return (Criteria) this;
        }

        public Criteria andIsbindmacEqualTo(Integer value) {
            addCriterion("ISBINDMAC =", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacNotEqualTo(Integer value) {
            addCriterion("ISBINDMAC <>", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacGreaterThan(Integer value) {
            addCriterion("ISBINDMAC >", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISBINDMAC >=", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacLessThan(Integer value) {
            addCriterion("ISBINDMAC <", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacLessThanOrEqualTo(Integer value) {
            addCriterion("ISBINDMAC <=", value, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacIn(List<Integer> values) {
            addCriterion("ISBINDMAC in", values, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacNotIn(List<Integer> values) {
            addCriterion("ISBINDMAC not in", values, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacBetween(Integer value1, Integer value2) {
            addCriterion("ISBINDMAC between", value1, value2, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andIsbindmacNotBetween(Integer value1, Integer value2) {
            addCriterion("ISBINDMAC not between", value1, value2, "isbindmac");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("LASTTIME is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("LASTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTIME =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTIME <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("LASTTIME >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTIME >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterionForJDBCDate("LASTTIME <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LASTTIME <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterionForJDBCDate("LASTTIME in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("LASTTIME not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LASTTIME between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LASTTIME not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLastipIsNull() {
            addCriterion("LASTIP is null");
            return (Criteria) this;
        }

        public Criteria andLastipIsNotNull() {
            addCriterion("LASTIP is not null");
            return (Criteria) this;
        }

        public Criteria andLastipEqualTo(String value) {
            addCriterion("LASTIP =", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipNotEqualTo(String value) {
            addCriterion("LASTIP <>", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipGreaterThan(String value) {
            addCriterion("LASTIP >", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipGreaterThanOrEqualTo(String value) {
            addCriterion("LASTIP >=", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipLessThan(String value) {
            addCriterion("LASTIP <", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipLessThanOrEqualTo(String value) {
            addCriterion("LASTIP <=", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipLike(String value) {
            addCriterion("LASTIP like", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipNotLike(String value) {
            addCriterion("LASTIP not like", value, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipIn(List<String> values) {
            addCriterion("LASTIP in", values, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipNotIn(List<String> values) {
            addCriterion("LASTIP not in", values, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipBetween(String value1, String value2) {
            addCriterion("LASTIP between", value1, value2, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastipNotBetween(String value1, String value2) {
            addCriterion("LASTIP not between", value1, value2, "lastip");
            return (Criteria) this;
        }

        public Criteria andLastmacIsNull() {
            addCriterion("LASTMAC is null");
            return (Criteria) this;
        }

        public Criteria andLastmacIsNotNull() {
            addCriterion("LASTMAC is not null");
            return (Criteria) this;
        }

        public Criteria andLastmacEqualTo(String value) {
            addCriterion("LASTMAC =", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacNotEqualTo(String value) {
            addCriterion("LASTMAC <>", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacGreaterThan(String value) {
            addCriterion("LASTMAC >", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacGreaterThanOrEqualTo(String value) {
            addCriterion("LASTMAC >=", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacLessThan(String value) {
            addCriterion("LASTMAC <", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacLessThanOrEqualTo(String value) {
            addCriterion("LASTMAC <=", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacLike(String value) {
            addCriterion("LASTMAC like", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacNotLike(String value) {
            addCriterion("LASTMAC not like", value, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacIn(List<String> values) {
            addCriterion("LASTMAC in", values, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacNotIn(List<String> values) {
            addCriterion("LASTMAC not in", values, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacBetween(String value1, String value2) {
            addCriterion("LASTMAC between", value1, value2, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLastmacNotBetween(String value1, String value2) {
            addCriterion("LASTMAC not between", value1, value2, "lastmac");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNull() {
            addCriterion("LOGINCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNotNull() {
            addCriterion("LOGINCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLogincountEqualTo(Integer value) {
            addCriterion("LOGINCOUNT =", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotEqualTo(Integer value) {
            addCriterion("LOGINCOUNT <>", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThan(Integer value) {
            addCriterion("LOGINCOUNT >", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGINCOUNT >=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThan(Integer value) {
            addCriterion("LOGINCOUNT <", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThanOrEqualTo(Integer value) {
            addCriterion("LOGINCOUNT <=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountIn(List<Integer> values) {
            addCriterion("LOGINCOUNT in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotIn(List<Integer> values) {
            addCriterion("LOGINCOUNT not in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountBetween(Integer value1, Integer value2) {
            addCriterion("LOGINCOUNT between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGINCOUNT not between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATEDATE >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("CREATEDATE <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATEDATE <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATE in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATEDATE not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATE between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATEDATE not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateEqualToOneOrTwo() {
            addCriterion("( STATE = '"+1+"' OR STATE = '"+2+"') AND 1= ","1","state");
            return (Criteria) this;
        }


        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIcnIsNull() {
            addCriterion("ICN is null");
            return (Criteria) this;
        }

        public Criteria andIcnIsNotNull() {
            addCriterion("ICN is not null");
            return (Criteria) this;
        }

        public Criteria andIcnEqualTo(String value) {
            addCriterion("ICN =", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnNotEqualTo(String value) {
            addCriterion("ICN <>", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnGreaterThan(String value) {
            addCriterion("ICN >", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnGreaterThanOrEqualTo(String value) {
            addCriterion("ICN >=", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnLessThan(String value) {
            addCriterion("ICN <", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnLessThanOrEqualTo(String value) {
            addCriterion("ICN <=", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnLike(String value) {
            addCriterion("ICN like", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnNotLike(String value) {
            addCriterion("ICN not like", value, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnIn(List<String> values) {
            addCriterion("ICN in", values, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnNotIn(List<String> values) {
            addCriterion("ICN not in", values, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnBetween(String value1, String value2) {
            addCriterion("ICN between", value1, value2, "icn");
            return (Criteria) this;
        }

        public Criteria andIcnNotBetween(String value1, String value2) {
            addCriterion("ICN not between", value1, value2, "icn");
            return (Criteria) this;
        }

        public Criteria andUnitcodeIsNull() {
            addCriterion("UNITCODE is null");
            return (Criteria) this;
        }

        public Criteria andUnitcodeIsNotNull() {
            addCriterion("UNITCODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitcodeEqualTo(String value) {
            addCriterion("UNITCODE =", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeNotEqualTo(String value) {
            addCriterion("UNITCODE <>", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeGreaterThan(String value) {
            addCriterion("UNITCODE >", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNITCODE >=", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeLessThan(String value) {
            addCriterion("UNITCODE <", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeLessThanOrEqualTo(String value) {
            addCriterion("UNITCODE <=", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeLike(String value) {
            addCriterion("UNITCODE like", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeNotLike(String value) {
            addCriterion("UNITCODE not like", value, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeIn(List<String> values) {
            addCriterion("UNITCODE in", values, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeNotIn(List<String> values) {
            addCriterion("UNITCODE not in", values, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeBetween(String value1, String value2) {
            addCriterion("UNITCODE between", value1, value2, "unitcode");
            return (Criteria) this;
        }

        public Criteria andUnitcodeNotBetween(String value1, String value2) {
            addCriterion("UNITCODE not between", value1, value2, "unitcode");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUtypeIsNull() {
            addCriterion("UTYPE is null");
            return (Criteria) this;
        }

        public Criteria andUtypeIsNotNull() {
            addCriterion("UTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUtypeEqualTo(Integer value) {
            addCriterion("UTYPE =", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeNotEqualTo(Integer value) {
            addCriterion("UTYPE <>", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeGreaterThan(Integer value) {
            addCriterion("UTYPE >", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("UTYPE >=", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeLessThan(Integer value) {
            addCriterion("UTYPE <", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeLessThanOrEqualTo(Integer value) {
            addCriterion("UTYPE <=", value, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeIn(List<Integer> values) {
            addCriterion("UTYPE in", values, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeNotIn(List<Integer> values) {
            addCriterion("UTYPE not in", values, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeBetween(Integer value1, Integer value2) {
            addCriterion("UTYPE between", value1, value2, "utype");
            return (Criteria) this;
        }

        public Criteria andUtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("UTYPE not between", value1, value2, "utype");
            return (Criteria) this;
        }

        public Criteria andUversionIsNull() {
            addCriterion("UVERSION is null");
            return (Criteria) this;
        }

        public Criteria andUversionIsNotNull() {
            addCriterion("UVERSION is not null");
            return (Criteria) this;
        }

        public Criteria andUversionEqualTo(Integer value) {
            addCriterion("UVERSION =", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionNotEqualTo(Integer value) {
            addCriterion("UVERSION <>", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionGreaterThan(Integer value) {
            addCriterion("UVERSION >", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionGreaterThanOrEqualTo(Integer value) {
            addCriterion("UVERSION >=", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionLessThan(Integer value) {
            addCriterion("UVERSION <", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionLessThanOrEqualTo(Integer value) {
            addCriterion("UVERSION <=", value, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionIn(List<Integer> values) {
            addCriterion("UVERSION in", values, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionNotIn(List<Integer> values) {
            addCriterion("UVERSION not in", values, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionBetween(Integer value1, Integer value2) {
            addCriterion("UVERSION between", value1, value2, "uversion");
            return (Criteria) this;
        }

        public Criteria andUversionNotBetween(Integer value1, Integer value2) {
            addCriterion("UVERSION not between", value1, value2, "uversion");
            return (Criteria) this;
        }

        public Criteria andKeypathIsNull() {
            addCriterion("KEYPATH is null");
            return (Criteria) this;
        }

        public Criteria andKeypathIsNotNull() {
            addCriterion("KEYPATH is not null");
            return (Criteria) this;
        }

        public Criteria andKeypathEqualTo(String value) {
            addCriterion("KEYPATH =", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathNotEqualTo(String value) {
            addCriterion("KEYPATH <>", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathGreaterThan(String value) {
            addCriterion("KEYPATH >", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathGreaterThanOrEqualTo(String value) {
            addCriterion("KEYPATH >=", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathLessThan(String value) {
            addCriterion("KEYPATH <", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathLessThanOrEqualTo(String value) {
            addCriterion("KEYPATH <=", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathLike(String value) {
            addCriterion("KEYPATH like", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathNotLike(String value) {
            addCriterion("KEYPATH not like", value, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathIn(List<String> values) {
            addCriterion("KEYPATH in", values, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathNotIn(List<String> values) {
            addCriterion("KEYPATH not in", values, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathBetween(String value1, String value2) {
            addCriterion("KEYPATH between", value1, value2, "keypath");
            return (Criteria) this;
        }

        public Criteria andKeypathNotBetween(String value1, String value2) {
            addCriterion("KEYPATH not between", value1, value2, "keypath");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNull() {
            addCriterion("EXPIREDATE is null");
            return (Criteria) this;
        }

        public Criteria andExpiredateIsNotNull() {
            addCriterion("EXPIREDATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredateEqualTo(Date value) {
            addCriterionForJDBCDate("EXPIREDATE =", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EXPIREDATE <>", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("EXPIREDATE >", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXPIREDATE >=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThan(Date value) {
            addCriterionForJDBCDate("EXPIREDATE <", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXPIREDATE <=", value, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateIn(List<Date> values) {
            addCriterionForJDBCDate("EXPIREDATE in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EXPIREDATE not in", values, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXPIREDATE between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andExpiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXPIREDATE not between", value1, value2, "expiredate");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andConaccountIsNull() {
            addCriterion("CONACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andConaccountIsNotNull() {
            addCriterion("CONACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andConaccountEqualTo(String value) {
            addCriterion("CONACCOUNT =", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountNotEqualTo(String value) {
            addCriterion("CONACCOUNT <>", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountGreaterThan(String value) {
            addCriterion("CONACCOUNT >", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountGreaterThanOrEqualTo(String value) {
            addCriterion("CONACCOUNT >=", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountLessThan(String value) {
            addCriterion("CONACCOUNT <", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountLessThanOrEqualTo(String value) {
            addCriterion("CONACCOUNT <=", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountLike(String value) {
            addCriterion("CONACCOUNT like", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountNotLike(String value) {
            addCriterion("CONACCOUNT not like", value, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountIn(List<String> values) {
            addCriterion("CONACCOUNT in", values, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountNotIn(List<String> values) {
            addCriterion("CONACCOUNT not in", values, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountBetween(String value1, String value2) {
            addCriterion("CONACCOUNT between", value1, value2, "conaccount");
            return (Criteria) this;
        }

        public Criteria andConaccountNotBetween(String value1, String value2) {
            addCriterion("CONACCOUNT not between", value1, value2, "conaccount");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNull() {
            addCriterion("APPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("APPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(String value) {
            addCriterion("APPTYPE =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(String value) {
            addCriterion("APPTYPE <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(String value) {
            addCriterion("APPTYPE >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPTYPE >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(String value) {
            addCriterion("APPTYPE <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(String value) {
            addCriterion("APPTYPE <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLike(String value) {
            addCriterion("APPTYPE like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotLike(String value) {
            addCriterion("APPTYPE not like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<String> values) {
            addCriterion("APPTYPE in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<String> values) {
            addCriterion("APPTYPE not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(String value1, String value2) {
            addCriterion("APPTYPE between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(String value1, String value2) {
            addCriterion("APPTYPE not between", value1, value2, "apptype");
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

        public Criteria andOptaccountIsNull() {
            addCriterion("OPTACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOptaccountIsNotNull() {
            addCriterion("OPTACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOptaccountEqualTo(String value) {
            addCriterion("OPTACCOUNT =", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountNotEqualTo(String value) {
            addCriterion("OPTACCOUNT <>", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountGreaterThan(String value) {
            addCriterion("OPTACCOUNT >", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountGreaterThanOrEqualTo(String value) {
            addCriterion("OPTACCOUNT >=", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountLessThan(String value) {
            addCriterion("OPTACCOUNT <", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountLessThanOrEqualTo(String value) {
            addCriterion("OPTACCOUNT <=", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountLike(String value) {
            addCriterion("OPTACCOUNT like", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountNotLike(String value) {
            addCriterion("OPTACCOUNT not like", value, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountIn(List<String> values) {
            addCriterion("OPTACCOUNT in", values, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountNotIn(List<String> values) {
            addCriterion("OPTACCOUNT not in", values, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountBetween(String value1, String value2) {
            addCriterion("OPTACCOUNT between", value1, value2, "optaccount");
            return (Criteria) this;
        }

        public Criteria andOptaccountNotBetween(String value1, String value2) {
            addCriterion("OPTACCOUNT not between", value1, value2, "optaccount");
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

        public Criteria andRc4EqualTo(String value) {
            addCriterion("RC4 =", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotEqualTo(String value) {
            addCriterion("RC4 <>", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThan(String value) {
            addCriterion("RC4 >", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4GreaterThanOrEqualTo(String value) {
            addCriterion("RC4 >=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThan(String value) {
            addCriterion("RC4 <", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4LessThanOrEqualTo(String value) {
            addCriterion("RC4 <=", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Like(String value) {
            addCriterion("RC4 like", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotLike(String value) {
            addCriterion("RC4 not like", value, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4In(List<String> values) {
            addCriterion("RC4 in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotIn(List<String> values) {
            addCriterion("RC4 not in", values, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4Between(String value1, String value2) {
            addCriterion("RC4 between", value1, value2, "rc4");
            return (Criteria) this;
        }

        public Criteria andRc4NotBetween(String value1, String value2) {
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

        public Criteria andRc5EqualTo(String value) {
            addCriterion("RC5 =", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotEqualTo(String value) {
            addCriterion("RC5 <>", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThan(String value) {
            addCriterion("RC5 >", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThanOrEqualTo(String value) {
            addCriterion("RC5 >=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThan(String value) {
            addCriterion("RC5 <", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThanOrEqualTo(String value) {
            addCriterion("RC5 <=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Like(String value) {
            addCriterion("RC5 like", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotLike(String value) {
            addCriterion("RC5 not like", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5In(List<String> values) {
            addCriterion("RC5 in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotIn(List<String> values) {
            addCriterion("RC5 not in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Between(String value1, String value2) {
            addCriterion("RC5 between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotBetween(String value1, String value2) {
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
            addCriterionForJDBCDate("RC6 =", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotEqualTo(Date value) {
            addCriterionForJDBCDate("RC6 <>", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThan(Date value) {
            addCriterionForJDBCDate("RC6 >", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RC6 >=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThan(Date value) {
            addCriterionForJDBCDate("RC6 <", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RC6 <=", value, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6In(List<Date> values) {
            addCriterionForJDBCDate("RC6 in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotIn(List<Date> values) {
            addCriterionForJDBCDate("RC6 not in", values, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6Between(Date value1, Date value2) {
            addCriterionForJDBCDate("RC6 between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andRc6NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RC6 not between", value1, value2, "rc6");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andAccountLikeInsensitive(String value) {
            addCriterion("upper(ACCOUNT) like", value.toUpperCase(), "account");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(NAME) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(REMARKS) like", value.toUpperCase(), "remarks");
            return (Criteria) this;
        }

        public Criteria andPasswordLikeInsensitive(String value) {
            addCriterion("upper(PASSWORD) like", value.toUpperCase(), "password");
            return (Criteria) this;
        }

        public Criteria andIpLikeInsensitive(String value) {
            addCriterion("upper(IP) like", value.toUpperCase(), "ip");
            return (Criteria) this;
        }

        public Criteria andMacLikeInsensitive(String value) {
            addCriterion("upper(MAC) like", value.toUpperCase(), "mac");
            return (Criteria) this;
        }

        public Criteria andLastipLikeInsensitive(String value) {
            addCriterion("upper(LASTIP) like", value.toUpperCase(), "lastip");
            return (Criteria) this;
        }

        public Criteria andLastmacLikeInsensitive(String value) {
            addCriterion("upper(LASTMAC) like", value.toUpperCase(), "lastmac");
            return (Criteria) this;
        }

        public Criteria andIcnLikeInsensitive(String value) {
            addCriterion("upper(ICN) like", value.toUpperCase(), "icn");
            return (Criteria) this;
        }

        public Criteria andUnitcodeLikeInsensitive(String value) {
            addCriterion("upper(UNITCODE) like", value.toUpperCase(), "unitcode");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andKeypathLikeInsensitive(String value) {
            addCriterion("upper(KEYPATH) like", value.toUpperCase(), "keypath");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andConaccountLikeInsensitive(String value) {
            addCriterion("upper(CONACCOUNT) like", value.toUpperCase(), "conaccount");
            return (Criteria) this;
        }

        public Criteria andApptypeLikeInsensitive(String value) {
            addCriterion("upper(APPTYPE) like", value.toUpperCase(), "apptype");
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

        public Criteria andOptaccountLikeInsensitive(String value) {
            addCriterion("upper(OPTACCOUNT) like", value.toUpperCase(), "optaccount");
            return (Criteria) this;
        }

        public Criteria andRc4LikeInsensitive(String value) {
            addCriterion("upper(RC4) like", value.toUpperCase(), "rc4");
            return (Criteria) this;
        }

        public Criteria andRc5LikeInsensitive(String value) {
            addCriterion("upper(RC5) like", value.toUpperCase(), "rc5");
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