Feature: REST API Tests

  @Rest
  Scenario: User can make REST API requests
    Given an user can make a GET request
    And an user can make a POST request
    And an user can make a PUT request
    And an user can make a DELETE request