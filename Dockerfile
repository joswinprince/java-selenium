FROM maven:3.8.5-openjdk-17-slim

# Install Chrome (optional for Selenium)
# ... Chrome install lines here ...
USER root

# Set noninteractive mode to avoid prompts
ENV DEBIAN_FRONTEND=noninteractive

#Intall dependencies
RUN apt-get update && apt-get install -y wget gnupg2 ca-certificates

# Install Google Chrome
RUN wget -q -O google-chrome.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && dpkg -i google-chrome.deb || apt-get -fy install -m && rm google-chrome.deb

# Install ChromeDriver (compatible version)
#ENV CHROME_DRIVER_VERSION 125.0.6422.60
#RUN wget --user-agent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) ..." -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/125.0.6422.60/linux64/chromedriver_linux64.zip && unzip /tmp/chromedriver.zip -d /usr/local/bin/ && chmod +x /usr/local/bin/chromedriver && rm /tmp/chromedriver.zip


# Install Node.js & npm
RUN apt-get update && apt-get install -y nodejs npm


# Install Allure commandline globally using npm (latest CLI v2)
RUN npm install -g allure-commandline --save-dev

WORKDIR /automation
COPY . .
RUN mvn dependency:go-offline

CMD ["sh", "-c", "mvn clean test -Dallure.results.directory=target/allure-results allure:report"]
