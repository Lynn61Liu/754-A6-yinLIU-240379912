Feature: settings

  Scenario: The user can access and edit their settings
    Given I am in the Settings page with id 123456789
    When I change a user setting
    And I press the save button
    Then the settings should save