@Smoke @Regression @NewRecords
Feature: Add New Records Page Tests

  Background:
    Given user is on the Login page
    And user enter "admin" and "admin@123"
    And user clicks on Login button
    And user is able to login
    And user clicks on Add New button
    And user is on Add Data page

  Scenario Outline: Verify the default status of the fields on the Add New Form
    Then user can see the "<field>" field and it's empty
    Examples:
      | field     |
      | Full Name |
      | Age       |
      | Address   |
      | Birthday  |
      | Country   |
      | Expertise |
      | Gender    |

  Scenario Outline: Verify the buttons availability below the Add New Form
    Then user can see the "<button>" button
    Examples:
      | button |
      | Submit |
      | Reset  |

  Scenario Outline: Verify the required address field
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    Then the address field error is not available
    And user clicks on Submit button
    Then the submission should be unsuccessful
    Examples:
      | fullName           | age | address | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  |         | 1991-10-31 | Sri Lanka | JAVA      | MALE   |
@Test
  Scenario Outline: Verify if the reset button clears the form
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    And user clicks on Reset button
    Then all the fields should be reset to default values
    Examples:
      | fullName           | age | address      | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  | 427, Gampaha | 1989-10-31 | Sri Lanka | JAVA      | MALE   |

  Scenario Outline: Verify submitting a new record
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    And user clicks on Submit button
    Then the new record with "<fullName>" is created
    Examples:
      | fullName           | age | address      | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  | 427, Gampaha | 1991-10-31 | Sri Lanka | JAVA      | MALE   |