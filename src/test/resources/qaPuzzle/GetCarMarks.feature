Feature: Get car marks

  Scenario: User calls web service to get car marks
    Given I open the page
    When I see car marks loaded
    Then the status code is 200
    And response is not empty
    And response includes the following
      | '905' | Volkswagen      |
      | '570' | Mercedes-Benz   |
      | '895' | Piaggio (Vespa) |