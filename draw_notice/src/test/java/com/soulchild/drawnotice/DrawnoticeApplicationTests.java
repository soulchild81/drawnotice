package com.soulchild.drawnotice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.annotation.Resource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DrawnoticeApplicationTests {

    @Resource
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
        System.out.println("--------------------");
    }

    @Test
    public void testCrawling(){
        this.webTestClient.get().uri("/crawling").accept(MediaType.TEXT_PLAIN).exchange()
                .expectBody(String.class).isEqualTo("get WebPage");
    }





}
