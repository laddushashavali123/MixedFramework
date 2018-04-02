# Cucumber

### Purpose

This a exploratory project evaulating Cucumber as an alternative to JBehave. Also uses Selenium 3 and Docker.

### Running

#### Local (Dev)

Runs against a local headless Chrome

Install Java8, Maven 3, Chrome and Chromedriver (Homebrew recommended)

`mvn clean verify`


#### Docker Chrome (Not Recommended)

Runs against a local Chrome

Docker must be installed

`./run_docker_chrome.sh`


#### Docker Grid (Functional Regression)

Runs against a local Chrome through Selenium Grid

Docker must be installed

`./run_docker_grid.sh`


#### BrowserStack (Cross Browser Regression)

Runs against Edge on BrowserStack and compares captured images against baseline using Applitools 

For BrowserStack, make sure the below environment variables are set:

1. APPLITOOLS_KEY
2. BROWSERSTACK_KEY
3. BROWSERSTACK_USER

Docker must be installed

`./run_browserstack.sh` 


#### TODO

1. Make reports available from Docker