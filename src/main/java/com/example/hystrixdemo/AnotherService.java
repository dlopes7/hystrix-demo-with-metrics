package com.example.hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dlopes on 5/20/18.
 */

public class AnotherService extends HystrixCommand<String> {

    private final String urlPath;

    public AnotherService(String urlPath){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("AnotherGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().
                        withMetricsRollingStatisticalWindowInMilliseconds(60000)));
        this.urlPath = urlPath;

    }

    @Override
    protected String run() throws IOException {


        URL url = new URL(urlPath);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        return content.toString();
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + urlPath + "!";
    }

}

