package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 操作js的Alert弹框中的元素
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("xxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.id("xxxxxxxx")).click();
        Thread.sleep(3000);
        //操作alert弹框,把控制权交个Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * 操作Alert弹框中的元素(确定/取消按钮)
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("xxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.id("xxxxxxxx")).click();
        Thread.sleep(3000);
        //把控制权交个Alert
        Alert alert = driver.switchTo().alert();
        //先点击取消
        alert.dismiss();
        //点击取消后在弹出确定按钮
        alert.accept();
    }

    /**
     * 在Alert弹框中的输入内容操作
     */
    @Test
    public void prompTest() throws InterruptedException {
        driver.get("xxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.id("xxxxxxxx")).click();
        Thread.sleep(3000);
        //把控制权交个Alert
        Alert alert = driver.switchTo().alert();
        //Alert弹框中输入内容
        alert.sendKeys("xxxxxxxxxxxxx");
        Thread.sleep(3000);
        //点击确定按钮
        alert.accept();
    }

    /**
     * 获取Alert弹框中的文本内容
     */
    @Test
    public void getTextTest() throws InterruptedException {
        driver.get("xxxxxxxxxxxxxxxxxxxx");
        driver.findElement(By.id("xxxxxxxx")).click();
        Thread.sleep(3000);
        //把控制权交个Alert
        Alert alert = driver.switchTo().alert();
        //获取警告框的文本值
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text, "用户名或密码错误");
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
