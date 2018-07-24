# GameoForum-API
Backend API of a simple RESTful forum application. Implemented using Java EE.

See Frontend implementation companion project:
https://github.com/martinsuas/GameoForum

# Required:
Maven

A MySQL server where you can create a database:

- Run all the *.sql scripts at **src/main/sql** to
populate the database with development data.

- Set up the following properties accordingly in the **pom.xml**:
    - **<mysql-app-database>** the database in the server that hosts
    your tables.

    - **<mysql-connection-url>** the connection url to communicate with
    your database.

    - **<mysql-user-name>**

    - **<mysql-password>**


# To run:
Run the following commands (bolded) at the root directory of the application:
1. **mvn wildfly:start** Initializes a local wildlfly instance.
2. **mvn install** Compiles, packages, and adds the datasources to your 
mysql database accordingly.
3. **mvn wildfly:deploy** Deploys your web application to wildfly.
 
#### To shutdown:
1. **mvn wildfly:shutdown** Shutdown local server.


# API URIs
Check **src/main/java/com/mss/ejb/rest** to check the available URIs to interact
with the API. For example, to get all the messages of a thread with a unique ID 4:
> http://localhost:8080/gameoForum/webapi/messages/thread:4