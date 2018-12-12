package com.lms.frame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class IndexController {

    @GetMapping(value = "/")
    //@ResponseBody
    public String index(){
        return "first page:首页";
    }


}
