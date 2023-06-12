Feature: courseOverview
  Background: Navigate directly to course overview as default user1
    Given I visit the course overview page with id 123456789
    When the correct course overview page is loaded

  # In a final refactor we have combined three acceptance criteria for user story #L2 into the below scenario
  # This includes the following four original scenarios which you can find in the git history of the pull request for L2
  # Scenario: The same view content is shown for a course content (AC1)
  # Scenario: User can see the details about the content such as the name, estimated time, difficulty rating, and topic. (AC2)
  # Scenario: User can view a syllabus of the content structure, such as what core principles/knowledge taught in order. (AC3)
  Scenario: The course overview page displays all the correct content about the course
    Then the course name is displayed correctly
    And the course category is displayed correctly
    And the course description is displayed correctly
    And the course format is displayed correctly
    And the course topic is displayed correctly
    And all learning modules for the course are displayed correctly
    And all practice modules for the course are displayed correctly
    And the estimated time of the course is displayed correctly
    And the difficulty rating of the course is displayed correctly
    And the course syllabus is present
    And the course syllabus is ordered correctly

  Scenario: The Practice list is displayed in order of dates
    Then the practice list is displayed in order of dates

  Scenario: User can add the learning content to their enrolled content.
    And I click on the enrol in course button
    Then the course is added to my enrolled courses

  Scenario: User can view if their learning modules are completed or not.
    Then the course progress is displayed correctly

  Scenario Outline: Users can navigate to the learning page Correctly
    And I click on the navigate <button>
    Then the correct learning module page is loaded with the correct <link>
    Examples:
      | button        | link       |
      | "navButton_0" | "/learn/0" |
      | "navButton_1" | "/learn/1" |
      | "navButton_2" | "/learn/2" |