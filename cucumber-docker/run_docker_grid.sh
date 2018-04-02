#! /bin/sh
ENV="${1}" 
echo "Enviroment is $ENV"
FILE_YML=""
case ${env} in 
   "chrome") FILE_YML="docker-chrome.yml" 
      ;; 
   "grid") FILE_YML="docker-grid.yml" 
      ;;
   "browserstack") FILE_YML="docker-browserstack.yml"
      ;;  
   *)  
      echo "`basename ${0}`:usage: [chrome Local Chrome] | [grid Selenium Grid] | [browserstack BrowserStack]" 
      exit 1 # Command to come out of the program with status 1
      ;; 
esac
docker-compose -f $FILE_YML build
docker-compose -f $FILE_YML up -d --scale chrome=3
docker ps
docker system prune -f
EXIT_CODE=$(docker wait cucumber_tester_1)
docker logs cucumber_tester_1
docker-compose stop
exit $EXIT_CODE