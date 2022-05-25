Feature: Wikipedia search functionality

  @wiki
  Scenario: Wikipedia search functionality
    Given user click on wikipedia page
    When User type Steve Jobs in the wiki search box
#    And User click search button
    Then User see Steve Jobs in the wiki page title