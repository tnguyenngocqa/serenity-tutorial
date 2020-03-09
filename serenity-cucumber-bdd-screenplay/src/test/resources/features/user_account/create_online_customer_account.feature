@cucumber
@smoke

Feature: Create a new online customer account

  As a new online customer
  user should be able to create an online account
  to purchase new items and access their history

  Scenario:  Create a new online customer account
    Given that Carla is a new online customer
    When she create a new account with information
      | Social title | FirstName | Last name | Email                         | Password | Birthdate  |
      | Mr.          | Francis   | Nguyen    | francis.nguyen@terralogic.com | password | 06/16/2000 |
    #Then she should be able to view her account profile