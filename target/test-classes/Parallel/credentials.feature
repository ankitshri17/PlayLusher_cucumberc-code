Feature: Test the credentials Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button
    Then click on project tab
    Then click on Add project button
    Then enter project title
    And click save project button

  Scenario: Check Add credentials functionality
    Then click on credentials icon
    Then click on credential edit button
    Then enter credential description
    Then credential upload file
    Then enter the comment
    Then upload file for comment
    Then click on post comment button
    Then click on save button
    Then validate credential message and comment message
    Then click on credential edit button
    Then enter updated credential description
    Then enter updated comment
    Then click on post comment button
    Then click on save button
    Then validate credential message and comment message
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
