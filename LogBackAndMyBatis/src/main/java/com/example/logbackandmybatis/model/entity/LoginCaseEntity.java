package com.example.logbackandmybatis.model.entity;

import lombok.Data;

/**
 * Description:
 *
 * @date:2022/08/01 21:55
 * @author: lyf
 */
@Data
public class LoginCaseEntity {

    private Long id;

    private String userName;

    private String password;

    private Boolean expected;

    public String toString() {
        return ("{" +
                "id:" + id + "," +
                "userName:" + userName + "," +
                "password:" + password + "," +
                "expected:" + expected + "}"
        );
    }


}
