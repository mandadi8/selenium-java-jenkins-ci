# Selenium Java POM Framework — Clean v2

This version intentionally has **no TestNG listener package**. TestNG remains a test-scoped dependency, so all TestNG code is under `src/test/java`.

## Stack

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model
- ThreadLocal WebDriver
- Selenium Manager
- Log4j2
- ExtentReports dependency

## Structure

```text
selenium-java-pom-framework/
├── pom.xml
├── testng.xml
├── src/
│   ├── main/java/
│   │   ├── config/
│   │   ├── constants/
│   │   ├── drivers/
│   │   ├── pages/
│   │   ├── utils/
│   │   ├── reports/
│   │   └── exceptions/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   └── tests/
│       └── resources/
│           ├── config/
│           ├── testdata/
│           └── log4j2.xml
└── reports/
```

## Verify Java and Maven

```cmd
java -version
mvn -version
```

Java should be 21.

## Run tests

From the folder containing `pom.xml`:

```cmd
mvn clean test
```

Chrome:

```cmd
mvn clean test -Dbrowser=chrome
```

Firefox:

```cmd
mvn clean test -Dbrowser=firefox
```

Edge:

```cmd
mvn clean test -Dbrowser=edge
```

Headless Chrome:

```cmd
mvn clean test -Dbrowser=chrome -Dheadless=true
```

Environment:

```cmd
mvn clean test -Dbrowser=chrome -Denvironment=qa
```

## Demo

The example uses SauceDemo:

`https://www.saucedemo.com/`

Demo credentials:

```text
standard_user
secret_sauce
```

## Jenkins

Use:

```cmd
mvn clean test -Dbrowser=chrome -Dheadless=true
```

## Important architecture choice

`TestNG` is intentionally declared with test scope in `pom.xml`.

Therefore TestNG-specific classes belong under:

```text
src/test/java
```

and production framework code under:

```text
src/main/java
```

There is **no `listeners/` package in this version**.
