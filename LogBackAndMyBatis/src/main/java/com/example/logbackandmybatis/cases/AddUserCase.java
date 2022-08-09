package com.example.logbackandmybatis.cases;

import com.example.logbackandmybatis.config.TestNGConfig;
import com.example.logbackandmybatis.model.entity.AddUserCaseEntity;
import com.example.logbackandmybatis.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/08/04 21:58
 * @author: lyf
 */
public class AddUserCase {

    @Test(dependsOnGroups = "loginTrue")
    public void addUser() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        AddUserCaseEntity addUserCaseEntity = session.selectOne("addUserCase", 1);
        System.out.println(addUserCaseEntity.toString());
        System.out.println(TestNGConfig.addUserInfo);
    }
}
