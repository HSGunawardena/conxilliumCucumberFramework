package com.conxillium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageFilterRecordsPageLocators {
    @FindBy(tagName = "h2")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(), 'Add New')]")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@value='Filter']")
    public WebElement filterButton;

    @FindBy(xpath = "//div[@ref='eCenterContainer']")
    public WebElement dataTable;

    @FindBy(xpath = "//div[@ref='eCenterContainer']/div[@role='row']")
    public List<WebElement> dataTableRows;

    @FindBy(xpath = "//input[@placeholder='Filter Full Name']")
    public WebElement filterFullNameField;

    @FindBy(xpath = "//input[@placeholder='Filter Country']")
    public WebElement filterCountryField;

    @FindBy(xpath = "//a[contains(text(), 'Address Manager')]")
    public WebElement navigationBarAddressManagerTitle;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    public WebElement navigationBarHome;

    @FindBy(xpath = "(//a[contains(text(), 'Add')])[2]")
    public WebElement navigationBarAdd;

    @FindBy(xpath = "//a[contains(text(), 'View')]")
    public WebElement navigationBarView;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    public WebElement fullNameHeaderFilterButton;

    @FindBy(xpath = "(//span[@ref='eMenu'])[2]")
    public WebElement countryHeaderFilterButton;

    @FindBy(id = "filterType")
    public WebElement filterCriteria;

    @FindBy(id = "filterText")
    public WebElement tableHeaderFilterFullNameField;

    @FindBy(xpath = "(//div[@comp-id=\"479\"])[2]")
    public WebElement lastTableRow;
}
