Feature: Report module Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button
    Then click on Report Tab

  Scenario: Check Report Functionality
    Then click on Add Report button
    Then click on submit button
    Then Enter the Description
    Then Enter Billed hours
    Then select the Plateform
    Then select the Users
    Then click on submit button
    Then Validate create Report message
    Then click on Report edit button
    Then Update the Report Description
    Then Update the plateform
    Then Update the Users
    Then clicks on Report Update button
    Then Validate updated Report message
