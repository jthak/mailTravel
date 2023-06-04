@booking
Feature:Travel Booking

  Scenario:User should be able to complete travel booking successfully

    Given user is on the homepage of mail travel
    When user search for India in search box on home page
    And user clicks on Book online button
    And user selects next available date
    And user confirms details of travel on next page
    And user fill passenger details
    Then user should verify user details for booking successfully