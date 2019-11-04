//package com.gla.auth.jwt.filter;
//
//import com.gla.datacenter.domain.UserInfo;
//import com.limp.framework.core.exception.PrivilegeException;
//import com.limp.framework.utils.StrUtils;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Description: JWT生成以及验证相关
// * @Author: zzh
// * @Modified By:shiniandate
// * @Date: 2018/10/31 14:48
// */
//public class JwtUtil {
//    private static Logger logger= LoggerFactory.getLogger(JwtUtil.class);
//
//    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
//    public static final String TOKEN_PREFIX = "Bearer";
//    public static final String HEADER_AUTH = "Authorization";
//    //传递token的备用字段
//    public static final String HEADER_X_USER_TOKEN = "x-user-token";
//    /**
//     *过期时间 分钟
//     */
//    public static final Integer EXPIRE_DATE = 24*60;
//
//    /**
//     * 定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。而类型为SingletonHolder的类，只有在Singleton.getInstance()中调用，
//     * 由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例
//     */
//
//    private static class SingletonHolder{
//        private final static JwtUtil instance=new JwtUtil();
//    }
//    public static JwtUtil getInstance(){
//        return SingletonHolder.instance;
//    }
//    /**
//     * 用户对象
//     * @param userInfo
//     * @return
//     */
//    public  String generateToken(UserInfo userInfo) {
//        HashMap<String, Object> map = new HashMap<>();
//        //id
//        map.put("id", userInfo.getId());
//        //账号
//        map.put("account", userInfo.getAccount());
//        //角色编码
//        map.put("roleCode", userInfo.getRoleCode());
//        //账号名称
//        map.put("name", userInfo.getName());
//        map.put("apikey", userInfo.getRc4());
//        map.put("exp", new Date().getTime()+EXPIRE_DATE*60*1000);
//        map.put("unitcode",userInfo.getUnitcode());
//        String jwt = Jwts.builder()
//                .setSubject("DSB user information").setClaims(map)
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//        String finalJwt = TOKEN_PREFIX + " " +jwt;
//        logger.debug("/*********获取token***********************/");
//        logger.debug(finalJwt);
//        return finalJwt;
//    }
//
//    /**
//     * 验证是token是否合法
//     * @param token 传入token值
//     * @return 解析后的map对象
//     */
//    public  UserInfo validateToken(String token) {
//        logger.info("/*********验证token***********************/");
//        logger.info(token);
//        if (token != null) {
//           try {
//
//            Map<String,Object> body = Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//            String id =  String.valueOf(body.get("id"));
//            String account = String.valueOf(body.get("account"));
//            //初始化用户信息
//            UserInfo userInfo=new UserInfo();
//            userInfo.setId(id);
//            userInfo.setAccount(String.valueOf(body.get("account")));
//            userInfo.setRoleCode(String.valueOf(body.get("roleCode")));
//            userInfo.setName(String.valueOf(body.get("name")));
//            userInfo.setRc4(String.valueOf(body.get("apikey")));
//            userInfo.setUnitcode(String.valueOf(body.get("unitcode")));
//
//            if(StrUtils.isBlank(account)) {
//                throw new PrivilegeException("user is error, please check");
//            }
//                Long exp = Long.parseLong(body.get("exp")+"");
//                Long end= new Date(exp).getTime()-new Date().getTime();
//             //验证是否过期
//            if(end<0){
//                throw new PrivilegeException("token is expire, please get it again");
//            }
//            logger.info("/*********验证token成功******登陆账号:{}***************/",userInfo.getAccount());
//            return userInfo;
//
//           }catch (Exception  ex){
//               throw new PrivilegeException("token is error, please check");
//           }
//        } else {
//            throw new PrivilegeException("token is error, please check");
//        }
//    }
//
//}
