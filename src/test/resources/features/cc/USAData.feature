Feature: Test API of https://datausa.io/api/data

  @GetUSAData
  Scenario: Get data from datausa.io
      Given user gets data from url "https://datausa.io/api/data" with query parameters
            |drilldowns |State     |
            |measures   |Population|
            |year       |latest    |
       Then verify that the http get value is a JSON document
        And verify that the http get json value has a member "data" with "JsonArray" value.
        And verify that the http get json value has a member "data" with JsonArray value containing JsonObjects with distinct "State" values.
        And verify that the http get json value has a member "data" with JsonArray value containing JsonObjects with same "Year" values.
    
