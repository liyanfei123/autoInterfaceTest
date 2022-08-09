package com.example.logbackandmybatis.model.entity;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Description:
 *
 * @date:2022/07/27 21:44
 * @author: lyf
 */
@Data
public class UserEntity {

    private Long id;

    private String userName;

    private String password;

    private Integer age;

    private Integer sex;

    private Integer permission;

    private Integer isDelete;

    public String toString() {
        return ("{" +
                "id:" + id + "," +
                "userName:" + userName + "," +
                "password:" + password + "," +
                "age:" + age + "," +
                "sex:" + sex + "," +
                "permission:" + permission + "," +
                "isDelete:" + isDelete + "}"
                );
    }
}
