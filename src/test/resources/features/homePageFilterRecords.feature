@Smoke @Regression @Home
Feature: Home Page Filter Table Tests

  Background:
    Given user is on the Login page
    And user enter "admin" and "admin@123"
    And user clicks on Login button
    And user is able to login

  Scenario: Verify home page default values and fields
    Then user can see the navigation bar with values
    And user can see the View Data title by default
    And user can see Filter Full Name and Filter Country fields
    And user can see Filter and Add New buttons
    And user can see the Data Table

  Scenario Outline: Verify home page navigation bar behaviour when clicked on navigation items
    When user click on "<item>" on navigation bar
    Then user is navigated to "<page>" page by "<item>"
    Examples:
      | item            | page |
      | Address Manager | view |
      | Home            | view |
      | Add             | add  |
      | View            | view |

  Scenario Outline: Verify Filter option in the table data using Full Name and Country filter fields
    When user enter "<value>" to Filter "<category>" filed
    And click on Filter button
    Then user "<value>" is filtered in the table
    Examples:
      | value              | category |
      | Queen              | name     |
      | Maldonado          | name     |
      | Russian Federation | country  |
      | Kuwait             | country  |

  Scenario Outline: Verify Filter option in the table data using Full Name column and Country column in the header
    When user selects "<header>" header filter button
    And user selects "<option>" option
    And user enter the "<value>" to filter
    Then user "<value>" is filtered in the table
    Examples:
      | header    | option     | value          |
      | Full Name | contains   | Judy           |
      | Full Name | equals     | Hester Roberts |
      | Country   | startsWith | Un             |
      | Country   | endsWith   | y              |

  Scenario: Verify the view link of each raw of the table navigates to correct details page
    When user clicks on view map link
    Then user is taken to map page and map is shown