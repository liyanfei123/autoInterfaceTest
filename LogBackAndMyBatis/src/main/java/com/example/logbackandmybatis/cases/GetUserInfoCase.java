package com.example.logbackandmybatis.cases;

import com.example.logbackandmybatis.config.TestNGConfig;
import com.example.logbackandmybatis.model.entity.GetUserInfoEntity;
import com.example.logbackandmybatis.model.entity.GetUserInfoListEntity;
import com.example.logbackandmybatis.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/08/04 22:03
 * @author: lyf
 */
public class GetUserInfoCase {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserInfo() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        GetUserInfoEntity getUserInfoEntity = session.selectOne("getUserInfoCase", 1);
        System.out.println(getUserInfoEntity.toString());
        System.out.println(TestNGConfig.getUserInfoUrl);
    }

}
