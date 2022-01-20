Feature: Find Realtor Agent Functionality


  Scenario Outline: Find a realtor agent to sell a property
    Given user is in the realtor home page for searching a realtor agent for sell a property
    And user navigate to real estate agent page
    When user type home address "<Address>" inside search box and click search button
    Then user can see real estate agent

    Examples:
      | Address                              |
      | 7104 162nd St Fresh Meadows NY 11365 |