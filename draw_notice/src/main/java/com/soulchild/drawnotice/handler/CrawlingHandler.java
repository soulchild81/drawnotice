package com.soulchild.drawnotice.handler;

import com.soulchild.drawnotice.config.Constant;
import com.soulchild.drawnotice.model.Release;
import com.soulchild.drawnotice.util.NoticeUtil;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CrawlingHandler {
    public Mono<ServerResponse> getPage(ServerRequest request) {
        WebElement webElement;
        List<WebElement> webElementList;

        try{
            System.setProperty(Constant.CHROME_DRIVER_NAME, Constant.CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments(Constant.CHROME_HEADLESS);

            ChromeDriver driver = new ChromeDriver(options);
            driver.get(Constant.NIKE_URL);

            webElement = driver.findElementByClassName(Constant.NIKE_LAUNCH_CONTENT_CLASS);
            webElementList = webElement.findElements(By.xpath("//div[contains(@class, 'upcomingItem')]"));
            List<Release> releaseList = new ArrayList<>();

            for(int i=0;i<webElementList.size();i++){
                String[] infoArray = webElementList.get(i).getText().split("\n");
                webElementList.get(i).getText().split("\n");
//                System.out.println(webElementList.get(i).findElement(By.tagName("img")).getAttribute("src"));
//                System.out.println(webElementList.get(i).findElement(By.xpath("//img"+"[contains(@class, 'img-component')]")).getAttribute("src"));

                String image = webElementList.get(i).findElement(By.tagName("img")).getAttribute("src");

                Release release = new Release();
                release.setRelease(infoArray[0] , infoArray[1] , infoArray[2] , infoArray[3] , image);
                releaseList.add(release);
//                System.out.println(webElementList.get(i).getText());
//                System.out.println(webElementList.get(i).findElement(By.xpath("//span"+"[contains(@class, 'month')]")).getText());
//                System.out.println(webElementList.get(i).findElement(By.xpath("//span"+"[contains(@class, 'day')]")).getText());
//                System.out.println(webElementList.get(i).findElement(By.xpath("//p"+"[contains(@class, 'txt-description')]")).getText());
//                System.out.println(webElementList.get(i).findElement(By.xpath("//p"+"[contains(@class, 'txt-subject')]")).getText());
            }

            driver.getPageSource();
            driver.quit();
            NoticeUtil.successMail(releaseList);
        }catch(Exception e){
            e.printStackTrace();
        }


        return ServerResponse.ok().body(Mono.just("SUCCESS"), String.class);
    }
}
