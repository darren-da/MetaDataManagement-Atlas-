package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RcsResourceCateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public RcsResourceCateExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
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

        public Criteria andCodeOrNameLike(String value){
            String str = "";
            str += "CODE like '" + value +"' OR NAME LIKE '" + value +"'";
            addCriterion("( " + str + " ) AND 1=","1","value");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andPcodeIsNull() {
            addCriterion("PCODE is null");
            return (Criteria) this;
        }

        public Criteria andPcodeIsNotNull() {
            addCriterion("PCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPcodeEqualTo(String value) {
            addCriterion("PCODE =", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotEqualTo(String value) {
            addCriterion("PCODE <>", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeGreaterThan(String value) {
            addCriterion("PCODE >", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PCODE >=", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLessThan(String value) {
            addCriterion("PCODE <", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLessThanOrEqualTo(String value) {
            addCriterion("PCODE <=", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLike(String value) {
            addCriterion("PCODE like", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotLike(String value) {
            addCriterion("PCODE not like", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeIn(List<String> values) {
            addCriterion("PCODE in", values, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotIn(List<String> values) {
            addCriterion("PCODE not in", values, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeBetween(String value1, String value2) {
            addCriterion("PCODE between", value1, value2, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotBetween(String value1, String value2) {
            addCriterion("PCODE not between", value1, value2, "pcode");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNull() {
            addCriterion("PROVIDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNotNull() {
            addCriterion("PROVIDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProviderNameEqualTo(String value) {
            addCriterion("PROVIDER_NAME =", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotEqualTo(String value) {
            addCriterion("PROVIDER_NAME <>", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThan(String value) {
            addCriterion("PROVIDER_NAME >", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER_NAME >=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThan(String value) {
            addCriterion("PROVIDER_NAME <", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER_NAME <=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLike(String value) {
            addCriterion("PROVIDER_NAME like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotLike(String value) {
            addCriterion("PROVIDER_NAME not like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameIn(List<String> values) {
            addCriterion("PROVIDER_NAME in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotIn(List<String> values) {
            addCriterion("PROVIDER_NAME not in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameBetween(String value1, String value2) {
            addCriterion("PROVIDER_NAME between", value1, value2, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotBetween(String value1, String value2) {
            addCriterion("PROVIDER_NAME not between", value1, value2, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderCodeIsNull() {
            addCriterion("PROVIDER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProviderCodeIsNotNull() {
            addCriterion("PROVIDER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProviderCodeEqualTo(String value) {
            addCriterion("PROVIDER_CODE =", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotEqualTo(String value) {
            addCriterion("PROVIDER_CODE <>", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeGreaterThan(String value) {
            addCriterion("PROVIDER_CODE >", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER_CODE >=", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLessThan(String value) {
            addCriterion("PROVIDER_CODE <", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER_CODE <=", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLike(String value) {
            addCriterion("PROVIDER_CODE like", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotLike(String value) {
            addCriterion("PROVIDER_CODE not like", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeIn(List<String> values) {
            addCriterion("PROVIDER_CODE in", values, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotIn(List<String> values) {
            addCriterion("PROVIDER_CODE not in", values, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeBetween(String value1, String value2) {
            addCriterion("PROVIDER_CODE between", value1, value2, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotBetween(String value1, String value2) {
            addCriterion("PROVIDER_CODE not between", value1, value2, "providerCode");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("INTRO is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("INTRO =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("INTRO <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("INTRO >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("INTRO >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("INTRO <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("INTRO <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("INTRO like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("INTRO not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("INTRO in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("INTRO not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("INTRO between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("INTRO not between", value1, value2, "intro");
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

        public Criteria andShareTypeEqualTo(Integer value) {
            addCriterion("SHARE_TYPE =", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotEqualTo(Integer value) {
            addCriterion("SHARE_TYPE <>", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThan(Integer value) {
            addCriterion("SHARE_TYPE >", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHARE_TYPE >=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThan(Integer value) {
            addCriterion("SHARE_TYPE <", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SHARE_TYPE <=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeIn(List<Integer> values) {
            addCriterion("SHARE_TYPE in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotIn(List<Integer> values) {
            addCriterion("SHARE_TYPE not in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeBetween(Integer value1, Integer value2) {
            addCriterion("SHARE_TYPE between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SHARE_TYPE not between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareIntroIsNull() {
            addCriterion("SHARE_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andShareIntroIsNotNull() {
            addCriterion("SHARE_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andShareIntroEqualTo(String value) {
            addCriterion("SHARE_INTRO =", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotEqualTo(String value) {
            addCriterion("SHARE_INTRO <>", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroGreaterThan(String value) {
            addCriterion("SHARE_INTRO >", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_INTRO >=", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLessThan(String value) {
            addCriterion("SHARE_INTRO <", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLessThanOrEqualTo(String value) {
            addCriterion("SHARE_INTRO <=", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLike(String value) {
            addCriterion("SHARE_INTRO like", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotLike(String value) {
            addCriterion("SHARE_INTRO not like", value, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroIn(List<String> values) {
            addCriterion("SHARE_INTRO in", values, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotIn(List<String> values) {
            addCriterion("SHARE_INTRO not in", values, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroBetween(String value1, String value2) {
            addCriterion("SHARE_INTRO between", value1, value2, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareIntroNotBetween(String value1, String value2) {
            addCriterion("SHARE_INTRO not between", value1, value2, "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareModeIsNull() {
            addCriterion("SHARE_MODE is null");
            return (Criteria) this;
        }

        public Criteria andShareModeIsNotNull() {
            addCriterion("SHARE_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andShareModeEqualTo(String value) {
            addCriterion("SHARE_MODE =", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeNotEqualTo(String value) {
            addCriterion("SHARE_MODE <>", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeGreaterThan(String value) {
            addCriterion("SHARE_MODE >", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_MODE >=", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeLessThan(String value) {
            addCriterion("SHARE_MODE <", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeLessThanOrEqualTo(String value) {
            addCriterion("SHARE_MODE <=", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeLike(String value) {
            addCriterion("SHARE_MODE like", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeNotLike(String value) {
            addCriterion("SHARE_MODE not like", value, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeIn(List<String> values) {
            addCriterion("SHARE_MODE in", values, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeNotIn(List<String> values) {
            addCriterion("SHARE_MODE not in", values, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeBetween(String value1, String value2) {
            addCriterion("SHARE_MODE between", value1, value2, "shareMode");
            return (Criteria) this;
        }

        public Criteria andShareModeNotBetween(String value1, String value2) {
            addCriterion("SHARE_MODE not between", value1, value2, "shareMode");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIsNull() {
            addCriterion("OPEN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIsNotNull() {
            addCriterion("OPEN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeEqualTo(Integer value) {
            addCriterion("OPEN_TYPE =", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotEqualTo(Integer value) {
            addCriterion("OPEN_TYPE <>", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThan(Integer value) {
            addCriterion("OPEN_TYPE >", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPEN_TYPE >=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThan(Integer value) {
            addCriterion("OPEN_TYPE <", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OPEN_TYPE <=", value, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIn(List<Integer> values) {
            addCriterion("OPEN_TYPE in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotIn(List<Integer> values) {
            addCriterion("OPEN_TYPE not in", values, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeBetween(Integer value1, Integer value2) {
            addCriterion("OPEN_TYPE between", value1, value2, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OPEN_TYPE not between", value1, value2, "openType");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroIsNull() {
            addCriterion("OPEN_TYPE_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroIsNotNull() {
            addCriterion("OPEN_TYPE_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroEqualTo(String value) {
            addCriterion("OPEN_TYPE_INTRO =", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroNotEqualTo(String value) {
            addCriterion("OPEN_TYPE_INTRO <>", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroGreaterThan(String value) {
            addCriterion("OPEN_TYPE_INTRO >", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_TYPE_INTRO >=", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroLessThan(String value) {
            addCriterion("OPEN_TYPE_INTRO <", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroLessThanOrEqualTo(String value) {
            addCriterion("OPEN_TYPE_INTRO <=", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroLike(String value) {
            addCriterion("OPEN_TYPE_INTRO like", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroNotLike(String value) {
            addCriterion("OPEN_TYPE_INTRO not like", value, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroIn(List<String> values) {
            addCriterion("OPEN_TYPE_INTRO in", values, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroNotIn(List<String> values) {
            addCriterion("OPEN_TYPE_INTRO not in", values, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroBetween(String value1, String value2) {
            addCriterion("OPEN_TYPE_INTRO between", value1, value2, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroNotBetween(String value1, String value2) {
            addCriterion("OPEN_TYPE_INTRO not between", value1, value2, "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNull() {
            addCriterion("PUBLISH_ID is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("PUBLISH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(String value) {
            addCriterion("PUBLISH_ID =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(String value) {
            addCriterion("PUBLISH_ID <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(String value) {
            addCriterion("PUBLISH_ID >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_ID >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(String value) {
            addCriterion("PUBLISH_ID <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_ID <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLike(String value) {
            addCriterion("PUBLISH_ID like", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotLike(String value) {
            addCriterion("PUBLISH_ID not like", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<String> values) {
            addCriterion("PUBLISH_ID in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<String> values) {
            addCriterion("PUBLISH_ID not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(String value1, String value2) {
            addCriterion("PUBLISH_ID between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_ID not between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleIsNull() {
            addCriterion("UPDATE_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleIsNotNull() {
            addCriterion("UPDATE_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleEqualTo(Integer value) {
            addCriterion("UPDATE_CYCLE =", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleNotEqualTo(Integer value) {
            addCriterion("UPDATE_CYCLE <>", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleGreaterThan(Integer value) {
            addCriterion("UPDATE_CYCLE >", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_CYCLE >=", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleLessThan(Integer value) {
            addCriterion("UPDATE_CYCLE <", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleLessThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_CYCLE <=", value, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleIn(List<Integer> values) {
            addCriterion("UPDATE_CYCLE in", values, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleNotIn(List<Integer> values) {
            addCriterion("UPDATE_CYCLE not in", values, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_CYCLE between", value1, value2, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andUpdateCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_CYCLE not between", value1, value2, "updateCycle");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("PUBLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("PUBLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBLISH_DATE <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterionForJDBCDate("PUBLISH_DATE in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PUBLISH_DATE not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBLISH_DATE between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBLISH_DATE not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIsNull() {
            addCriterion("DRAFT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIsNotNull() {
            addCriterion("DRAFT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDraftTypeEqualTo(Integer value) {
            addCriterion("DRAFT_TYPE =", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotEqualTo(Integer value) {
            addCriterion("DRAFT_TYPE <>", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeGreaterThan(Integer value) {
            addCriterion("DRAFT_TYPE >", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRAFT_TYPE >=", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeLessThan(Integer value) {
            addCriterion("DRAFT_TYPE <", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeLessThanOrEqualTo(Integer value) {
            addCriterion("DRAFT_TYPE <=", value, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeIn(List<Integer> values) {
            addCriterion("DRAFT_TYPE in", values, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotIn(List<Integer> values) {
            addCriterion("DRAFT_TYPE not in", values, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeBetween(Integer value1, Integer value2) {
            addCriterion("DRAFT_TYPE between", value1, value2, "draftType");
            return (Criteria) this;
        }

        public Criteria andDraftTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DRAFT_TYPE not between", value1, value2, "draftType");
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

        public Criteria andLvIsNull() {
            addCriterion("LV is null");
            return (Criteria) this;
        }

        public Criteria andLvIsNotNull() {
            addCriterion("LV is not null");
            return (Criteria) this;
        }

        public Criteria andLvEqualTo(Integer value) {
            addCriterion("LV =", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotEqualTo(Integer value) {
            addCriterion("LV <>", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThan(Integer value) {
            addCriterion("LV >", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThanOrEqualTo(Integer value) {
            addCriterion("LV >=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThan(Integer value) {
            addCriterion("LV <", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThanOrEqualTo(Integer value) {
            addCriterion("LV <=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvIn(List<Integer> values) {
            addCriterion("LV in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotIn(List<Integer> values) {
            addCriterion("LV not in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvBetween(Integer value1, Integer value2) {
            addCriterion("LV between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotBetween(Integer value1, Integer value2) {
            addCriterion("LV not between", value1, value2, "lv");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSortNumIsNull() {
            addCriterion("SORT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSortNumIsNotNull() {
            addCriterion("SORT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSortNumEqualTo(Integer value) {
            addCriterion("SORT_NUM =", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotEqualTo(Integer value) {
            addCriterion("SORT_NUM <>", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumGreaterThan(Integer value) {
            addCriterion("SORT_NUM >", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT_NUM >=", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumLessThan(Integer value) {
            addCriterion("SORT_NUM <", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumLessThanOrEqualTo(Integer value) {
            addCriterion("SORT_NUM <=", value, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumIn(List<Integer> values) {
            addCriterion("SORT_NUM in", values, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotIn(List<Integer> values) {
            addCriterion("SORT_NUM not in", values, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumBetween(Integer value1, Integer value2) {
            addCriterion("SORT_NUM between", value1, value2, "sortNum");
            return (Criteria) this;
        }

        public Criteria andSortNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT_NUM not between", value1, value2, "sortNum");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("KEY_WORD is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("KEY_WORD is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("KEY_WORD =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("KEY_WORD <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("KEY_WORD >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_WORD >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("KEY_WORD <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("KEY_WORD <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("KEY_WORD like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("KEY_WORD not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("KEY_WORD in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("KEY_WORD not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("KEY_WORD between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("KEY_WORD not between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andPcodesIsNull() {
            addCriterion("PCODES is null");
            return (Criteria) this;
        }

        public Criteria andPcodesIsNotNull() {
            addCriterion("PCODES is not null");
            return (Criteria) this;
        }

        public Criteria andPcodesEqualTo(String value) {
            addCriterion("PCODES =", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesNotEqualTo(String value) {
            addCriterion("PCODES <>", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesGreaterThan(String value) {
            addCriterion("PCODES >", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesGreaterThanOrEqualTo(String value) {
            addCriterion("PCODES >=", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesLessThan(String value) {
            addCriterion("PCODES <", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesLessThanOrEqualTo(String value) {
            addCriterion("PCODES <=", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesLike(String value) {
            addCriterion("PCODES like", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesNotLike(String value) {
            addCriterion("PCODES not like", value, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesIn(List<String> values) {
            addCriterion("PCODES in", values, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesNotIn(List<String> values) {
            addCriterion("PCODES not in", values, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesBetween(String value1, String value2) {
            addCriterion("PCODES between", value1, value2, "pcodes");
            return (Criteria) this;
        }

        public Criteria andPcodesNotBetween(String value1, String value2) {
            addCriterion("PCODES not between", value1, value2, "pcodes");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(NAME) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(CODE) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andPcodeLikeInsensitive(String value) {
            addCriterion("upper(PCODE) like", value.toUpperCase(), "pcode");
            return (Criteria) this;
        }

        public Criteria andProviderNameLikeInsensitive(String value) {
            addCriterion("upper(PROVIDER_NAME) like", value.toUpperCase(), "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLikeInsensitive(String value) {
            addCriterion("upper(PROVIDER_CODE) like", value.toUpperCase(), "providerCode");
            return (Criteria) this;
        }

        public Criteria andIntroLikeInsensitive(String value) {
            addCriterion("upper(INTRO) like", value.toUpperCase(), "intro");
            return (Criteria) this;
        }

        public Criteria andShareIntroLikeInsensitive(String value) {
            addCriterion("upper(SHARE_INTRO) like", value.toUpperCase(), "shareIntro");
            return (Criteria) this;
        }

        public Criteria andShareModeLikeInsensitive(String value) {
            addCriterion("upper(SHARE_MODE) like", value.toUpperCase(), "shareMode");
            return (Criteria) this;
        }

        public Criteria andOpenTypeIntroLikeInsensitive(String value) {
            addCriterion("upper(OPEN_TYPE_INTRO) like", value.toUpperCase(), "openTypeIntro");
            return (Criteria) this;
        }

        public Criteria andPublishIdLikeInsensitive(String value) {
            addCriterion("upper(PUBLISH_ID) like", value.toUpperCase(), "publishId");
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

        public Criteria andKeyWordLikeInsensitive(String value) {
            addCriterion("upper(KEY_WORD) like", value.toUpperCase(), "keyWord");
            return (Criteria) this;
        }

        public Criteria andPcodesLikeInsensitive(String value) {
            addCriterion("upper(PCODES) like", value.toUpperCase(), "pcodes");
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