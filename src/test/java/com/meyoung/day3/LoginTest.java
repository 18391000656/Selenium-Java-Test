package com.meyoung.day3;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void loginPoge(WebDriver driver,String email,String pwd){
        driver.get("https://mail.163.com/");
        driver.findElement(By.id("switchAccountLogin")).click();
        //driver控制权转交
        driver.switchTo().frame("x-URS-iframe1575165921366.1458");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
