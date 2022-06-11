Feature: This feature would be used to design the Login page of the application

  Background: Open the application
    Given User is on the login page

  @Regression
  Scenario Outline: To validate the positive login
    When User enters username "<Username>"
    And User enters password "<Password>"
    And User clicks on Login button
    Then User should be landed on the Products Page

    Examples: 
      | UserName      | Password       |
      | standard_user | secrert_ sauce |

  Scenario Outline: To validate the negative login
    When User enters username "<Username>"
    And User enters password "<Password>"
    And User clicks on Login button
    Then User should be getting the error message "Epic sadface: Username and password do not match any user in this service."

    Examples: 
      | UserName      | Password      |
      | standard_user | secret_sauce1 |
