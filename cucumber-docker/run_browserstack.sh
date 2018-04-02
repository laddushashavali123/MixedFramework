#! /bin/sh -
docker-compose -f docker-browserstack.yml build
docker-compose -f docker-browserstack.yml up -d
docker ps
docker system prune -f
EXIT_CODE=$(docker wait cucumber_tester_1)
docker logs cucumber_tester_1
docker-compose -f docker-browserstack.yml stop
exit $EXIT_CODE
