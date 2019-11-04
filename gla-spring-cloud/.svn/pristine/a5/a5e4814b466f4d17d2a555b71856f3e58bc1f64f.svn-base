package com.limp.framework.boss.domain;

import com.limp.framework.core.bean.Pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OperationSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pager page;

    public OperationSettingExample() {
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

        public Criteria andPojoKeyIsNull() {
            addCriterion("POJO_KEY is null");
            return (Criteria) this;
        }

        public Criteria andPojoKeyIsNotNull() {
            addCriterion("POJO_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andPojoKeyEqualTo(String value) {
            addCriterion("POJO_KEY =", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyNotEqualTo(String value) {
            addCriterion("POJO_KEY <>", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyGreaterThan(String value) {
            addCriterion("POJO_KEY >", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyGreaterThanOrEqualTo(String value) {
            addCriterion("POJO_KEY >=", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyLessThan(String value) {
            addCriterion("POJO_KEY <", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyLessThanOrEqualTo(String value) {
            addCriterion("POJO_KEY <=", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyLike(String value) {
            addCriterion("POJO_KEY like", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyNotLike(String value) {
            addCriterion("POJO_KEY not like", value, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyIn(List<String> values) {
            addCriterion("POJO_KEY in", values, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyNotIn(List<String> values) {
            addCriterion("POJO_KEY not in", values, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyBetween(String value1, String value2) {
            addCriterion("POJO_KEY between", value1, value2, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andPojoKeyNotBetween(String value1, String value2) {
            addCriterion("POJO_KEY not between", value1, value2, "pojoKey");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIsNull() {
            addCriterion("BUSSINESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIsNotNull() {
            addCriterion("BUSSINESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessNameEqualTo(String value) {
            addCriterion("BUSSINESS_NAME =", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotEqualTo(String value) {
            addCriterion("BUSSINESS_NAME <>", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameGreaterThan(String value) {
            addCriterion("BUSSINESS_NAME >", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSSINESS_NAME >=", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLessThan(String value) {
            addCriterion("BUSSINESS_NAME <", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLessThanOrEqualTo(String value) {
            addCriterion("BUSSINESS_NAME <=", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLike(String value) {
            addCriterion("BUSSINESS_NAME like", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotLike(String value) {
            addCriterion("BUSSINESS_NAME not like", value, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameIn(List<String> values) {
            addCriterion("BUSSINESS_NAME in", values, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotIn(List<String> values) {
            addCriterion("BUSSINESS_NAME not in", values, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameBetween(String value1, String value2) {
            addCriterion("BUSSINESS_NAME between", value1, value2, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andBussinessNameNotBetween(String value1, String value2) {
            addCriterion("BUSSINESS_NAME not between", value1, value2, "bussinessName");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateIsNull() {
            addCriterion("URL_TEMPLATE is null");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateIsNotNull() {
            addCriterion("URL_TEMPLATE is not null");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateEqualTo(String value) {
            addCriterion("URL_TEMPLATE =", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateNotEqualTo(String value) {
            addCriterion("URL_TEMPLATE <>", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateGreaterThan(String value) {
            addCriterion("URL_TEMPLATE >", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("URL_TEMPLATE >=", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateLessThan(String value) {
            addCriterion("URL_TEMPLATE <", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateLessThanOrEqualTo(String value) {
            addCriterion("URL_TEMPLATE <=", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateLike(String value) {
            addCriterion("URL_TEMPLATE like", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateNotLike(String value) {
            addCriterion("URL_TEMPLATE not like", value, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateIn(List<String> values) {
            addCriterion("URL_TEMPLATE in", values, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateNotIn(List<String> values) {
            addCriterion("URL_TEMPLATE not in", values, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateBetween(String value1, String value2) {
            addCriterion("URL_TEMPLATE between", value1, value2, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateNotBetween(String value1, String value2) {
            addCriterion("URL_TEMPLATE not between", value1, value2, "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateIsNull() {
            addCriterion("FIELD_TEMPLATE is null");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateIsNotNull() {
            addCriterion("FIELD_TEMPLATE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateEqualTo(String value) {
            addCriterion("FIELD_TEMPLATE =", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateNotEqualTo(String value) {
            addCriterion("FIELD_TEMPLATE <>", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateGreaterThan(String value) {
            addCriterion("FIELD_TEMPLATE >", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_TEMPLATE >=", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateLessThan(String value) {
            addCriterion("FIELD_TEMPLATE <", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateLessThanOrEqualTo(String value) {
            addCriterion("FIELD_TEMPLATE <=", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateLike(String value) {
            addCriterion("FIELD_TEMPLATE like", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateNotLike(String value) {
            addCriterion("FIELD_TEMPLATE not like", value, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateIn(List<String> values) {
            addCriterion("FIELD_TEMPLATE in", values, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateNotIn(List<String> values) {
            addCriterion("FIELD_TEMPLATE not in", values, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateBetween(String value1, String value2) {
            addCriterion("FIELD_TEMPLATE between", value1, value2, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateNotBetween(String value1, String value2) {
            addCriterion("FIELD_TEMPLATE not between", value1, value2, "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("LOG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("LOG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Integer value) {
            addCriterion("LOG_TYPE =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Integer value) {
            addCriterion("LOG_TYPE <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Integer value) {
            addCriterion("LOG_TYPE >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOG_TYPE >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Integer value) {
            addCriterion("LOG_TYPE <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOG_TYPE <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Integer> values) {
            addCriterion("LOG_TYPE in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Integer> values) {
            addCriterion("LOG_TYPE not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOG_TYPE between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOG_TYPE not between", value1, value2, "logType");
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

        public Criteria andContentTemplateIsNull() {
            addCriterion("CONTENT_TEMPLATE is null");
            return (Criteria) this;
        }

        public Criteria andContentTemplateIsNotNull() {
            addCriterion("CONTENT_TEMPLATE is not null");
            return (Criteria) this;
        }

        public Criteria andContentTemplateEqualTo(String value) {
            addCriterion("CONTENT_TEMPLATE =", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateNotEqualTo(String value) {
            addCriterion("CONTENT_TEMPLATE <>", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateGreaterThan(String value) {
            addCriterion("CONTENT_TEMPLATE >", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT_TEMPLATE >=", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateLessThan(String value) {
            addCriterion("CONTENT_TEMPLATE <", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateLessThanOrEqualTo(String value) {
            addCriterion("CONTENT_TEMPLATE <=", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateLike(String value) {
            addCriterion("CONTENT_TEMPLATE like", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateNotLike(String value) {
            addCriterion("CONTENT_TEMPLATE not like", value, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateIn(List<String> values) {
            addCriterion("CONTENT_TEMPLATE in", values, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateNotIn(List<String> values) {
            addCriterion("CONTENT_TEMPLATE not in", values, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateBetween(String value1, String value2) {
            addCriterion("CONTENT_TEMPLATE between", value1, value2, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateNotBetween(String value1, String value2) {
            addCriterion("CONTENT_TEMPLATE not between", value1, value2, "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNull() {
            addCriterion("CREATE_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNotNull() {
            addCriterion("CREATE_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountEqualTo(String value) {
            addCriterion("CREATE_ACCOUNT =", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotEqualTo(String value) {
            addCriterion("CREATE_ACCOUNT <>", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThan(String value) {
            addCriterion("CREATE_ACCOUNT >", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_ACCOUNT >=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThan(String value) {
            addCriterion("CREATE_ACCOUNT <", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("CREATE_ACCOUNT <=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLike(String value) {
            addCriterion("CREATE_ACCOUNT like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotLike(String value) {
            addCriterion("CREATE_ACCOUNT not like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIn(List<String> values) {
            addCriterion("CREATE_ACCOUNT in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotIn(List<String> values) {
            addCriterion("CREATE_ACCOUNT not in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountBetween(String value1, String value2) {
            addCriterion("CREATE_ACCOUNT between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotBetween(String value1, String value2) {
            addCriterion("CREATE_ACCOUNT not between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNull() {
            addCriterion("UPDATE_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNotNull() {
            addCriterion("UPDATE_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountEqualTo(String value) {
            addCriterion("UPDATE_ACCOUNT =", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotEqualTo(String value) {
            addCriterion("UPDATE_ACCOUNT <>", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThan(String value) {
            addCriterion("UPDATE_ACCOUNT >", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_ACCOUNT >=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThan(String value) {
            addCriterion("UPDATE_ACCOUNT <", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_ACCOUNT <=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLike(String value) {
            addCriterion("UPDATE_ACCOUNT like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotLike(String value) {
            addCriterion("UPDATE_ACCOUNT not like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIn(List<String> values) {
            addCriterion("UPDATE_ACCOUNT in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotIn(List<String> values) {
            addCriterion("UPDATE_ACCOUNT not in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountBetween(String value1, String value2) {
            addCriterion("UPDATE_ACCOUNT between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotBetween(String value1, String value2) {
            addCriterion("UPDATE_ACCOUNT not between", value1, value2, "updateAccount");
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

        public Criteria andRc5EqualTo(Date value) {
            addCriterionForJDBCDate("RC5 =", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotEqualTo(Date value) {
            addCriterionForJDBCDate("RC5 <>", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThan(Date value) {
            addCriterionForJDBCDate("RC5 >", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RC5 >=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThan(Date value) {
            addCriterionForJDBCDate("RC5 <", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RC5 <=", value, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5In(List<Date> values) {
            addCriterionForJDBCDate("RC5 in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotIn(List<Date> values) {
            addCriterionForJDBCDate("RC5 not in", values, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5Between(Date value1, Date value2) {
            addCriterionForJDBCDate("RC5 between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andRc5NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RC5 not between", value1, value2, "rc5");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andPojoKeyLikeInsensitive(String value) {
            addCriterion("upper(POJO_KEY) like", value.toUpperCase(), "pojoKey");
            return (Criteria) this;
        }

        public Criteria andBussinessNameLikeInsensitive(String value) {
            addCriterion("upper(BUSSINESS_NAME) like", value.toUpperCase(), "bussinessName");
            return (Criteria) this;
        }

        public Criteria andUrlTemplateLikeInsensitive(String value) {
            addCriterion("upper(URL_TEMPLATE) like", value.toUpperCase(), "urlTemplate");
            return (Criteria) this;
        }

        public Criteria andFieldTemplateLikeInsensitive(String value) {
            addCriterion("upper(FIELD_TEMPLATE) like", value.toUpperCase(), "fieldTemplate");
            return (Criteria) this;
        }

        public Criteria andContentTemplateLikeInsensitive(String value) {
            addCriterion("upper(CONTENT_TEMPLATE) like", value.toUpperCase(), "contentTemplate");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLikeInsensitive(String value) {
            addCriterion("upper(CREATE_ACCOUNT) like", value.toUpperCase(), "createAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLikeInsensitive(String value) {
            addCriterion("upper(UPDATE_ACCOUNT) like", value.toUpperCase(), "updateAccount");
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