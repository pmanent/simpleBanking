## Simple Banking application:


This is Project for a Simple Banking application

How to run test:

```
mvn clean test
```

Jacoco Test Coverage:

/target/site/jacoco/index.html

Run application:

```
mvn spring-boot:run
```

# Api Rest Commands:
Login
```
localhost:9000/login (GET)
```
Statement
```
localhost:9000/statement?username=admin (GET)
```
Add Bearer + token

Desposit
```
localhost:9000/deposit (POST)
```
Add Bearer + token,
Body: 
{
	"username": "admin",
	"ammount": 2000
}

Withdraw
```
localhost:9000/withdraw (POST)
```
Add Bearer + token,
Body: 
{
	"username": "admin",
	"ammount": -2000
}
