# Portail DTI

A **Spring Boot** application designed to manage the Department of Information Technology's portal

---

## Project Structure
```
PortailDepartementInformatique/
└── src/
    └── main/
        ├── java/com/portaildti/portaildti/
        │   ├── config/
        │   ├── controller/
        │   ├── entities/
        │   ├── repos/
        │   ├── rest/
        │   ├── service/
        │   │   └── exception/
        │   └── websocket/
        └── resources/
            ├── static/
            │   ├── css/
            │   ├── documents/utilisateur/
            │   ├── files/
            │   ├── images/utilisateur/
            │   ├── js/
            │   └── videos/utilisateur/
            ├── templates/
            │   └── fragments/
            └── application.properties
```
---

## Getting started

### Prerequisites

- **Java 17** or higher
- **Maven** installed
- **MySQL** running locally
- **IntelliJ IDEA** or another preferred IDE

### MySQL Configuration

If you need to make changes in the application properties, the `application.properties` file is located in `src/main/resources/`

### Database Initialization

To set up the initial database schema and data, execute the provided SQL script found in the project's root directory named `portaildti.sql`

---

## Authors and acknowledgment
Patrick Nguyen

Anayees Sarkes

Othmane Sedjari

## License
This project is licensed under the MIT License.
