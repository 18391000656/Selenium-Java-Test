package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionsTest2 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度按钮
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest() {
        driver.get("http://www.baidu.com");

        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions这个类
        Actions actions = new Actions(driver);
        //在百度一下按钮上右键
        actions.contextClick(buttonBaidu).perform();
    }

    /**
     * 打开百度按钮
     * 在百度一下按钮上双击
     */
    @Test
    public void doubleClickTest() {
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));

        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
    }

    /**
     * 把鼠标移动到百度首页更多产品时展示文本信息
     */
    @Test
    public void moveTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement move = driver.findElement(By.linkText("设置"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(move).perform();
    }

    /**
     * 模拟crtl+s保存
     */
    @Test
    public void saveHtmlTest() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
        //按Ctrl键
        robot.keyPress(KeyEvent.VK_CONTROL);
        //按S键

        /**
         * 把一个值转化为AICI值
         */
//        int Keys = (int)new Character('A');
//        System.out.println(Keys);
//        robot.keyPress(Keys);

        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        //按enter键
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放Crtl键
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * 百度文件上传
     */
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div[2]/input")).sendKeys("C:\\Users\\ZL\\Pictures\\Camera Roll\\545741979a1a7.jpg");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
