Feature: register

  Scenario: The user can register for an account
    Given I visit the register page
    When I enter "newemail@test.com" as the email field
    And I enter "newUser" as the username field
    And I enter "newPassword" as the password field
    And I press the register button
    Then I should receive a message indicating I have created an account

  Scenario: The user cannot register for an account with a taken email
    Given I visit the register page
    When I enter "user1@gmail.com" as the email field
    And I enter "newUser" as the username field
    And I enter "newPassword" as the password field
    And I press the register button
    Then I should receive a message indicating the email is taken

  Scenario: The user cannot register for an account with a taken username
    Given I visit the register page
    When I enter "test@gmail.com" as the email field
    And I enter "user1" as the username field
    And I enter "newPassword" as the password field
    And I press the register button
    Then I should receive a message indicating the username is taken