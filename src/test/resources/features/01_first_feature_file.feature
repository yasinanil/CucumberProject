@Login
Feature: Login Functionality

  @PositiveLogin @SmokeTest
  Scenario: Successful Login with Valid Credentials
    Given the user is on the login page
    When the user enters valid credentials
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver