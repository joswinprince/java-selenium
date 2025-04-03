
## Folder structure
- selenium framework

|-- src
|   |-- main
|   |   |--- java
|   |   |   |--- base (web driver setup and base classes)
|   |   |   |--- config (properties or configuration files)
|   |   |   |--- pages (Page bject Model classes)
|   |   |   |--- utils (utility functions)
|   |   |   |--- reporting (custom logging , error reporting)
|   |   |--- resources (project resources)


|-- src
|   |-- test
|   |   |--- java
|   |   |   |--- tests (test classes using Junit/testng)
|   |   |   |--- runners (cucumber test)
|   |   |   |--- step definitions (cucumber)
|--- drivers (web driver typically chromedriver.exe)
|--- logs (test execution log files)
|--- reports (Extent reports, allure, html reports)
|--- test-data (xls or json files)
|--- screenshots (failed tests)
|--- framework-config.properties
|--- testng.xml (Test ng suite)
|--- pom.xml (Maven dependencies for Java)

## Execution Instruction

`
mvn clean compile
`
`
mvn test
`

