Feature: This is a demo file of Karate testing

  @Test1
  Scenario: Get API Testing
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200

  @Test2
  Scenario: Get API Testing two
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200
    Then params page = 2
    And print response
    And  print responseStatus
    And print responseTime