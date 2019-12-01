package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class waitTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 等待一：线程等待：Thread.sleep(时间)
     * <p>
     * 等待二：(隐式等待)全局等待：driver.manage().timeouts().implicitlyWait(时间，TimeUnit.SECONDS)
     * <p>
     * 等待三：显示等待：
     * new WebDriverWait(driver,30).until(ExpectedConditions,presenceOfElementLocated(By))
     */

    //推荐隐式等待
    public void waitTest() {
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String text = driver.findElement(By.linkText("xxxxxx")).getText();
        Assert.assertEquals(text, "xxxxx");
    }
}
