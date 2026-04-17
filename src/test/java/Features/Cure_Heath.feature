@All
Feature:  Verify Cura Healthcare Services

  @TC011 @sanity @regression
  Scenario: Verify make appointment button on home page
    Given   User on the home page
    When    User click on Make Appointment button
    Then    Verify User should land on login page

  @TC012 @sanity
  Scenario: Verify login page
    Given  User on the home page
    And    User click on Make Appointment button
    When   User enter valid username'John Doe' and  User enter valid password'ThisIsNotAPassword'
    And    User click on login button
    Then   Verify User should  successfully login and redirect to make appointment form page

  @TC013 @regression
  Scenario: Verify make appointment details
    Given  User on the home page
    And   User click on Make Appointment button
    And    User enter valid username'John Doe' and  User enter valid password'ThisIsNotAPassword'
    And    User click on login button
    When   User fill the appointment form
    And    User click on book appointment button
    Then   Verify User successfully book appointment and redirect to appointment confirmation page

  @TC014 @sanity @regression
  Scenario: Verify history page appointment data
    Given  User on the home page
    And    User click on Make Appointment button
    And    User enter valid username'John Doe' and  User enter valid password'ThisIsNotAPassword'
    And    User click on login button
    And    User fill the appointment form
    And    User click on book appointment button
    When   User can see  history of appointment data
    Then   Verify User should redirect to history page and check appointment data
    And    Verify User should back to home page

  @TC015 @sanity
  Scenario: Verify profile page and logout button
    Given  User on the home page
    And    User click on Make Appointment button
    And    User enter valid username'John Doe' and  User enter valid password'ThisIsNotAPassword'
    And    User click on login button
    And    User fill the appointment form
    And    User click on book appointment button
    When   User can check profile page
    Then   Verify User check profile page and successfully logout


