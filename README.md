### DRONE-MG
#### USAGE
1. used to manage a fleet of drone
#### TECHNOLOGIST USED
1. Java 21
2. gradle 8.10
3. spring 3.3
4. open-api
5. Postgres 
6. Docker & Docker Compose
7. TestContainers

#### BUILDING
1. `gradle clean build -x test`

#### RUNNING
1. `docker compose -f docker-compose.yml up`
2. `gradle bootRun`
3. access the application throw  [open-api](http://localhost:8080/swagger-ui/index.html)

#### RUNNING UNIT-TEST
1. `gradle unitTests`

#### RUNNING INTEGRATION-TEST
1. `gradle integrationTests`