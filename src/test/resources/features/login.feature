Feature: Login
  Scenario: Valid login
    Given I am on the SauceDemo login page
    When I log in with username "standard_user" and password "secret_sauce"
    Then I should land on the inventory page

  Scenario: Invalid login: wrong password
    Given I am on the SauceDemo login page
    When I log in with username "standard_user" and password "something_wrong"
    Then I should see an error message "Username and password do not match any user in this service" in the login page

  Scenario: Invalid login: wrong username
    Given I am on the SauceDemo login page
    When I log in with username "wrong_username" and password "secret_sauce"
    Then I should see an error message "Username and password do not match any user in this service" in the login page
