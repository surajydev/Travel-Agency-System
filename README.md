

# 🌍 Travel Agency Management System
  Name - Suraj Yadav
  Registration Number - 12326764

A comprehensive **Travel Agency Management System** built using **Spring Boot**, designed to efficiently manage customers, bookings, tour packages, destinations, and travel itineraries through RESTful APIs.

---

## 🚀 Features

* **Customer Management**
  Create, update, retrieve, and delete customer records.

* **Booking Management**
  Handle travel bookings and reservations with relational data support.

* **Tour Package Management**
  Manage tour packages with pricing and destination mapping.

* **Destination Management**
  Maintain structured information about travel destinations.

* **Itinerary Management**
  Plan, assign, and track itineraries linked to bookings.

---

## 🛠️ Technology Stack

* **Java 25**
* **Spring Boot 4.0.1**
* **Spring Web** – RESTful API development
* **Spring Data JPA** – ORM & database abstraction
* **Spring Validation** – Request and input validation
* **H2 Database** – In-memory database for development/testing
* **MySQL Connector** – Production-ready database support
* **Lombok** – Reduces boilerplate code

---

## ⚙️ Application Configuration

The project runs using a **`dev` profile** with an embedded H2 database for quick setup.

| Configuration | Value                  |
| ------------- | ---------------------- |
| Server Port   | `8080`                 |
| H2 Console    | `/h2-console`          |
| Database URL  | `jdbc:h2:mem:traveldb` |
| Username      | `sa`                   |
| Password      | *(empty)*              |

---

## 🏃 Getting Started

### ✅ Prerequisites

* JDK **25** or higher
* Maven (or Maven Wrapper)

---

### 📥 Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/surajydev/Travel-Agency-System.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Travel-Agency-System
   ```

3. Build the project:

   ```bash
   ./mvnw clean install
   ```

---

### ▶️ Running the Application

Using Maven:

```bash
./mvnw spring-boot:run
```

Or run the generated JAR:

```bash
java -jar target/travel-agency-system-0.0.1-SNAPSHOT.jar
```

---

## 📚 REST API Endpoints

Base URL: **`http://localhost:8080`**

| Resource      | Endpoint             |
| ------------- | -------------------- |
| Customers     | `/api/customers`     |
| Bookings      | `/api/bookings`      |
| Tour Packages | `/api/tour-packages` |
| Destinations  | `/api/destinations`  |
| Itineraries   | `/api/itineraries`   |

> 📌 *Refer to individual controller classes for detailed request mappings.*

---

## 🧩 Project Highlights (For Recruiters)

* Clean **layered architecture** (Controller → Service → Repository)
* Proper **entity relationships** using JPA
* RESTful design following industry conventions
* Easily switchable **H2 ↔ MySQL** configuration
* Scalable and production-ready foundation

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Submit a pull request

