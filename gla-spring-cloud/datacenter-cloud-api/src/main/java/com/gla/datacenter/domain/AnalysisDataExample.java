package com.gla.datacenter.domain;

import com.limp.framework.core.bean.Pager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalysisDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public AnalysisDataExample() {
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

        public Criteria andRoletypeIsNull() {
            addCriterion("ROLETYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoletypeIsNotNull() {
            addCriterion("ROLETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoletypeEqualTo(String value) {
            addCriterion("ROLETYPE =", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeNotEqualTo(String value) {
            addCriterion("ROLETYPE <>", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeGreaterThan(String value) {
            addCriterion("ROLETYPE >", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLETYPE >=", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeLessThan(String value) {
            addCriterion("ROLETYPE <", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeLessThanOrEqualTo(String value) {
            addCriterion("ROLETYPE <=", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeLike(String value) {
            addCriterion("ROLETYPE like", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeNotLike(String value) {
            addCriterion("ROLETYPE not like", value, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeIn(List<String> values) {
            addCriterion("ROLETYPE in", values, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeNotIn(List<String> values) {
            addCriterion("ROLETYPE not in", values, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeBetween(String value1, String value2) {
            addCriterion("ROLETYPE between", value1, value2, "roletype");
            return (Criteria) this;
        }

        public Criteria andRoletypeNotBetween(String value1, String value2) {
            addCriterion("ROLETYPE not between", value1, value2, "roletype");
            return (Criteria) this;
        }

        public Criteria andApicountsIsNull() {
            addCriterion("APICOUNTS is null");
            return (Criteria) this;
        }

        public Criteria andApicountsIsNotNull() {
            addCriterion("APICOUNTS is not null");
            return (Criteria) this;
        }

        public Criteria andApicountsEqualTo(Integer value) {
            addCriterion("APICOUNTS =", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsNotEqualTo(Integer value) {
            addCriterion("APICOUNTS <>", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsGreaterThan(Integer value) {
            addCriterion("APICOUNTS >", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("APICOUNTS >=", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsLessThan(Integer value) {
            addCriterion("APICOUNTS <", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsLessThanOrEqualTo(Integer value) {
            addCriterion("APICOUNTS <=", value, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsIn(List<Integer> values) {
            addCriterion("APICOUNTS in", values, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsNotIn(List<Integer> values) {
            addCriterion("APICOUNTS not in", values, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsBetween(Integer value1, Integer value2) {
            addCriterion("APICOUNTS between", value1, value2, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApicountsNotBetween(Integer value1, Integer value2) {
            addCriterion("APICOUNTS not between", value1, value2, "apicounts");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsIsNull() {
            addCriterion("APIINVOKINGS is null");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsIsNotNull() {
            addCriterion("APIINVOKINGS is not null");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsEqualTo(Integer value) {
            addCriterion("APIINVOKINGS =", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsNotEqualTo(Integer value) {
            addCriterion("APIINVOKINGS <>", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsGreaterThan(Integer value) {
            addCriterion("APIINVOKINGS >", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsGreaterThanOrEqualTo(Integer value) {
            addCriterion("APIINVOKINGS >=", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsLessThan(Integer value) {
            addCriterion("APIINVOKINGS <", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsLessThanOrEqualTo(Integer value) {
            addCriterion("APIINVOKINGS <=", value, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsIn(List<Integer> values) {
            addCriterion("APIINVOKINGS in", values, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsNotIn(List<Integer> values) {
            addCriterion("APIINVOKINGS not in", values, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsBetween(Integer value1, Integer value2) {
            addCriterion("APIINVOKINGS between", value1, value2, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andApiinvokingsNotBetween(Integer value1, Integer value2) {
            addCriterion("APIINVOKINGS not between", value1, value2, "apiinvokings");
            return (Criteria) this;
        }

        public Criteria andFailtimesIsNull() {
            addCriterion("FAILTIMES is null");
            return (Criteria) this;
        }

        public Criteria andFailtimesIsNotNull() {
            addCriterion("FAILTIMES is not null");
            return (Criteria) this;
        }

        public Criteria andFailtimesEqualTo(Integer value) {
            addCriterion("FAILTIMES =", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesNotEqualTo(Integer value) {
            addCriterion("FAILTIMES <>", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesGreaterThan(Integer value) {
            addCriterion("FAILTIMES >", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAILTIMES >=", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesLessThan(Integer value) {
            addCriterion("FAILTIMES <", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesLessThanOrEqualTo(Integer value) {
            addCriterion("FAILTIMES <=", value, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesIn(List<Integer> values) {
            addCriterion("FAILTIMES in", values, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesNotIn(List<Integer> values) {
            addCriterion("FAILTIMES not in", values, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesBetween(Integer value1, Integer value2) {
            addCriterion("FAILTIMES between", value1, value2, "failtimes");
            return (Criteria) this;
        }

        public Criteria andFailtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("FAILTIMES not between", value1, value2, "failtimes");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsIsNull() {
            addCriterion("APIABNORMALS is null");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsIsNotNull() {
            addCriterion("APIABNORMALS is not null");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsEqualTo(Integer value) {
            addCriterion("APIABNORMALS =", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsNotEqualTo(Integer value) {
            addCriterion("APIABNORMALS <>", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsGreaterThan(Integer value) {
            addCriterion("APIABNORMALS >", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsGreaterThanOrEqualTo(Integer value) {
            addCriterion("APIABNORMALS >=", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsLessThan(Integer value) {
            addCriterion("APIABNORMALS <", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsLessThanOrEqualTo(Integer value) {
            addCriterion("APIABNORMALS <=", value, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsIn(List<Integer> values) {
            addCriterion("APIABNORMALS in", values, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsNotIn(List<Integer> values) {
            addCriterion("APIABNORMALS not in", values, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsBetween(Integer value1, Integer value2) {
            addCriterion("APIABNORMALS between", value1, value2, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andApiabnormalsNotBetween(Integer value1, Integer value2) {
            addCriterion("APIABNORMALS not between", value1, value2, "apiabnormals");
            return (Criteria) this;
        }

        public Criteria andWaittimeIsNull() {
            addCriterion("WAITTIME is null");
            return (Criteria) this;
        }

        public Criteria andWaittimeIsNotNull() {
            addCriterion("WAITTIME is not null");
            return (Criteria) this;
        }

        public Criteria andWaittimeEqualTo(Integer value) {
            addCriterion("WAITTIME =", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeNotEqualTo(Integer value) {
            addCriterion("WAITTIME <>", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeGreaterThan(Integer value) {
            addCriterion("WAITTIME >", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WAITTIME >=", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeLessThan(Integer value) {
            addCriterion("WAITTIME <", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeLessThanOrEqualTo(Integer value) {
            addCriterion("WAITTIME <=", value, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeIn(List<Integer> values) {
            addCriterion("WAITTIME in", values, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeNotIn(List<Integer> values) {
            addCriterion("WAITTIME not in", values, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeBetween(Integer value1, Integer value2) {
            addCriterion("WAITTIME between", value1, value2, "waittime");
            return (Criteria) this;
        }

        public Criteria andWaittimeNotBetween(Integer value1, Integer value2) {
            addCriterion("WAITTIME not between", value1, value2, "waittime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE not between", value1, value2, "score");
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

        public Criteria andBatchIsNull() {
            addCriterion("BATCH is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(Integer value) {
            addCriterion("BATCH =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(Integer value) {
            addCriterion("BATCH <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(Integer value) {
            addCriterion("BATCH >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("BATCH >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(Integer value) {
            addCriterion("BATCH <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(Integer value) {
            addCriterion("BATCH <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<Integer> values) {
            addCriterion("BATCH in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<Integer> values) {
            addCriterion("BATCH not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(Integer value1, Integer value2) {
            addCriterion("BATCH between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(Integer value1, Integer value2) {
            addCriterion("BATCH not between", value1, value2, "batch");
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
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(USERID) like", value.toUpperCase(), "userid");
            return (Criteria) this;
        }

        public Criteria andRoletypeLikeInsensitive(String value) {
            addCriterion("upper(ROLETYPE) like", value.toUpperCase(), "roletype");
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