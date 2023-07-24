Feature: Test basic put features.
  
  Background:
    * url 'https://reqres.in'

  Scenario: This test cases was done to test put request
    Given path 'api/users/2'
    Given request {"name": "morpheus", "job": "zion resident"}
    When method PUT
    When status 200
    When print response
    Then match $ contains {name:"#notnull"}
    Then match response.name == "morpheus"
    Then match response.job == "zion resident"