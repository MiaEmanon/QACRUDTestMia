Feature: The user attempts to sort the database using different criterea

Background:
	Given a web browser has navigated to the database app	
	
	Scenario: The user sorts the base by computer name ascending
		Given current sorting is not alphabetical ascending
		When the user clicks on computer name
		Then the computers are sorted in ascending alphabetical order by name

	Scenario: The user sorts the base by computer name descending
		Given current the sorting is by name ascending
		When the user clicks on computer name
		Then the computers are sorted in descending alphabetical order by name	
	
	Scenario: The user sorts the base by date introduced ascending
		Given current sorting is not date introduced ascending
		When the user clicks on date introduced
		Then the computers are sorted by date introduced in ascending order

	Scenario: The user sorts the base by date introduced descending
		Given current the sorting is by date introduced ascending
		When the user clicks on date introduced
		Then the computers are sorted by date introduced in descending order			
		
	Scenario: The user sorts the base by date discontinued ascending
		Given current sorting is not date discontinued ascending
		When the user clicks on date discontinued
		Then the computers are sorted by date discontinued in ascending order

	Scenario: The user sorts the base by date discontinued descending
		Given current the sorting is by date discontinued ascending
		When the user clicks on date discontinued
		Then the computers are sorted by date discontinued in descending order

	Scenario: The user sorts the base by company ascending
		Given current sorting is not by company ascending
		When the user clicks on company
		Then the computers are sorted by company in ascending order

	Scenario: The user sorts the base by company descending
		Given current the sorting is by company ascending
		When the user clicks on company
		Then the computers are sorted by company in descending order
		