
# EazySchool

- Official Website of the EazySchool, New York
- Lets Student view and update their Profiles as well as View their enrolled courses.
- Lets general public send their queries to School Administration.
- Allows Admin to manage Classes (and Students enrolled in them), Courses (and Students enrolled in them) and the Queries Received from General Public.


## Features

- Authentication and Authorization
- Role-Based Access
- Pagination and Custom Sorting
- Rest Services
- Logging to file
- Used Spring Profiles
- Data Validation
- Model View Controller Architecture


## Tech Stack

- Thymeleaf
- Spring Framework
- Spring Boot
- Spring Security
- Spring Data Validation
- Lombok
- Spring Data JPA


## Installation


```bash
# 1. Bring the Project to your Local Machine
git clone https://github.com/VivekKumar1515/EazySchool.git

# 2. Navigate to the Maven project directory
cd /path/to/your/maven/project

# 3. Make a docker container of MySql
docker run -p 3306:3306 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=eazyschool -e MYSQL_ROOT_PASSWORD=root --name EazySchool mysql:latest

# 4. Execute the schema.sql and data.sql files present inside the resources folder

# 5. Clean and download dependencies
mvn clean install

# 6. Run the Spring Boot application
mvn spring-boot:run
```
    
## API Reference

#### Register

```
  POST public/createUser
```


#### Get all Holidays

```
  GET /holidays/{display}
```

### Login

```
  GET POST /Login
``` 

### Update Profile

```
  POST /updateProfile
```

### Close Message

```
  GET /closeMsg
```

### display ith message

```
  GET /displayMessages/page/{page}
```

### Send Message

```
  POST /saveMsg
```

### Add New Class

```
  POST /admin/addNewClass
```

### Add New Course

```
  POST /admin/addNewCourse
```

### Add Students To Course

```
  POST /admin/addStudentToCourse
```



## Screenshots

- Home Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/HomePage.jpeg?raw=true)

- Courses Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/CoursesPage.jpeg?raw=true)

- Contact Us Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/ContactUsPage.jpeg?raw=true)

- Login Page

    ```
    Admin Credentials:
        Username: admin 
        Password: MightyAdmin
    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/LoginPage.jpeg?raw=true)

- Registeration Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/RegisterPage.jpeg?raw=true)

- Admin Dashboard Page
    ```
    Admins can : 
    - Edit their Profile
    - Read messages or queries sent through Contact Us Page and Close their queries.
    - View, Add and Delete Classes.
    - View, Add and Delete Students from the Classes.
    - View, Add Courses
    - View, Add and Delete Students from the Courses.

    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminDashboardPage.jpeg?raw=true)

- Admin & Student Profile Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminStudentProfilePage.jpeg?raw=true)

- Admin Message Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminMessagePage.jpeg?raw=true)

- Admin Classes Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminClassesPage.jpeg?raw=true)

- Admin Add Students To Class Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminAddStudentsToClassPage.jpeg?raw=true)

- Admin Courses Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminCoursesPage.jpeg?raw=true)

- Admin Add Students To Courses Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminAddStudentsToCoursesPage.jpeg?raw=true)


- Student Dashboard Page

    ```
    Students can :
    - Edit and Update their Profile
    - View Courses they're enrolled in.

    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/StudentDashboardPage.jpeg?raw=true)

- Contact Us Page

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/StudentViewCoursesPage.jpeg?raw=true)







## 🌟 Author

### Vivek Kumar

📧 Feel free to reach out to me through [Email](mailto:vivekvasu1515@gmail.com) for any inquiries, feedback, or collaboration opportunities related to the EazySchool or other similiar projects. Your input is very valuable to me! 🚀


