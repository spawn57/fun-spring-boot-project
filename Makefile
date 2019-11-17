SHELL := /bin/bash

PROJECT_NAME ?= fun

test:
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.maven.yml run --rm maven mvn clean test --settings ./settings.xml
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.yml down

build:
	rm -rf target/fun-*.jar*
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.maven.yml run --rm maven mvn package -Drevision=$(shell git rev-parse HEAD) -Dmaven.test.skip=true --settings ./settings.xml

verify: start-db start-localstack
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.maven.yml run --rm maven mvn verify -e --settings ./settings.xml

deploy-to-artifactory: start-localstack
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.maven.yml run --rm maven mvn deploy -Drevision=$(REVISION) -e -U --settings ./settings.xml

start-project:
	docker-compose --project-name=${PROJECT_NAME} up --build

stop-project:
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.yml -f docker-compose.maven.yml -f docker-compose.localstack.yml down

clean-project: stop-project
	-docker kill $$(docker ps -qa -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-docker rm $$(docker ps -qa -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-docker rmi -f $$(docker images "${PROJECT_NAME}*" -qa) 2>/dev/null || true
	-docker rmi -f $$(docker images -f 'dangling=true' -qa) 2>/dev/null || true
	-docker network rm $$(docker network ls -q -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-yes | docker volume prune 2>/dev/null || true

.PHONY: clean-project stop-project start-project deploy-to-artifactory verify build test start-localstack start-db init
