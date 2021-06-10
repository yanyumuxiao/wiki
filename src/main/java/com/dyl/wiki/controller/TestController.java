package com.dyl.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    /*

    GET POST PUT DELETE

    /user?id=1
    /user/1
    @return


     */
    // GetMapping("/hello")
//    @RequestMapping(value = "/user/1", method = RequestMethod.GET)
//    @RequestMapping(value = "/user/1", method = RequestMethod.DELETE)
//    @PostMapping("/hello")  status=405 浏览器访问只支持get，而此处是post
//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello(){


        return "Hello World.";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){

        return "Hello World! Post" + name;
    }
}
