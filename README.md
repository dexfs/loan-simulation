
# Loan Simulation

The API will provide a loan simulation given a value the customer needs.

The API will return the installments of this loan.


# Flow

To make a simulation, it's necessary to create a customer and after that call the simulation endpoint resource passing the customer and the value needs.


# Compile

```bash
$ mvn compile
$ mvn package
$ java -jar target/loan-simulation-0.0.1-SNAPSHOT.jar

```

# Docker

```bash
$ docker build -t org/app .
$ docker run -p 8080:8080 myorg/myapp  

```







