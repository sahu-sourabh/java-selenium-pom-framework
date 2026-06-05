# Selenium Java POM MVP (`selenium-java-pom-mvp`)

A high-performance, enterprise-ready web automation showcase engineered with Java 25, Selenium 4, and TestNG. This repository demonstrates a thread-safe, decoupled Page Object Model (POM) architecture optimized for continuous integration environments.

---

## 🛠️ Core Engineering Highlights

* **Thread-Safe Architecture:** Eliminated brittle listener-to-base inheritance anti-patterns by utilizing TestNG execution context reflection to handle runtime browser sessions safely.
* **Encapsulated Page Objects:** Strict object-oriented design patterns where locator attributes are isolated as private class-level constants, enforcing complete webpage decoupling.
* **Self-Cleaning Lifecycles:** Configured runtime logs, HTML regression reports, and failure screenshots to route entirely into Maven's transient `target/` directory, automating local workspace cleanup during execution loops.
* **Headless CI/CD Pipeline:** Fully automated GitHub Actions workflow integrated with virtual framebuffers (`xvfb`), executing test runners seamlessly on remote cloud instances while persisting historical run metrics via pipeline artifacts.

---

## 💻 Tech Stack Matrix

| Layer | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | Java 25 | Utilizes modern language structures (Switch Expressions) |
| **Core Engine** | Selenium 4 | Native driver binary handling via Selenium Manager |
| **Test Runner** | TestNG | Advanced test lifecycle controls and execution routing |
| **Logging** | Log4j2 + SLF4J Bridge | Uniform tracing across both local frameworks and internal engine drivers |
| **Reporting** | Extent Reports | Responsive HTML reporting output maps with relative visual capture links |
| **CI/CD Pipeline** | GitHub Actions | Remote test orchestration on headless Ubuntu containers |

---

## 📂 Project Architecture

```text
├── .github
│   └── workflows
│       └── maven.yml          # GitHub Actions CI pipeline configuration
├── src
│   └── test
│       ├── java
│       │   └── com.saucedemo
│       │       ├── pages      # Page Object wrappers (UI action layers)
│       │       ├── tests      # Test execution suits and BaseTest hooks
│       │       └── utils      # Centralized reporting configurations and listeners
│       └── resources
│           ├── config.properties  # Global environment settings
│           └── log4j2.xml         # Unified logging engine configurations
└── pom.xml                    # Consolidated dependencies and build lifecycle manager
```

---

## 🚀 Local Execution Setup
**Prerequisites**
Ensure you have the following installed locally:
- Java JDK 25
- Apache Maven

**Running the Tests**
To wipe out stale runtime components and execute the regression suite natively, open your terminal at the root directory and trigger:
- mvn clean test

**Viewing Execution Outputs**
- **Logs:** Available at ./target/logs/execution.log
- **HTML Reports:** Interactive test results are automatically rendered at ./target/reports/index.html

---
