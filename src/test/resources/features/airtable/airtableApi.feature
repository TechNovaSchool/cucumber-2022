Feature: Airtable API Test
  @api
  Scenario: Verify status code of get endpoint
    When I hit the GET endpoint
    Then I expect status code to be "200"
    And I verify the name of first record to be "MAX"

@apiSecondTest
  Scenario: Check POST endpoint
    When I create a record
    And I check status code is 200
    Then I am able to get recordID
    And I update the record email to name
    And I check status code is 200
    And I delete the record
    And I check status code is 200
