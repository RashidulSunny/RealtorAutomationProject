Feature: Sorting Functionality

  Scenario: Sorting Bed Room
    Given user is in home page for sorting house
    When user enter zip code "11423" on search text box and click on search icon
    And user click on bed tab and select 3 bedroom
    Then user can see home with 3 bedroom

