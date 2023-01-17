@Login
Feature: Test login functionality

  Background: 
    Given navigate to the baseurl

  Scenario Outline: check login is successful with valid credentials
    When user enter valid credentials <email> and <password>
    Then clicks login button
    Then validate Login success message

    #Then user enters
    #And clicks on login button
    #Then validate login success message
    #Then Homepage title
    Examples: 
      | email                    | password      |
      | ankit17sep1995@gmail.com | Uimatic@12345 |

  Scenario Outline: check login with invalid credentials
    When user enter invalid credentials <email> and <password>
    Then clicks login button
    Then validate Login error message

    Examples: 
      | email             | password      |
      | invalid@gmail.com | Uimatic@12345 |
