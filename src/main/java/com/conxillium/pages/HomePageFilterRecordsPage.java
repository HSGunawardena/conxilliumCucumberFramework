package com.conxillium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class HomePageFilterRecordsPage {
    private final By pageTitle = By.tagName("h2");
    private final By addNewButton = By.xpath("//a[contains(text(), 'Add New')]");
    private final By filterButton = By.xpath("//input[@value='Filter']");
    private final By dataTable = By.xpath("//div[@ref='eCenterContainer']");
    private final By dataTableRows = By.xpath("//div[@ref='eCenterContainer']/div[@role='row']");
    private final By filterFullNameField = By.xpath("//input[@placeholder='Filter Full Name']");
    private final By filterCountryField = By.xpath("//input[@placeholder='Filter Country']");
    private final By navigationBarAddressManagerTitle = By.xpath("//a[contains(text(), 'Address Manager')]");
    private final By navigationBarHome = By.xpath("//a[contains(text(), 'Home')]");
    private final By navigationBarAdd = By.xpath("(//a[contains(text(), 'Add')])[2]");
    private final By navigationBarView = By.xpath("//a[contains(text(), 'View')]");
    private final By fullNameHeaderFilterButton = By.xpath("(//span[@ref='eMenu'])[1]");
    private final By countryHeaderFilterButton = By.xpath("(//span[@ref='eMenu'])[2]");
    private final By lastTableRow = By.xpath("(//div[@row-id='9'])[2]");
    private final By filterCriteria = By.id("filterType");
    private final By tableHeaderFilterFullNameField = By.id("filterText");
    private final By viewLink = By.linkText("View");

    public WebElement getPageTitle() {
        return getDriver().findElement(this.pageTitle);
    }

    public WebElement getAddNewButton() {
        return getDriver().findElement(this.addNewButton);
    }

    public WebElement getDataTable() {
        return getDriver().findElement(this.dataTable);
    }

    public List<WebElement> getDataTableRows() {
        return getDriver().findElements(this.dataTableRows);
    }

    public By getTableLastRowElement() {
        return this.lastTableRow;
    }

    public WebElement getFilterFullNameField() {
        return getDriver().findElement(this.filterFullNameField);
    }

    public WebElement getFilterCountry() {
        return getDriver().findElement(this.filterCountryField);
    }

    public WebElement getFilterButton() {
        return getDriver().findElement(this.filterButton);
    }

    public WebElement getNavigationBarAddressManagerTitle() {
        return getDriver().findElement(this.navigationBarAddressManagerTitle);
    }

    public WebElement getNavigationBarHome() {
        return getDriver().findElement(this.navigationBarHome);
    }

    public WebElement getNavigationBarAdd() {
        return getDriver().findElement(this.navigationBarAdd);
    }

    public WebElement getNavigationBarView() {
        return getDriver().findElement(this.navigationBarView);
    }

    public WebElement getFullNameHeaderFilter() {
        return getDriver().findElement(this.fullNameHeaderFilterButton);
    }

    public WebElement getCountryHeaderFilter() {
        return getDriver().findElement(this.countryHeaderFilterButton);
    }

    public WebElement getFilterCriteria() {
        return getDriver().findElement(this.filterCriteria);
    }

    public void selectFilterCriteria(String option) {
        Select filterCriteriaDropDown = new Select(getFilterCriteria());
        filterCriteriaDropDown.selectByValue(option);
    }

    public WebElement getTableHeaderFilterFullNameField() {
        return getDriver().findElement(this.tableHeaderFilterFullNameField);
    }

    public List<WebElement> getViewLink(){
        return getDriver().findElements(this.viewLink);
    }
}
