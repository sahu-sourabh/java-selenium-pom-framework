# Modern Web Automation Framework (MVP)

A lightweight, high-performance web automation framework designed using the **Page Object Model (POM)** pattern. Engineered from the ground up using modern software practices, this project showcases a clean, decoupled test architecture built for scalability and thread safety.

## 🚀 Tech Stack & Specifications
* **Language:** Java 25 (utilizing modern pattern matching and switch expressions)
* **Automation Engine:** Selenium 4+ (featuring native Selenium Manager execution)
* **Test Orchestration:** TestNG 7.12.0
* **Build Tool:** Apache Maven
* **Logging System:** Log4j2 (API & Core synchronization)

## 🏛️ Framework Architecture Key Features
* **Zero Driver Setup Overhead:** Completely decoupled from legacy WebDriverManager binaries; leverages Selenium 4's native background driver manager.
* **Thread-Safe Architecture:** Drivers are instance-scoped within test classes to allow concurrent cross-browser execution without resource collision.
* **Robust Configuration Parsing:** Uses the Java ClassLoader to read environment properties dynamically from the classpath, avoiding brittle relative system directory paths.
* **Lean Execution Footprint:** Stripped of unnecessary boilerplate build plugins to maximize execution speed and simplify dependency tracking.

## 📁 Directory Structure
```text
├── src
│   └── test
│       ├── java
│       │   └── com.saucedemo
│       │       ├── pages       # Page Object classes (Encapsulated elements/actions)
│       │       ├── tests       # Test execution layers (BaseTest & Test cases)
│       │       └── utils       # Configuration loaders and Listeners
│       └── resources           # Global environment properties & configurations
├── testng.xml                  # Test suite configuration definitions
└── pom.xml                     # Maven dependencies configuration file
```

## ⚙️ How to Run the Suite
**Prerequisites**
Ensure you have **Java 25** and **Maven** installed and configured in your environment path variable.

**Execute via CLI**
Open your terminal at the root directory of the project and execute:
- mvn clean test