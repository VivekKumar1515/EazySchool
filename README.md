# EazyByteSchool

EazyByteSchool is a Spring Boot application designed to demonstrate various Spring Boot features, including web, security, data, and administration.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or later
- Maven 3.6.3 or later
- MySQL database

## Installation

1. **Clone the repository**

    ```bash
    git clone https://github.com/your-repo/EazyByteSchool.git
    cd EazyByteSchool
    ```

2. **Configure the database**

    Ensure you have a MySQL database running. Update the `src/main/resources/application.properties` file with your database configuration:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build the project**

    Use Maven to build the project:

    ```bash
    mvn clean install
    ```

4. **Run the application**

    After building the project, you can run the application using:

    ```bash
    mvn spring-boot:run
    ```

    Alternatively, you can run the JAR file generated in the `target` directory:

    ```bash
    java -jar target/EazyByteSchool-0.0.1-SNAPSHOT.jar
    ```

## Features

- **Spring Boot Admin**: Monitors and manages your Spring Boot application.
- **Spring Boot Actuator**: Provides endpoints for monitoring and managing your application.
- **Spring Data JPA**: Simplifies database interactions.
- **Spring Security**: Adds security features to your application.
- **Thymeleaf**: Template engine for rendering HTML.
- **RESTful APIs**: Create RESTful services using Spring Data REST and HAL Explorer.
- **Lombok**: Reduces boilerplate code with annotations.

## Dependencies

The project uses the following dependencies:

- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-test`
- `spring-boot-starter-web`
- `spring-boot-devtools`
- `lombok`
- `spring-boot-starter-validation`
- `spring-boot-starter-security`
- `spring-security-test`
- `thymeleaf-extras-springsecurity6`
- `spring-boot-starter-data-jpa`
- `mysql-connector-j`
- `jackson-dataformat-xml`
- `spring-boot-starter-data-rest`
- `spring-data-rest-hal-explorer`
- `spring-boot-starter-actuator`
- `spring-boot-admin-starter-client`
- `hibernate-micrometer`

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Developers

- [Your Name](https://github.com/your-github-username)

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any bugs or improvements.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Hibernate](https://hibernate.org/)
- [Lombok](https://projectlombok.org/)
