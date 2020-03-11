Feature: Working in MobileWeb Application

@mobileweb
Scenario: Verify the Shopping list page in Mobile Browser

Given navigating to Google Shopping list page
And Search 'milk' in the search bar
When search for product less than 15
Then display the product falling under the given category


@mobile
Scenario: Testing a mobile application
  Given navigate to google site