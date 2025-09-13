
Feature: Open New Account

  Scenario: User opens a new savings account successfully
    Given User navigates to Open New Account page
    When User selects account type "SAVINGS"
    And User selects an existing account to deposit a minimum amount at the time of opening
    And clicks the open new account button
    Then It should be listed in Accounts Overview
