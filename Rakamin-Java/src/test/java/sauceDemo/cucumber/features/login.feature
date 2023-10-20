Feature: Login Page Web Saucedemo

  Scenario: Success Login
    Given  Login page Saucedemo
    When Input username
    And Input password
    And Click login button
    Then User on dashboard page

  Scenario: Fail Login
    Given  Login page Saucedemo
    When Input username
    And Input wrong password
    And Click login button
    Then User get error message