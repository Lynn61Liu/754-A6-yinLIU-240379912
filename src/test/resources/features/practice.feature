Feature: practice

  Background: Navigate directly to MCQ as default user
    Given I visit the MCQ page with the id 123
    When the MCQ page loads

  Scenario: User can see the question
    Then I should see the question boolean is the same as string
    And I should see the question what is an example of a character

  Scenario: Progress updates when user clicks through answers
    When I click the first answer
    Then I should see the progress bar is one out of total questions
    When I click the third answer
    Then I should see the progress bar is two out of total questions

  Scenario: User is notified if they have answered correctly
    When I click the second answer
    When I click the third answer
    When I click submit
    Then The second answer correctness is shown
    And The third answer correctness is shown
    And The first answer correctness is not shown
    And The fourth answer correctness is not shown
