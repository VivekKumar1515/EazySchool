## 🌟 EazySchool

- 🌐 Official Website of the EazySchool, New York
- 📚 Lets Students view and update their Profiles as well as view their enrolled courses.
- 📢 Allows the general public to send queries to the School Administration.
- 🔧 Enables Admin to manage Classes (and Students enrolled in them), Courses (and Students enrolled in them), and Queries received from the general public.

---

## 🔄 Features

- ⚡ Authentication and Authorization
- 🔐 Role-Based Access
- 🔭 Pagination and Custom Sorting
- 📡 REST Services
- 🔨 Logging to file
- 🔧 Spring Profiles
- ✅ Data Validation
- 🎨 Model-View-Controller Architecture

---

## 🤖 Tech Stack

- 💡 Thymeleaf
- 👨‍💻 Spring Framework
- 🌱 Spring Boot
- ⚠️ Spring Security
- 🔬 Spring Data Validation
- 🍂 Lombok
- 🔄 Spring Data JPA

---

## 🔧 Installation

```bash
# 1. Clone the Project Repository
git clone https://github.com/VivekKumar1515/EazySchool.git

# 2. Navigate to the Maven Project Directory
cd /path/to/your/maven/project

# 3. Create a Docker Container for MySQL
docker run -p 3306:3306 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=eazyschool -e MYSQL_ROOT_PASSWORD=root --name EazySchool mysql:latest

# 4. Execute the schema.sql and data.sql files inside the resources folder

# 5. Clean the project and download dependencies
mvn clean install

# 6. Run the Spring Boot application
mvn spring-boot:run
```

---

## 🔖 API Reference

#### ✉ Register
```
POST public/createUser
```

#### 🌎 Get all Holidays
```http
GET /holidays/{display}
```

#### 🔐 Login
```http
GET POST /login
```

#### ✏️ Update Profile
```http
POST /updateProfile
```

#### ❌ Close Message
```http
GET /closeMsg
```

#### 🗃️ Display ith Message
```http
GET /displayMessages/page/{page}
```

#### 🖊️ Send Message
```http
POST /saveMsg
```

#### 💵 Add New Class
```http
POST /admin/addNewClass
```

#### 🎓 Add New Course
```http
POST /admin/addNewCourse
```

#### 🌟 Add Students to Course
```http
POST /admin/addStudentToCourse
```

---

## 🜄 Screenshots

- 🌇 **Home Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/HomePage.jpeg?raw=true)

- 🎓 **Courses Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/CoursesPage.jpeg?raw=true)

- ✉ **Contact Us Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/ContactUsPage.jpeg?raw=true)

- 🔐 **Login Page**

    ```
    Admin Credentials:
        Username: admin
        Password: MightyAdmin
    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/LoginPage.jpeg?raw=true)

- 🔒 **Registration Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/RegisterPage.jpeg?raw=true)

- 🔧 **Admin Dashboard Page**
    ```
    Admins can:
    - Edit their Profile
    - Read messages or queries sent through Contact Us Page and close their queries.
    - View, Add, and Delete Classes.
    - View, Add, and Delete Students from the Classes.
    - View, Add Courses.
    - View, Add, and Delete Students from the Courses.
    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminDashboardPage.jpeg?raw=true)

- 📊 **Admin & Student Profile Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminStudentProfilePage.jpeg?raw=true)

- 📢 **Admin Message Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminMessagePage.jpeg?raw=true)

- 🏢 **Admin Classes Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminClassesPage.jpeg?raw=true)

- 🎨 **Admin Add Students to Class Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminAddStudentsToClassPage.jpeg?raw=true)

- 🎓 **Admin Courses Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminCoursesPage.jpeg?raw=true)

- 📚 **Admin Add Students to Courses Page**

  ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/AdminAddStudentsToCoursesPage.jpeg?raw=true)

- 🌆 **Student Dashboard Page**
    ```
    Students can:
    - Edit and Update their Profile
    - View Courses they are enrolled in.
    ```

    ![Github](https://github.com/VivekKumar1515/EazySchool/blob/master/Screenshots/StudentDashboardPage.jpeg?raw=true)

---

## 👨‍💼 Author

### Vivek Kumar

📧 Feel free to reach out to me through [Email](mailto:vivekvasu1515@gmail.com) for any inquiries, feedback, or collaboration opportunities related to EazySchool or similar projects. Your input is very valuable to me! 🚀

