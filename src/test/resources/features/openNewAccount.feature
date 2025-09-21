
Feature: Open New Account
  @openNewAccount
  Scenario: User opens a new savings account successfully
    Given User navigates to Open New Account page
    When User selects account type "SAVINGS"
    And User selects an existing account to deposit a minimum amount at the time of opening
    And clicks the open new account button
    Then Account should be created successfully with new account number
    And it should be reflected in account overview section
