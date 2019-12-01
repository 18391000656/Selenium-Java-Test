package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgDemo2 {
    @BeforeMethod
    public void start() throws InterruptedException {
        Thread.sleep(3000);
    }

    //校验 a == a ？？？；
    @Test
    public void assertEqualTest() {
        String a = "asdf";
        String b = "asdf";

        Assert.assertEquals(a,b);
       // Assert.assertEquals(a, b);
        //Assert.assertEquals失败后，代码不会继续向下执行
        System.out.println("1111111111");
    }

    @Test
    public void assertNoEqualTest() {
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a, b);
    }

    @Test
    public void assertNull() {
        String a = null;
        Assert.assertNull(a);
    }

    @Test
    public void assertNotNull() {
        String a = "啊啊";
        Assert.assertNotNull(a);
    }
}
