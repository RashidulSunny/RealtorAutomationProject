Feature: Buy Functionality


  Scenario Outline: Search for a new home to buy
    Given the user is on the realtor home page for searching home for buy
    And user navigate to buy page
    When the user clicks on the search icon upon typing the address "<Address>"
    Then the user can see all the available homes
  Examples:
    | Address        |
    | Hicksville, NY |