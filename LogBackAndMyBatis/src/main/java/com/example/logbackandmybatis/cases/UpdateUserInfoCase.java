package com.example.logbackandmybatis.cases;

import com.example.logbackandmybatis.config.TestNGConfig;
import com.example.logbackandmybatis.model.entity.AddUserCaseEntity;
import com.example.logbackandmybatis.model.entity.UpdateUserInfoCaseEntity;
import com.example.logbackandmybatis.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @date:2022/08/04 22:04
 * @author: lyf
 */
public class UpdateUserInfoCase {

    @Test(dependsOnGroups = "loginTrue")
    public void updateUserInfo() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        UpdateUserInfoCaseEntity updateUserInfoCaseEntity = session.selectOne("updateUserInfoCase", 1);
        System.out.println(updateUserInfoCaseEntity.toString());
        System.out.println(TestNGConfig.updateUserInfoUrl);
    }

    @Test(dependsOnGroups = "loginTrue")
    public void deleteUser() throws IOException {
        SqlSession session = DataBaseUtil.getSqlSession();
        UpdateUserInfoCaseEntity updateUserInfoCaseEntity = session.selectOne("deleteUser", 1);
        System.out.println(updateUserInfoCaseEntity.toString());
        System.out.println(TestNGConfig.updateUserInfoUrl);
    }

}
