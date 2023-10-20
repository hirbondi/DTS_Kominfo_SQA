Feature: Order an item

  Scenario: Success Order
    Given User already login
    When User add Sauce Lab backpack
    And User click shopping cart
    And User click checkout button
    And User fill data id
    And User click finish
    Then Complete status shown

  Scenario: Fail Order
    Given User already login
    When User add Sauce Lab backpack
    And User click shopping cart
    And User click checkout button
    And User left data id blank
    Then Error message shown