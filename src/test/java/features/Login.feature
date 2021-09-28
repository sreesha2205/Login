Feature: Login
  Scenario: Login with valid credentials
    Given I'm On Invoice Manager Login Page
    And I enter Username as "admin@gic.com"
    And I enter Password as "Admin123"
    When I click on Login
    Then I redirected to Invoice Manager Home Page


  Scenario: Login with Invalid email valid password
    Given I'm On Invoice Manager Login Page
    And I enter Invalid Username as "admin123@gic.com"
    And I enter Password as "Admin123"
    When I click on Login
    Then I should get Unable to Login message "Unable to Login"

  Scenario: Login with valid email Id and invalid password
    Given I'm On Invoice Manager Login Page
    And I enter Username as "admin@gic.com"
    And I enter Invalid password "Admin789"
    When I click on Login
    Then I should get Unable to Login message "Unable to Login"

  Scenario: Reset Password
    Given I'm On Invoice Manager Login Page
    When I click Forgot Password
    Then I should redirect to Forgot Password Page
    And I enter Email Address "sirihari2205@gmail.com"
    And I click submit
    Then I should get message "Reset Password link sent"
