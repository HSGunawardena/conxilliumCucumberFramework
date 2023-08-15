package com.conxillium.actions;

import com.conxillium.locators.HomePageFilterRecordsPageLocators;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePageFilterRecordsPageAction {
    HomePageFilterRecordsPageLocators homePageFilterRecordsPageLocators = null;
    private Select filterCriteriaDropDown;

    public HomePageFilterRecordsPageAction() {
        this.homePageFilterRecordsPageLocators = new HomePageFilterRecordsPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), homePageFilterRecordsPageLocators);
    }

    public WebElement getPageTitle() {
        WebElement pageTitle = homePageFilterRecordsPageLocators.pageTitle;
        return pageTitle;
    }

    public WebElement getAddNewButton() {
        WebElement addNewButton = homePageFilterRecordsPageLocators.addNewButton;
        return addNewButton;
    }

    public WebElement getDataTable() {
        WebElement dataTable = homePageFilterRecordsPageLocators.dataTable;
        return dataTable;
    }

    public List<WebElement> getDataTableRows() {
        List<WebElement> dataTableRows = homePageFilterRecordsPageLocators.dataTableRows;
        return dataTableRows;
    }

    public WebElement getFilterFullNameField() {
        WebElement filterFullNameField = homePageFilterRecordsPageLocators.filterFullNameField;
        return filterFullNameField;
    }

    public WebElement getFilterCountry() {
        WebElement filterCountryField = homePageFilterRecordsPageLocators.filterCountryField;
        return filterCountryField;
    }

    public WebElement getFilterButton() {
        WebElement filterButton = homePageFilterRecordsPageLocators.filterButton;
        return filterButton;
    }

    public WebElement getNavigationBarAddressManagerTitle() {
        WebElement navigationBarAddressManagerTitle = homePageFilterRecordsPageLocators.navigationBarAddressManagerTitle;
        return navigationBarAddressManagerTitle;
    }

    public WebElement getNavigationBarHome() {
        WebElement navigationBarHome = homePageFilterRecordsPageLocators.navigationBarHome;
        return navigationBarHome;
    }

    public WebElement getNavigationBarAdd() {
        WebElement navigationBarAdd = homePageFilterRecordsPageLocators.navigationBarAdd;
        return navigationBarAdd;
    }

    public WebElement getNavigationBarView() {
        WebElement navigationBarView = homePageFilterRecordsPageLocators.navigationBarView;
        return navigationBarView;
    }

    public WebElement getFullNameHeaderFilter() {
        WebElement fullNameHeaderFilterButton = homePageFilterRecordsPageLocators.fullNameHeaderFilterButton;
        return fullNameHeaderFilterButton;
    }

    public WebElement getCountryHeaderFilter() {
        WebElement countryHeaderFilterButton = homePageFilterRecordsPageLocators.countryHeaderFilterButton;
        return countryHeaderFilterButton;
    }

    public WebElement getFilterCriteria() {
        WebElement filterCriteria = homePageFilterRecordsPageLocators.filterCriteria;
        return filterCriteria;
    }

    public void selectFilterCriteria(String option) {
        this.filterCriteriaDropDown = new Select(getFilterCriteria());
        filterCriteriaDropDown.selectByValue(option);
    }

    public WebElement getTableHeaderFilterFullNameField() {
        WebElement tableHeaderFilterFullNameField = homePageFilterRecordsPageLocators.tableHeaderFilterFullNameField;
        return tableHeaderFilterFullNameField;
    }
}
