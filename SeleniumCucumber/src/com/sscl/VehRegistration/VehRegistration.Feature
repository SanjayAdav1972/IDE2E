Feature: Verify Vehicle Registration Details with DVLA site

Scenario: Verify Vehicle Registration Details
	Given I retrieve list of VRNs from excel sheet
	And I open DVLA site from internet
	When I search VRN on DVLA
	Then I get Make and Colour of entered VRN