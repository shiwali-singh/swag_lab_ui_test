# Selenium TestNG Project

This project contains automated tests using Selenium and TestNG.

## Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed
- [Apache Maven](https://maven.apache.org/download.cgi) installed
- [WebDriver executable](https://www.selenium.dev/documentation/en/webdriver/driver_requirements/) for your chosen browser (e.g. ChromeDriver)

## Project Structure

- `src/test/java`: Contains test classes
- `src/main/java`: Contains main application code (if applicable)
- `src/test/resources`: Contains test resources such as configuration files
- `testng.xml` : COntains 

## Dependencies

- Selenium: Used for browser automation
- TestNG: Testing framework
- WebDriver (e.g., ChromeDriver): Browser-specific drivers

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/shiwali-singh/swag_lab_ui_test.git
   cd project-repo
2. Download WebDriver executable for your browser and place it in the project root.

3. Building the Project
   ```bash
   mvn clean install
   
 4. Running Tests
       a. Go to testng.xml file in your project structure
       b. Right click and select run testg.xml file
       
6. Test Reports
   TestNG generates reports in the test-report/swagLabs.html directory.
![image](https://github.com/shiwali-singh/swag_lab_ui_test/assets/99180572/d5b3b600-4cad-44e5-8aee-b13d2391e417)


