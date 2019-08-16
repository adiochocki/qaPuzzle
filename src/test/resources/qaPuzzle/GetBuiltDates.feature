Feature: Get built dates

  Scenario Outline: User select Mercedes to get main type in different Languages
    Given I open the page
    And select language "DE"
    And I have selected "<carMark>" as a car mark
    And I have selected "<carType>" as a car type
    When I want to select car build dates
    Then the status code is 200
    And response is not empty
    And response includes the following "<dates>"

    Examples:
      | carMark | carType            | dates          |
      | 570     | GLA-Klasse         | 2013,2014,2019 |
      | 905     | Golf VII Sportsvan | 2013,2014,2019 |
      | 285     | Mustang            | 2005,2010,2019 |
