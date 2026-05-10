# 🎓 Student Management System
A desktop-based Student Management System developed using Java Swing and MySQL.

This application allows users to manage student records efficiently with features like authentication, student management, search, marks management, and CSV export functionality.

# ✨ Features

- 🔐 User Registration & Login
- ➕ Add Student
- 👀 View Students
- ✏️ Update Student Details
- ❌ Delete Student
- 🔎 Search Student
- 📊 Manage Student Marks
- 📁 Export Student Data to CSV


# 🛠 Technologies Used

| Technology | Purpose |
|------------|----------|
| Java | Core Programming Language |
| Swing | GUI Development |
| MySQL | Database |
| JDBC | Database Connectivity |
| IntelliJ IDEA | IDE |

# 🗄 Database Configuration
## Create Database

```sql
CREATE DATABASE student_db;
USE student_db;

User Table
CREATE TABLE users(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100)
);

Student Table
CREATE TABLE students(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    marks FLOAT
);

▶️ How to Run the Project
Step 1: Clone or Download the Project
Download the ZIP or clone using Git.

Step 2: Open Project in IntelliJ IDEA
Open IntelliJ IDEA
Click Open
Select project folder

Step 3: Configure MySQL Database
Update database credentials inside DBConnection.java
Example:
String url = "jdbc:mysql://localhost:3306/student_db";
String user = "root";
String password = "your_password";

Step 4: Create Database Tables
Run all SQL queries in MySQL Workbench.

Step 5: Run the Application
Run:
Java
Main.java

Step 6: Register & Login
Create account using Register page and login.

📂 Project Structure
src
├── DAO
│   ├── StudentDAO.java
│   └── UserDAO.java
├── UI
│   ├── LoginFrame.java
│   ├── RegisterFrame.java
│   ├── DashboardFrame.java
│   ├── AddStudentFrame.java
│   └── ViewStudentFrame.java
├── util
│   └── DBConnection.java
└── Main.java

🚀 Future Improvements
Export to Excel/PDF
Attendance Management
Result Analytics
Improved UI Design
Role-Based Authentication

👩‍💻 Author
Samruddhi Gurav

📄 License
This project is created for learning and educational purposes.
