@Smoke @Regression
Feature: Login Page Test Suite

  @Smoke
  Scenario Outline: Login page content verification
    Given user is on the login page
    Then user can see the "<item>" by default

    Examples:
      | item     |
      | Welcome  |
      | Username |
      | Password |
      | Login    |

  @Smoke
  Scenario Outline: Login to the system with incorrect credentials
    Given user is on the login page
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
    Given user is on the login page
    When user enter "<username>" and "<password>"
    And user clicks on Login button
    Then user is able to login

    Examples:
      | username | password |
      | admin    | admin123 |