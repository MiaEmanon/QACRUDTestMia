Feature: The user creates a new entry in the application and chooses a company

Background:
	Given a web browser has navigated to the database app
	And the user has clicked on the Add a New Computer button
	
	
	Scenario: The user adds a Computer with valid name and dates and chooses a company
		When the user inputs a computer with valid name and dates
		And chooses one of the companies from the drop down menu
		And clicks on the Create button
		Then the computer is saved with a valid name date and company
	
	
		
		
		