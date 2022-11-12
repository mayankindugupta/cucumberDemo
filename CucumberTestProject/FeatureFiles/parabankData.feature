@smoke
Feature: Bank login functionality

  Scenario: Login using valid credentials
    Given user is on login page
    When user enters the "Hello.Bye" and "Hello.Bye"
    And clicks on login button
    Then display user home page
    And user will close the application
