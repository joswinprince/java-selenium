FROM maven:3.8.5-openjdk-17

# Install Chrome (optional for Selenium)
# ... Chrome install lines here ...

WORKDIR /automation

COPY . .

RUN mvn clean install
RUN mvn allure:report

CMD ["mvn", "test"]
