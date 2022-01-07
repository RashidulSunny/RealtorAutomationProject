Feature: Rental Functionality


  Scenario: Search all rental home in Queens, NY
    Given user is in the realtor home page for searching home for rent
    And user navigate to rent page
    When user type place "Queens,NY" inside search box and click search button
    Then user can see all home for rent in Queens, NY