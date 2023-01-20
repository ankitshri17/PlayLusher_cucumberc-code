Feature: Test create Label Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button
    Then click on project tab
    Then click on Add project button
    Then enter project title
    And click save project button
    Then validate project create successfully

  Scenario: Check Label Functionality
    #When clicks on Hamburger icon
    Then click on Label icon
    Then click on New label button
    Then enter label name
    Then click on create label button
    Then validate Label create message
    Then click on Hamburger icon of project
