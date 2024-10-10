@Grid
Feature: Selenium Grid Feature

  Scenario: Selenium Grid Scenario
    Given go to "https://yasinanil67.github.io/signIn" via remote driver
    When the user enters username "admin" password "123" via remote driver
    And the user clicks on submit button via remote driver
    Then close the driver
