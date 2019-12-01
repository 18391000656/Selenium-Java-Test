package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    public GridTest() throws MalformedURLException {
    }

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities 类型
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.170.2:4444/wd/hub"), dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"firefox"},
                {"chrome"}};
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else if (browser.equals("chrome")) {
            dc = DesiredCapabilities.chrome();
        } else {
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.170.2:4444/wd/hub"), dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }

}
