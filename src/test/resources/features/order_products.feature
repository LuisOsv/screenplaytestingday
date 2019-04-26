Feature: search Wikipedia

  Scenario: Search for term in home page
    Given Junior navigates to Sauce Store page
    And he login to the Sauce Store page
    When he adds the following products to the Cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    Then he should see the products in the Cart