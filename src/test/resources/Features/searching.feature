Feature: Searching Functionality
  Background:
    Given user is in home page for searching house
  Scenario: Searching House by zip code
    When user enter zip code "11365" on search text box and click on search icon
    Then user can see all newest listings home

  Scenario: Sorting Bed Room
    When user enter zip code "11423" on search text box and click on search icon
    And user click on bed tab and select 3 bedroom
    Then user can see home with 3 bedroom
