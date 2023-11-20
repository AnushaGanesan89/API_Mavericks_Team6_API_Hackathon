Feature: Dieticians Role Module Positive Scenarios
Background: User sets Authorization to Bearer Token

#Dietician Logs In
Scenario Outline: Check if user(Dietician) is able to login  valid endpoint and with valid email id and password in request body
Given: User creates POST Request for the Dietician API endpoint
When User sends HTTPS Request and  request Body with valid emailid and password from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 Ok Status with response body and successfully logs in
Examples: 
      |SheetName           | RowNumber |
      |User_Login          |         0 |

#Dietician Creates a patient details
Scenario Outline: Check if user_dietician able to create a patient with valid endpoint and request body for non existing values
Given: User creates POST Request for the Dietician API endpoint for creating a new patient records
When User sends HTTPS Request and request Body with mandatory and additional  fields to create a patient records from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 Created Status with response body and patient is successfully created

Examples: 
      |SheetName           | RowNumber |
      |New_Patient         |         0 |

#Dietician retrieves all patient details
Scenario: Check if user able to retrieve all patients with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve all patients details
When User sends HTTPS Request to retrieve all patients details
Then User recieves 200 OK with response body 


#Dietician updates a patient details
Scenario Outline: Check if user_dietician is able to update a patient with valid patient details and mandatory request body
Given: User creates PUT Request for dietician API endpoint for updating the patient records
When User sends HTTPS Request and request Body with mandatory and additional  fields to update a patient records from the excel sheet "<SheetName>" and <RowNumber>
Then User recieves 200 Ok with response body with response body and patient details are successfully updated

Examples: 
      |SheetName              | RowNumber |
      |Update_Patient         |         0 |


#Dietician retrieves test report of a patient
Scenario Outline: Check if user able to retrieve specific patients test report with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports of the patient
When User sends HTTPS Request with valid patient id <ID>
Then User recieves 200 OK with patient test report details
Examples:
|ID|
|0|


#Dietician retrieves file of a patient
Scenario Outline: Check if user able to retrieve specific patients test report by fileid with valid API Endpoint
Given: User creates GET Request for the dietician API endpoint to retrieve test reports by sending the fileid
When User sends HTTPS Request with valid fileid "<FID>"
Then User recieves 200 OK with patient test report details
Examples:
|FID|
|value|

#Dietician gets all morbidities
Scenario: Check if user able to retrieve all morbidity information 
Given: User creates GET Request for the Dietition endpoint to retrieve all morbidity details
When User sends HTTPS Request to retrieve all morbidity details
Then User recieves 200 OK with response body with all morbidities


#Dietician gets morbidity by test name
Scenario Outline: Check if user able to retrieve a morbidity information with valid Morbidity TestName
Given: User creates GET Request for the Dietition endpoint to retrieve a morbidity information with valid Morbidity TestName
When User sends HTTPS Request with morbidity test name "<Morbidity Test name>"
Then User recieves 200 OK with response body with the details of morbidity test name

Examples:
|Morbidity Test name|
|value|
    

#Dietician logs out
Scenario: Check if user able to logout from Dietician API
Given: User creates GET Request for the Dietician API endpoint
When User sends HTTPS GET Request to logout from the Dietician API
Then User receives 200 OK Status with response body Logout successful
  	
  
  
    
      
       