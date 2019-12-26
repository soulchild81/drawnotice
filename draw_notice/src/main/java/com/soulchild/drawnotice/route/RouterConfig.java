package com.soulchild.drawnotice.route;

import com.soulchild.drawnotice.handler.CrawlingHandler;
import com.soulchild.drawnotice.handler.StudentServiceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RouterConfig {
    @Bean
    @Order(1)
    public RouterFunction<ServerResponse> routes(StudentServiceHandler handler) {
        return RouterFunctions.route()
                .GET("/students/{number}", handler::getStudent)
                .GET("/students",  handler::getStudents)
                .build();
    }


    @Bean
    @Order(2)
    public RouterFunction<ServerResponse> crawlroutes(CrawlingHandler handler) {
        return RouterFunctions.route()
                .GET("/crawling",  handler::getPage)
                .build();
    }
}
