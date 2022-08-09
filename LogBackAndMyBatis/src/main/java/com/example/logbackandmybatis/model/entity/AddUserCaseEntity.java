package com.example.logbackandmybatis.model.entity;

import lombok.Data;

/**
 * Description:
 *
 * @date:2022/08/01 21:55
 * @author: lyf
 */
@Data
public class AddUserCaseEntity {

    private Long id;

    private String userName;

    private String password;

    private Integer age;

    private Integer sex;

    private Integer permission;

    private Integer isDelete;

    private Boolean expected;

    public String toString() {
        return ("{" +
                "id:" + id + "," +
                "userName:" + userName + "," +
                "password:" + password + "," +
                "age:" + age + "," +
                "sex:" + sex + "," +
                "permission:" + permission + "," +
                "isDelete:" + isDelete + "," +
                "expected:" + expected + "}"
        );
    }

}
