Feature: learn

  Background: Navigate directly to learning page as default user
    Given I visit the learning page with the id 123
    When the learning page loads

  Scenario: User can see the learning contents
    Then I should see the learning contents
