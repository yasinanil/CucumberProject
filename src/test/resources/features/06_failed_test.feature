@FailedLogin
Feature: Failed Feature

  @PositiveLogin @SmokeTest
  Scenario: Failed Login 1
    Given the user is on the login page
    When the user enters username "talentifylab@gmail.com" password "Talentify.123"
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver

  @PositiveLogin @SmokeTest
  Scenario: Failed Login 2
    Given the user is on the login page
    When the user enters username "talentifylab@gmail.com" password "Talentify.123"
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver