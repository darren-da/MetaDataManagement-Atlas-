
package com.limp.framework.core.constant;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-2-4
 * Time: 下午10:33
 * 定义静态变量
 * To change this template use File | Settings | File Templates.
 */
public class Constant {
    //未授权
    public static final String ERROR_403 = "403";
    //资源文件不存在
    public static final String ERROR_404 = "404";
    //服务器错误
    public static final String ERROR_500 = "500";

    /*******************框架业务********************/
    public static final String DB_ORACLE = "ORACLE";

    public static final String DB_MYSQL = "MYSQL";

    public static final String DB_KEY = "LIMP.DATABASE";

    /*******************请求方式********************/
    public static final String GET = "GET";

    public static final String POST = "POST";

    public static final String PUT = "PUT";

    public static final String DELETE_METHOD = "DELETE";

    /*******************文字编码********************/
    public static final String CODE_UTF_8 = "UTF-8";

    public static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    /**
     *字典表转换标示前缀
     * 在get方法上加入此前缀，表示此字典表需要转码
     * @JSONField(name= Constant.CODE_TRANS_PRE+"funtype")
     */
    public static final String CODE_TRANS_PRE = "LP_CODE_";



    /**
     * 登陆用户(用于存储Session)
     */
    public static final String KEY_MSGNUM = "KEY_MSGNUM";

    public static final String KEY_SET = "KEY_SET";

    public static final String KEY_USER = "KEY_USER";

    public static final String KEY_ROLE = "KEY_ROLE";

    public static final String KEY_MENU = "KEY_MENU";
    /**
     * 存放Permission的权限信息 list集合
     */
    public static final String KEY_PERM = "KEY_PERM";

    public static final String KEY_MENU_JSON = "KEY_MENU_JSON";

    /**
     * menid:menu 对应map、格式的彩带权限
     */
    public static final String KEY_MENU_KVMAP = "KEY_MENU_KVMAP";

    public static final String KEY_PERM_JSON = "KEY_PERM_JSON";

    /**
     * 系统环境配置
     */

    public static final String KEY_CONFFIELD = "KEY_CONFFIELD";


    public static final String KEY_CONFFIELD_KVMAP = "KEY_CONFFIELD_KVMAP";

    /**
     * 所有的权限点
     */
    public static final String KEY_CODE = "KEY_CODE";
    /**
     * 权限： key：url
     */
    public static final String KEY_AUTH_MAP = "KEY_AUTH_MAP";

    public static final String KEY_ELEMENTS = "KEY_ELEMENTS";

    /**
     * 小数点
     */
    public static final String DOT = ".";
    /**
     * 逗号
     */
    public static final String DHAO = ",";
    /********************************用户设置变量*****************************/
    public static final String SET_MEN_KEYWORD = "MEN_KEYWORD";

    public static final String SET_ORDER_LINK = "LIMIT_LINK";

    /**
     * 账号登录
     */
    public static final String F_LOGIN_ACCOUNT = "F_LOGIN_ACCOUNT";
    /**
     * 手机登录
     */
    public static final String F_LOGIN_PHONE = "F_LOGIN_PHONE";
    /**
     * 邮箱登录
     */
    public static final String F_LOGIN_EMAIL = "F_LOGIN_EMAIL";


    /*************************************************************/

    /**
     * 树 TREE
     */
    public final static String TREE="tree";
    /**
     * 首页
     */
    public final static String INDEX="index";
    /**
     * 首页--后台
     */
    public final static String MAIN="main";
    /**
     * 首页--主面板
     */
    public final static String PANEL="panel";
    /**
     * 数字0
     */
    public final static int NUMBER_0 = 0;
    /**
     * 数字1
     */
    public final static int NUMBER_1 = 1;
    /**
     * 数字2
     */
    public final static int NUMBER_2 = 2;
    /**
     * 数字3
     */
    public final static int NUMBER_3 = 3;
    /**
     * 数字4
     */
    public final static int NUMBER_4 = 4;
    /**
     * 数字5
     */
    public final static int NUMBER_5 = 5;

    /**
     * 空
     */
    public final static String NULL = "null";

    /**
     * 空字符串
     */
    public final static String STRING_EMPTY = "";

    /**
     * -1字符创
     */

    public final static String STRING_DEL_STATE = "-1";

