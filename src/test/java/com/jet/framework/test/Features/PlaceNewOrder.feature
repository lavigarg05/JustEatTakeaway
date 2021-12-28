#Author: lavigarg05@gmail.com

Feature: Place a new order for invalid address
  
	@PlaceOrder
  Scenario Outline: Order burgers for invalid address on browser <browser>
  	Given I launch the website on browser <browser>
    When I search for "<searchString>"
    And I select restaurant "<searchString>"
    And I select menu option "<FoodCategory>"
    When I add food items in cart
    | item           | count |
    | Chicken Burger | 2     |
    And I checkout with cash and place the order
    Then verify error message <errorMessage>


    Examples: 
      | searchString                | browser  |FoodCategory |errorMessage                                                      |
      | BRT Cypress Test Restaurant | Chrome   | Burgers     |BRT Cypress Test Restaurant does not deliver in the delivery area |
      | BRT Cypress Test Restaurant | Firefox  | Burgers     |BRT Cypress Test Restaurant does not deliver in the delivery area |
 