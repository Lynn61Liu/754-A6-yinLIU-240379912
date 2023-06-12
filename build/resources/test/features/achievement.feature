Feature: achievement

  Scenario: User can view all achievements
    Given I visit the achievements page with id 123456
    When the correct achievements page is loaded
    Then I can see all achievements
    And I can see the state of the achievement

  Scenario: The user can view their achievements change state
    Given I am on the achievements page with id 123456
    When I achieve an achievement
    Then I can see the state of the achievement change

  Scenario: The user can view unachieved achievements
    Given I am on the achievements page with id 123456
    When I click the view Unachieved achievements button
    Then I can see the achievements that I haven't achieved yet

  Scenario: The user can view achieved achievements
    Given I am on the achievements page with id 123456
    When I click the view Achieved achievements button
    Then I can see the achievements that I have achieved