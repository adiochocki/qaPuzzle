Feature: Get main Types

  Scenario: User select Mercedes to get main type in different Languages
    Given I open the page
    And select language "DE"
    When I choose 570 as a car mark
    Then the status code is 200
    And response is not empty
    And response includes the following
      | 'C-Klasse' | C-Klasse |
      | 'MB 100'   | MB 100   |
      | 'M-Klasse' | M-Klasse |

    Given I open the page
    And select language "PL"
    When I choose 570 as a car mark
    Then the status code is 200
    And response is not empty
    And response includes the following
      | 'C-Klasse' | C-klasa |
      | 'MB 100'   | MB 100  |
      | 'M-Klasse' | M-klasa |

  Scenario: User select Volkswagen to get main type
    Given I open the page
    And select language "DE"
    When I choose 905 as a car mark
    Then the status code is 200
    And response is not empty
    And response includes the following
      | 'Golf VII Sportsvan' | Golf VII Sportsvan |
      | 'T4 Transporter'     | T4 Transporter     |
      | 'up!'                | up!                |