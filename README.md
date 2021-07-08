# Socra_project

This project was made by:  

Sallé Erwan  
Monfray Baptiste  
Billy Mathieu  
Bugeia Alexandre  
Keloghlanian Corentin

For this api we have use a classic rest api wich follows the pattern controllers, services and repositories.  

For the workflow of the project we have choose to use a basic git flow, with release, develop and feature.

We have also implemented the CI on github with travis.  

# Requirements

For this project you'll need a java editor and postgres sql.

# Create the database

For that you'll need to open the postgres sql shell and type the following:

CREATE DATABASE socra;  
\du (to check list of role)  
GRANT ALL PRIVILEGES ON DATABASE "socra" to [role]; (you should put postgres as the role, if you don't, make sure to change it in the application.properties located in the resources folder)

Don't forget to put your sql password in the application.properties file (resources folder). If you haven't set any, the default password should be postgres.

# Testing our endpoints
In order to test our endpoints, here are an example of how to:

GET http://localhost:8080/tasks   
POST http://localhost:8080/tasks  (with json body)  
PUT http://localhost:8080/tasks/1 (with json body)  
DEL http://localhost:8080/tasks/1  

GET http://localhost:8080/missions/keywords?keywords=test,testbis

GET http://localhost:8080/tasks/export/1   

All the core features and bonuses are implemented and should follow the behavior describe.  

We have tests in the test folder to test our funtions.