# 🧠 Quiz App (Monolithic → Microservices)

## 📌 Overview
This project is a **Quiz Application** built using **Spring Boot** with a focus on **real-world backend architecture**.

Instead of just building a CRUD app, this project follows a structured approach:
- Start with a **Monolithic Architecture**
- Gradually evolve into a **Microservices Architecture**

This helps in understanding **how systems scale in real industry scenarios**.

---

## 🎯 Objectives
- Build a production-ready backend for a Quiz Application  
- Apply clean code and layered architecture principles  
- Learn how to **decompose a monolith into microservices**  
- Understand real-world backend challenges and solutions  

---

## ⚙️ Tech Stack
- **Backend:** Spring Boot  
- **Database:** MongoDB  
- **Libraries:** Lombok  
- **Development Tools:** Spring Boot DevTools  
- **Build Tool:** Maven  

---

## 🧩 Architecture

### 🔹 Phase 1: Monolithic Architecture (Current)
All modules are part of a single application:
- User Management  
- Quiz Management  
- Quiz Attempt & Evaluation  

---

### 🔹 Phase 2: Microservices Architecture (Planned 🚀)
The application will be split into independent services:

- **User Service** → Handles authentication & user data  
- **Quiz Service** → Manages quiz creation & retrieval  
- **Result Service** → Handles scoring & results  

---

## 📦 Features (Monolithic Phase)
- User Signup & Login  
- Create and Manage Quizzes  
- Attempt Quizzes  
- Score Calculation  
- Input Validation  

---

## 🔄 Future Enhancements (Microservices)
Planned implementation of industry-level concepts:

- API Gateway (centralized routing)  
- Service Discovery (dynamic service communication)  
- Inter-service Communication (REST / async messaging)  
- Docker (containerization)  
- Fault Tolerance (resilience handling)  

---

## 🧪 Running the Project

### 1️⃣ Clone the repository
```bash
git clone https://github.com/jhanishant658/Quiz-App.git
```
### 2️⃣ Navigate to the project directory
```bash
cd Quiz-App
```
### 3️⃣ Configure MongoDB
#### Configure MongoDB  in application.properties
Update your MongoDB connection in:
```bash
src/main/resources/application.properties
```
Example :
```bash
spring.data.mongodb.uri=your_mongodb_connection_string
```
### 4️⃣ Run the application:
```bash
mvn spring-boot:run
```

## 📈 Learning Outcomes

### Through this project, you will gain:

- Strong backend fundamentals
- Clean architecture understanding
- Hands-on microservices transition
- Practical system design knowledge
## 🤝 Contributing

Contributions are welcome! Feel free to fork the repo and submit a PR.
## ⭐ Final Note

This project is part of my journey to becoming a skilled backend developer, focusing on building scalable and production-ready systems.
## 👨‍💻 Author
**Nishant**  
- GitHub: https://github.com/jhanishant658  
- LinkedIn: linkedin.com/in/nishant-jha-0b96a629b/
