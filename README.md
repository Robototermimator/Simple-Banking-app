#  Banking System

A secure, console-based Banking System built with **Java** and **Maven**. This project demonstrates Object-Oriented Programming (OOP), file-based data persistence, PIN hashing using SHA-256, and a layered architecture.

---

##  Overview

The Banking System allows users to create bank accounts, securely store PINs using SHA-256 hashing, and perform basic banking operations. Account information is persisted to a local file so that data remains available after the application is closed.

This project was built as a learning project to strengthen Java programming skills while following software engineering best practices.

---

##  Features

-  Create a bank account
-  Deposit money
-  Withdraw money
-  Check account balance
-  Secure PIN hashing (SHA-256)
-  Account lock after multiple failed login attempts
-  File-based persistence
-  Layered architecture
-  Unit testing with JUnit 5

---

## 🛠 Tech Stack

- Java 21+
- Maven
- JUnit 5
- SHA-256 (Java MessageDigest)
- File I/O (BufferedReader & BufferedWriter)

---

## 📂 Project Structure

```text
banking-system/
│
├── data/
│   └── accounts.db
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/thorn/banking/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── security/
│   │   │       ├── service/
│   │   │       ├── util/
│   │   │       └── Main.java
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│           ├── AccountTest.java
│           ├── AuthServiceTest.java
│           ├── FileAccountRepositoryTest.java
│           └── PasswordHasherTest.java
│
├── pom.xml
└── README.md
```

---

##  Architecture

The project follows a layered architecture:

### Model
Contains the application's data objects.

- Account
- Customer
- Transaction

### Service

Contains business logic.

- BankService
- AuthService

### Repository

Responsible for storing and retrieving account information.

- FileAccountRepository

### Security

Handles password hashing and verification.

- PasswordHasher

### Utilities

Contains helper classes.

- ConsoleHelper
- FileUtil

---

##  Getting Started

### Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/banking-system.git
```

### Navigate to the project

```bash
cd banking-system
```

### Compile the project

```bash
mvn compile
```

### Run the application

```bash
mvn exec:java
```

or run

```
Main.java
```

directly from your IDE.

---

##  Running Tests

Run all tests using Maven:

```bash
mvn test
```

---

##  Security

This project implements several basic security concepts:

- SHA-256 PIN hashing
- PIN verification
- Failed login tracking
- Account locking after repeated failed attempts
- No plain-text PIN storage

---

##  Data Persistence

Account data is stored locally in:

```
data/accounts.db
```

The application automatically loads account information when it starts and saves changes whenever an account is updated.

---

##  Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Encapsulation
- Collections (HashMap)
- File Handling
- Exception Handling
- Maven Project Structure
- Unit Testing
- Basic Authentication
- Secure Hashing
- Layered Software Architecture

---

##  Planned Features

- Transaction history
- Money transfers
- Savings and current accounts
- Interest calculations
- Admin dashboard
- Customer login/logout sessions
- JSON data storage
- Database integration (MySQL/PostgreSQL)
- Spring Boot REST API
- JWT Authentication
- Docker support
- AWS deployment

---

##  Author

**Thorn**

Bachelor of Information Technology (Business Systems)

Interested in:

- Backend Development
- Cybersecurity
- Cloud Computing

---

##  License

This project is licensed under the MIT License.

Feel free to use, modify, and learn from this project.

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!
