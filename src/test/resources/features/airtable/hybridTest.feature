Feature: Creating and verifying a record

  @hybridTest
  Scenario: Airtable login and record verification

Given Navigate to login page
When  Enter the email address
And   Enter the password
And   press the sign in button
Then  Home base page should appear
And   Click on Transformers button
When I add a new record
Then I will check with API that record was saved