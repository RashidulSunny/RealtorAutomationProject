Feature: Mortgage Calculator & Refinance Calculator


  Scenario: Calculate monthly mortgage payment
    Given user is in the realtor home page for searching mortgage calculator
    And user navigate to mortgage page
    When user can see the monthly mortgage payment upon entering the data
      | HomePrice | DownPayment | InterestRate | PropertyTax |
      | 1000000   | 195000      | 4            | 1016        |
    Then The monthly mortgage payment is "$5,085"

  Scenario: Calculate new monthly payment after refinancing
    Given user is in the realtor home page for searching refinance calculator
    And user navigate to refinance page
    When user can see the new monthly payment upon entering the data
      | OriginalLoanAmount | OriginalLoanRate | CurrentBalance | NewLoanRate |
      | 500000             | 4                | 305000         | 3.420       |
    Then The new monthly payment after refinancing is "1,056"
