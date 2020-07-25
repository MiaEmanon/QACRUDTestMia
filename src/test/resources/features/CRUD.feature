Feature: The user creates, reads, updates and deletes entries from the computer database

  Background:
    Given web browser has navigated to the database app

    Scenario: The user creates a Computer with valid credentials
      When add a new computer button is clicked
      And  valid computer credentials are filled in
      And  crete button is clicked
      Then the computer is saved in the database

    Scenario: The user searches and validates the inputs in an existing entry
      When a search by name is applied
      And  the result entry is clicked
      Then The user is navigated to the edit page

    Scenario: The user makes changes and saves them
      When  a search by name is applied
      And   the result entry is clicked
      And   all fields are edited
      And   save button is clicked
      Then  the entry is saved

   Scenario: The user deletes an existing entry
      When a search by new name is applied
      And  the result entry is clicked
      And  delete this computer button is clicked
      Then the entry is removed from the list