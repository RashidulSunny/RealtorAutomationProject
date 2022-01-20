Feature: Test login functionalities

  Background:
    Given user is on the login page
    And the user clicks on the login link

  @positive_test
  Scenario: Check login is successful with valid credentials
    When the user clicks on the continue button upon entering the email "sunny09203019@gmail.com"
    And the user clicks on the login button upon entering the password "Test123@123"
    Then the user is successfully logged in

  @positive_test @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials
    When the user clicks on the continue button upon entering the email "<emailAddress>"
    And the user clicks on the login button upon entering the password "<password>"
    Then the user is successfully logged in

    Examples:
      | emailAddress            | password    |
      | sunny09203019@gmail.com | Test123@123 |


  @negative_test
  Scenario: Check login is unsuccessful with invalid password
    When the user clicks on the continue button upon entering the email "sunny09203019@gmail.com"
    And the user clicks on the login button upon entering the password "test123"
    Then Then the user is failed to log in due to the error "Email and/or Password do not match"
