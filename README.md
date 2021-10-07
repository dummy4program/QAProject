<p align="centre"> ### QA Tech Bootcamp - Software Development Cohort DFESW1
#### Practical Project</p>

<p align="left">Welcome to my project. The purpose of this project is to show understanding and implementation of concepts learnt during this course. These concepts include:

*Agile & Project Management (Git, Jira)
*Databases & Cloud Fundamentals (H2, MySQL)
*Programming Fundamentals (Java)
*API Development (Spring Boot)
*Automated Testing (JUnit, Mockito)

To accomplish this objective, the "QAProject" Spring Boot API was created which serves to allow CRUD (Create, Read, Update, Delete) functionality through HTTP requests from a tool like Postman. The application allows data to be tested with speed in an H2 console or persisted in a MySQL database in a live environment. Either a MySQL command line client or MySQL Workbench can be used to access the persisted database.

The intended usage for the application is to record, view and manipulate details in a database of dogs entering a kennel or shelter.

The Dog class becomes an entity in the database with the following basic variables becoming attributes in the database;

*id - a Long datatype automatically assigned in the database to ensure each entry is unique
*name - a String
*breed - a String
*age - an integer
*weight - a double datatype due to the need to use decimal places

<details>
<summary>#####"Expectations for the project"</summary>

Going into the project I felt that I had a fairly good - if basic - grasp of the general concepts that needed to be used but I didn't feel very confident about my ability to recall syntax quickly.

I knew that I'd need to refer to work where I had practiced the concepts before and would likely need to research help online when facing new bugs - particularly in the testing part of the project which I had the least experience in.

I prepared my previous work and already knew some resources to use online so I was still fairly confident I could complete the task.
</details>

<details>
<summary align="center">#####"What went well?"</summary>
The main application seemed to come together quite well and implementing the CRUD functionality went smoothly. I also enjoyed the challenges and feeling of accomplishment overcoming any errors or functionality problems in other areas during development.
</details>

<details>
<summary>#####"Opportunities to learn"</summary>
Time management was the single biggest challenge during this project, particularly because I had some external distractions due to illness. A significant amount of time was also spent trying to get the Github network graph to look like a "textbook" example should. This is evidence in some of my earlier commits in this Github repository where the work done was either insignificant or manufactured to be able to add a commit on purpose and try to force Github to diversify the branches I was using (main/dev/feature). Further research revealed that Github is not always accurate and with this being a small project it wasn't an ideal scenario to worry about details like that. So there was a learning opportunity to remain focused on more important tasks rather than getting caught up in particular details. Although this didn't have a negative impact on actually delivering the project on time as I continually re-evaluated my plan and remaining schedule each day to ensure I would reach my goals.

I came to realise the importance of clarifying any ambiguous details in the original brief early on. For example, quantifying subjective terminology to help with the project aims and also clarifying that despite the project listing some possible stretch goals - there was no scoring incentive to complete them, whereas there was the possibility of losing points by underachieving in the Minimum Viable Product ("MVP"). This shifting my focus from attempting to achieve stretch goals to instead ensuring that every aspect of the MVP was as good as I could possibly make it before the deadline. I've learnt to clarify details such as these right away in future.

I also learnt some niché technical details through trial and error or finding appropriate help to fix problems such as needing to set _Coverage Configurations_ appropriately when running JUnit tests, or how using H2 rather than MySQL for database implementation means that the double datatype needs to be declared slightly differently in a schema.
</details>

<details>
<summary>#####"Future plans for improvement"</summary>
Apart from completing the stretch goals set out for the project (adding more advanced development features such as DTOs and custom exceptions, or improving the test coverage and including an Entity Relationship Diagram), the original scope envisioned for this application could include the following improvements/additions:

*further revision and refactoring of existing code for best practice standards such as SOLID Principles
*adding more variables/attributes to the Dog entity such as dateEnteredShelter
*adding a new entity to the database to record details of any individuals who adopt dogs from the shelter, recording details such as their name, address, phone number, email address, date first contacted, date adopted
 *adding interaction between the Dog and Adopter entities such as common records for the date of adoption - perhaps through a new Adoption entity - and interaction between the entities using foreign keys to show which Adopter is related to which Dog
  *the above would require adapting the current application to be able to carry out CRUD functionality on different classes/entities with ease
*adding a front-end to the application to make using it even easier
 *with a front-end implemented, User Experience research could be carried out to optimise the app for users and improve usability
</details>

<details>
<summary>#####"Screenshots - Postman"</summary>
</details>

<details>
<summary>#####"Screenshots - Persisted data"</summary>
</details>

<details>
<summary>#####"Screenshots - Tests and coverage reports"</summary>
</details>

[Link to Jira board - collaborators have been added](https://kalford.atlassian.net/jira/software/projects/QP/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiZTk4MDhlMmI1ZGYyNDM1YjhkZDNkOTUxNTUyZTg4NGMiLCJwIjoiaiJ9)

A "documentation" folder has also been added to this repo, containing a risk assessment carried out for this project and plotted in a risk matrix.