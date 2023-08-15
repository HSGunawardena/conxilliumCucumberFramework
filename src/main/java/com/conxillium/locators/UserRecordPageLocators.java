package com.conxillium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRecordPageLocators {
    @FindBy(tagName = "h2")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(), 'Add New')]")
    public WebElement addNewButton;

    @FindBy(xpath = "//div[@ref=\"eCenterContainer\"]")
    public WebElement dataTable;
}
