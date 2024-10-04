@Parameterization
Feature: Parameterization Feature

  Background: Load the page
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters valid credentials
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver

  @ParameterizedPositiveLogin
  Scenario: Login with valid credentials parameterized
    When the user enters username "talentifylab@gmail.com" password "Talentify.123"
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver

  Scenario:  Login with invalid username valid password
    When the user enters username "xyz" password "Talentify.123"
    And the user clicks on submit button
    Then the user sees the error message
    And close the driver

  @Parallel
  Scenario:  Login with valid username invalid password
    When the user enters username "talentifylab@gmail.com" password "xyz"
    And the user clicks on submit button
    Then the user sees the error message
    And close the driver

  @SmokeTest
  Scenario:  Login with empty credentials
    When the user enters username "" password ""
    And the user clicks on submit button
    Then the user sees the error message
    And close the driver


