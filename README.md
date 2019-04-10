# Library_API



Pre-requisites : 

    Java 7+
    Maven 3
    PostgresSQL 10


In order to Run the Project you need to do the next steps :

1-Create a Database in PostgresSQL called **library**

2-After the database is created please check which is the **PORT** , **USERNAME** and **PASSWORD** where the DB is running. In case that the PORT is **different** of **5432** or USERNAME is different of **postgres**  or PASSWORD is different of **root**. You will need to do the next steps :

* Go to the **application.properties** file
inside the project library_api

    path :  **/library_api/src/main/resources**

    * Update property **spring.datasource.url** with  the right PORT

      example: jdbc:postgresql://localhost:[PORT]/library

    * Update the **spring.datasource.username** with the     right username
    
    * Update the **spring.datasource.password** with the right password.

3- For run the application you can do it in different ways:

* **mvn spring-boot:run** : This command will lunch the application that will be running in **localhost** on PORT:8080

    The command above have to be ran in a Terminal inside the root folder **library_api**

* **mvn clean install -DskipTests** :This command will compile the code and skip any unit testing,  and will generate a **target** folder inside the root project. In the target folder will be a file called **library.api.jar**

    Open an terminal and go to the target folder and run this command : **java -jar library.api.jar**

In order to check if the local server is running , you can hit one of the next endpoints:

    localhost:8080/serverDetail/ping       GET Method

                OR

    localhost:8080/serverDetail/serverInfo  GET Method


**The endpoints related to Book API are :**

* localhost:8080/book          GET Method
* localhost:8080/book/**2**    GET Method

    * The last part of the URL is the **ID of the book**.
* localhost:8080/book/**3**/page/**1**/**text**     GET Method

    * The structure of the  url is  localhost:8080/book/**{bookID}**/page/**{pageNumber}**/**{format}** 

    The possible formats  are : **text** or **html**

    **ex:**  localhost:8080/book/**3**/page/**1**/**html**




## How database will be loaded with Data

Once you run the project the tables (**book , book_page**) will be created under the **library** database.

After the tables are created : 
    
    3 records will be inserted in the book table
    10 records will be inserted in the book_page table

* First book record will have 5 entries related in the book_page table

* Second book record will have 3 entries related in the book_page table.

* Third book record will have 2 entries related in the book_page table.

The sql files that create tables and insert the data are inside the root project in the path :  **/library_api/src/main/resources**
    
    schema.sql (tables creation)
    data.sql (tables inserts) 



## How to run Unit Testing

There are Unit testing for all the Restful Services related to the book.

if you want to run the test, use this command

 **mvn test** 

 if you don't want to run the test , you need to skip it using this command :

 mvn clean install **-DskipTests**