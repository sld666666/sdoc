package com.sld.web.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * Created by diwu.sld on 2017/4/12.
 */
@RestController
@Log4j
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        log.error("aabbccee");
        return "Greetings from Spring Boot!";
    }


    @RequestMapping("/increase")
    public String increase(@RequestParam("id") Integer id){
        return  String.valueOf(++id);
    }

    @RequestMapping(value ="/postData", method = RequestMethod.POST)
    public String postData(@RequestParam("postData") String postData){

        return "response:" + postData;
    }



}
