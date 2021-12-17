$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PlaceNewOrder.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: lavigarg05@gmail.com"
    }
  ],
  "line": 3,
  "name": "Place a new order",
  "description": "",
  "id": "place-a-new-order",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Order burgers",
  "description": "",
  "id": "place-a-new-order;order-burgers",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchRestaurant"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I launch the website on browser \u003cbrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for \"\u003csearchString\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I select restaurant \"\u003csearchString\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I select menu option \"\u003cFoodCategory\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 11,
      "value": "#When select a random wine"
    },
    {
      "line": 12,
      "value": "#And collect information for selected wine"
    },
    {
      "line": 13,
      "value": "#Then verify selected wine data"
    }
  ],
  "line": 16,
  "name": "",
  "description": "",
  "id": "place-a-new-order;order-burgers;",
  "rows": [
    {
      "cells": [
        "searchString",
        "browser",
        "FoodCategory"
      ],
      "line": 17,
      "id": "place-a-new-order;order-burgers;;1"
    },
    {
      "cells": [
        "BRT Cypress Test Restaurant",
        "Firefox",
        "Burgers"
      ],
      "line": 18,
      "id": "place-a-new-order;order-burgers;;2"
    },
    {
      "cells": [
        "BRT Cypress Test Restaurant",
        "Chrome",
        "Burgers"
      ],
      "line": 19,
      "id": "place-a-new-order;order-burgers;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1133561000,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Order burgers",
  "description": "",
  "id": "place-a-new-order;order-burgers;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchRestaurant"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I launch the website on browser Firefox",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for \"BRT Cypress Test Restaurant\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I select restaurant \"BRT Cypress Test Restaurant\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I select menu option \"Burgers\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Firefox",
      "offset": 32
    }
  ],
  "location": "CommonStepDefs.launchWebsite(String)"
});
formatter.result({
  "duration": 10653067700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BRT Cypress Test Restaurant",
      "offset": 14
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 5544070400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BRT Cypress Test Restaurant",
      "offset": 21
    }
  ],
  "location": "CommonStepDefs.selectRestaurant(String)"
});
formatter.result({
  "duration": 5260371300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Burgers",
      "offset": 22
    }
  ],
  "location": "CommonStepDefs.selectMenuItem(String)"
});
formatter.result({
  "duration": 2720403400,
  "status": "passed"
});
formatter.after({
  "duration": 1341809100,
  "status": "passed"
});
formatter.before({
  "duration": 76647200,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Order burgers",
  "description": "",
  "id": "place-a-new-order;order-burgers;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@SearchRestaurant"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I launch the website on browser Chrome",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for \"BRT Cypress Test Restaurant\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I select restaurant \"BRT Cypress Test Restaurant\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I select menu option \"Burgers\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Chrome",
      "offset": 32
    }
  ],
  "location": "CommonStepDefs.launchWebsite(String)"
});
formatter.result({
  "duration": 6291950400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BRT Cypress Test Restaurant",
      "offset": 14
    }
  ],
  "location": "CommonStepDefs.searchForKeyword(String)"
});
formatter.result({
  "duration": 4335412100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BRT Cypress Test Restaurant",
      "offset": 21
    }
  ],
  "location": "CommonStepDefs.selectRestaurant(String)"
});
formatter.result({
  "duration": 5776466700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Burgers",
      "offset": 22
    }
  ],
  "location": "CommonStepDefs.selectMenuItem(String)"
});
formatter.result({
  "duration": 2905918000,
  "status": "passed"
});
formatter.after({
  "duration": 949085800,
  "status": "passed"
});
});