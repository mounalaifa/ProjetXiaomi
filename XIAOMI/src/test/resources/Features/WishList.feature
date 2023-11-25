#Author: your.email@your.domain.com

Feature: Wish List


  Scenario: Wish List
  
    Given admin is product page
    
    When admin adds product to the wish list "Mi Portable Bluetooth Speaker Haut-parleur Bluetooth"
    And admin access the wish list page
  
    Then admin verifies that the product is added
 