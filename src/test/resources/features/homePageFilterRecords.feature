@Smoke @Regression @Home
Feature: Home Page Filter Table Tests

  Background:
    Given user is on the Login page
    And user enter "admin" and "admin@123"
    And user clicks on Login button
    And user is able to login

  Scenario: Home page content verification
    Then user can see the navigation bar with values
    And user can see the View Data title by default
    And user can see Filter Full Name and Filter Country fields
    And user can see Filter and Add New buttons
    And user can see the Data Table

  Scenario Outline: Navigation bar verification
    When user click on "<item>" on navigation bar
    Then user is navigated to "<page>" page by "<item>"
    Examples:
      | item            | page |
      | Address Manager | view |
      | Home            | view |
      | Add             | add  |
      | View            | view |

  Scenario Outline: Filter table data with Full Name and Country verification
    When user enter "<value>" to Filter "<category>" filed
    And click on Filter button
    Then user "<value>" is filtered in the table
    Examples:
      | value              | category |
      | Queen              | name     |
      | Maldonado          | name     |
      | Russian Federation | country  |
      | Kuwait             | country  |

  Scenario Outline: Filter table data using Name column header
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