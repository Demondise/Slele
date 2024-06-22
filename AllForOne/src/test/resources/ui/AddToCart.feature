@ui
Feature: Add to cart E2E scenario
#Scenario: Adding Product to cart
#	Given I navigate to test site
#	And I Login with credentials
#	And "Homepage" is successfuly loaded
#	When I add "ZARA COAT 3" to cart
#	Then "ZARA COAT 3" is added to cart successfully
Scenario: Purchasing a product from cart
	Given I have added "ZARA COAT 3" to cart
	When I purchase "ZARA COAT 3" product from cart
	Then  "THANKYOU FOR THE ORDER." is displayed