Feature: The user attempts to search for specific computers

Background:
	Given a web browser has navigated to the database app	
	
	Scenario: The user searches for a non existing computer name
		When the user inputs a non existing item in the search box
		And clicks the filter by name button
		Then no results are displayed

	Scenario: The user searches for an existing computer name
		When the user inputs an existing item in the search box
		And clicks the filter by name button
		Then the correct number of results is displayed

	