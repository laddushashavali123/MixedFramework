#! /bin/sh -
docker-compose -f docker-chrome.yml build
docker-compose -f docker-chrome.yml up -d
docker ps
docker system prune -f
EXIT_CODE=$(docker wait cucumber_chrome_tester_1)
docker logs cucumber_chrome_tester_1
docker-compose -f docker-chrome.yml stop
exit $EXIT_CODE