package com.example.logbackandmybatis.model.entity;

import lombok.Data;

/**
 * Description:
 *
 * @date:2022/08/01 21:55
 * @author: lyf
 */@Data
public class UpdateUserInfoCaseEntity {

    private Long id;

    private Long userId;

    private String userName;

    private Integer age;

    private Integer sex;

    private Integer permission;

    private Integer isDelete;

    private String expected;

    public String toString() {
        return ("{" +
                "id:" + id + "," +
                "userName:" + userName + "," +
                "age:" + age + "," +
                "sex:" + sex + "," +
                "permission:" + permission + "," +
                "isDelete:" + isDelete + "," +
                "expected:" + expected + "}"
        );
    }


}
