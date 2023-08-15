package com.conxillium.actions;

import com.conxillium.locators.AddNewRecordPageAction;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAction {
    AddNewRecordPageAction addNewRecordPageAction = null;

    public LoginPageAction() {
        this.addNewRecordPageAction = new AddNewRecordPageAction();

        PageFactory.initElements(HelperClass.getDriver(), addNewRecordPageAction);
    }

    public WebElement getPageTitle() {
        WebElement pageTitle = addNewRecordPageAction.pageTitle;
        return pageTitle;
    }

    public WebElement getUserNameField() {
        WebElement userName = addNewRecordPageAction.userName;
        return userName;
    }

    public WebElement getPasswordField() {
        WebElement password = addNewRecordPageAction.password;
        return password;
    }

    public WebElement getLoginButton() {
        WebElement loginButton = addNewRecordPageAction.loginButton;
        return loginButton;
    }
}
