package com.limp.framework.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/25 13:42
 * @Description: 业务代码静态常量
 */
public class ConstantClazz {

    /** 可用 **/
    public static final byte DELETE_FLAG_FALSE = 0;

    /** 已删除 **/
    public static final byte DELETE_FLAG_TRUE = 1;

    /**----------------api接口类型开始-------------------------**/
    /** rest **/
    public static final byte API_TYPE_HTTP = 0;

    /** webservice **/
    public static final byte API_TYPE_WEBSERVICE = 1;

    /** rpc **/
    public static final byte API_TYPE_RPC = 2;

    /** 转发或者路由 **/
    public static final byte API_TYPE_FORWARD = 3;

    /**----------------api接口类型结束-------------------------**/

    /**  共享全网  **/
    public static final byte SHARE_LEVEL_ALL = 0;

    /**  需要申请  **/
    public static final byte SHARE_LEVEL_APPLY = 1;

    /** 不共享 **/
    public static final byte SHARE_LEVEL_NONE = 2;

    /** 无参数 **/
    public static final byte PARMS_FLAG_FLASE = 0;

    /** 有参数 **/
    public static final byte PARMS_FLAG_TRUE = 1;

    /** API状态  正常 **/
    public static final byte API_STATUS_NORMAL = 0;

    /** API状态  不正常 **/
    public static final byte API_STATUS_ABNORMAL = 1;

    /**   请求方式静态常量  **/
    public static final Map<Byte,String> requestType = new HashMap<Byte,String>();
    static {
        requestType.put((byte) 0,"POST");
        requestType.put((byte) 1,"GET");
        requestType.put((byte) 2,"PUT");
        requestType.put((byte) 3,"DELETE");
    }

    /**   权限设置 用户和api  **/
    public static final int LIMT_TYPE_USER = 1;

    /**   订单状态  正常**/
    public static final String ORDER_SERVICE_STATUS_NORMAL = "1";

    /**   订单状态  异常**/
    public static final String ORDER_SERVICE_STATUS_ABNORMAL  = "2";

    /**   订单状态  无效**/
    public static final String ORDER_SERVICE_STATUS_INVALID  = "0";

    public static final String PARAM_API_KEY = "apikey";

    /**   数据目录分类最高级编码   **/
    public static final String CATEGORY_ORG_ID = "-1";

    /**   用户单位最高级Code   **/
    public static final String PRODUCER_ORG_ID = "-1";

    /*******************************     主数据管理相关常量  *******************************/

    /** 数据模型状态  未删除 **/
    public static final int MDM_DATA_MODEL_STATUS_DELETE_FLAG_FLASE = 1;

    /** 数据模型状态  已删除 **/
    public static final int MDM_DATA_MODEL_STATUS_DELETE_FLAG_TRUE = 0;

    /** 数据库名称 **/
    public static final String DATABASE_NANE = "mdm_db";

    /** 表查询模糊前缀 **/
    public static final String TABLE_PREFIX = "lp%";

    /*******************************     主数据管理相关常量结束  *******************************/

}
