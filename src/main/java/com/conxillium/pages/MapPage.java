package com.conxillium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.conxillium.utils.HelperClass.getDriver;

public class MapPage {
    private final By pageTitle = By.tagName("h1");

    public WebElement getPageTitle() {
        return getDriver().findElement(this.pageTitle);
    }

}
