package com.conxillium.actions;

import com.conxillium.locators.AddNewRecordPageLocators;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class AddNewRecordPageAction {
    AddNewRecordPageLocators addNewRecordPageLocators;
    Select countryDropDown = null;

    public AddNewRecordPageAction() {
        this.addNewRecordPageLocators = new AddNewRecordPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), addNewRecordPageLocators);
    }

    public WebElement getPageTitle() {
        WebElement pageTitle = addNewRecordPageLocators.pageTitle;
        return pageTitle;
    }

    public WebElement getFullName() {
        WebElement fullName = addNewRecordPageLocators.fullName;
        return fullName;
    }

    public WebElement getAge() {
        WebElement age = addNewRecordPageLocators.age;
        return age;
    }

    public WebElement getAddress() {
        WebElement address = addNewRecordPageLocators.address;
        return address;
    }

    public WebElement getBirthday() {
        WebElement birthday = addNewRecordPageLocators.birthday;
        return birthday;
    }

    public WebElement getCountry() {
        WebElement country = addNewRecordPageLocators.country;
        return country;
    }

    public List<WebElement> getExpertise() {
        List<WebElement> expertise = addNewRecordPageLocators.expertise;
        return expertise;
    }

    public List<WebElement> getGender() {
        List<WebElement> gender = addNewRecordPageLocators.gender;
        return gender;
    }

    public WebElement getSubmitButton() {
        WebElement submitButton = addNewRecordPageLocators.submitButton;
        return submitButton;
    }

    public WebElement getResetButton() {
        WebElement resetButton = addNewRecordPageLocators.resetButton;
        return resetButton;
    }

    public void setCountry(String country) {
        this.countryDropDown = new Select(getCountry());
        countryDropDown.selectByValue(country);
    }
}
