Feature: Airtable API Test
  @api
  Scenario: Verify status code of get endpoint
    When I hit the GET endpoint
    Then I expect status code to be "200"
    And I verify the name of first record to be "MAX"
