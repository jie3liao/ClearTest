
## General Info
This project does three things:
* Automates the Ikea shopping bag action.
* Test the GET API of datausa.
* Simplify a method to produce name initials.

## Technologies
Project is created with:
* Java
* Maven
* Cucumber
* Selenium
* Serenity

## Setup
* This project is tested with Jave version 8 and 11.
* The Maven version is "3.6.3".
* Browser is chrome
* Chrome driver is in a directory in the Path environment variable.

## Review Code
Use an IDE like Eclipse to import this Maven project.

## Run the project
Go to the project directory.

For Ikea automation test, run 
* mvn clean verify -Dcucumber.filter.tags="@AddToBag"

For datausa API test, run
* mvn clean verify -Dcucumber.filter.tags="@GetUSAData"

For the name utility, the file is NameUtility.java in the package "cc.explore". Run
* cd src\test\java
* javac ./cc/explore/NameUtility.java
* java cc.explore.NameUtility
