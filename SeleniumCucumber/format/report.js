$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:\\Projects\\IDE2E\\SeleniumCucumber\\src\\com\\sscl\\VehRegistration\\VehRegistration.Feature");
formatter.feature({
  "line": 1,
  "name": "Verify Vehicle Registration Details with DVLA site",
  "description": "",
  "id": "verify-vehicle-registration-details-with-dvla-site",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify Vehicle Registration Details",
  "description": "",
  "id": "verify-vehicle-registration-details-with-dvla-site;verify-vehicle-registration-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I retrieve list of VRNs from excel sheet",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I open DVLA site from internet",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I search VRN on DVLA",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I get Make and Colour of entered VRN",
  "keyword": "Then "
});
formatter.match({
  "location": "VehRegTests.I_retrieve_list_of_VRNs_from_excel_sheet()"
});
formatter.result({
  "duration": 814186492,
  "status": "passed"
});
formatter.match({
  "location": "VehRegTests.I_open_DVLA_site_from_internet()"
});
formatter.result({
  "duration": 5406703527,
  "status": "passed"
});
formatter.match({
  "location": "VehRegTests.I_search_VRN_on_DVLA()"
});
formatter.result({
  "duration": 3597933252,
  "status": "passed"
});
formatter.match({
  "location": "VehRegTests.I_get_Make_and_Colour_of_entered_VRN()"
});
formatter.result({
  "duration": 1112348324,
  "status": "passed"
});
});