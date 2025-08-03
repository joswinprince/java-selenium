Feature: API Testing using Cucumber and RestAssured

  Scenario: Validate GET API Response
    Given the API is available
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain "userId" with value 1

  Scenario: Validate POST API Request
    Given the API is available
    When I send a POST request to "/posts" with data:
      | title       | body             | userId |
      | Automation | API Testing Demo | 1      |
    Then the response status code should be 201
    And the response should contain "title" with value "Automation"
