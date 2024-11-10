Feature: Homepage test
  As user I want to Homepage into amezon.co.uk website

  Background:
    Given I am on homepage
    And I accept cookies

  Scenario: User should check basket is empty
    When I click on basket
    Then I should see Your Amazon Cart is empty


#  Scenario: User should not logged is check
#    When I click on loginlink
#    Then I should see sign in page
#
#  Scenario: user can select Books from searchbar
#    When I click on searchbar
#    Then I should select books in searchbar
#    And I should able to search Bitcoin in search box
#
