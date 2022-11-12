Feature: Bank login functionality

  Scenario: Login using valid credentials
    Given user on login page
    When user enters the credentials
      | UserName   | Password   |
      | nxtgendemo | nxtgendemo |
    And clicks at login button
    Then display views home page
    And user the application
