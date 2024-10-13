Feature: Registration Page Feature

  @RegistrationPositive
  Scenario: Registration Page Positive Scenario
    Given go to "https://yasinanil67.github.io/Registration"
    When enter the ssn "345-34-9876"
    And enter the firstname "John" and lastname "Doe"
    And enter the gender "Male" and job "Tester"
    And upload the CV
    And enter the username "johndoe", email "johndoe@gmail.com" and password "John.1234"
    And click on register
    Then validate registration message
    And close the driver

  @RegistrationNegative
  Scenario: Registration Page With Invalid SSN
    Given go to "https://yasinanil67.github.io/Registration"
    When enter the ssn "345-34-987"
    And enter the firstname "John" and lastname "Doe"
    And enter the gender "Male" and job "Tester"
    And upload the CV
    And enter the username "johndoe", email "johndoe@gmail.com" and password "John.1234"
    And click on register
    Then validate registration message did not appear
    And close the driver



