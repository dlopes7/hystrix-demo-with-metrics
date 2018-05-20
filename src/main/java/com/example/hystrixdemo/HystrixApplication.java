package com.example.hystrixdemo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HystrixApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(HystrixApplication.class).web(WebApplicationType.SERVLET).run();
	}

	@Bean
    public ServletRegistrationBean hystrixMetrics(){
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(),"/hystrix.stream");
    }

}
