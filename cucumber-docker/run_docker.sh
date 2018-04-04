#!/bin/bash
export ENV="${1}" 
echo "Enviroment is $ENV"
export FILE_YML=docker.yml
case $ENV in 
   "chrome") FILE_YML=docker-chrome.yml
      ;; 
   "grid") FILE_YML=docker-grid.yml
      ;;
   "browserstack") FILE_YML=docker-browserstack.yml
      ;;  
   *)  
      echo "`basename ${0}`:usage: [chrome Local Chrome] | [grid Selenium Grid] | [browserstack BrowserStack]"
      ;; 
esac

echo $FILE_YML
#clean up reports folder
rm -rf docker-reports/*
#up existing image file
#docker-compose -f $FILE_YML up -d --scale chrome=3
#docker-compose -f $FILE_YML build
docker-compose -f $FILE_YML up
#grid is below
docker ps
docker logs cucumberdocker_chrome_tester_1
docker cp cucumberdocker_chrome_tester_1:/target/ docker-reports/
EXIT_CODE=$(docker wait cucumberdocker_chrome_tester_1)
#docker-compose stop
#docker system prune -f
exit $EXIT_CODE
done