package com.conxillium.stepDefs;

import com.conxillium.pages.AddNewRecordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.List;

import static com.conxillium.utils.HelperClass.getDriver;

public class AddNewRecordPageSteps {
    AddNewRecordPage addNewRecordPage = new AddNewRecordPage();

    @And("user is on Add Data page")
    public void userIsOnAddDataPage() {
        Assert.assertTrue(
                "URL does not contain /AddressManager/add",
                getDriver().getCurrentUrl().contains("/AddressManager/add")
        );
        Assert.assertTrue(addNewRecordPage.getPageTitle().getText().contains("Add Data"));
    }

    @Then("user can see the {string} field and it's empty")
    public void userCanSeeTheFieldAndItSEmpty(String field) {
        if (field.equals("Full Name")) {
            Assert.assertTrue(
                    "Full Name field is not displayed",
                    addNewRecordPage.getFullName().isDisplayed()
            );
            Assert.assertTrue(
                    "Full Name field is not empty",
                    addNewRecordPage.getFullName().getAttribute("value").isEmpty()
            );
        } else if (field.equals("Age")) {
            Assert.assertTrue(
                    "Age field is not displayed",
                    addNewRecordPage.getAge().isDisplayed()
            );
            Assert.assertTrue(
                    "Age field is not empty",
                    addNewRecordPage.getAge().getAttribute("value").isEmpty()
            );
        }
        if (field.equals("Address")) {
            Assert.assertTrue(
                    "Address field is not displayed",
                    addNewRecordPage.getAddress().isDisplayed()
            );
            Assert.assertTrue(
                    "Address field is not empty",
                    addNewRecordPage.getAddress().getAttribute("value").isEmpty()
            );
        }
        if (field.equals("Birthday")) {
            Assert.assertTrue(
                    "Birthday field is not displayed",
                    addNewRecordPage.getBirthday().isDisplayed()
            );
            Assert.assertTrue(
                    "Birthday field is not empty",
                    addNewRecordPage.getBirthday().getAttribute("value").isEmpty()
            );
        }
        if (field.equals("Country")) {
            Assert.assertTrue(
                    "Country field is not displayed",
                    addNewRecordPage.getCountry().isDisplayed()
            );
            Assert.assertTrue(
                    "Country field is not empty",
                    addNewRecordPage.getCountry().getAttribute("value").isEmpty()
            );
        }
        if (field.equals("Expertise")) {
            List<WebElement> expertiseElements = addNewRecordPage.getExpertise();
            for (WebElement expertise : expertiseElements) {
                Assert.assertTrue(expertise.isDisplayed());
                Assert.assertFalse(expertise.isSelected());
            }
        }
        if (field.equals("Gender")) {
            List<WebElement> genderElements = addNewRecordPage.getGender();
            for (WebElement gender : genderElements) {
                Assert.assertTrue(gender.isDisplayed());
                Assert.assertFalse(gender.isSelected());
            }
        }
    }

    @Then("user can see the {string} button")
    public void userCanSeeTheButton(String button) {
        if (button.equals("Submit")) {
            Assert.assertTrue(addNewRecordPage.getSubmitButton().isDisplayed());
        } else if (button.equals("Reset"))
            Assert.assertTrue(addNewRecordPage.getResetButton().isDisplayed());
    }

    @When("user fill the {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void userFillTheAnd(
            String fullName,
            String age,
            String address,
            String birthday,
            String country,
            String expertise,
            String gender) {
        addNewRecordPage.getFullName().sendKeys(fullName);
        addNewRecordPage.getAge().sendKeys(age);
        addNewRecordPage.getAddress().sendKeys(address);
        addNewRecordPage.getBirthday().sendKeys(birthday);
        addNewRecordPage.setCountry(country);
        List<WebElement> expertiseElements = addNewRecordPage.getExpertise();
        if (expertise.equals("ANGULAR")) {
            expertiseElements.get(0).click();
            expertiseElements.get(0).isSelected();
        } else if (expertise.equals("JAVA")) {
            expertiseElements.get(1).click();
            expertiseElements.get(1).isSelected();
        } else if (expertise.equals("C#")) {
            expertiseElements.get(2).click();
            expertiseElements.get(2).isSelected();
        } else if (expertise.equals("GIT")) {
            expertiseElements.get(3).click();
            expertiseElements.get(3).isSelected();
        } else if (expertise.equals("HTML")) {
            expertiseElements.get(4).click();
            expertiseElements.get(4).isSelected();
        }
        List<WebElement> genderElements = addNewRecordPage.getGender();
        if (gender.equals("MALE")) {
            genderElements.get(0).click();
            genderElements.get(0).isSelected();
        } else if (gender.equals("FEMALE")) {
            genderElements.get(1).click();
            genderElements.get(1).isSelected();
        }
    }

    @And("user clicks on Reset button")
    public void userClicksOnResetButton() {
        addNewRecordPage.getResetButton().click();
    }

    @Then("all the fields should be reset to default values")
    public void allTheFieldsShouldBeResetToDefaultValues() {
        Assert.assertTrue(
                "Full Name field is not reset",
                addNewRecordPage.getFullName().getAttribute("value").isEmpty()
        );
        Assert.assertTrue(
                "Age field is not reset",
                addNewRecordPage.getAge().getAttribute("value").isEmpty()
        );
        Assert.assertTrue(
                "Address field is not reset",
                addNewRecordPage.getAddress().getAttribute("value").isEmpty()
        );
        Assert.assertTrue(
                "Birthday field is not reset",
                addNewRecordPage.getBirthday().getAttribute("value").isEmpty()
        );
        Assert.assertTrue(
                "Country field is not reset",
                addNewRecordPage.getCountry().getAttribute("value").isEmpty()
        );
        List<WebElement> expertiseElements = addNewRecordPage.getExpertise();
        for (WebElement expertise : expertiseElements) {
            Assert.assertTrue(expertise.isDisplayed());
            Assert.assertFalse(expertise.isSelected());
        }
        List<WebElement> genderElements = addNewRecordPage.getGender();
        for (WebElement gender : genderElements) {
            Assert.assertTrue(gender.isDisplayed());
            Assert.assertFalse(gender.isSelected());
        }
    }

    @And("user clicks on Submit button")
    public void userClicksOnSubmitButton() {
        addNewRecordPage.getSubmitButton().click();
    }

    @Then("the submission should be unsuccessful")
    public void theSubmissionShouldBeUnsuccessful() {
        String classValues = addNewRecordPage.getAddress().getAttribute("class");
        Assert.assertTrue("Address field error was not shown", classValues.contains("form-field--error"));
    }

    @Then("the address field error is not available")
    public void theAddressFieldErrorIsNotAvailable() {
        String classValues = addNewRecordPage.getAddress().getAttribute("class");
        Assert.assertFalse("Address field error was shown", classValues.contains("form-field--error"));
    }
}
