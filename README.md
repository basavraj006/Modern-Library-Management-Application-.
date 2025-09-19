# 📚 Modern Library Management Application

Welcome to the Modern Library Management Application—an advanced, feature-rich digital library system designed for seamless management of books, users, and transactions. Built with the latest technologies: **Spring Boot**, **Java**, **PostgreSQL**, **Hibernate ORM**, **HTML**, **CSS**, and **JavaScript**. This solution is perfect for schools, colleges, and public libraries aiming for efficiency and a modern user experience.

---

## 🎯 Key Features

- **🔒 Authentication & Authorization**
  - Secure login and registration
  - Role-based access control (User/Admin)
  - Password encryption for enhanced security

- **📖 Book Management**
  - Add, edit, delete, and search books
  - Real-time tracking of book availability
  - Categorization and filtering by genre/author/year

- **👥 User Management**
  - Create and manage library members
  - Profile management for users
  - Admin controls for blocking/unblocking users

- **📚 Borrowing & Returns**
  - Simple book borrowing & return workflow
  - Notifications for overdue books
  - Borrowing history and transaction audit

- **📊 Dashboard & Analytics**
  - Comprehensive admin dashboard
  - Statistics on book popularity and user activity
  - Export data for reporting

- **🖥️ Modern Responsive UI**
  - Built with HTML, CSS, and JavaScript for a smooth user experience
  - Mobile-friendly design
  - Interactive tables, forms, and modals

- **🔗 Integration & Extensibility**
  - RESTful APIs for third-party integrations
  - Easily extendable codebase for new features

---

## 🛠️ Tech Stack

| Layer        | Technology                         |
| ------------ | --------------------------------- |
| Backend      | Spring Boot, Java                  |
| Database     | PostgreSQL                        |
| ORM          | Hibernate ORM                     |
| Frontend     | HTML, CSS, JavaScript             |
| Security     | Spring Security                   |
| Build Tool   | Maven                             |

---

## 🗂️ Project Structure

```plaintext
Modern-Library-Management-Application-.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── library
│   │   │           ├── config        # Security & app configurations
│   │   │           ├── controller    # REST controllers for API endpoints
│   │   │           ├── dto           # Data Transfer Objects
│   │   │           ├── exception     # Custom exception handlers
│   │   │           ├── model         # Entity classes (User, Book, Transaction)
│   │   │           ├── repository    # JPA repositories for DB access
│   │   │           ├── service       # Business logic/service classes
│   │   ├── resources
│   │   │   ├── application.properties # Database & app config
│   │   │   ├── static                # Static assets (CSS, JS, images)
│   │   │   └── templates             # HTML templates (Thymeleaf)
│   └── test
│       └── java                      # Unit and integration tests
├── pom.xml                           # Maven build file
├── README.md                         # Project documentation
```

---

## 🚦 Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL

### Installation Steps

1. **Clone the repository**
    ```bash
    git clone https://github.com/basavraj006/Modern-Library-Management-Application-.
    cd Modern-Library-Management-Application-.
    ```

2. **Configure PostgreSQL**
    - Create a database (e.g., `library_db`).
    - Update your DB credentials in `src/main/resources/application.properties`.

3. **Build & Run the Application**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Access the Application**
    - Main UI: `http://localhost:8080`
    - Admin Dashboard: `/admin` (login required)

---

## 📐 API Endpoints (Examples)

| Method | Endpoint          | Description            |
|--------|-------------------|------------------------|
| POST   | `/admin/login`    | User login             |
| POST   | `/admin/register` | User registration          |
| GET    | `/books/all`      | Get all books              |
| POST   | `/books/save`      | Add new book (admin)      |
| PUT    | `/books/update/{id}` | Update book info        |
| DELETE | `/books/delete/{id}` | Delete book (admin)     |
| PATCH  | `/borrow/{userId}/{bookId}`| Borrow a book     |
| PATCH  | `/return/{bookId}` | Return a book             |
| GET    | `/books/users/all` | Get list of users (admin) |

---

## 💡 Usage

- **Users**: Register, log in, search for books, borrow and return books, view borrowing history.
- **Admins**: Manage books and users, track transactions, view analytics and reports.

---

## 🧪 Testing

- Run unit and integration tests:
    ```bash
    mvn test
    ```

---

## 🤝 Contributing

Contributions are welcome!  
Fork the repo, create a pull request, and help us build the future of library management.

---

## 📄 License

MIT License. See [LICENSE](LICENSE) for more details.

---

## 🙋 Contact

Raise an issue or reach out to [@basavraj006](https://github.com/basavraj006) for questions or feedback.
