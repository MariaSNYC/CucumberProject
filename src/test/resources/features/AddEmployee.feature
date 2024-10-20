Feature: Add employee in HRMS
  Background:
    #Given user is able to access HRMS application
    When the user enters valid username and password
    And the user clicks the login button
    Then user is navigated to dashboard page
    When user clicks on PIM option
    And user clicks on add employee option

  @add
  Scenario: Add Employee
    When user enters firstname and lastname in the name fields
    And the employee ID is automatically generated
    And  user clicks on save button
    Then  user added successfully

    @addId
    Scenario: Add Employee
      When user enters firstname and lastname in the name fields
      And user clears the generated employee ID
      And user enters new employee ID
      And  user clicks on save button
      Then  user added successfully

      @emptyFirstname
      Scenario: Add Employee
        When user enters lastname in the field
        And user leaves the firstname field empty
        And  user clicks on save button
        Then the error message should be displayed

  @emptyLastname
  Scenario: Add Employee
    When user enters firstname in the field
    And user leaves the lastname field empty
    And  user clicks on save button
    Then the error message should be displayed


