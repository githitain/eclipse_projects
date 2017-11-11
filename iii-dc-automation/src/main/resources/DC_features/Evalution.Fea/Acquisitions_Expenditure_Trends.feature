Feature: Evalution-Acquisitions_Expenditure_Trends
Scenario: C60345	Verify Expenditure Trends by Bib Level report, under Acquisitions -> Expenditure Trends using default filters available
	
	Given Evalution User is on DC Home Page
	When Bib Level report User is logged in into DC and currently is under Evaluation mode
	Then Bib Level report User has verified

Scenario: C60333 Verify Expenditure Trends by Call Number Range report, under Acquisitions -> Expenditure Trends using default filters available i.e. don’t select any filter from any option

	Given Evalution User is on DC Home Page
	When  Call Number Range User is logged in into DC and currently is under Evaluation mode
	Then  Call Number Range User has verified
	
Scenario: C60336	Verify Expenditure Trends by Format report, under Acquisitions -> Expenditure Trends when all filters are applied

	Given Evalution User is on DC Home Page
	When  Format report User is logged in into DC and currently is under Evaluation mode
	Then  Format report User has verified
	
Scenario: C60337	Verify Expenditure Trends by Funds report, under Acquisitions -> Expenditure Trends when all filters are applied

	Given Evalution User is on DC Home Page
	When  Funds report User is logged in into DC and currently is under Evaluation mode
	Then  Funds report User has verified
	
	
Scenario: C60338	Verify Expenditure Trends by Language report, under Acquisitions -> Expenditure Trends when only Order Location filter is applied 

	Given Evalution User is on DC Home Page
	When  Language report User is logged in into DC and currently is under Evaluation mode
	Then  Language report User has verified		