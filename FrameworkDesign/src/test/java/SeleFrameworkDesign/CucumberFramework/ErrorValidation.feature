#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: This is the test for error validation.

@regression
Scenario Outline: Negetive test for login
    Given I landed on Ecommerce page.
    When Login to ecommerece website using username <username> and password <password>
    Then "Incorrect email or password." message is displayed on login page.
    
    Examples: 
      | username            |  password     
      | anshikaa@gmail.com  |  Iamking@000
      | anshika@gmail.com   |  Iamkicng@000
      
@regression
  Scenario Outline: Checking right product added to cart
    Given I landed on Ecommerce page.
    And Login to ecommerece website using username <username> and password <password>
    When I add product <productName> to cart
    Then Correct product is added to cart
    Examples: 
      | username            |  password      | productName   |
      | anshika@gmail.com   |  Iamking@000 | ZARA COAT 3 |