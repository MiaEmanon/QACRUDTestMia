Feature: The user attempts to edit the content of an entry

Background:
	Given a web browser has navigated to the database app
	And the user has navigated to an existing entry
	
	Scenario: The user makes changes but clicks cancel
		When the user edits all possible entries
		And the user clicks cancel
		Then the user is navigated back to the database with no changes

	Scenario: The user makes changes and saves them
		When the user edits all possible entries
		And the user clicks save
		Then the user is navigated back to the database with all changes saved

	