Feature: Cookies
  As an user
  I want accept cookies
  So that the cookies messages is closed

  Scenario: Accept cookies
    When I navigate to the home page
    Then the welcome page is open

    When I click the link in text 'Please click HERE to GO to the next page' to navigate the next page
    And I accept cookies
    Then the form is closed