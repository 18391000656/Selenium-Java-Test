package com.meyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exeJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"asdfg\");");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
