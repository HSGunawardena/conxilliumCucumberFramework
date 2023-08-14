package com.conxillium.stepDefs;

import com.conxillium.actions.LoginPageAction;
import com.conxillium.utils.HelperClass;
import com.conxillium.utils.PropertyFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.conxillium.utils.HelperClass.getDriver;

public class LoginPageSteps {
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    LoginPageAction loginPageAction = new LoginPageAction();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String baseUrl = propertyFileReader.getProperty("config", "base.url");
        HelperClass.openPage(baseUrl);
    }

    @Then("user can see the Welcome title by default")
    public void user_can_see_the_welcome_title_by_default() {
        Assert.assertTrue(loginPageAction.getPageTitle().getText().contains("Welcome"));
    }

    @Then("user can see Username and Password fields")
    public void user_can_see_username_and_password_fields() {
        Assert.assertTrue(loginPageAction.getUserNameField().isDisplayed());
        Assert.assertTrue(loginPageAction.getPasswordField().isDisplayed());
    }

    @Then("user can see Login button")
    public void user_can_see_login_button() {
        Assert.assertTrue(loginPageAction.getLoginButton().isDisplayed());

    }

    @When("user enter {string} and {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginPageAction.getUserNameField().sendKeys(username);
        loginPageAction.getPasswordField().sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPageAction.getLoginButton().click();
    }

    @Then("user is not able to login")
    public void user_is_not_able_to_login() {
        getDriver().switchTo().alert().getText().contains("Invalid Credentials!");
        getDriver().switchTo().alert().dismiss();
        Assert.assertTrue("URL does not contain /AddressManager/login", getDriver().getCurrentUrl().contains("/AddressManager/login"));
    }

    @Then("user is able to login")
    public void user_is_able_to_login() {
        Assert.assertTrue("URL does not contain /AddressManager/view", getDriver().getCurrentUrl().contains("/AddressManager/view"));
    }
}
