#Feature file for 5th TestScenario
Feature: Testing OpenMRS Health Page

  Scenario Outline: User has to test if new service type could be added in OpenMRS Health Page
    Given I open the chrome browser
    Then I open the OpenMRS Health Page
    Then I enter the usernamme as admin and password as Admin123
    When I enter the location
    Then I click on login button
    Then I click on AppointmentSchedulling block
    When I click on ManageServiceType block
    Then I click on NewServiceType button
    And I enter name as '<Name>' on the page
    And I enter duration as '<duration>' on the page
    When I click on save button
    Then I verify
    And I close the browser

    Examples: 
      | Name           | duration |
      | General Health |       60 |
      | GeneralHealth  |      100 |
      | Psychology     | 10 min   |
      | General Health |      100 |
