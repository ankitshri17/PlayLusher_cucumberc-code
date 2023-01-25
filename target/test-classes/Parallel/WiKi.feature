Feature: Test the WiKi Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button
    Then click on project tab
    Then click on Add project button
    Then enter project title
    And click save project button

  Scenario: Check Add WiKi functionality
    Then click on wiki icon
    Then click on wiki edit button
    Then enter wiki description
    Then wiki upload file
    Then enter the wiki comment
    Then upload file for wiki comment
    Then click on wiki post comment button
    Then click on wiki save button
    #Then validate credential message and comment message
    #Then click on wiki edit button
    #Then enter updated wiki description
    #Then enter updated wiki comment
    #Then click on wiki post comment button
    #Then click on wiki save button
    #Then validate credential message and comment message
