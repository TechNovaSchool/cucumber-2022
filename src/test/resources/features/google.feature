@regression @login
Feature: Google feature test verification

  Here we can add some details about the test
  #to comments
  #Given, When, Then, And

  Scenario: Google title verification
    Given I am at google home page
    When I verify the title is Google
@google
  Scenario: Google search test
    Given I am at google home page
    When I search for dark web
    Then I verify the title contains dark web
