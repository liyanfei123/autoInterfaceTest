package com.example.logbackandmybatis.cases;

import com.example.logbackandmybatis.config.TestNGConfig;
import com.example.logbackandmybatis.model.entity.LoginCaseEntity;
import com.example.logbackandmybatis.model.meta.enums.InterfaceName;
import com.example.logbackandmybatis.utils.ConfigFile;
import com.example.logbackandmybatis.utils.DataBaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/08/02 21:51
 * @author: lyf
 */
public class LoginTest {


    @BeforeTest(groups = "loginTrue", description = "测试准备工作")
    public void beforeTest() {
        TestNGConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestNGConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestNGConfig.addUserInfo = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestNGConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestNGConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestNGConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue", description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        LoginCaseEntity loginCaseEntity = session.selectOne("loginCase", 1);
        System.out.println(loginCaseEntity.toString());
        System.out.println(TestNGConfig.loginUrl);
    }

    @Test(groups = "loginFalse")
    public void loginFalse() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        LoginCaseEntity loginCaseEntity = session.selectOne("loginCase", 2);
        System.out.println(loginCaseEntity.toString());
        System.out.println(TestNGConfig.loginUrl);
    }

}
