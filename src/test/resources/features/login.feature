Feature: Login Functionality
  Scenario: Successful Login with valid Credentials
    Given User on the login page
    When User enter username "user" and password "Password123"
    And  click the "Login" button
    Then user should redirected to homepage