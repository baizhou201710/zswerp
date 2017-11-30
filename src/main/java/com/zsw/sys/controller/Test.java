package com.zsw.sys.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 *
 * @author baizhou
 * @create 2017-11-17 11:41
 */
@RestController
public class Test {

    @RequestMapping(value = "/index2")
    public String test1(Model model){
        System.out.println("Test page!");
        return  "index";
    }
}
