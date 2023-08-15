package com.conxillium.actions;

import com.conxillium.locators.LoginPageLocators;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAction {
    LoginPageLocators loginPageLocators;

    public LoginPageAction() {
        this.loginPageLocators = new LoginPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
    }

    public WebElement getPageTitle() {
        WebElement pageTitle = loginPageLocators.pageTitle;
        return pageTitle;
    }

    public WebElement getUserNameField() {
        WebElement userName = loginPageLocators.userName;
        return userName;
    }

    public WebElement getPasswordField() {
        WebElement password = loginPageLocators.password;
        return password;
    }

    public WebElement getLoginButton() {
        WebElement loginButton = loginPageLocators.loginButton;
        return loginButton;
    }
}
