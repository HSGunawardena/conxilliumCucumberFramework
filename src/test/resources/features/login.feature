@Smoke @Regression @Login
Feature: Login Page Tests

  Background:
    Given user is on the Login page

  Scenario: Login page content verification
    Then user can see the Welcome title by default
    And user can see Username and Password fields
    And user can see Login button

  Scenario Outline: Verify Login to the system with invalid credentials
    When user enter "<username>" and "<password>"
    And user clicks on Login button
    Then user is not able to login
    Examples:
      | username | password |
      | Admin    | admin123 |
      | admin    | Admin123 |
      | 2343     | 2342345  |

  Scenario Outline: Verify Login to the system with valid credentials
    When user enter "<username>" and "<password>"
    And user clicks on Login button
    Then user is able to login
    Examples:
      | username | password  |
      | admin    | admin@123 |