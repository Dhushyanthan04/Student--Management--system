# 🎓 Student Management System – Setup & Structure

## 📁 Project Structure

Student-Management-System/  
├── pom.xml  
├── src/  
│   └── main/  
│       ├── java/com/example/student/  
│       │   ├── controller/  
│       │   ├── service/  
│       │   ├── repository/  
│       │   ├── model/  
│       │   └── exception/  
│       └── resources/  
│           └── application.properties  
└── README.md  

---

## ⚡ How to Run the Project

1. Clone the repository
2. Open in IntelliJ / Eclipse  
3. Configure MySQL in  
   application.properties  
4. Run StudentApplication.java  
5. Test APIs using Postman  

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| POST | /students | Add new student |
| GET | /students/{id} | Get student by ID |
| DELETE | /students/{id} | Delete student |

---

## ⚠ Exception Handling

- StudentNotFoundException for invalid student ID  
- GlobalExceptionHandler handles errors globally  
- Returns proper HTTP status codes  

---

## 🎯 Why This Project?

This project demonstrates:

- Spring Boot REST API development  
- Layered architecture (Controller → Service → Repository)  
- JPA & MySQL integration  
- Custom exception handling  
- Clean backend design  

This project showcases practical Java backend development skills 
and is suitable for freshers aiming to crack Java Backend Developer roles 
in top IT companies.
