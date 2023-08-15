package com.conxillium.actions;

import com.conxillium.locators.UserRecordPageLocators;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserRecordPageAction {
    UserRecordPageLocators userRecordPageLocators = null;
    private Select filterCriteriaDropDown;

    public UserRecordPageAction() {
        this.userRecordPageLocators = new UserRecordPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), userRecordPageLocators);
    }

    public WebElement getPageTitle() {
        WebElement pageTitle = userRecordPageLocators.pageTitle;
        return pageTitle;
    }

    public WebElement getAddNewButton() {
        WebElement addNewButton = userRecordPageLocators.addNewButton;
        return addNewButton;
    }

    public WebElement getDataTable() {
        WebElement dataTable = userRecordPageLocators.dataTable;
        return dataTable;
    }

    public List<WebElement> getDataTableRows() {
        List<WebElement> dataTableRows = userRecordPageLocators.dataTableRows;
        return dataTableRows;
    }

    public WebElement getFilterFullNameField() {
        WebElement filterFullNameField = userRecordPageLocators.filterFullNameField;
        return filterFullNameField;
    }

    public WebElement getFilterCountry() {
        WebElement filterCountryField = userRecordPageLocators.filterCountryField;
        return filterCountryField;
    }

    public WebElement getFilterButton() {
        WebElement filterButton = userRecordPageLocators.filterButton;
        return filterButton;
    }

    public WebElement getNavigationBarAddressManagerTitle() {
        WebElement navigationBarAddressManagerTitle = userRecordPageLocators.navigationBarAddressManagerTitle;
        return navigationBarAddressManagerTitle;
    }

    public WebElement getNavigationBarHome() {
        WebElement navigationBarHome = userRecordPageLocators.navigationBarHome;
        return navigationBarHome;
    }

    public WebElement getNavigationBarAdd() {
        WebElement navigationBarAdd = userRecordPageLocators.navigationBarAdd;
        return navigationBarAdd;
    }

    public WebElement getNavigationBarView() {
        WebElement navigationBarView = userRecordPageLocators.navigationBarView;
        return navigationBarView;
    }

    public WebElement getFullNameHeaderFilter() {
        WebElement fullNameHeaderFilterButton = userRecordPageLocators.fullNameHeaderFilterButton;
        return fullNameHeaderFilterButton;
    }

    public WebElement getCountryHeaderFilter() {
        WebElement countryHeaderFilterButton = userRecordPageLocators.countryHeaderFilterButton;
        return countryHeaderFilterButton;
    }

    public WebElement getFilterCriteria() {
        WebElement filterCriteria = userRecordPageLocators.filterCriteria;
        return filterCriteria;
    }

    public void selectFilterCriteria(String option) {
        this.filterCriteriaDropDown = new Select(getFilterCriteria());
        filterCriteriaDropDown.selectByValue(option);
    }

    public WebElement getTableHeaderFilterFullNameField() {
        WebElement tableHeaderFilterFullNameField = userRecordPageLocators.tableHeaderFilterFullNameField;
        return tableHeaderFilterFullNameField;
    }
}
