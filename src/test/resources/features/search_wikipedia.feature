Feature: search Wikipedia

  Scenario: Search for term in home page
    Given Luis navigates to Wikipedia home page
    When he searches for "Testing" term
    Then he should see "Test" in header of result page