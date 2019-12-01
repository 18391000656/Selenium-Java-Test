package com.meyoung.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 点击百度首页的新闻链接
     * 那么我打开了新闻页面
     */
    @Test
    public void clickTest() {
        driver.get("http://www.baidu.com");
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        newslink.click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //断言，判断当前页面的url是http://news.baidu.com/
        Assert.assertEquals(url, "http://news.baidu.com/");
    }

    /**
     * 点击百度首页
     * 获取新闻文本
     * 校验是否为“selenium”
     * 再次获取输入狂框文本
     * 校验文本为空
     */
    @Test
    public void getText() {
        driver.get("http://www.baidu.com");
        String text = driver.findElement(By.name("tj_trnews")).getText();
        //校验获取的内容是否是“新闻”
        Assert.assertEquals(text, "新闻");
    }

    /**
     * 获取元素属性值
     */
    @Test
    public void getATest() {
        driver.get("http://www.baidu.com");
        String attributeValue = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue, "百度一下");
    }

    /**
     * 判断元素是否展示isDisplay
     * 打开百度首页是否显示百度一下
     */
    @Test
    public void isDisplayTest() {
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * 判断选择框是否选中
     */
    @Test
    public void isSelectTest() {
        driver.get("xxxxxxxxxxxxxx");
        Boolean a = driver.findElement(By.xpath("xxxxxx")).isSelected();
        Assert.assertTrue(a);
    }

    /**
     * 判断元素是否激活（置灰状态）
     */
    @Test
    public void isEnabledTest() {
        driver.get("xxxxxxxxxxx");
        Boolean c = driver.findElement(By.id("xxxxxxxxx")).isEnabled();
        Assert.assertFalse(c);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest() {
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("C:\\Users\\ZL\\Desktop\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
