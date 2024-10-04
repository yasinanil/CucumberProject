@CrowBrowser @Parallel
Feature: Cross Browser Test Feature

  Scenario Outline: Login With Different Browsers
    Given set the browser type "<browser>"
    And the user is on the login page
    When the user enters valid credentials
    And the user clicks on submit button
    Then the user should be redirected to the contact list
    And close the driver
    Examples:
      | browser |
      | edge    |
      | firefox |
      | chrome  |

