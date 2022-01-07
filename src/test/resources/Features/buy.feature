Feature: Buy Functionality


  Scenario: Search new home for buy in Hicksville, NY
    Given user is in the realtor home page for searching home for buy
    And user navigate to buy page
    When user type address "Hicksville,NY" inside search box and click search icon
    Then user can see all  home for buy in Hicksville, NY