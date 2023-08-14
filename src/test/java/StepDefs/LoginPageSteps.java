package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("user is on the login page");
    }

    @Then("user can see the {string} by default")
    public void user_can_see_the_item_by_default(String item) {
        System.out.println("user can see the " + item + " by default");

    }

    @When("user enter {string} and {string}")
    public void user_enter_username_and_password(String username, String password) {
        System.out.println("user enter " + username + " and " + password + "");

    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        System.out.println("user clicks on Login button");

    }

    @Then("user is not able to login")
    public void user_is_not_able_to_login() {
        System.out.println("user is not able to login");

    }

    @Then("user is able to login")
    public void user_is_able_to_login() {
        System.out.println("user is able to login");

    }
}
