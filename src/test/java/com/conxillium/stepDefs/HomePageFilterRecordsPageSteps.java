package com.conxillium.stepDefs;

import com.conxillium.pages.HomePageFilterRecordsPage;
import com.conxillium.pages.MapPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class HomePageFilterRecordsPageSteps {
    HomePageFilterRecordsPage homePageFilterRecordsPage = new HomePageFilterRecordsPage();
    MapPage mapPage = new MapPage();

    @And("user clicks on Add New button")
    public void userClicksOnAddNewButton() {
        homePageFilterRecordsPage.getAddNewButton().click();
    }

    @Then("the new record with {string} is created")
    public void theNewRecordWithIsCreated(String fullName) {
        Assert.assertTrue("User " + fullName + " was not created", homePageFilterRecordsPage.getDataTable()
                .getText().contains(fullName));
    }

    @Then("user can see the View Data title by default")
    public void userCanSeeTheViewDataTitleByDefault() {
        Assert.assertTrue(homePageFilterRecordsPage.getPageTitle().getText().contains("View Data"));
    }

    @And("user can see Filter Full Name and Filter Country fields")
    public void userCanSeeFilterFullNameAndFilterCountryFields() {
        Assert.assertTrue(
                "Filter Full Name field was not displayed",
                homePageFilterRecordsPage.getFilterFullNameField().isDisplayed()
        );
        Assert.assertTrue(
                "Filter Country field was not displayed",
                homePageFilterRecordsPage.getFilterCountry().isDisplayed()
        );
    }

    @And("user can see Filter and Add New buttons")
    public void userCanSeeFilterAndAddNewButtons() {
        Assert.assertTrue(
                "Filter button was not displayed",
                homePageFilterRecordsPage.getFilterButton().isDisplayed()
        );
        Assert.assertTrue(
                "Add New button was not displayed",
                homePageFilterRecordsPage.getAddNewButton().isDisplayed()
        );
    }

    @Then("user can see the navigation bar with values")
    public void userCanSeeTheNavigationBarWithValues() {
        Assert.assertTrue(
                "Address Manager navigation bar text was not visible",
                homePageFilterRecordsPage.getNavigationBarAddressManagerTitle().isDisplayed()
        );
        Assert.assertTrue(
                "Home navigation bar text was not visible",
                homePageFilterRecordsPage.getNavigationBarHome().isDisplayed()
        );
        Assert.assertTrue(
                "Add navigation bar text was not visible",
                homePageFilterRecordsPage.getNavigationBarAdd().isDisplayed()
        );
        Assert.assertTrue(
                "View navigation bar text was not visible",
                homePageFilterRecordsPage.getNavigationBarView().isDisplayed()
        );
    }

    @And("user can see the Data Table")
    public void userCanSeeTheDataTable() {
        Assert.assertTrue(
                "User Data Table was not displayed",
                homePageFilterRecordsPage.getDataTable().isDisplayed()
        );
    }

    @When("user click on {string} on navigation bar")
    public void userClickOnOnNavigationBar(String item) {
        if (item.equals("Address Manager")) {
            homePageFilterRecordsPage.getNavigationBarAddressManagerTitle().click();
            Assert.assertTrue(
                    "User was not taken to Home page by" + item,
                    getDriver().getCurrentUrl().contains("/AddressManager/view")
            );
        } else if (item.equals("Home")) {
            homePageFilterRecordsPage.getNavigationBarHome().click();
            Assert.assertTrue(
                    "User was not taken to Home page by" + item,
                    getDriver().getCurrentUrl().contains("/AddressManager/view")
            );
        } else if (item.equals("Add")) {
            homePageFilterRecordsPage.getNavigationBarAdd().click();
            Assert.assertTrue(
                    "User was not taken to Add page by" + item,
                    getDriver().getCurrentUrl().contains("/AddressManager/add")
            );
        } else if (item.equals("View")) {
            homePageFilterRecordsPage.getNavigationBarView().click();
            Assert.assertTrue(
                    "User was not taken to View page by" + item,
                    getDriver().getCurrentUrl().contains("/AddressManager/view")
            );
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
        final int rowCount = homePageFilterRecordsPage.getDataTableRows().size();
        Assert.assertTrue(rowCount == 10);
        if (category.equals("name")) {
            homePageFilterRecordsPage.getFilterFullNameField().sendKeys(value);
        } else if (category.equals("country")) {
            homePageFilterRecordsPage.getFilterCountry().sendKeys(value);
        }
    }

    @And("click on Filter button")
    public void clickOnFilterButton() {
        homePageFilterRecordsPage.getFilterButton().click();
    }

    @Then("user {string} is filtered in the table")
    public void userIsFilteredInTheTable(String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(homePageFilterRecordsPage.getTableLastRowElement()));
        final int rowCount = homePageFilterRecordsPage.getDataTableRows().size();
        Assert.assertTrue("Row count was not 1", rowCount == 1);
        List<WebElement> getNames = homePageFilterRecordsPage.getDataTableRows();
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
        if (header.equals("Full Name")) {
            homePageFilterRecordsPage.getFullNameHeaderFilter().click();
        } else if (header.equals("Country")) {
            homePageFilterRecordsPage.getCountryHeaderFilter().click();
        }
    }

    @And("user selects {string} option")
    public void userSelectsOption(String option) {
        homePageFilterRecordsPage.selectFilterCriteria(option);
    }

    @And("user enter the {string} to filter")
    public void userEnterTheToFilter(String value) {
        homePageFilterRecordsPage.getTableHeaderFilterFullNameField().sendKeys(value);
    }

    @When("user clicks on view map link")
    public void userClicksOnViewLink() {
        List<WebElement> viewLinks = homePageFilterRecordsPage.getViewLink();
        viewLinks.get(5).click();
    }

    @Then("user is taken to map page and map is shown")
    public void userIsTakenToDetailsPage() {
        Assert.assertEquals(
                "User was not navigated to correct details page",
                true,
                getDriver().getCurrentUrl().contains("/map/")
        );
        Assert.assertFalse(
                "Page should not contain 404 Error",
                mapPage.getPageTitle().getText().contains("404")
        );
    }
}
