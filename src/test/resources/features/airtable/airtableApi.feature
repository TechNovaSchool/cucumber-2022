Feature: Airtable API Test
  @api
  Scenario: Verify status code of get endpoint
    When I hit the GET endpoint
    Then I expect status code to be "200"
