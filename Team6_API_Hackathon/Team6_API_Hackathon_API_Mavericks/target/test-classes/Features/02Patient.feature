Feature: Patient Role Module Positive Scenarios
Background: User sets Authorization to Bearer Token

#Patient Logs In
Scenario Outline: Check if user(Patient) is able to login  valid endpoint and with valid email id and password in request body
Given: User creates POST Request for the Dietician API endpoint
When User sends HTTPS Request and  request Body with valid patient emailid and password from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 Ok Status with response body and the patient successfully logs in
Examples: 
      |SheetName           | RowNumber |
      |User_Login          |         1 |
      
      
#Patient retrieves his test report using patientid
Scenario Outline: Check if user able to retrieve specific patients test report with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports of the patient
When User sends HTTPS Request with valid patient id <ID>
Then User recieves 200 OK with patient test report details
Examples:
|ID|
|0|


#Patient retrieves his files
Scenario Outline: Check if user able to retrieve specific patients test report by fileid with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports by sending the fileid
When User sends HTTPS Request with valid fileid "<FID>"
Then User recieves 200 OK with patient test report files
Examples:
|FID|
|value|  

#Patient logs out
Scenario: Check if user able to logout from Dietician API
Given: User creates GET Request for the Dietician API endpoint
When User sends HTTPS GET Request to logout from the Dietician API
Then User receives 200 OK Status with response body Logout successful
  	    