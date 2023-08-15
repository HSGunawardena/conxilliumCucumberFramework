package com.conxillium.stepDefs;

import com.conxillium.actions.AddNewRecordPageAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class AddNewRecordPageSteps {
    AddNewRecordPageAction addNewRecordPageAction = new AddNewRecordPageAction();

    @And("user is on Add Data page")
    public void userIsOnAddDataPage() {
        Assert.assertTrue("URL does not contain /AddressManager/add", getDriver().getCurrentUrl().contains("/AddressManager/add"));
        Assert.assertTrue(addNewRecordPageAction.getPageTitle().getText().contains("Add Data"));
    }

    @Then("user can see the {string} field and it's empty")
    public void userCanSeeTheFieldAndItSEmpty(String field) {
        switch (field) {
            case "Full Name":
                Assert.assertTrue("Full Name field is not displayed", addNewRecordPageAction.getFullName().isDisplayed());
                Assert.assertTrue("Full Name field is not empty", addNewRecordPageAction.getFullName().getAttribute("value").isEmpty());
                break;
            case "Age":
                Assert.assertTrue("Age field is not displayed", addNewRecordPageAction.getAge().isDisplayed());
                Assert.assertTrue("Age field is not empty", addNewRecordPageAction.getAge().getAttribute("value").isEmpty());
                break;
            case "Address":
                Assert.assertTrue("Address field is not displayed", addNewRecordPageAction.getAddress().isDisplayed());
                Assert.assertTrue("Address field is not empty", addNewRecordPageAction.getAddress().getAttribute("value").isEmpty());
                break;
            case "Birthday":
                Assert.assertTrue("Birthday field is not displayed", addNewRecordPageAction.getBirthday().isDisplayed());
                Assert.assertTrue("Birthday field is not empty", addNewRecordPageAction.getBirthday().getAttribute("value").isEmpty());
                break;
            case "Country":
                Assert.assertTrue("Country field is not displayed", addNewRecordPageAction.getCountry().isDisplayed());
                Assert.assertTrue("Country field is not empty", addNewRecordPageAction.getCountry().getAttribute("value").isEmpty());
                break;
            case "Expertise":
                List<WebElement> expertiseElements = addNewRecordPageAction.getExpertise();
                for (WebElement expertise : expertiseElements) {
                    Assert.assertTrue(expertise.isDisplayed());
                    Assert.assertFalse(expertise.isSelected());
                }
                break;
            case "Gender":
                List<WebElement> genderElements = addNewRecordPageAction.getGender();
                for (WebElement gender : genderElements) {
                    Assert.assertTrue(gender.isDisplayed());
                    Assert.assertFalse(gender.isSelected());
                }
                break;
        }
    }

    @Then("user can see the {string} button")
    public void userCanSeeTheButton(String button) {
        switch (button) {
            case "Submit":
                Assert.assertTrue(addNewRecordPageAction.getSubmitButton().isDisplayed());
                break;
            case "Reset":
                Assert.assertTrue(addNewRecordPageAction.getResetButton().isDisplayed());
                break;
        }
    }

    @When("user fill the {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void userFillTheAnd(String fullName, String age, String address, String birthday, String country, String expertise, String gender) {
        addNewRecordPageAction.getFullName().sendKeys(fullName);
        addNewRecordPageAction.getAge().sendKeys(age);
        addNewRecordPageAction.getAddress().sendKeys(address);
        addNewRecordPageAction.getBirthday().sendKeys(birthday);
        addNewRecordPageAction.setCountry(country);
        List<WebElement> expertiesElements = addNewRecordPageAction.getExpertise();
        switch (expertise) {
            case "ANGULAR":
                expertiesElements.get(0).click();
                expertiesElements.get(0).isSelected();
                break;
            case "JAVA":
                expertiesElements.get(1).click();
                expertiesElements.get(1).isSelected();
                break;
            case "C#":
                expertiesElements.get(2).click();
                expertiesElements.get(2).isSelected();
                break;
            case "GIT":
                expertiesElements.get(3).click();
                expertiesElements.get(3).isSelected();
                break;
            case "HTML":
                expertiesElements.get(4).click();
                expertiesElements.get(4).isSelected();
                break;
        }
        List<WebElement> genderElements = addNewRecordPageAction.getGender();
        switch (gender) {
            case "MALE":
                genderElements.get(0).click();
                genderElements.get(0).isSelected();
                break;
            case "FEMALE":
                genderElements.get(1).click();
                genderElements.get(1).isSelected();
                break;
        }
    }

    @And("user clicks on Reset button")
    public void userClicksOnResetButton() {
        addNewRecordPageAction.getResetButton().click();
    }

    @Then("all the fields should be reset to default values")
    public void allTheFieldsShouldBeResetToDefaultValues() {
        Assert.assertTrue("Full Name field is not reset", addNewRecordPageAction.getFullName().getAttribute("value").isEmpty());
        Assert.assertTrue("Age field is not reset", addNewRecordPageAction.getAge().getAttribute("value").isEmpty());
        Assert.assertTrue("Address field is not reset", addNewRecordPageAction.getAddress().getAttribute("value").isEmpty());
        Assert.assertTrue("Birthday field is not reset", addNewRecordPageAction.getBirthday().getAttribute("value").isEmpty());
        Assert.assertTrue("Country field is not reset", addNewRecordPageAction.getCountry().getAttribute("value").isEmpty());
        List<WebElement> expertiseElements = addNewRecordPageAction.getExpertise();
        for (WebElement expertise : expertiseElements) {
            Assert.assertTrue(expertise.isDisplayed());
            Assert.assertFalse(expertise.isSelected());
        }
        List<WebElement> genderElements = addNewRecordPageAction.getGender();
        for (WebElement gender : genderElements) {
            Assert.assertTrue(gender.isDisplayed());
            Assert.assertFalse(gender.isSelected());
        }
    }

    @And("user clicks on Submit button")
    public void userClicksOnSubmitButton() {
        addNewRecordPageAction.getSubmitButton().click();
    }

    @Then("the submission should be unsuccessful")
    public void theSubmissionShouldBeUnsuccessful() {
        String classValues = addNewRecordPageAction.getAddress().getAttribute("class");
        Assert.assertTrue("Address field error was not shown", classValues.contains("form-field--error"));
    }

    @Then("the address field error is not available")
    public void theAddressFieldErrorIsNotAvailable() {
        String classValues = addNewRecordPageAction.getAddress().getAttribute("class");
        Assert.assertFalse("Address field error was shown", classValues.contains("form-field--error"));
    }
}
