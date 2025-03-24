# Portail DTI

A **Spring Boot** application designed to manage the Department of Information Technology's portal

---

## 🔧 Tech Stack

- **Spring Boot** (Java)
- **MySQL** (Database)
- **Maven** (Build tool)

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

Ensure your MySQL database is set up and the connection details are specified in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/portailinfodb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.servlet.multipart.max-file-size=30MB
spring.servlet.multipart.max-request-size=30MB
spring.mail.host=smtp.office365.com
spring.mail.port=587
spring.mail.username=email@example.com
spring.mail.password=mail_password
spring.mail.properties.mail.debug=true
spring.mail.properties.mail.transport.protocol=smtp
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
spring.mail.properties.mail.smtp.starttls.enable=true
server.port=9090
```

Replace your_password with your actual MySQL root password.
Replace email@example.com with an actual email address.
Replace mail_password with the password associated with the above email address.

### Database Initialization

To set up the initial database schema and data, execute the provided SQL script found in the project's root directory named portaildti.sql

---

## Authors and acknowledgment
Patrick Nguyen
Anayees Sarkes
Othmane Sedjari

## License
This project is licensed under the MIT License.
