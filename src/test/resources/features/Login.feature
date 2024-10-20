Feature: Login scenarios
  @login @emptyUserName
  Scenario:
    #Given user is able to access HRMS application
    When the user enters a valid password
    And the user leaves the username field empty
    And the user clicks the login button
    Then the error message about the username should be displayed


  @login @emptyPassword
    Scenario:
      #Given user is able to access HRMS application
    When the user enters a valid username
    And the user leaves the password field empty
    And the user clicks the login button
    Then the error message about the password should be displayed

    @invalidcredentials
  Scenario:
    #Given user is able to access HRMS application
    When the user enters an invalid username and password
    And the user clicks the login button
    Then the error message about invalid credentials should be displayed

@correct
  Scenario: User can correct their input after an error
    #Given user is able to access HRMS application
    When the user enters an invalid username and password
    And the user clicks the login button
    Then the error message about invalid credentials should be displayed
    When the user enters valid username and password
    And the user clicks the login button
    Then user is navigated to dashboard page
