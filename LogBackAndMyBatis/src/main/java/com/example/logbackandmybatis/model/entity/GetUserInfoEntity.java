package com.example.logbackandmybatis.model.entity;

import lombok.Data;

/**
 * Description:
 *
 * @date:2022/08/01 21:55
 * @author: lyf
 */
@Data
public class GetUserInfoEntity {

    private Long id;

    private Long userId;

    private String expected;

    public String toString() {
        return ("{" +
                "id:" + id + "," +
                "userId:" + userId + "," +
                "expected:" + expected + "}"
        );
    }

}
