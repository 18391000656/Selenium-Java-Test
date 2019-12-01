package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void registerTest() {
        driver.get("http://mail.163.com");
        //点击用密码登录按钮
        driver.findElement(By.id("switchAccountLogin")).click();
        //控制权交给 iframe页面
        driver.switchTo().frame("x-URS-iframe1574564211179.727");
        //点击去注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handlel值
        String handle1 = driver.getWindowHandle();
        //driver 到新的windows页面
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        //获取时间撮
        String time = String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("nameIpt")).sendKeys("time");
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123123qwe");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123qwe");
        driver.findElement(By.id("vcodeIpt")).sendKeys("123123");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("18665423876");
        driver.findElement(By.id("mainAcceptIpt")).click();
        driver.findElement(By.id("mainRegA")).click();

        String error = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span/text()")).getText();
        Assert.assertEquals(error, "  验证码不正确，请重新填写");
    }

//    @Test
//    public void testcase(){
//        long time = System.currentTimeMillis();
//        System.out.println(time);
//    }


    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
