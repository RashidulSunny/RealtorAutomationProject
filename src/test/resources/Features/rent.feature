Feature: Rental Functionality


  Scenario Outline: Search for a home to rent
    Given the user is on the realtor home page
    And user navigates to the rent page
    When the user clicks on the search button upon typing the address "<Address>"
    Then the user can see all the available homes to rent
  Examples:
    | Address   |
    | Queens NY |


