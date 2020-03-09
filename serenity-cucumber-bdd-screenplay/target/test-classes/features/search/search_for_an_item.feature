@cucumber
@smoke
Feature: Search for an item

  To check an item price and add them to shopping cart
  as an online customer
  user should be able to search for an item

  Scenario: Search products from navigation-menu
    Given that Carla wants to buy Sweater
    When she searches for Sweater using the navigate menu
