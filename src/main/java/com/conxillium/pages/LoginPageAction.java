package com.conxillium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.conxillium.utils.HelperClass.getDriver;

public class LoginPageAction {
    private final By pageTitle = By.tagName("h1");
    private final By userName = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.className("btn");

    public WebElement getPageTitle() {
        return getDriver().findElement(this.pageTitle);
    }

    public WebElement getUserNameField() {
        return getDriver().findElement(this.userName);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(this.password);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(this.loginButton);
    }
}
