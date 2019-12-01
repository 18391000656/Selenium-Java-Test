package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
    /**
     * 163邮箱
     */

    //定义email文本框的定位方式
    public static By emailInput = By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //地位登录按钮的定位方式
    public static By loginButton = By.id("dologin");
    //去注册定位方式
    public static By registerButton = By.id("changepage");

}
