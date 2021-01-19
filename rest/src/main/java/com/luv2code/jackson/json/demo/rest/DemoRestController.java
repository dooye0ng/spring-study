package com.luv2code.jackson.json.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(){
        return "hello rest !";
    }
}