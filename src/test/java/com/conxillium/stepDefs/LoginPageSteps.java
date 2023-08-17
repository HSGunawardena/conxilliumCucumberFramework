package com.conxillium.stepDefs;

import com.conxillium.pages.LoginPage;
import com.conxillium.utils.HelperClass;
import com.conxillium.utils.PropertyFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.conxillium.utils.HelperClass.getDriver;

public class LoginPageSteps {
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the Login page")
    public void userIsOnTheLoginPage() {
        String baseUrl = propertyFileReader.getProperty("config", "base.url");
        HelperClass.openPage(baseUrl);
    }

    @Then("user can see the Welcome title by default")
    public void userCanSeeTheWelcomeTitleByDefault() {
        Assert.assertTrue(loginPage.getPageTitle().getText().contains("Welcome"));
    }

    @Then("user can see Username and Password fields")
    public void userCanSeeUsernameAndPasswordFields() {
        Assert.assertTrue(loginPage.getUserNameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }

    @Then("user can see Login button")
    public void userCanSeeLoginButton() {
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());

    }

    @When("user enter {string} and {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.getUserNameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
    }

    @When("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("user is not able to login")
    public void userIsNotAbleToLogin() {
        getDriver().switchTo().alert().getText().contains("Invalid Credentials!");
        getDriver().switchTo().alert().dismiss();
        Assert.assertTrue(
                "URL does not contain /AddressManager/login",
                getDriver().getCurrentUrl().contains("/AddressManager/login")
        );
    }

    @Then("user is able to login")
    public void userIsAbleToLogin() {
        Assert.assertTrue(
                "URL does not contain /AddressManager/view",
                getDriver().getCurrentUrl().contains("/AddressManager/view")
        );
    }
}
