PROJECT_NAME ?= fun

start-project:
	docker-compose --project-name=${PROJECT_NAME} up --build

stop-project:
	docker-compose --project-name=${PROJECT_NAME} -f docker-compose.yml down

clean-project: stop-project
	-docker kill $$(docker ps -qa -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-docker rm $$(docker ps -qa -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-docker rmi -f $$(docker images "${PROJECT_NAME}*" -qa) 2>/dev/null || true
	-docker rmi -f $$(docker images -f 'dangling=true' -qa) 2>/dev/null || true
	-docker network rm $$(docker network ls -q -f "name=${PROJECT_NAME}*") 2>/dev/null || true
	-yes | docker volume prune 2>/dev/null || true

.PHONY: stop-project start-project
