Feature: This is a Delete demo using Karate framework

  Background:
    * url 'https://jsonplaceholder.typicode.com/'

  Scenario: This is a GET example using jason place holder API
    Given  path 'posts/1'
    When  method GET
    When status 200
    Then print responses

  Scenario: this is a DELETE example
    Given path '/posts/1'
    When method DELETE
    When status 200
    When print response
