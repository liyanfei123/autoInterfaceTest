package com.autotest.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @date:2022/07/16 22:33
 * @author: lyf
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @GetMapping("hello")
    @ResponseBody
    String hello() {
        return "hello world";
    }
}
