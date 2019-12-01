package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    @Test
    public void openFirefox1() {
        //默认安装且火狐版本《=47
        WebDriver webDriver = new FirefoxDriver();
        webDriver.quit();
    }

    @Test
    public void openFirefox2() {
        //不是默认安装
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.baidu.com");
        webDriver.quit();
    }

    @Test
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        Thread.sleep(5000);
        webDriver.quit();
    }

    @Test
    public void openIE() {
        System.setProperty("webdriver.ie.driver", "E:\\IdeaProjects\\Selenium\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
        webDriver.quit();
    }

    @Test
    public void openEdge() {
        System.setProperty("webdriver.edge.driver", "E:\\IdeaProjects\\Selenium\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
        webDriver.quit();
    }


}