    /**
     * 刪除标记
     */
    public final static String STRING_DEL = "-1";
    /**
     * 字符 :0 [48 ]
     */
    public final static String STRING_0 = "0";
    /**
     * 字符 :1 [49 ]
     */
    public final static String STRING_1 = "1";
    /**
     * 字符 :2 [50 ]
     */
    public final static String STRING_2 = "2";
    /**
     * 字符 :3 [51 ]
     */
    public final static String STRING_3 = "3";
    /**
     * 字符 :4 [52 ]
     */
    public final static String STRING_4 = "4";
    /**
     * 字符 :5 [53 ]
     */
    public final static String STRING_5 = "5";
    /**
     * 字符 :6 [54 ]
     */
    public final static String STRING_6 = "6";
    /**
     * 字符 :7 [55 ]
     */
    public final static String STRING_7 = "7";
    /**
     * 字符 :8 [56 ]
     */
    public final static String STRING_8 = "8";
    /**
     * 字符 :9 [57 ]
     */
    public final static String STRING_9 = "9";
    /**
     * 字符 :A [65 ]
     */
    public final static String STRING_A = "A";
    /**
     * 字符 :B [66 ]
     */
    public final static String STRING_B = "B";
    /**
     * 字符 :C [67 ]
     */
    public final static String STRING_C = "C";
    /**
     * 字符 :D [68 ]
     */
    public final static String STRING_D = "D";
    /**
     * 字符 :E [69 ]
     */
    public final static String STRING_E = "E";
    /**
     * 字符 :F [70 ]
     */
    public final static String STRING_F = "F";
    /**
     * 字符 :G [71 ]
     */
    public final static String STRING_G = "G";
    /**
     * 字符 :H [72 ]
     */
    public final static String STRING_H = "H";
    /**
     * 字符 :I [73 ]
     */
    public final static String STRING_I = "I";
    /**
     * 字符 :J [74 ]
     */
    public final static String STRING_J = "J";
    /**
     * 字符 :K [75 ]
     */
    public final static String STRING_K = "K";
    /**
     * 字符 :L [76 ]
     */
    public final static String STRING_L = "L";
    /**
     * 字符 :M [77 ]
     */
    public final static String STRING_M = "M";
    /**
     * 字符 :N [78 ]
     */
    public final static String STRING_N = "N";
    /**
     * 字符 :O [79 ]
     */
    public final static String STRING_O = "O";
    /**
     * 字符 :P [80 ]
     */
    public final static String STRING_P = "P";
    /**
     * 字符 :Q [81 ]
     */
    public final static String STRING_Q = "Q";
    /**
     * 字符 :R [82 ]
     */
    public final static String STRING_R = "R";
    /**
     * 字符 :S [83 ]
     */
    public final static String STRING_S = "S";
    /**
     * 字符 :T [84 ]
     */
    public final static String STRING_T = "T";
    /**
     * 字符 :U [85 ]
     */
    public final static String STRING_U = "U";
    /**
     * 字符 :V [86 ]
     */
    public final static String STRING_V = "V";
    /**
     * 字符 :W [87 ]
     */
    public final static String STRING_W = "W";
    /**
     * 字符 :X [88 ]
     */
    public final static String STRING_X = "X";
    /**
     * 字符 :Y [89 ]
     */
    public final static String STRING_Y = "Y";
    /**
     * 字符 :Z [90 ]
     */
    public final static String STRING_Z = "Z";

    /**
     * 字符 :a [97 ]
     */
    public final static String STRING_A_L = "a";
    /**
     * 字符 :b [98 ]
     */
    public final static String STRING_B_L = "b";
    /**
     * 字符 :c [99 ]
     */
    public final static String STRING_C_L = "c";
    /**
     * 字符 :d [100 ]
     */
    public final static String STRING_D_L = "d";
    /**
     * 字符 :e [101 ]
     */
    public final static String STRING_E_L = "e";
    /**
     * 字符 :f [102 ]
     */
    public final static String STRING_F_L = "f";
    /**
     * 字符 :g [103 ]
     */
    public final static String STRING_G_L = "g";
    /**
     * 字符 :h [104 ]
     */
    public final static String STRING_H_L = "h";
    /**
     * 字符 :i [105 ]
     */
    public final static String STRING_I_L = "i";
    /**
     * 字符 :j [106 ]
     */
    public final static String STRING_J_L = "j";
    /**
     * 字符 :k [107 ]
     */
    public final static String STRING_K_L = "k";
    /**
     * 字符 :l [108 ]
     */
    public final static String STRING_L_L = "l";
    /**
     * 字符 :m [109 ]
     */
    public final static String STRING_M_L = "m";
    /**
     * 字符 :n [110 ]
     */
    public final static String STRING_N_L = "n";
    /**
     * 字符 :o [111 ]
     */
    public final static String STRING_O_L = "o";
    /**
     * 字符 :p [112 ]
     */
    public final static String STRING_P_L = "p";
    /**
     * 字符 :q [113 ]
     */
    public final static String STRING_Q_L = "q";
    /**
     * 字符 :r [114 ]
     */
    public final static String STRING_R_L = "r";
    /**
     * 字符 :s [115 ]
     */
    public final static String STRING_S_L = "s";
    /**
     * 字符 :t [116 ]
     */
    public final static String STRING_T_L = "t";
    /**
     * 字符 :u [117 ]
     */
    public final static String STRING_U_L = "u";
    /**
     * 字符 :v [118 ]
     */
    public final static String STRING_V_L = "v";
    /**
     * 字符 :w [119 ]
     */
    public final static String STRING_W_L = "w";
    /**
     * 字符 :x [120 ]
     */
    public final static String STRING_X_L = "x";
    /**
     * 字符 :y [121 ]
     */
    public final static String STRING_Y_L = "y";
    /**
     * 字符 :z [122 ]
     */
    public final static String STRING_Z_L = "z";

