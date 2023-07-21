Feature: testing a basic post api request

  Background:
    * url 'https://reqres.in'
    * def requestBody1 = read('RequestCreate.json')
    * def requestBody2 = read('RequestRegister.json')

  @TestPOST1
  Scenario: Basic test request.
    Given path '/api/users'
    Given request {"name": "Alberto", "job": "leader"}
    When method POST
    When status 201
    When print response
    Then match $ contains {id:"#notnull"}
    Then match response.name == "Alberto"

  @TestPOST2
  Scenario: API Register
    Given path '/api/register'
    Given request {"email": "eve.holt@reqres.in","password": "pistol"}
    When method POST
    When status 200
    When print response
    Then match $ contains {token:"#notnull"}
    Then match $ contains {token:"QpwL5tke4Pnpja7X4"}

  @TestPOST3
  Scenario: Basic test request.
    Given path '/api/users'
    Given request requestBody1
    When method POST
    When status 201
    When print response
    Then match $ contains {id:"#notnull"}
    Then match response.name == "Alberto"

  @TestPOST4
  Scenario: API Register
    Given path '/api/register'
    Given request requestBody2
    When method POST
    When status 200
    When print response
    Then match $ contains {token:"#notnull"}
    Then match $ contains {token:"QpwL5tke4Pnpja7X4"}
