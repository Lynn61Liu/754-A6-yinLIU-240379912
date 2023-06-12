Feature: Search for content with filters

  Scenario Outline: Search course use search bar
    Given I see have search bar at the search page
    When I type the <keyword> in the input
    And I click on the search button
    Then I should see search page with <num> course
    Examples:
      | keyword       |num|
      | Java          |2|
      | robots        |1|
      | Coding        |1|
      | OS            |1|


  Scenario Outline:  courses filter by category
    Given I visit the search page
    When I click on the <category> button
    Then  I should see <num> filter courses in search page

    Examples:
      | category       |num|
      | "programming"  |2|
      | "Systems"      |1|
      | "Robotics"     |1|
      | "BootCamp"     |1|

  Scenario: sort all course alphabetically
    Given I navigate to the search page
    When I click on the sort button
    Then  I should see courses order alphabetically
