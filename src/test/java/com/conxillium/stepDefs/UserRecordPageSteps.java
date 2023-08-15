package com.conxillium.stepDefs;

import com.conxillium.actions.UserRecordPageAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserRecordPageSteps {
    UserRecordPageAction userRecordPageAction = new UserRecordPageAction();

    @And("user clicks on Add New button")
    public void userClicksOnAddNewButton() {
        userRecordPageAction.getAddNewButton().click();
    }

    @Then("the new record with {string} is created")
    public void theNewRecordWithIsCreated(String fullName) {
        Assert.assertTrue("User " + fullName + " was not created", userRecordPageAction.getDataTable().getText().contains(fullName));
    }
}