    public final static String DELETE = "delete";

    public final static String UPDATE = "update";

    public final static String INSERT = "insert";

    public final static String DROP = "drop";

    public final static String SELECT = "select";

    public final static String ACCESS = "access";

    /**
     * 状态-无效
     */
    public static final int STATE_INVALID = 0;
    /**
     * 状态-有效
     */
    public static final int STATE_EFFECTIVE = 1;

    /**
     * 删除标记
     */
    public static final int STATE_DELETE= -1;


    /**
     * 邮箱标识符号
     */
    public static final String FLAY_EMAIL= "@";



    /**
     * 操作成功
     */
    public static final String OPRT_SUCCESS = "1";
    /**
     * 操作失败
     */
    public static final String OPRT_FAIL= "2";

    public static final String LP_NR4sXuN5M5P= "XIof/3JOSkgTC3SlSFkOdLzQqYxPTBNfYecp3GOMY7D66gCXlpqmi9c7BWxvwEADipMKtzM09QHln90Lkh1xhKiNNkJPkbMZoVfafjU1P9GicFj1ZjSAznMSRrlv47y0j2CUwq0unbNOEkQS5kwFZCgEfeoB7p9hCRxj3Jp4/8M=";

    /*******************文件后缀***************************/
    public static final String FILE_POS_DOCX= ".docx";

    public static final String FILE_POS_DOC= ".doc";

    public static final String FILE_POS_XLSX= ".xlsx";

    public static final String FILE_POS_JPG= ".jpg";

    public static final String FILE_POS_PNG= ".png";
    /**
     * 本机地址
     */

    public static final String LOCALHOST_IP= "127.0.0.1";

    public static final String UNKNOWN= "unknown";

    public  static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJyoA6wrpEKXX7DdR0lIL9SkSsAzoBZB16hNNS5IbZ4978X+tf6+yBzXWctd1/VOKsZ/y3SlR7FmezWUHbGtF3cI6r7v5EFzXcy3+zAX4JxrL/Ig2IDkl2XPAGwC1rbxVZJGXcPJLWTecfEoga9vlNujqXUCFZRn6tGaN3hqxFuXAgMBAAECgYAYiNfKZytaooqCEKXRfFTBYNm0MGGqGrXDzhO+I+nHFrwuri2isA53NeMCTrg72vooDGu44QnRZtN1GLVt1kYOR7k11gos0ZiV6IFxhSuyr3TVDWjKGHOcbqfrZsnSZCfgnnvwDLSBmk1oaCnYSIm7Z/ONbU5VsQMs6bUdelwTwQJBANAMD4B5ZrrmJKgNTgKFEHNtmiI2Gd8XHI2e/IYIWiHvO7DTXgmYaE1e1WmzyJihK9QYJg8+Gxk9UnpWZkK6ksUCQQDAw5wZay6hL9ZTljznu+ypjfQsLnyKP1D7CWPyZmBzwgEGj9JHJnzlTU3jdku+W/GdT7pGjSxN26Pqja/M0CqrAkEAjVT0HvnZ8POxSTyolwugLlnxkHYiQyxnKEouEDuSR2VGrowYYPpZON5IqmMIza8HoDC7gjVVoWLIKfWRyJkIZQJAQlXObSzmUg/dSMyFzxVrnvm70kx5DTY2zvzvSSaUAKH9ql1p9pQ3HM3ahPFbpXmMjx81sju4yF5SbVAu9GOamwJAWoz8dDudr87HjqNHn+/ohQ8vvrCfR5zBL+Fqj+G+DMaFiusTa1EsyxJPWb9qKifKybwWJvSVK+4Bn36mthPCiw==";

    public  static String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCcqAOsK6RCl1+w3UdJSC/UpErAM6AWQdeoTTUuSG2ePe/F/rX+vsgc11nLXdf1TirGf8t0pUexZns1lB2xrRd3COq+7+RBc13Mt/swF+Ccay/yINiA5JdlzwBsAta28VWSRl3DyS1k3nHxKIGvb5Tbo6l1AhWUZ+rRmjd4asRblwIDAQAB";








}
