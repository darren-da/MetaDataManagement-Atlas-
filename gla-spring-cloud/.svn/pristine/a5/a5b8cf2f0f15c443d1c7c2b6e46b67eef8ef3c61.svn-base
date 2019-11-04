package com.gla.datacenter.service;

import com.gla.datacenter.domain.DBSource;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 数据抽取转化加载
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:46
 */
public interface ETLService   {

    @Transactional
    boolean loadDBTable(String nodeId);

    boolean testConn(DBSource dbSource);
}
