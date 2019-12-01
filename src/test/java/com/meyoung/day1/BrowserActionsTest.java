package com.meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
    WebDriver driver;

    @BeforeMethod //每次执行Case时，都会执行
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 1.打开谷歌浏览器
     * 2.打开百度首页
     * 3.等待5s
     * 4.关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void backTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().back();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void forwardTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().back();
        Thread.sleep(3000);
        //浏览器前进
        driver.navigate().forward();
        driver.quit();
    }

    @Test
    public void refreshTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //浏览器后退
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * 设置窗口大小以及最大化
     */
    @Test
    public void winTest() throws InterruptedException {
        //实例化Dimension，设置窗口大小
        Dimension dimension = new Dimension(300, 300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(30000);
        //窗口最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void getUrlTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的url是：" + url);
        Assert.assertEquals(url, "https://www.baidu.com/");
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod  //每次Case执行后，都会执行
    public void closeBrowser() {
        driver.quit();
    }
}
