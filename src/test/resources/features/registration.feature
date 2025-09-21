Feature: User Registration
  As a new user
  I want to register on the website
  So that I can log in and use the services
  Scenario: Successful user registration
    Given User navigates to the registration page
    When User enters registration details:
      | FirstName | LastName | Address       | City     | State | ZipCode | Phone       | SSN       | Username   | Password    | ConfirmPassword |
      | Ram      | C      | 123 Stret        | Chennai      | TN    | 10001   | 1234567890  | 123-45-6789 | user | Password123 | Password123    |
    And User clicks the "Register" button
    Then User should see a registration success message

