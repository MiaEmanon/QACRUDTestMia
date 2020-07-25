Feature: The user creates a new entry in the application with name only

Background:
	Given a web browser has navigated to the database app
	And the user has clicked on the Add a New Computer button
	
	
	Scenario: The user adds a Computer with a valid name with numbers and latin characters
		When the user inputs a computer name using numbers and latin characters
		And clicks on the Create button
		Then the computer is saved with a valid name
		
	Scenario: The user adds a Computer with a valid name with non latin characters
		When the user inputs a computer name using non latin characters
		And clicks on the Create button
		Then the computer is saved with a valid name
		
	Scenario: The user adds a Computer with an invalid name with over 256 characters
		When the user inputs a computer name with over 256 characters
		And clicks on the Create button
		Then an error message is shown notifying the user
	
	Scenario: The user adds a Computer with an invalid name using special characters
		When the user inputs a computer name with special characters
		And clicks on the Create button
		Then an error message is shown notifying the user
		
	Scenario: The user adds a Computer with a link in the name
		When the user inputs a link for a computer name
		And clicks on the Create button
		Then an error message is shown notifying the user
		
	Scenario: The user adds a Computer with an emoji in the name
		When the user copies an emoji from "https://getemoji.com/"
		And pastes into computer name
		And clicks on the Create button
		Then an error message is shown notifying the user
	
	Scenario: The user adds a Computer with no characters in the name
		When the user leaves the computer name blank
		And clicks on the Create button
		Then an error message is shown notifying the user
		
		