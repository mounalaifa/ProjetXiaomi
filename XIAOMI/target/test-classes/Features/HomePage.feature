#Author: your.email@your.domain.com

Feature: Home Page


  Scenario: Select a Product
  
    Given admin is on home page
    
    When admin mouseHover on menu "Smart Home" and click on submenu "Maison Connectée"
  
    Then admin is directed to the page "Maison Connectée"

