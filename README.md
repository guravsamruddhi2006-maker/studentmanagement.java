🎓 Student Management System

A desktop-based Student Management System developed using Java Swing and MySQL.
This application allows users to manage student records efficiently with features like authentication, student management, search, marks management, and CSV export functionality.

📌 Features
🔐 User Registration & Login
➕ Add Student
👀 View Students
✏ Update Student Details
❌ Delete Student
🔍 Search Student
📊 Manage Student Marks
📁 Export Student Data to CSV

🛠 Technologies Used
Technology            Purpose
Java                  Core Programming Language
Swing                 GUI Development
MySQL                 Database
JDBC                  Database Connectivity
IntelliJ IDEA         IDE

🗄 Database Configuration
Database Name
SQL
CREATE DATABASE student_db;
USE student_db;

Users Table
SQL
CREATE TABLE users(
username VARCHAR(50) PRIMARY KEY,
password VARCHAR(100)
);

Students Table
SQL
CREATE TABLE students(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
course VARCHAR(50),
marks FLOAT
);

▶ How to Run the Project
Step 1: Clone or Download the Project
Download the project ZIP or clone it using Git.

Step 2: Open Project in IntelliJ IDEA
Open IntelliJ IDEA
Click Open
Select the project folder

Step 3: Configure MySQL Database
Make sure MySQL server is running.
Update database credentials inside your DBConnection.java file.
Example:
Java
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";

Step 4: Create Database Tables
Run all SQL queries provided above inside MySQL Workbench or any MySQL client.

Step 5: Run the Application
Run:
Java
Main.java

Step 6: Register & Login
Create a new account using the Register page
Login using your registered username and password

Project Structure
src
│
├── DAO
│   ├── StudentDAO.java
│   └── UserDAO.java
│
├── UI
│   ├── LoginFrame.java
│   ├── RegisterFrame.java
│   ├── DashboardFrame.java
│   ├── AddStudentFrame.java
│   └── ViewStudentFrame.java
│
├── util
│   ├── DBConnection.java
│   └── Main.java

📋 Functionalities
🔐 Authentication Module
User Registration
User Login Validation

👨‍🎓 Student Management Module
Add Student Details
View All Students
Update Existing Student
Delete Student Record

🔍 Search Module
Search students using keywords

📁 Export Module
Export student records into CSV format

⭐ Future Improvements
Export to Excel
PDF Report Generation
Attendance Management
Student Result Analytics
Improved UI Design
Role-Based Authentication

👩‍💻 Author
Samruddhi Gurav

📄 License
This project is created for learning and educational purposes.
