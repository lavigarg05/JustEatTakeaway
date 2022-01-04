1) This project is to automate on below front end scenarios: 
	a) Confirm an order cannot be placed when the consumer is not in the same City / Region
	b) Confirm an order cannot be checked out if the cart value is less than minimum order value of the restaurant.
	
2) The technology stack used is Java+Selenium+Cucumber+Maven

3) Current project uses firefox geckoDriver.exe and is working for Firefox Version 93.0 
   For Chrome, chromeDriver.exe is working for Chrome Version 96.0.4664.110   
   These exe files can be replaced based on your browser version at : JustEatTakeaway/browserExeFiles
   
4) The tests are stored at location : JustEatTakeaway/src/test/java/com/jet/framework/test/Features

5) The subsequent glue code is at location : JustEatTakeaway/src/main/java/com/jet/framework/stepDefinitions

6) The TestRunner.java file is at : JustEatTakeaway/src/test/java/com/jet/framework/TestRunner/TestRunner.java
   --> Use tag @Regression to run all the test cases together.

7) To run the test as maven test -->
- Ensure maven is installed on the computer and path set in system variables. (Refer : https://maven.apache.org/install.html)
- Go to project path in command prompt : cd <path of JustEatTakeaway project>
- Execute command : mvn clean install
- All tests will be executed.

Alternatively, in any IDE , run as maven with Goals -> clean install

8) Logs and Reporting :
- To view the Test logs -->  JustEatTakeaway/logs/application.log
- To view test Report (open the report in web browser)--> JustEatTakeaway/target/cucumber-html-reports/overview-features.html
- To view application screenshots --> JustEatTakeaway/screenshots/

9) Static data (User Address) is stored in file --> JustEatTakeaway/TestData/AdressInfo.xlsx
10) To run test as headless : JustEatTakeaway/config/config.properties --> set headless=true