package com.luv2code.restDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "text/plain")
    public String hello(){
        return "hello rest !!";
    }
}
