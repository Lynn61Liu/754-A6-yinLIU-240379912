Feature: View Learning Analytics
  Scenario: Navigating to analysis section
    Given I am a user on the application
    When I click the navigation page button
    Then I should be redirected to the analytics page

  Scenario: Analysis section should be able to show user progress
    Given I am on the analytics page
    When The analytics page is loaded
    Then I should be able to see my progress on the analytics page
  Scenario: View Progress bar of the course
    Given I am on the analytics page
    When The analytics page is loaded
    Then I should be able to see a progress bar for my course
  Scenario: Progress bar should update when a module is finished
    Given I am on the analytics page
    When The analytics page is loaded
    Then The progress bar should show an updated visual compared to last time