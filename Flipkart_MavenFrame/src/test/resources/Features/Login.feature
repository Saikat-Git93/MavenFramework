Feature: Test Login Functionality of Flipkart

Scenario: Check the Login Function with Valide user name and password

Given User navigate to the URL 'https://www.flipkart.com/'
When User navigate to the login page
Then User enter the username and password
And Click on the login button
Then Check if the user navigate to the after login page


