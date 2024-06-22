@api
Feature: E2EE api testing 
Scenario: Api login request
	Given "login" data payload is added
	When  user calls "login" api with "Post" http request
	Then "message" in the response is "Login Successfully" 