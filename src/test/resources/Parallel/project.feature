Feature: Test Project  module Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button

  Scenario: Check Add project Functionality
    #When clicks on Hamburger icon
    Then click on project tab
    Then click on Add project button
    Then enter project title
    And click save project button
    Then validate project create successfully
    Then click on Edit button
    Then update project title
    Then update project visibility
    Then update project handle
    Then add project members
    Then update visible bucket
    Then click on Update button
    Then Update project successfully message
    Then clicks delete project button
    Then display delete project message
