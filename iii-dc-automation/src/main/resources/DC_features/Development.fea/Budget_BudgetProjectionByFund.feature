Feature: Development -Budget -> Budget Projection by Fund

Scenario: 	C60637	Verify Budget Projection by Fund report when default filters are applied 
	
	Given Development User is on DC Home Page
	When  Fund report User is logged in into DC and currently is under Evaluation mode
	Then  Fund report User has verified

Scenario: C72886	Verify Export to Excel functionalty for Budget Projection by Fund report when default filters are applied 

	Given Development User is on DC Home Page
	When Budget Projection User is logged in into DC and currently is under Evaluation mode
	Then Budget Projection User has verified