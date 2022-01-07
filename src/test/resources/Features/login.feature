Feature: Test login functionalities

  Background:
    Given user is on the login page and click on Login Link

  @positive_test
  Scenario: Check login is successful with valid credentials
    When user enters emailAddress "sunny09203019@gmail.com" and click on continue button
    And user enters password "Test123@123" and click on login button
    Then user is navigated to home page

  @positive_test @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials
    When user enters emailAddress "<emailAddress>" and click on continue button
    And user enters password "<password>" and click on login button
    Then user is navigated to home page

    Examples:
      | emailAddress            | password    |
      | sunny09203019@gmail.com | Test123@123 |


  @negative_test
  Scenario: Check login is unsuccessful with invalid password
    When user enters emailAddress "sunny09203019@gmail.com" and click on continue button
    And user enters password "test123" and click on login button
    Then user is failed to login
