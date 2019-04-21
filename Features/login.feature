Feature: Login Action

Scenario: Successful login with valid credentials
    Given User is on Home page
    When User navigate to login Page
    And User Enters the Mobile no.
    Then Check for Secure Pin 
    And User Book bus from "Hyderabad" to "Goa" on journey date "ToDay Date"
    Then User check for Any Travel from filter having lowestprice
    And User select lowestprice available bus by clicking on select seat 
    Then Select any available seat, if there are no available seats select other travels from filter
    