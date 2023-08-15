@Smoke @Regression @NewRecords
Feature: Add New Records

  Background:
    Given user is on the Login page
    And user enter "admin" and "admin@123"
    And user clicks on Login button
    And user is able to login
    And user clicks on Add New button
    And user is on Add Data page

  Scenario Outline: Form default content verification
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

  Scenario Outline: Form buttons verification
    Then user can see the "<button>" button
    Examples:
      | button |
      | Submit |
      | Reset  |

  Scenario Outline: Mandatory field verification for address field
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    Then the address field error is not available
    And user clicks on Submit button
    Then the submission should be unsuccessful
    Examples:
      | fullName           | age | address | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  |         | 1991-10-31 | Sri Lanka | JAVA      | MALE   |

  Scenario Outline: Reset button should clear the form
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    And user clicks on Reset button
    Then all the fields should be reset to default values
    Examples:
      | fullName           | age | address      | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  | 427, Gampaha | 1991-10-31 | Sri Lanka | JAVA      | MALE   |

  Scenario Outline: Submit a new record
    When user fill the "<fullName>", "<age>", "<address>", "<birthday>", "<country>", "<expertise>" and "<gender>"
    And user clicks on Submit button
    Then the new record with "<fullName>" is created
    Examples:
      | fullName           | age | address      | birthday   | country   | expertise | gender |
      | Saliya Gunawardena | 34  | 427, Gampaha | 1991-10-31 | Sri Lanka | JAVA      | MALE   |