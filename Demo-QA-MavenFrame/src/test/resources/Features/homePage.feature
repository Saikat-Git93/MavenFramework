Feature: Home Page UI Elements

  @SmokeTest
  Scenario: Verify that the Home Page loads successfully
    Given I navigate to the demoqa homepage URL "https://demoqa.com/"
    Then the page title should be "DEMOQA"
    And the URL should contain "https://demoqa.com/"
    Then The Footer should contain "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED."
    Then Close the Browser
