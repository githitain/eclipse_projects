Feature: Maintenance-Clean-up -> Missing Items
Scenario: C60663	Verify Missing Items report under Maintenance -> Weeding when default filters are applied
	
	Given Maintenance User is on DC Home Page
	When Weeding User is logged in into DC and currently is under Evaluation mode
	Then Weeding User has verified
	Then Maintenance User is close the application
	
	
	Scenario: C60647	Verify Subject Use By Location report, when default filters are applied

		Given Balancing User is on DC Home Page
		When Location report User is logged in into DC and currently is under Evaluation mode
		Then Location report has verified
		Then Balancing User is close the application