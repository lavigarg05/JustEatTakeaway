#Author: lavigarg05@gmail.com

Feature: Place a new order less than minimum acceptable value
  
	@PlaceOrderLessThenMinValue @Regression
  Scenario Outline: Order an item with value less than minimum acceptable amount
  	Given I launch the website on browser <browser>
    When I search for "<searchString>"
    And I select restaurant "<searchString>"
    And I select menu option "<FoodCategory>"
    Then I add food items in cart and verify total bill amount
    | item                | count |
    | White Rice. 1.00    | 1     |
    Then verify cart error message <errorMessage>


    Examples: 
      | searchString                | browser  |FoodCategory    |errorMessage                                   |
      | BRT Cypress Test Restaurant | Firefox  | FRIED RICE     |Amount needed to reach the minimum order value |
 