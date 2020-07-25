Feature: The user attempts to read an existing entry in the database

Background:
	Given a web browser has navigated to the database app	
	
	Scenario: The user accesses an existing entry with a valid name
		When the user clicks on an entry with a valid name
		Then the user is navigated to the edit page

	Scenario: The user accesses an existing entry with a only a space character in the name
		When the user clicks on an entry with only a space character in the name
		Then the user is navigated to the edit page

	