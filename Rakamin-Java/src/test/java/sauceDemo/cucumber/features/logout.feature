Feature: Logout Web Saucedemo

  Scenario: Success Logout
    Given User already logged in
    When User click left burger menu
    And User click Logout
    Then User on Login Page