# PeopleSphere – Test Automation

## 📌 Project Overview

PeopleSphere is a web-based HR management application used for managing employee-related operations.

This project focuses on automating functional test scenarios using Selenium WebDriver with Java and TestNG. The automation follows the Page Object Model (POM) design pattern for better code organization and reusability.

## 🛠️ Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub

## 📂 Project Structure

```text
PeopleSphere
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── DashboardPage.java
│   │   │   │   └── PIMPage.java
│   │   │   │
│   │   │   └── utils
│   │   │       └── ConfigReader.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       └── java
│           ├── base
│           │   └── BaseTest.java
│           │
│           └── tests
│               ├── LoginTest.java
│               └── PIMTest.java
│
└── pom.xml
🧪 Test Scenarios
Login Testing
Valid login
Invalid username
Invalid password
Empty username
Empty password
Empty credentials
Logout
PIM Testing
Open PIM module
Add employee
Search employee
Edit employee details
Delete employee
⚙️ Framework Features
Page Object Model (POM)
Reusable page methods
Explicit waits
TestNG assertions
Configuration using properties file
Maven dependency management
▶️ How to Run
1. Clone the repository
git clone https://github.com/SunnySingh0001/PeopleSphere.git
2. Open the project

Open the project in IntelliJ IDEA or any Java-supported IDE.

3. Install Maven dependencies
mvn clean install
4. Run the tests
mvn test

You can also execute individual TestNG test classes directly from IntelliJ IDEA.

📊 Test Coverage

The project covers core authentication and employee management functionalities of the application.

👨‍💻 Author

Sunny Singh

GitHub:
https://github.com/SunnySingh0001
