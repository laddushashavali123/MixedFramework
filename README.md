# Automation mudules
Hi guest, below is small description of this project. Here you can find improvements for Selenium based 
Automation framework in sepparate classes, Appium features, API Automation examples.
# 1) SeleniumStart
Here is example how to take value from property file
and how to run test in different browsers
# 2) Selenium features
Project that contains improvements of framework:
* us.st.selenium.browsers - running browsers with different capabilities
* us.st.selenium.data_driven - different types of data-driven approaches
* us.st.selenium.protocols - tee console output, output to mysql, using logback, sl4j
* us.st.selenium.extension - extension of framework to compare images and highlight DOM elements
# 3) Java Core features
* us.st.java_features - features from Java core. Code samples taken from Book "Thinking in Java" Bruce Eckel. All related to Java SE + features of jdk 8
* us.st.patterns - Java programing patterns
* us.st.datastructure - implementation of Queue, Stack, List, And Hash
* us.st.tasks - solutions to some HackerRank and TopTall tests
# 4) docker-cucumber framework: 
Example of cucumber framework to run in docker container in chrome and selenium grid:
* mvn clean verify - will run feature file in specified amount of Threads;
* sh run_docker.sh chrome - will run chrome in headless in Docker container;
* sh run_docker.sh grid - will run on registered chrome node in Docker container;

*Report folder-location:* cucumber-docker/target/

**#ToDO:**
fix ReporterMerger class for parsable to this plugin:

https://github.com/damianszczepanik/cucumber-reporting
# 5) API-automation:
Examples of automation of api testing using JSON parser and HttpClientBuilder:
* us.st.API - automation of http get and set requests. Parsing JSON Responses using Jackson and GSON parsers. Added example of parsing response from:

https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=0
# 6) Appium tests:
Example how Appium tests are working:
* us.st.appium - has next tests:

     **AmazonPriceCompareTest** - put all prices in Hahmap and compare them and output the cheapest given item
     
     **SampleTest** - navigate through android system
     
     **AppiumServerJava** - wrapper for how start and stop appium via Java code
               





