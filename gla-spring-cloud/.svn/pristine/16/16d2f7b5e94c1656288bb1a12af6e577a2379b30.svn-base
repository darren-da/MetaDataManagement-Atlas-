import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.auth.AuthUtils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/31 15:07
 */
public class Test {
    public static void main(String[] args) {
        UserInfo userInfo=new UserInfo();
        userInfo.setId("4a45c9b1784c4699927bc8bd79f5a733");
        userInfo.setAccount("test1");
        userInfo.setRoleCode("ROLE_DATACENTER_PROVIDER");
        userInfo.setName("test1");

        String userStr= JwtUtil.getInstance().generateToken(userInfo);

        System.out.println(userStr);
        System.out.println(JwtUtil.getInstance().validateToken(userStr));

//        System.out.println(AuthUtils.encodeMD5("2b5f182260dc40cbaa1fa442e1ea912d"+"K"+287,""));;


    }
}
