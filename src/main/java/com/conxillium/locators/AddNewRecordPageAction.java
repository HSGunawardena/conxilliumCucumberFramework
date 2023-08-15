package com.conxillium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewRecordPageAction {
    @FindBy(tagName = "h1")
    public WebElement pageTitle;

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(className = "btn")
    public WebElement loginButton;
}
