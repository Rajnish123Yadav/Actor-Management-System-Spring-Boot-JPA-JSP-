# Actor Management System (Spring Boot + JPA + JSP)

## Project Description
The **Actor Management System** is a Spring Boot-based web application designed to manage actors' records efficiently. It provides **CRUD operations**, **pagination**, **search functionality**, and **soft deletion** support using JPA and Hibernate.

This system demonstrates the use of:
- **Spring MVC** for web layer
- **Spring Data JPA** for database interactions
- **JSP** for the frontend
- **Responsive UI** with dark mode and sticky footer
- **Optimistic locking** and timestamp tracking

---

## Technologies Used
- **Backend:** Java 17+, Spring Boot, Spring MVC, Spring Data JPA, Hibernate
- **Frontend:** JSP, HTML5, CSS3 (Responsive + Dark Mode)
- **Database:** MySQL / Oracle
- **Build Tool:** Maven

---

## Project Structure

ActorManagementSystem/
├── src/
│ ├── main/
│ │ ├── java/com/nt/
│ │ │ ├── controller/
│ │ │ │ └── ActorOperationsController.java
│ │ │ ├── entity/
│ │ │ │ └── ActorEntity.java
│ │ │ ├── repository/
│ │ │ │ └── IActorRepository.java
│ │ │ ├── service/
│ │ │ │ ├── IActorMgmtService.java
│ │ │ │ └── ActorMgmtServiceImpl.java
│ │ │ └── vo/
│ │ │ └── ActorVO.java
│ │ ├── resources/
│ │ │ ├── application.properties
│ │ │ └── static/ (CSS, JS, images)
│ │ └── webapp/
│ │ └── WEB-INF/views/
│ │ ├── home.jsp
│ │ ├── register_actor.jsp
│ │ ├── update_actor.jsp
│ │ └── show_report.jsp
├── pom.xml
└── README.md

pgsql
Copy code

---

## Features

1. **Home Page:** Landing page with navigation links.  
2. **Actor Registration:** Add new actor details (name, address, category, fee).  
3. **Actor Report:** View all actors in a paginated table with edit/delete options.  
4. **Edit Actor:** Update actor information with optimistic locking to prevent concurrent modifications.  
5. **Delete Actor:** Soft delete actors using `ACTIVE_SW` column to preserve historical data.  
6. **Search Actor:** Search actors by name with pagination support.  
7. **Responsive Design:** Optimized for desktop, tablet, and mobile.  
8. **Dark Mode:** Optional dark mode theme for better UI experience.

9. ## Setup Instructions

1. **Clone the Repository**
```bash
git clone https://github.com/<your-username>/actor-management-system.git
