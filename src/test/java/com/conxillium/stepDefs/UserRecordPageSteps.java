package com.conxillium.stepDefs;

import com.conxillium.actions.UserRecordPageAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class UserRecordPageSteps {
    UserRecordPageAction userRecordPageAction = new UserRecordPageAction();

    @And("user clicks on Add New button")
    public void userClicksOnAddNewButton() {
        userRecordPageAction.getAddNewButton().click();
    }

    @Then("the new record with {string} is created")
    public void theNewRecordWithIsCreated(String fullName) {
        Assert.assertTrue("User " + fullName + " was not created", userRecordPageAction.getDataTable()
                .getText().contains(fullName));
    }

    @Then("user can see the View Data title by default")
    public void userCanSeeTheViewDataTitleByDefault() {
        Assert.assertTrue(userRecordPageAction.getPageTitle().getText().contains("View Data"));
    }

    @And("user can see Filter Full Name and Filter Country fields")
    public void userCanSeeFilterFullNameAndFilterCountryFields() {
        Assert.assertTrue(
                "Filter Full Name field was not displayed",
                userRecordPageAction.getFilterFullNameField().isDisplayed()
        );
        Assert.assertTrue(
                "Filter Country field was not displayed",
                userRecordPageAction.getFilterCountry().isDisplayed()
        );
    }

    @And("user can see Filter and Add New buttons")
    public void userCanSeeFilterAndAddNewButtons() {
        Assert.assertTrue(
                "Filter button was not displayed",
                userRecordPageAction.getFilterButton().isDisplayed()
        );
        Assert.assertTrue(
                "Add New button was not displayed",
                userRecordPageAction.getAddNewButton().isDisplayed()
        );
    }

    @Then("user can see the navigation bar with values")
    public void userCanSeeTheNavigationBarWithValues() {
        Assert.assertTrue(
                "Address Manager navigation bar text was not visible",
                userRecordPageAction.getNavigationBarAddressManagerTitle().isDisplayed()
        );
        Assert.assertTrue(
                "Home navigation bar text was not visible",
                userRecordPageAction.getNavigationBarHome().isDisplayed()
        );
        Assert.assertTrue(
                "Add navigation bar text was not visible",
                userRecordPageAction.getNavigationBarAdd().isDisplayed()
        );
        Assert.assertTrue(
                "View navigation bar text was not visible",
                userRecordPageAction.getNavigationBarView().isDisplayed()
        );
    }

    @And("user can see the Data Table")
    public void userCanSeeTheDataTable() {
        Assert.assertTrue(
                "User Data Table was not displayed",
                userRecordPageAction.getDataTable().isDisplayed()
        );
    }

    @When("user click on {string} on navigation bar")
    public void userClickOnOnNavigationBar(String item) {
        switch (item) {
            case "Address Manager":
                userRecordPageAction.getNavigationBarAddressManagerTitle().click();
                break;
            case "Home":
                userRecordPageAction.getNavigationBarHome().click();
                Assert.assertTrue(
                        "User was not taken to Home page",
                        getDriver().getCurrentUrl().contains("/AddressManager/view")
                );
                break;
            case "Add":
                userRecordPageAction.getNavigationBarAdd().click();
                Assert.assertTrue(
                        "User was not taken to Add page",
                        getDriver().getCurrentUrl().contains("/AddressManager/add")
                );
                break;
            case "View":
                userRecordPageAction.getNavigationBarView().click();
                Assert.assertTrue(
                        "User was not taken to View page",
                        getDriver().getCurrentUrl().contains("/AddressManager/view")
                );
                break;
        }
    }

    @Then("user is navigated to {string} page by {string}")
    public void userIsNavigatedToSpecificPage(String page, String item) {
        Assert.assertTrue(
                "User was not taken to " + page + " page when clicked on " + item,
                getDriver().getCurrentUrl().contains("/AddressManager/" + page)
        );
    }

    @When("user enter {string} to Filter {string} filed")
    public void userEnterToFilterFiled(String value, String category) {
        final int rowCount = userRecordPageAction.getDataTableRows().size();
        Assert.assertTrue(rowCount == 10);
        System.out.println(category);
        switch (category) {
            case "name":
                userRecordPageAction.getFilterFullNameField().sendKeys(value);
                break;
            case "country":
                userRecordPageAction.getFilterCountry().sendKeys(value);
                break;
        }
    }

    @And("click on Filter button")
    public void clickOnFilterButton() {
        userRecordPageAction.getFilterButton().click();
    }

    @Then("user {string} is filtered in the table")
    public void userIsFilteredInTheTable(String value) {
        final int rowCount = userRecordPageAction.getDataTableRows().size();
        Assert.assertTrue("Row count was not 1", rowCount == 1);
        List<WebElement> getNames = userRecordPageAction.getDataTableRows();
        for (WebElement getName : getNames) {
            Assert.assertEquals(
                    "Correct name '" + value + "' was not filtered",
                    true,
                    getName.getText().contains(value)
            );
        }
    }

    @When("user selects {string} header filter button")
    public void userSelectsHeaderFilterButton(String header) {
        switch (header) {
            case "Full Name":
                userRecordPageAction.getFullNameHeaderFilter().click();
                break;
            case "Country":
                userRecordPageAction.getCountryHeaderFilter().click();
                break;
        }
    }

    @And("user selects {string} option")
    public void userSelectsOption(String option) {
        userRecordPageAction.selectFilterCriteria(option);
    }

    @And("user enter the {string} to filter")
    public void userEnterTheToFilter(String value) {
        userRecordPageAction.getTableHeaderFilterFullNameField().sendKeys(value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
