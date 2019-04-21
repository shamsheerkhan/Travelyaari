Feature: Signup Action

Scenario: Successful Signup with valid credentials
	Given User is on Home Page
	When User Navigate to Signup page
	And User enters the mobile no. 
	Then Check for OTP
	And Create Secure pin 
	Then Message should display Account created successfully
	And Logout from application
	And close the browser
	
	
		
		