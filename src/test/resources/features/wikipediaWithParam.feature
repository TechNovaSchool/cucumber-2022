@wikiAllTests
Feature: Wikipedia search functionality

  @wikiDynamicTest
  Scenario: Wikipedia search functionality
    Given user click on wikipedia page
    When User type "Mohamed Salah" in the wiki search box
    And User click search button
    Then User see "Mohamed Salah" in the wiki page title

# --- ctrl+/
@wikiDynamicTest2
  Scenario: Wikipedia Search Functionality page header
  Given user click on wikipedia page
  When User type "Mohamed Salah" in the wiki search box
  And User click search button
   Then User see "Mohamed Salah" in the main header

  @wikiDynamicTest3
  Scenario: Wikipedia Search Functionality image header
    Given user click on wikipedia page
    When User type "Messy" in the wiki search box
    And User click search button
    Then User see "Messy" in the image header