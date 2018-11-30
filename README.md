# KLyrics

KLyrics is a simple project based on Ktor and Kotlin. 
It's goal is to explore the testing strategies related to a Ktor web application written in Kotlin.
It provide a set of examples for:
* acceptance tests with remote endpoint
* external rest service integration tests
* controller unit tests

## Getting Started

Clone the repository:

```
git clone https://github.com/fracassi-marco/klyrics.git
cd klyrics
```

Run the application:

```
mvn exec:java -Dexec.mainClass="klyrics.KLyricsKt"
```

Open browser:

```
http://localhost:8080/
```

Enjoy

### Prerequisites

You must have Maven

## Running the tests

```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **[Marco Fracassi](https://github.com/fracassi-marco)**

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE Version 3 - see the [LICENSE](LICENSE) file for details
