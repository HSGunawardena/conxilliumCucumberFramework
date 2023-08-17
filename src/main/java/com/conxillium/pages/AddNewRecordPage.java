package com.conxillium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class AddNewRecordPage {
    private final By pageTitle = By.tagName("h2");
    private final By fullName = By.id("fullName");
    private final By age = By.id("age");
    private final By address = By.id("address");
    private final By birthday = By.name("dp");
    private final By country = By.id("country");
    private final By expertise = By.xpath("//input[@type='checkbox']");
    private final By gender = By.xpath("//input[@type='radio']");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By resetButton = By.xpath("//input[@type='reset']");

    public WebElement getPageTitle() {
        return getDriver().findElement(this.pageTitle);
    }

    public WebElement getFullName() {
        return getDriver().findElement(this.fullName);
    }

    public WebElement getAge() {
        return getDriver().findElement(this.age);
    }

    public WebElement getAddress() {
        return getDriver().findElement(this.address);
    }

    public WebElement getBirthday() {
        return getDriver().findElement(this.birthday);
    }

    public WebElement getCountry() {
        return getDriver().findElement(this.country);
    }

    public List<WebElement> getExpertise() {
        return getDriver().findElements(this.expertise);
    }

    public List<WebElement> getGender() {
        return getDriver().findElements(this.gender);
    }

    public WebElement getSubmitButton() {
        return getDriver().findElement(this.submitButton);
    }

    public WebElement getResetButton() {
        return getDriver().findElement(this.resetButton);
    }

    public void setCountry(String country) {
        Select countryDropDown = new Select(getCountry());
        countryDropDown.selectByValue(country);
    }
}
