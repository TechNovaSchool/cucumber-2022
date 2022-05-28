Feature: Verify smart bear orders page

  @smartBearTest
  Scenario Outline: User should be able to place order with different data sets
    Given User is logged into SmartBear Tester account and on Order page
    And User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity input box
    And User enters "<customerName>" to costumer name input box
    And User enters "<streetName>" to street name input box
    And User enters "<city>" to city input box
    And User enters "<state>" to state input box
    And User enters "<zip>" to zip input box
    And User selects "<cardType>" as card type from radio buttons
    And User enters "<cardNumber>" to card number input box
    And User enters "<expirationDate>" to expiration date into input box
    And User clicks process button
    Then User verifies "<expectedName>" is in the table


    Examples:
      | product     | quantity | customerName | streetName   | city     | state | zip   | cardType         | cardNumber       | expirationDate | expectedName |
      | MyMoney     | 1        | Kamol        | 852 Road     | Chicago  | IL    | 12345 | MasterCard       | 1234123412341234 | 05/22          | Kamol        |
#    | FamilyAlbum | 2        | Andrew       | 741 Drive    | New York | NY    | 12345 | Visa             | 1234123412341234 | 05/22          | Andrew       |
#    | ScreenSaver | 3        | Karina       | 456 Driveway | Miami    | FL    | 12345 | American Express | 1234123412341234 | 05/22          | Karina       |

