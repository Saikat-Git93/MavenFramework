Feature: Home Page UI Elements

  @SmokeTest
  Scenario: Verify that the Home Page loads successfully
    Given I navigate to the demoqa homepage URL "https://demoqa.com/"
    Then the page title should be "DEMOQA"
    And the URL should contain "demoqa.com"
    Then Close the Browser
