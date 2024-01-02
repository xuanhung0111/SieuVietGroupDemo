# Selenium Maven Project with Cucumber

This is a sample Maven project that integrates Selenium WebDriver with Cucumber for automated testing of web applications.

## Project Overview
1. Framework: Maven
2. Testing Framework: Cucumber
3. Automation Tool: Selenium WebDriver
4. Language: Java

### Project Structure

See details in: [selenium-maven-cucumber](https://artoftesting.com/wp-content/uploads/2019/12/cucumber-with-selenium.jpg)

## Getting Started
Prerequisites
- [JAVA 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) installed
- [Maven](https://maven.apache.org/download.cgi) installed
- [Chrome](https://www.google.com/intl/vi_vn/chrome/) browser installed
- [ChromeDriver](https://chromedriver.chromium.org/downloads/version-selection) downloaded

Note1: Need to change "chromedriver" path in DriverMager class as your config system.

Note2: GitHub repo only support 100Mb, with big files, it just a name

Note3: Some test still didn't work as expected, so I still let them failures

##

1. Clone the Repository:
```
git clone https://github.com/yourusername/selenium-maven-cucumber.git
```

2. Download Dependencies:
Open a terminal in the project root directory and run:
```
mvn clean install
```

3. Run Tests:
```
mvn test
```