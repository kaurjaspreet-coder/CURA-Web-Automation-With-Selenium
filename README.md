# CURA-HealthCare-Automation-Testing

This is an **Automation Testing** project for the **CURA Healthcare** application, demonstrating hands-on experience in Selenium WebDriver, TestNG, Cucumber, and Maven. The project automates the **appointment booking** process on the CURA Healthcare website, validating the features like login, facility selection, date picker, and appointment booking.

## Features
- **Login Functionality Testing**: Automated testing for login with valid and invalid credentials.
- **Appointment Booking**: Validates booking an appointment by selecting facilities, health programs, and dates.
- **Date Picker Handling**: Tests the ability to select future and past dates.
- **Cross-Browser Testing**: Supports **Chrome**, **Firefox**, and **Edge** browsers.
- **Test Reporting**: Generates detailed HTML reports using **ExtentReports**.
- **Page Object Model (POM)**: Ensures better code maintainability and reusability.
- **Maven**: For dependency management and running tests.

## Technologies Used
- **Selenium WebDriver**: Automates browser interactions for testing the CURA application.
- **TestNG**: Framework for running test cases.
- **Maven**: Dependency management and build automation.
- **ExtentReports**: Generates detailed, interactive HTML reports.
- **Cucumber**: Behavior-Driven Development (BDD) for API testing.
- **Java**: Programming language for writing test scripts.

## Prerequisites
To run the automation framework, make sure you have the following installed:
- **Java 21** (or later)
- **Maven**
- **Selenium WebDriver**
- **TestNG**
- **Cucumber**
- **ExtentReports**
- **Maven Dependencies**: Managed via the `pom.xml` file
- **Browser Drivers**: ChromeDriver, GeckoDriver, or EdgeDriver

## Test Scenarios Covered
- Login with valid/invalid credentials.
- Appointment booking with different options (facility, health program, comments, date selection).
- Cross-browser compatibility (Chrome, Firefox, Edge).
- Test reports generation with **ExtentReports**.

## Test Reports
Test execution results are captured in the `reports/index.html` file, which provides detailed information about each test case, including screenshots for failed tests.
