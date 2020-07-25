Feature: The user attempts to delete an entry

Background:
	Given a web browser has navigated to the database app
	And a test entry was created
	And the user is navigated to the test entry
	
	Scenario: The user deletes an existing entry
		When clicks the delete this computer button
		Then the entry is removed from list



	