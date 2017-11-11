Feature: Maintenance-Clean-up -> Missing Items
Scenario: C60663	Verify Missing Items report under Maintenance -> Weeding when default filters are applied
	
	Given Maintenance User is on DC Home Page
	When Weeding User is logged in into DC and currently is under Evaluation mode
	Then Weeding User has verified
