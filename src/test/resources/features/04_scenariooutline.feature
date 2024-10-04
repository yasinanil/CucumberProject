@ScenarioOutline @Parallel
Feature: Scenario Outline Feature

  Background: Load Page
    Given the user is on the login page

  Scenario Outline: Scenario Outline Test
    When the user enters username "<username>" password "<password>"
    And the user clicks on submit button
    Then the user sees the error message
    And close the driver
    Examples:
      | username               | password      |
      | talentifylab@gmail.com | xyz           |
      | xyz                    | Talentify.123 |
      |                        | Talentify.123 |
      | talentifylab@gmail.com |               |
      |                        |               |
