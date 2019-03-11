# REST API for generating questions for nembed widget

This backend version which provides a REST API. **There is no UI**.


## Running application locally
```
	git clone https://github.com/pssharma/question.git
	cd question
	./mvnw spring-boot:run
```

You can then access petclinic here: http://localhost:8080/questions/ through Postman client

## Swagger REST API documentation presented here :
<a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>


## Database configuration

In its default configuration, this application uses an in-memory database (HSQLDB) which
gets populated at startup with data.


## Working with Petclinic in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)


### Steps:

1) In the command line
```
git clone https://github.com/pssharma/question.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```


## Looking for something in particular?

| Layer | Source |
|--|--|
| REST API controllers | [REST folder](src/main/java/com/questions/domain/controllers) |
| JPA | [jpa folder](src/main/java/com/questions/domain/repositories) |
| Tests | [controller Tests](src/test/java/com/questions/domain/controllers) |
| DB | [database](src/main/resources/db) |


## Security Consideration

* No OAuth is added or Security in general
* Database is open, but since its in memory threat is lower.

## Assumptions

* Question ID (QID) is estimated to be provided from client
* Options have been stored as string in DB, in agreement with ACID complaince. But are separated with unique string pattern (::) and assumed with be processed in frontend.
* Answers are stored in similar way in the background
* Since REST is stateless it was hard to implement unique question generator on backend. But if Oauth is assumed to be implemented, this would be easier to implement.

## Scalability

* Implement OAuth so that multiple client can access.
* Implementing scalable DB would be preferable way to go.
* Index on Answer DB would make unique question generator load faster.
* Keep API backward compatible always.
* Implement DTO service to make mapping better.

