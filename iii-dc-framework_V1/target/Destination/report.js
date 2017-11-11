$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Blance/DCBalancing_CollectionSubjectUse.feature");
formatter.feature({
  "line": 1,
  "name": "Balancing-Collection Use -\u003e Subject Use",
  "description": "",
  "id": "balancing-collection-use--\u003e-subject-use",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "C60646\tVerify Subject Use report, when default filters are applied",
  "description": "",
  "id": "balancing-collection-use--\u003e-subject-use;c60646-verify-subject-use-report,-when-default-filters-are-applied",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Balancing User is on DC Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Subject User is logged in into DC and currently is under Evaluation mode",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Subject User has verified",
  "keyword": "Then "
});
formatter.match({
  "location": "DCBalancingFea_Step.goToDC()"
});
formatter.result({
  "duration": 200441922,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest1()"
});
formatter.result({
  "duration": 7968176920,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest2()"
});
formatter.result({
  "duration": 6075999604,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "C60647\tVerify Subject Use By Location report, when default filters are applied",
  "description": "",
  "id": "balancing-collection-use--\u003e-subject-use;c60647-verify-subject-use-by-location-report,-when-default-filters-are-applied",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 11,
      "value": "#\t\tGiven Balancing User is on DC Home Page"
    }
  ],
  "line": 12,
  "name": "Location report User is logged in into DC and currently is under Evaluation mode",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Location report has verified",
  "keyword": "Then "
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest3()"
});
formatter.result({
  "duration": 4110527872,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest4()"
});
formatter.result({
  "duration": 6046208491,
  "status": "passed"
});
formatter.uri("Maintenance/DCMaintenance_CleanupMissingItems.feature");
formatter.feature({
  "line": 1,
  "name": "Maintenance-Clean-up -\u003e Missing Items",
  "description": "",
  "id": "maintenance-clean-up--\u003e-missing-items",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "C60663\tVerify Missing Items report under Maintenance -\u003e Weeding when default filters are applied",
  "description": "",
  "id": "maintenance-clean-up--\u003e-missing-items;c60663-verify-missing-items-report-under-maintenance--\u003e-weeding-when-default-filters-are-applied",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Maintenance User is on DC Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Weeding User is logged in into DC and currently is under Evaluation mode",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Weeding User has verified",
  "keyword": "Then "
});
formatter.match({
  "location": "DCMaintenanceFea_Step.goToDC()"
});
formatter.result({
  "duration": 48111640,
  "status": "passed"
});
formatter.match({
  "location": "DCMaintenanceFea_Step.DCLogin1()"
});
formatter.result({
  "duration": 3978976747,
  "status": "passed"
});
formatter.match({
  "location": "DCMaintenanceFea_Step.Logout1()"
});
formatter.result({
  "duration": 6018193350,
  "status": "passed"
});
});