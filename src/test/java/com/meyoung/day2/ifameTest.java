package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ifameTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 操作iframe页面
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("xxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.id("xxxxxxxx")).click();
        //通过ID 或者 Name 方式 转交控制权
//      driver.switchTo().frame("xxxxxxxxx");

        //通过webelemnet 方式 转交控制权
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("xxxxxxxxx")).click();
        Thread.sleep(3000);
        //driver的控制权转交到原来的界面
        driver.switchTo().defaultContent();
        //点击原来界面的页面元素
        driver.findElement(By.id("xxxxxxxxx")).click();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
