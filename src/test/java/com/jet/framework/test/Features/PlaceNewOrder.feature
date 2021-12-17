#Author: lavigarg05@gmail.com

Feature: Place a new order
  
	@SearchRestaurant
  Scenario Outline: Order burgers
  	Given I launch the website on browser <browser>
    When I search for "<searchString>"
    And I select restaurant "<searchString>"
    And I select menu option "<FoodCategory>"
    #When select a random wine
    #And collect information for selected wine
    #Then verify selected wine data


    Examples: 
      | searchString                | browser  |FoodCategory |
      | BRT Cypress Test Restaurant | Firefox  | Burgers     |
      | BRT Cypress Test Restaurant | Chrome   | Burgers     |
