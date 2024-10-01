@Background
Feature: Background Feature

  Background:
    Given the user is on the login page

  @PositiveLogin
  Scenario: Login Test With Background
    When the user enters valid credentials
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver

  @NegativeLogin
  Scenario: Negative Login Test With Background
    When the user enters invalid credentials
    And the user clicks on submit button
    Then the user sees the error message
    And close the driver

  @EmptyCredentials
  Scenario: Negative Login Test With Empty Credentials
    When the user clicks on submit button
    Then the user sees the error message
    And close the driver