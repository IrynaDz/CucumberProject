Feature: all login tests scenarios are in this file

  Background:
    Given user navigates to the login page

#  @loginPositive
#  Scenario: user logs in wiht valid credentials
#    Given user navigates to the login page
#    When user enters email "admin@codewise.com" to the email field
#    And user enters password "codewise123" to the password field
#    Then user performs click action on the login button
#    Then user should be logged in to the application

#  @loginNegative
#    Scenario Outline: user logs in wiht invalid credentials
#    Given user navigates to the login page
#    When user enters email "<email>" to the email field
#    And user enters password "<password>" to the password field
#    Then user should not be logged in to the application
#
#    Examples:
#      | email            | password |
#      | admin@gmail.com  | code45   |
#      | codwiser@cod.com | pass24   |
#      | admin@admin.com  | cycy12   |
#      | can@gmail.com    | one1     |
#      | barbie@gmail.com | two2     |
#      | sindy@mail.com   | three3   |

  @loginNegative
  Scenario Outline: user tries to log in wiht invalid email
    When user enters email "<email>" to the email field
    And user enters password "<password>" to the password field
    Then user performs click action on the login button
    Then user should see error message

    Examples:
      | email       | password |
      | barbie12@   | abc123   |
      | can12@gmail | xyz123   |
      | sindy12     | aindy123 |
      | john12      | john123  |


