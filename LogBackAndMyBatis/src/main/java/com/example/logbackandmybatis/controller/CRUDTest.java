package com.example.logbackandmybatis.controller;

import com.example.logbackandmybatis.model.entity.UserEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @date:2022/07/27 21:33
 * @author: lyf
 */
@RestController
@RequestMapping("/db")
public class CRUDTest {

    // 首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @GetMapping(value = "getUserCount")
    public int getUserList() {
        return template.selectOne("getUserCount");
    }

    @PostMapping(value = "/addUser")
    public int addUser(@RequestBody UserEntity user) {
        return template.insert("addUser", user);
    }

    @PostMapping(value = "/updateUser")
    public int updateUser(@RequestBody UserEntity user) {
        return template.update("updateUser", user);
    }

    @GetMapping(value = "/delUser")
    public int delUser(@RequestParam int id) {
        return template.update("delUser", id);
    }

}
