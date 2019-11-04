package com.limp.framework.boss.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public BlogExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
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

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
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

        public Criteria andOrdernoIsNull() {
            addCriterion("ORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("ORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(Integer value) {
            addCriterion("ORDERNO =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(Integer value) {
            addCriterion("ORDERNO <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(Integer value) {
            addCriterion("ORDERNO >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERNO >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(Integer value) {
            addCriterion("ORDERNO <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERNO <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<Integer> values) {
            addCriterion("ORDERNO in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<Integer> values) {
            addCriterion("ORDERNO not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(Integer value1, Integer value2) {
            addCriterion("ORDERNO between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERNO not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("TAGS is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("TAGS is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("TAGS =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("TAGS <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("TAGS >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("TAGS >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("TAGS <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("TAGS <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("TAGS like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("TAGS not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("TAGS in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("TAGS not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("TAGS between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("TAGS not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andCatanameIsNull() {
            addCriterion("CATANAME is null");
            return (Criteria) this;
        }

        public Criteria andCatanameIsNotNull() {
            addCriterion("CATANAME is not null");
            return (Criteria) this;
        }

        public Criteria andCatanameEqualTo(String value) {
            addCriterion("CATANAME =", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameNotEqualTo(String value) {
            addCriterion("CATANAME <>", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameGreaterThan(String value) {
            addCriterion("CATANAME >", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameGreaterThanOrEqualTo(String value) {
            addCriterion("CATANAME >=", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameLessThan(String value) {
            addCriterion("CATANAME <", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameLessThanOrEqualTo(String value) {
            addCriterion("CATANAME <=", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameLike(String value) {
            addCriterion("CATANAME like", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameNotLike(String value) {
            addCriterion("CATANAME not like", value, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameIn(List<String> values) {
            addCriterion("CATANAME in", values, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameNotIn(List<String> values) {
            addCriterion("CATANAME not in", values, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameBetween(String value1, String value2) {
            addCriterion("CATANAME between", value1, value2, "cataname");
            return (Criteria) this;
        }

        public Criteria andCatanameNotBetween(String value1, String value2) {
            addCriterion("CATANAME not between", value1, value2, "cataname");
            return (Criteria) this;
        }

        public Criteria andTitlemd5IsNull() {
            addCriterion("TITLEMD5 is null");
            return (Criteria) this;
        }

        public Criteria andTitlemd5IsNotNull() {
            addCriterion("TITLEMD5 is not null");
            return (Criteria) this;
        }

        public Criteria andTitlemd5EqualTo(String value) {
            addCriterion("TITLEMD5 =", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5NotEqualTo(String value) {
            addCriterion("TITLEMD5 <>", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5GreaterThan(String value) {
            addCriterion("TITLEMD5 >", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5GreaterThanOrEqualTo(String value) {
            addCriterion("TITLEMD5 >=", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5LessThan(String value) {
            addCriterion("TITLEMD5 <", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5LessThanOrEqualTo(String value) {
            addCriterion("TITLEMD5 <=", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5Like(String value) {
            addCriterion("TITLEMD5 like", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5NotLike(String value) {
            addCriterion("TITLEMD5 not like", value, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5In(List<String> values) {
            addCriterion("TITLEMD5 in", values, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5NotIn(List<String> values) {
            addCriterion("TITLEMD5 not in", values, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5Between(String value1, String value2) {
            addCriterion("TITLEMD5 between", value1, value2, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andTitlemd5NotBetween(String value1, String value2) {
            addCriterion("TITLEMD5 not between", value1, value2, "titlemd5");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIsNull() {
            addCriterion("BLOG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIsNotNull() {
            addCriterion("BLOG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeEqualTo(Integer value) {
            addCriterion("BLOG_TYPE =", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotEqualTo(Integer value) {
            addCriterion("BLOG_TYPE <>", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThan(Integer value) {
            addCriterion("BLOG_TYPE >", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BLOG_TYPE >=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThan(Integer value) {
            addCriterion("BLOG_TYPE <", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BLOG_TYPE <=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIn(List<Integer> values) {
            addCriterion("BLOG_TYPE in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotIn(List<Integer> values) {
            addCriterion("BLOG_TYPE not in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_TYPE between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BLOG_TYPE not between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIsNull() {
            addCriterion("SOURCE_URL is null");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIsNotNull() {
            addCriterion("SOURCE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andSourceUrlEqualTo(String value) {
            addCriterion("SOURCE_URL =", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotEqualTo(String value) {
            addCriterion("SOURCE_URL <>", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlGreaterThan(String value) {
            addCriterion("SOURCE_URL >", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_URL >=", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLessThan(String value) {
            addCriterion("SOURCE_URL <", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_URL <=", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLike(String value) {
            addCriterion("SOURCE_URL like", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotLike(String value) {
            addCriterion("SOURCE_URL not like", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIn(List<String> values) {
            addCriterion("SOURCE_URL in", values, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotIn(List<String> values) {
            addCriterion("SOURCE_URL not in", values, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlBetween(String value1, String value2) {
            addCriterion("SOURCE_URL between", value1, value2, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotBetween(String value1, String value2) {
            addCriterion("SOURCE_URL not between", value1, value2, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorIsNull() {
            addCriterion("SOURCE_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorIsNotNull() {
            addCriterion("SOURCE_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorEqualTo(String value) {
            addCriterion("SOURCE_AUTHOR =", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorNotEqualTo(String value) {
            addCriterion("SOURCE_AUTHOR <>", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorGreaterThan(String value) {
            addCriterion("SOURCE_AUTHOR >", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_AUTHOR >=", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorLessThan(String value) {
            addCriterion("SOURCE_AUTHOR <", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_AUTHOR <=", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorLike(String value) {
            addCriterion("SOURCE_AUTHOR like", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorNotLike(String value) {
            addCriterion("SOURCE_AUTHOR not like", value, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorIn(List<String> values) {
            addCriterion("SOURCE_AUTHOR in", values, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorNotIn(List<String> values) {
            addCriterion("SOURCE_AUTHOR not in", values, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorBetween(String value1, String value2) {
            addCriterion("SOURCE_AUTHOR between", value1, value2, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorNotBetween(String value1, String value2) {
            addCriterion("SOURCE_AUTHOR not between", value1, value2, "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoIsNull() {
            addCriterion("SOURCE_READNO is null");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoIsNotNull() {
            addCriterion("SOURCE_READNO is not null");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoEqualTo(Integer value) {
            addCriterion("SOURCE_READNO =", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoNotEqualTo(Integer value) {
            addCriterion("SOURCE_READNO <>", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoGreaterThan(Integer value) {
            addCriterion("SOURCE_READNO >", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_READNO >=", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoLessThan(Integer value) {
            addCriterion("SOURCE_READNO <", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_READNO <=", value, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoIn(List<Integer> values) {
            addCriterion("SOURCE_READNO in", values, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoNotIn(List<Integer> values) {
            addCriterion("SOURCE_READNO not in", values, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_READNO between", value1, value2, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andSourceReadnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_READNO not between", value1, value2, "sourceReadno");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIsNull() {
            addCriterion("COVER_IMG_PATH is null");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIsNotNull() {
            addCriterion("COVER_IMG_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathEqualTo(String value) {
            addCriterion("COVER_IMG_PATH =", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotEqualTo(String value) {
            addCriterion("COVER_IMG_PATH <>", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathGreaterThan(String value) {
            addCriterion("COVER_IMG_PATH >", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("COVER_IMG_PATH >=", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLessThan(String value) {
            addCriterion("COVER_IMG_PATH <", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLessThanOrEqualTo(String value) {
            addCriterion("COVER_IMG_PATH <=", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLike(String value) {
            addCriterion("COVER_IMG_PATH like", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotLike(String value) {
            addCriterion("COVER_IMG_PATH not like", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIn(List<String> values) {
            addCriterion("COVER_IMG_PATH in", values, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotIn(List<String> values) {
            addCriterion("COVER_IMG_PATH not in", values, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathBetween(String value1, String value2) {
            addCriterion("COVER_IMG_PATH between", value1, value2, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotBetween(String value1, String value2) {
            addCriterion("COVER_IMG_PATH not between", value1, value2, "coverImgPath");
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

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(TITLE) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andIntroLikeInsensitive(String value) {
            addCriterion("upper(INTRO) like", value.toUpperCase(), "intro");
            return (Criteria) this;
        }

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(USERID) like", value.toUpperCase(), "userid");
            return (Criteria) this;
        }

        public Criteria andTagsLikeInsensitive(String value) {
            addCriterion("upper(TAGS) like", value.toUpperCase(), "tags");
            return (Criteria) this;
        }

        public Criteria andCatanameLikeInsensitive(String value) {
            addCriterion("upper(CATANAME) like", value.toUpperCase(), "cataname");
            return (Criteria) this;
        }

        public Criteria andTitlemd5LikeInsensitive(String value) {
            addCriterion("upper(TITLEMD5) like", value.toUpperCase(), "titlemd5");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLikeInsensitive(String value) {
            addCriterion("upper(SOURCE_URL) like", value.toUpperCase(), "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceAuthorLikeInsensitive(String value) {
            addCriterion("upper(SOURCE_AUTHOR) like", value.toUpperCase(), "sourceAuthor");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLikeInsensitive(String value) {
            addCriterion("upper(COVER_IMG_PATH) like", value.toUpperCase(), "coverImgPath");
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