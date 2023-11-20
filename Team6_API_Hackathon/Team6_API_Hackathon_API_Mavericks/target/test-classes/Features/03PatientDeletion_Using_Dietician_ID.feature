Feature: Dieticians Role Module Patient Deletion Positive Scenarios
Background: User sets Authorization to Bearer Token


#Dietician Logs In
Scenario Outline: Check if user(Dietician) is able to login  valid endpoint and with valid email id and password in request body
Given: User creates POST Request for the Dietician API endpoint
When User sends HTTPS Request and  request Body with valid emailid and password from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 Ok Status with response body and successfully logs in
Examples: 
      |SheetName           | RowNumber |
      |User_Login          |         0 |


#Dietician Deletes PaitentID

Scenario Outline: Check if user(Dietician) able to delete patient record with valid endpoint
Given: User creates Delete Request for dietician API endpoint  
When User sends HTTPS Request to delete a patient record using patient <ID>
Then User recieves 200 OK with response

Examples:
|ID|
|0|


#Dietician logs out
Scenario: Check if user able to logout from Dietician API
Given: User creates GET Request for the Dietician API endpoint
When User sends HTTPS GET Request to logout from the Dietician API
Then User receives 200 OK Status with response body Logout successful