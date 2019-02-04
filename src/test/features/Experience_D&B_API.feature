Feature: EXPERIENCE API - D&B 
@experienceAPI @L1 @D&B  @Positive
  Scenario: I want to validate CompanyName 
	Given a valid companyName POLYRIDGE LIMITED with valid headers
	When I validate companyName 
	Then the status code is 200
	And response includes the following
	| companyName 			| POLYRIDGE LIMITED 	|
	| companyID				| 224422009				|
	| registrationNumber	| 11606757				|

	
