package com.conxillium.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddNewRecordPageLocators {
    @FindBy(tagName = "h2")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(), 'Add New')]")
    public WebElement addNewButton;

    @FindBy(id = "fullName")
    public WebElement fullName;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(name = "dp")
    public WebElement birthday;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> expertise;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> gender;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@type='reset']")
    public WebElement resetButton;
}
