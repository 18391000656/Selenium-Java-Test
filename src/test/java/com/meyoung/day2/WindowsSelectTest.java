package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsSelectTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度首页
     * 点击把百度设为主页按钮
     */
    @Test
    public void testWindows() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //当前driver所在的页面的句柄值
        String handlel = driver.getWindowHandle();

        driver.findElement(By.linkText("把百度设为主页")).click();
        Thread.sleep(3000);

        //for 循环判断 获取到的handles是否等于handlel
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handlel)) {
                continue;
            }
            driver.switchTo().window(handlel);
        }
        driver.findElement(By.linkText("帮助中心")).click();

        driver.switchTo().window(handlel);
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
