@Smoke @Regression
Feature: Login Page Tests

  Background:
    Given user is on the login page

  @Smoke
  Scenario: Login page content verification
    Then user can see the Welcome title by default
    And user can see Username and Password fields
    And user can see Login button

  @Smoke
  Scenario Outline: Login to the system with incorrect credentials
    When user enter "<username>" and "<password>"
    And user clicks on Login button
    Then user is not able to login

    Examples:
      | username | password |
      | Admin    | admin123 |
      | admin    | Admin123 |
      | 2343     | 2342345  |

  @Smoke
  Scenario Outline: Login to the system with correct credentials
    When user enter "<username>" and "<password>"
    And user clicks on Login button
    Then user is able to login

    Examples:
      | username | password |
      | admin    | admin@123 |