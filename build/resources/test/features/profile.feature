Feature: profile

  Scenario: The user can edit their profile settings
    Given I visit my profile page with id 123456789
    When I change the visibility of a profile section
    And I press the save button for profile
    Then the visibility of the profile sections should save

  Scenario: The user can set the visibility of their profile
    Given I visit my profile page with id 123456789
    When I change the visibility of my profile
    And I save the profile visibility
    Then the overall visibility of my profile should be saved