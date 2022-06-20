Feature: Registering to automation practice

  Scenario: Validate user is able to register
    Given Automation practice application is opened
    When I click sign in
    And I create account with emailid "testRandom@testauto.com"
    Then I should be able to register with my below details
      | Gender | FirstName | LastName  | Password  | Address            | City      | State  | Zip  | Mobile     |
      | Mr     | TestFName | TestLName | Password1 | 100 Spencer Street | Anchorage | Alaska | 30000 | 0406345454 |

    Scenario: Navigate to Summer Dresses through the Megamenu
      Given Automation practice application is opened
      When I click Summer Dresses
      Then I am on the correct page

    Scenario: Add a Blue Dress to the cart
      Given Automation practice application is opened
      When I click Summer Dresses
      And I click the first Dress
      Then I am on the Printed Summer Dress Page
      When I click the blue colour
      And I add to cart
      Then The correct details are on the summary page