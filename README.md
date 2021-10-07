# QA Tech Bootcamp - Software Development Cohort DFESW1  
## Practical Project

Welcome to my project. Please click on each section below to learn more about it.

<details>
 
---

<summary align="center">Objective</summary>

The purpose of this project is to show understanding and implementation of software development concepts learnt during this course. These concepts include:

* Agile & Project Management (Git, Jira)
* Source Code Management (GitHub)
* Databases & Cloud Fundamentals (H2, MySQL)
* Programming Fundamentals (Java)
* API Development (Spring Boot)
* Automated Testing (JUnit, Mockito)

This also included the additional use of Eclipse, Postman, MySQL Workbench and Maven.
 
To accomplish this objective, the "QAProject" Spring Boot API was created which serves to allow CRUD (Create, Read, Update and Delete) functionality through HTTP requests from a tool like Postman. The application allows data to be tested with speed in an H2 console or persisted within a MySQL database in a live environment. Either a MySQL command line client or MySQL Workbench can be used to access the persisted database.

The intended use of the application is to create and use records of dogs entering a kennel, shelter or rescue centre - to enable the staff to keep track of their canine occupant best friends.

The Dog class becomes an entity in the database with the following basic self-explanitory variables becoming attributes of each dog in the database:

* id - a Long datatype automatically assigned in the database to ensure each record is unique and help identify them quickly
* name - a String
* breed - a String
* age - an integer
* weight - a double datatype due to the need to use decimal places

---

</details>

<details>

---

<summary align="center">Expectations for the project</summary>
  
Going into the project I felt that I had a fairly good - if basic - grasp of the general concepts that needed to be used but I wasn't as confident about being able to recall syntax for everything right away.

I knew that I'd need to refer to work where I had practiced the concepts before to get syntax right and would likely need to research help online when facing new bugs - particularly in the testing part of the project which I had the least experience in. But I also knew I could rely on Eclipse as a great IDE to prompt me about syntax and also help with debugging.

I prepared my previous work and already knew some resources to use online - such as Stack Overflow - so I was still fairly confident I could complete the task.

My original goal for the project had been to keep the general idea of the application very simple so that I could focus on getting the functionality right - considering this was the first time I was creating my own application like this - and also have time to move onto stretch goals where I could then add some complexity to the application.

---

</details>

<details>

---

<summary align="center">Successes</summary>
The main application seemed to come together quite well and implementing the CRUD functionality went smoothly. It was a great feeling to create my first fully functional application tied to a database. I also enjoyed the feeling of accomplishment overcoming challenges during development and learning new things along the way - such as what a .md file is and how to edit them in fun ways, similar to HTML files!

---

</details>

<details>

---

<summary align="center">Opportunities to learn</summary>

Time management was the single biggest challenge during this project, particularly because I had some external distractions due to illness. A significant amount of time was also spent trying to get the Github network graph to look like a "textbook" example should. This is evidenced in some of my earlier commits in this Github repository where the work done was either insignificant or manufactured to be able to add a commit on purpose and try to force Github to diversify the branches I was using (main/dev/feature). Further research revealed that Github is not always 100% accurate when creating network graphs and with this being a small project it wasn't an ideal scenario to worry about details like that. So there was a learning opportunity to remain focused on more important tasks rather than getting caught up in particular details. Although, this didn't have a negative impact on delivering the project on time as I continually re-evaluated my plan and remaining schedule each day to ensure I would reach my goals.

I came to realise the importance of clarifying any ambiguous details in the original brief early on. For example, quantifying subjective terminology to help with the project aims and planning. Or also clarifying that despite the project listing some possible stretch goals there was no grading incentive to complete them - whereas there was the possibility of _losing_ points by underachieving in delivering the Minimum Viable Product ("MVP"). This shifted my focus from attempting to achieve stretch goals to instead ensuring that every aspect of the MVP was as good as I could possibly make it in the time given. I've learnt to clarify details such as these right away in future.

I also learnt some niché technical details through trial and error or finding appropriate help to fix problems such as needing to set _Coverage Configurations_ appropriately when running JUnit tests, or how using H2 rather than MySQL for database implementation means that the double datatype needs to be declared slightly differently in a schema.

---

</details>

<details>

---

<summary align="center">Future plans for improvement</summary>

Stretch goals could improve the functionality or confidence in the application by adding more advanced development features such as DTOs, custom database queries and custom exceptions, or improving the test coverage and including an Entity Relationship Diagram. In addition, the original scope envisioned for this application could include the following improvements or additions:

* further revision and refactoring of existing code for best practice standards such as SOLID Principles
* adding more variables/attributes to the Dog entity which might be useful for the staff users, such as dateEnteredShelter
* adding a new entity to the database to record details of any individuals who adopt dogs from the shelter, recording details such as their name, address, phone number, email address, date first contacted, date adopted
 * adding interaction between the Dog and Adopter entities such as using foreign keys and a new Adoption entity to store details for each adoption event, holding details which would be related to both the Dog and Adopter
  * the above would require adapting the current application to be able to carry out CRUD functionality on different classes/entities with ease
* adding a frontend to the application to make using it even easier
 * after adding a frontend, or even beforehand, User Experience research could be carried out to optimise the app for its intended users and improve usability

---

</details>

<details>

---
 
<summary align="center">Screenshots - Postman</summary>

---

</details>

<details>

---
 
<summary align="center">Screenshots - Persisted data</summary>

---

</details>

<details>

---

<summary align="center">Screenshots - Tests and coverage reports</summary>

---

</details>

[Link to Jira project management Scrum board](https://kalford.atlassian.net/jira/software/projects/QP/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiZTk4MDhlMmI1ZGYyNDM1YjhkZDNkOTUxNTUyZTg4NGMiLCJwIjoiaiJ9)

A [documentation](https://github.com/dummy4program/QAProject/tree/dev/documentation) folder has also been added to this repo containing a [risk assessment](https://github.com/dummy4program/QAProject/blob/dev/documentation/RiskAssessment.pdf) carried out for the project, which has also been plotted in a risk matrix.
