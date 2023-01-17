Feature: Test Task module Functionality

  Background: 
    Given navigate to the baseurl
    When user enter credentials
    Then clicks login button
    Then click on project tab
    Then click on Add project button
    Then enter project title
    And click save project button
    Then validate project create successfully

  Scenario: Check Add task Functionality
   Then clicks on add task button
   Then enter task name
   Then enter task details
   Then select bucket option
   Then clicks on save button
   Then validate task create message
   Then clicks on Backlog ticket
   Then update task name
   Then update task details
   Then update bucket option
   Then enter task comment
   Then clicks on post comment button
   Then clicks on save button for update task
   Then validate update task message