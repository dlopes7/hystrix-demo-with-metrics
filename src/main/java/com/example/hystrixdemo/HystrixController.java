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
        return new IntegrationService("http://ip.jsontest.com").execute();

    }

    @RequestMapping("/fail")
    public String fail() throws Exception{
        return new IntegrationService("invalidurl").execute();

    }

}
