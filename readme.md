# 🧑‍💻 Users JDBC Project

A simple Java application that manages user data using JDBC (Java Database Connectivity). It demonstrates how to perform CRUD operations (Create, Read, Update, Delete) on a relational database using raw SQL and the JDBC API.

---

## 📦 Features

- Add new users to the database
- Retrieve user details by ID
- Retrieve user details by Username
- Update user information dynamically (null-safe)
- Delete users
- Exception handling and resource management
- Modular DAO architecture

---

## 🛠️ Technologies Used

- Java 17+
- JDBC API
- MySQL (or any other RDBMS)
- IntelliJ IDEA

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/users-jdbc-project.git
cd users-jdbc-project
```

## Configure the Database 

Create a *users* table in your database:
```
CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100),
email VARCHAR(100),
password VARCHAR(100)
);
```

Update your DB credentials in *db.properties*:

```
user=root
password=root
dburl=jdbc:mysql://localhost:3306/usersjdbc
useSSL=false
allowPublicKeyRetrieval=true
```

# 📂 Project Structure

```
UsersJDBC/
├── .idea/                      # IntelliJ IDEA project settings
├── out/                        # Compiled output files
├── resources/
│   └── db.properties           # Database configuration file
├── src/
│   ├── application/
│   │   └── db/
│   │       ├── DBConfig.java      # Handles DB connection
│   │       └── DBException.java   # Custom exception for DB errors
│   ├── model/
│   │   ├── dao/
│   │   │   ├── UserDao.java           # Interface for user operations
│   │   │   ├── DaoFactory.java        # Factory for DAO instances
│   │   │   └── impl/
│   │   │       └── UserDaoImplement.java  # JDBC implementation
│   │   └── entities/
│   │       └── User.java              # User entity class
│   └── Main.java                       # Entry point for testing
├── .gitignore                        # Git ignore rules
├── README.md                         # Project documentation
├── UsersJDBC.iml                     # IntelliJ module file
├── External Libraries/               # IDE-managed dependencies
└── Scratches and Consoles/           # IDE scratch files and console outputs
```

# Sample Usage

```
public class Main {
    public static void main(String[] args) {

        UserDao userDao = DaoFactory.createUserDao();

        System.out.println(userDao.findAll());

        System.out.println(userDao.findById(5));
        System.out.println(userDao.findByUsername("João Pereira"));

        userDao.insert(new User(null, "luix", "luix.felipe1@email.com", "adminadmin", new Date()));
        
        //null safe
        userDao.update(5, "marilove", "mari.love@email.com", null);

        userDao.deleteById(6);

    }
}
```

## 🧭 Next Steps

Now that your JDBC-based user management system is up and running, here are some ideas to take it further:

### 🔐 1. Add Password Security
- Hash passwords using libraries like **BCrypt** or **Argon2** before storing them.
- Avoid storing plain-text passwords to improve security.

### 🧪 2. Implement Unit and Integration Tests
- Use **JUnit** and **Mockito** to test DAO methods.
- Create a test database or use an in-memory DB like **H2** for isolated testing.

### 🌐 3. Build a RESTful API
- Wrap your JDBC logic in a **Java web framework** like **Spring Boot**.
- Expose endpoints for user operations (`GET`, `POST`, `PUT`, `DELETE`).

### 🧑‍🎓 4. Create a CLI or GUI
- Build a **command-line interface** or a **JavaFX/Swing GUI** for user interaction.
- Makes the app more accessible and user-friendly.