# Portail DTI

A **Spring Boot** application designed to manage the Department of Information Technology's portal

---

## 🔧 Tech Stack

- **Spring Boot** (Java)
- **MySQL** (Database)
- **Maven** (Build tool)

---

## Project Structure

PortailDepartementInformatique/ 
└── src/ 
  ├── main/ 
    ├── java/com/portaildti/portaildti/ 
    │ ├── config/
    │ ├── controller/ 
    │ ├── entities/ 
    │ ├── repos/
    │ ├── rest/
	│ ├── service/
	│ │ └── exception/
	│ └── websocket/
	└── resources/
      ├── static/
	  │ ├── css/
	  │ ├── documents/utilisateur/
	  │ ├── files/
	  │ ├── images/utilisateur/
	  │ ├── js/
	  │ ├── videos/utilisateur/
	  └── templates/
	  │ └── fragments/
      └── application.properties
	  
---

## Getting started

### Prerequisites

- **Java 17** or higher
- **Maven** installed
- **MySQL** running locally
- **IntelliJ IDEA** or another preferred IDE

### MySQL Configuration

Ensure your MySQL database is set up and the connection details are specified in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/portail_dti
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=9090```

Replace your_password with your actual MySQL root password.

### Database Initialization

To set up the initial database schema and data, execute the provided SQL script found in the project's root directory named portaildti.sql

## Authors and acknowledgment
Patrick Nguyen
Anayees Sarkes
Othmane Sedjari

## License
This project is licensed under the MIT License.
