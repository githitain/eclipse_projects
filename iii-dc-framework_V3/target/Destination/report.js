$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Balancing/DCBalancing_CollectionSubjectUse.feature");
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
formatter.step({
  "line": 8,
  "name": "Balancing User is close the application",
  "keyword": "Then "
});
formatter.match({
  "location": "DCBalancingFea_Step.goToDC()"
});
formatter.result({
  "duration": 7439032566,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest1()"
});
formatter.result({
  "duration": 61023147937,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.DCBalancingTest2()"
});
formatter.result({
  "duration": 61459667723,
  "status": "passed"
});
formatter.match({
  "location": "DCBalancingFea_Step.wclose()"
});
formatter.result({
  "duration": 7230398776,
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
formatter.step({
  "line": 7,
  "name": "Maintenance User is close the application",
  "keyword": "Then "
});
formatter.match({
  "location": "DCMaintenanceFea_Step.goToDC()"
});
formatter.result({
  "duration": 3729591608,
  "status": "passed"
});
formatter.match({
  "location": "DCMaintenanceFea_Step.DCLogin1()"
});
formatter.result({
  "duration": 61040910114,
  "status": "passed"
});
formatter.match({
  "location": "DCMaintenanceFea_Step.Logout1()"
});
formatter.result({
  "duration": 61503129591,
  "status": "passed"
});
formatter.match({
  "location": "DCMaintenanceFea_Step.close()"
});
formatter.result({
  "duration": 5528650004,
  "status": "passed"
});
});