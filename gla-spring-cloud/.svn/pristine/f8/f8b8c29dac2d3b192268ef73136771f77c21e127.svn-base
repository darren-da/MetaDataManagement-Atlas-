package com.gla.datacenter.util;

import com.gla.datacenter.domain.DBSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Description: 动态数据源
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/3/27 20:51
 */
public class JdbcTemplateDynamic {
    DriverManagerDataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public JdbcTemplateDynamic(DBSource dbSource) {
        //        设置数据库信息
        this.dataSource = new DriverManagerDataSource();
        this.dataSource.setDriverClassName(dbSource.getDriverClassName());
        this.dataSource.setUrl(dbSource.getUrl());
        this.dataSource.setUsername(dbSource.getUsername());
        this.dataSource.setPassword(dbSource.getPassword());
        //    设置数据源
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
