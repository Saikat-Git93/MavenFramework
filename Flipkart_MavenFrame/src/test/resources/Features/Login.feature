Feature: Test Login Functionality of Flipkart

  @SmokeTest
  Scenario Outline: Check the Login Function with Valide user name and password
    Given User navigate to the URL 'https://www.flipkart.com/'
    Then Validate the Page Title 'Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!'
    When User navigate to the login page
    Then User enter the <username> and <password>
    And Click on the login button
    Then Check if the user navigate to the after login page
    Then Logout
    #Then Close the Browser

    Examples: 
      | username | password |
      | Admin    | Pass     |
