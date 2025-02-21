@activity4
Feature: Data driven test without Examples

  Scenario: Testing with correct data from inputs
    Given the user is on login page
    When the user enters "admin" and "password"
    And click on the submit button
    Then get the confirmation text and verify message as "Welcome Back, Admin!"