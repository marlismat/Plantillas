package com.digitel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.digitel.filters.ErrorFilter;
import com.digitel.filters.PostFilter;
import com.digitel.filters.PreFilter;
import com.digitel.filters.RouteFilter;
 
@SpringBootApplication
@EnableZuulProxy
public class SpringBootZuulgatwayproxyApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootZuulgatwayproxyApplication.class, args);
    }
 
    @Bean
    public PreFilter preFilter() {
    	System.out.println("bean pre filter");
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
    	System.out.println("bean post filter");
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
    	System.out.println("bean error filter");
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
    	System.out.println("route pre filter");
        return new RouteFilter();
    }
}