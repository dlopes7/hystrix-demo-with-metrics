package com.example.hystrixdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dlopes on 5/20/18.
 */

@RestController
public class HystrixController {

    @RequestMapping("/ok")
    public String ok() throws Exception{
        return new IntegrationService("http://localhost:3000").execute();

    }

    @RequestMapping("/fail")
    public String fail() throws Exception{
        return new IntegrationService("invalidurl").execute();

    }

    @RequestMapping("/string-ok")
    public String stringOk() throws Exception{
        return new StringService("http://localhost:3000").execute();

    }

    @RequestMapping("/string-fail")
    public String stringFail() throws Exception{
        return new StringService("invalidurl").execute();

    }

    @RequestMapping("/ok-group2")
    public String ok2() throws Exception{
        return new AnotherService("http://localhost:3000").execute();

    }

    @RequestMapping("/fail-group2")
    public String fail2() throws Exception{
        return new AnotherService("invalidurl").execute();

    }

}
