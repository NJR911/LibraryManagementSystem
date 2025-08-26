# Library Management System

A Java console application to manage books in a library with full CRUD functionality.

## Features

- Add, view, update, and delete books.
- Search for a book by ID.
- Input validation to ensure proper data.
- Secure database operations using PreparedStatement to prevent SQL injection.

## Technologies Used

- **Java** – Core programming language for the console app.  
- **MySQL** – Relational database to store book data.  
- **JDBC** – Java Database Connectivity for interacting with MySQL.  

## Project Structure
libraryManagement/
├─ src/
│ └─ libraryManagement/
│ ├─ Main.java ← Entry point
│ ├─ DBConnection.java ← Handles DB connection
│ ├─ DBSetup.java ← Creates DB and tables
│ ├─ Book.java ← Book model
│ └─ BookCRUD.java ← CRUD operations
└─ src/config.properties ← Database configuration (ignored in git)

Usage
- Add new books by providing title, author, and year. 
- View all books in the library.
- Search for a book by its ID.
- Update or delete books from the database.
