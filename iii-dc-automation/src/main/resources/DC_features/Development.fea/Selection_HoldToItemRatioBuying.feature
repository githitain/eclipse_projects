Feature: Development Selection -> Hold-to-Item Ratio Buying

Scenario: C60635	Verify Hold-to-Item Ratio Buying -> On Order Titles report, when default filters are applied
	
	Given Development User is on DC Home Page
	When  Order Titles User is logged in into DC and currently is under Evaluation mode
	Then  Order Titles User has verified

Scenario: C60636	Verify Hold-to-Item Ratio Buying -> Current Holdings report, when default filters are applied 

	Given Development User is on DC Home Page
	When  Holdings report User is logged in into DC and currently is under Evaluation mode
	Then  Holdings report User has verified