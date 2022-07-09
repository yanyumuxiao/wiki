package com.dyl.wiki.controller;

import com.dyl.wiki.domain.Test;
import com.dyl.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    // 优先读配置文件里的value
    // 冒号后面的是默认配置项，当项目打包之后，没有application.properties，可以读取默认值
    @Value("${test.hello:TEST1111}")
    private String testHello;

    @Resource
    private TestService testService;

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
        return "Hello World." + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){

        return "Hello World! Post" + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }

}
