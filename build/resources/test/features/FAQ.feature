Feature: FAQ

Scenario: View FAQ page
Given I navigate to the login page
When I click the Help/FAQ links in page foot
Then I should see FAQ page

  Scenario Outline: View specific question
    Given I see a list of question titles on the Help/FAQ page
    When I click the <buttonID> of one Question
    Then  this <TextID> text style is <answerDisplayStyle>
    Examples:
      | buttonID   | TextID        | answerDisplayStyle |
      | "btn_1"    |  "text_1"     |"block"           |
      | "btn_3"    |  "text_3"      |"block"             |
      | "btn_2"    |  "text_2"      |"block"             |


