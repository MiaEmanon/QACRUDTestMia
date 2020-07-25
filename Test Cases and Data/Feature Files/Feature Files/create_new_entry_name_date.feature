Feature: The user creates a new entry in the application with name and date

Background:
	Given a web browser has navigated to the database app
	And the user has clicked on the Add a New Computer button
	
	
	Scenario: The user adds a Computer with a valid name and valid dates
		When the user inputs a valid computer name "TestComp 10"
		And the user inputs a valid date introduced "2018-03-21"
		And the user inputs a valid date discontinued "2019-03-21"
		And clicks on the Create button
		Then the computer is saved with valid name and dates
		
	Scenario: The user adds a Computer with discontinued date before the introduced date
		When the user inputs a valid computer name "TestComp 10"
		And the user inputs a valid date introduced "2018-03-21"
		And the user inputs an invalid date discontinued "2017-03-21"
		And clicks on the Create button
		Then an error message is shown notifying the user
		
	Scenario: The user adds a Computer with imposible dates
		When the user inputs a valid computer name "TestComp 10"
		And the user inputs an valid date introduced "0001-12-23"
		And the user inputs an invalid date discontinued "2216-11-26"
		And clicks on the Create button
		Then an error message is shown notifying the user	


		
		