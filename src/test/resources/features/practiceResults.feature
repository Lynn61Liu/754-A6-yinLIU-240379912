Feature: practiceResult (User Story P4)
  Scenario: The practice results should be displayed on completion of the practice module (AC10
    Given I visit the results of any arbitrary practice session
    When the practice results page successfully loads
    Then there should be a pass or fail result displayed

  Scenario: Users should receive feedback on questions that they answered correctly, as a percentage
    Given I visit the results of a practice session where I got 4 out of 6 questions correct
    When the practice results page successfully loads
    Then there should be a percentage of how many questions I answered correctly
    And the percentage should be 66.66 percent

  Scenario: Users should also see a list of incorrectly answered questions, where each question also has a correct answer provided
    Given I visit the results of a practice session where I got 4 out of 6 questions correct
    When the practice results page successfully loads
    Then the questions I got wrong should be listed
    And the answers for those questions are displayed

  Scenario: Users can opt to try the incorrect questions again
    Given I visit the results of a practice session where I got 4 out of 6 questions correct
    And the practice results page successfully loads
    When I click on the retry practice button
    Then the page should change to the practice page