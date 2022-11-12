@sanity
Feature: Bank login functionality

  Scenario Outline: parabank login scenario
    Given user launch parabank page
    When user enter credentials "<UserName>" and "<Password>"
    And click login button
    Then user should view home page
    And user should close application

    Examples: 
      | UserName    | Password    |
      | Hello.Bye   | Hello.Bye   |
      | nxtgendemo  | nxtgendemo  |
      | nxtgendemo1 | nxtgendemo1 |
