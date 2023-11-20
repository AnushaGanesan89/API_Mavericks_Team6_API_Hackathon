Feature: Dietician API Negative Scenarios
Background: User sets Authorization to Bearer Token

#User Logs in with Invalid/ Email ID(Dietician)

Scenario Outline: Check if user(Dietician) is able to login with invalid/blank credentials in request body
Given: User creates POST Request for the Dietician API endpoint
When User sends HTTPS Request and  request Body with invalid blank emailids and passwords from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 401 Unauthorized Status in the response body
Examples: 
      |SheetName                    | RowNumber |
      |Invalid_Credentials          |         0 |
      |Invalid_Credentials          |         1 |
      |Invalid_Credentials          |         2 |
      |Invalid_Credentials          |         3 |
      


#Dietician Logs In(Positive Scenario to check other negative scenarios)
Scenario Outline: Check if user(Dietician) is able to login  valid endpoint and with valid email id and password in request body
Given: User creates POST Request for the Dietician API endpoint
When User sends HTTPS Request and  request Body with valid emailid and password from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 Ok Status with response body and successfully logs in
Examples: 
      |SheetName           | RowNumber |
      |User_Login          |         0 |
      

#User(Dietician) creates patient with missing Mandatory fields.
Scenario Outline: Check if user_dietician able to create a patient with valid endpoint and request body for non existing values
Given: User creates POST Request for the Dietician API endpoint for creating a new patient records
When User sends HTTPS Request and request Body without mandatory fields tries to create a patient records from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request Status created

Examples: 
      |SheetName           | RowNumber |
      |New_Patient         |         0 |    
      
#User(Dietician) creates patient with missing patient info and attaches only the file.
Scenario Outline: Check if user_dietician able to create a patient with valid endpoint and request body for non existing values
Given: User creates POST Request for the Dietician API endpoint for creating a new patient records
When User sends HTTPS Request and request Body without patientinfo and attaches only the file tries to create a patient records from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request Status created and patientid is not created

Examples: 
      |SheetName           | RowNumber |
      |New_Patient         |         0 |  
          
#Dietician tries to update a patient details with invalid patient id
Scenario Outline: Check if user_dietician is able to update a patient with invalid patient details and mandatory request body
Given: User creates PUT Request for dietician API endpoint for updating the patient records
When User sends HTTPS Request and request Body with mandatory and additional  fields to update a patient records with invalid patientID from the excel sheet "<SheetName>" and <RowNumber>
Then User recieves 400 bad request is created and update failed

Examples: 
      |SheetName              | RowNumber |
      |Update_Patient         |         0 |
      
#Dietician retrieve test report of a patient with invalid patient id
Scenario Outline: Check if user able to retrieve specific patients test report with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports of the patient
When User sends HTTPS Request with invalid patient id <ID>
Then User recieves 404 not found and reports failed to be displayed.
Examples:
|ID|
|0|      

#Dietician tries to retrieve file of a patient with invalid fileid
Scenario Outline: Check if user able to retrieve specific patients test report by fileid with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports by sending the invalid fileid
When User sends HTTPS Request with invalid fileid "<FID>"
Then User recieves 404 not found with no patient test report details
Examples:
|FID|
|value|

#Dietician tries to get morbidity by invalid test name
Scenario Outline: Check if user able to retrieve a morbidity information with valid Morbidity TestName
Given: User creates GET Request for the Dietition endpoint to retrieve a morbidity information with invalid Morbidity TestName
When User sends HTTPS Request with invalid  morbidity test name "<Morbidity Test name>"
Then User recieves 400 Bad Request with no details of morbidity test name getting displayed

Examples:
|Morbidity Test name|
|value|

#Dietician tries to Delete invalid PaitentID

Scenario Outline: Check if user(Dietician) able to delete patient record with valid endpoint
Given: User creates Delete Request for dietician API endpoint  
When User sends HTTPS Request to delete a patient record using invalid patient <ID>
Then User recieves 404 not found with response

Examples:
|ID|
|0|