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
    Then click on Label icon
    Then click on New label button
    Then enter label name
    Then click on create label button
    Then validate Label create message
    Then click on Hamburger icon of project

  Scenario: Check Add task Functionality
    Then clicks on add task button
    Then enter task name
    Then enter task details
    Then select bucket option
    Then Upload file for task
    Then clicks on save button
    Then validate task create message
    Then clicks on Backlog ticket
    Then update task name
   Then update task details
   Then update bucket option
   Then select Label option
   Then enter task comment
   Then clicks on post comment button
   Then clicks on save button for update task
   Then validate update task message
   Then clicks on Delete task Button
   Then validate Delete task message
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
