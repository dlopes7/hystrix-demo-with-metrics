# Sample Hystrix application with metric stream

## To run

`mvn clean spring-boot:run`

## Endpoints

* `http://localhost:8080/ok` - HystrixCommand executes OK
* `http://localhost:8080/fail` HystrixCommand activates failback
* `http://localhost:8080/hystrix.stream` - Metric Stream

