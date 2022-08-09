package com.example.logbackandmybatis.cases;

import com.example.logbackandmybatis.config.TestNGConfig;
import com.example.logbackandmybatis.model.entity.GetUserInfoListEntity;
import com.example.logbackandmybatis.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/08/04 22:00
 * @author: lyf
 */
public class GetUserInfoListCase {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserListInfo() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        GetUserInfoListEntity getUserInfoListEntity = session.selectOne("getUserListCase", 1);
        System.out.println(getUserInfoListEntity.toString());
        System.out.println(TestNGConfig.getUserListUrl);
    }
}
