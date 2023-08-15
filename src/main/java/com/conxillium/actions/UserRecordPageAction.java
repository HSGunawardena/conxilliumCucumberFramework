package com.conxillium.actions;

import com.conxillium.locators.UserRecordPageLocators;
import com.conxillium.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserRecordPageAction {
    UserRecordPageLocators userRecordPageLocators = null;

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
}
