
## Folder structure
- selenium framework

|-- src
|   |-- main
|   |   |--- java
|   |   |   |--- base (web driver setup and base classes)
|   |   |   |--- config (properties or configuration files)
|   |   |   |--- pages (Page object Model classes)
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
# Generating Reports with report folder
`
allure generate allure-results --clean -o allure-report
allure open allure-report
`

# Generating the report
`
allure serve allure-results
`

# Running Locally 
`
mvn clean test -Dallure.results.directory=target/allure-results allure:report allure:serve
`

# To Run Locally as Docker 
`
docker build -t selenium-tests .
`

# Run Docker and iterate to shell'
`
docker run -it selenium-tests sh
`


# Moving Reports locally from docker
`
docker run --rm -v "%cd%/allure-report:/automation/target/allure-report" selenium-tests
`

#Moving Reports locally from docker linux:
`
docker run --rm -v "$(pwd)/allure-report:/automation/target/allure-report" selenium-test
`

# Mount the local folder to Docker and get the reports
docker run --rm -v "%cd%/allure-report:/automation/target/allure-report" selenium-test

# Steps to run report successfully inside docker 
Goal: Run the tests in Docker, keep the container alive, and inspect the allure-results later.
Step 1 — Run the container and give it a name
bash
Copy
Edit
docker run -it --name selenium-run selenium-tests sh
This opens a shell inside the container without running tests yet.

Step 2 — Run your tests inside the container
bash
Copy
Edit
mvn clean test -Dallure.results.directory=target/allure-results allure:report
Your allure-results will now be created inside this running container.

Step 3 — Leave but keep container
Press:

css
Copy
Edit
Ctrl + P, then Ctrl + Q
(That “detaches” from the container without stopping it.)

Step 4 — Re-enter the container anytime
bash
Copy
Edit
docker exec -it selenium-run sh
Now you can cd into target/allure-results and see your files, even days later.

Step 5 — Copy results to host (optional)
bash
Copy
Edit
docker cp selenium-run:/automation/target/allure-results ./allure-results