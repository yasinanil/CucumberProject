@Practice05
Feature: Practice 05

  Scenario: Add Record
    Given go to "https://yasinanil67.github.io/addRecordWebTable"
    When user enters name, age and country using excel and assert it
    Then  close the driver

