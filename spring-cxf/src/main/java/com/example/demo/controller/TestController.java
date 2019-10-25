package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Harry
 * @Date 2019/9/29 13:51
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}
