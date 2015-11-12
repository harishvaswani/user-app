# user-app
Repository for the UserApp app

Description:
This is a sample app to add and show users using a RESTful web service

Tools and frameworks used:
Jersey, Spring, Gson, JUnit, Gradle and Tomcat 7.x

Quick start:

1. Clone the repo https://github.com/harishvaswani/user-app.git
2. Go to ~/user-app/UserApp and build the WAR file: gradle war
3. Copy the sample.war file from ~/user-app/UserApp/build/dist into the tomcat webapps directory and start tomcat. 
4. Test "Show Users" by calling GET http://localhost:8080/sample/user/show (can test in a browser).
5. Test "Add User" by calling  POST http://localhost:8080/sample/user/add?username={username} (need to use a REST client).
6. Call "Show Users" API again to see the newly added user in the response. 

Application Architecture:

1. The application architecture is 3-tiered with the REST (Jersey) layer, the Service layer and the DAO layer.
2. The REST layer returns a JSON response for success or failure that consists of status, message and the payload.
3. Validations have been added to ensure the username query parameter is mandatory for the /add API and that it does not allow invalid and duplicate usernames. 
4. A ServiceException class is added as a generic exception class that can be used by the service layer to customize exceptions. Currently, it just produces error messages for invalid/duplicate usernames.
5. Unit tests are added for the implementation classes for the service and DAO layers and some REST helper classes. 
Building the project:

1. Gradle is the build tool and the dependencies are specified in the build.gradle file. It contains the java and war tasks to compile, run tests and build the WAR file. It also has a task to copy the dependencies to the build/lib directory (convenience for local development).
2. The WAR file can be built by issuing the command 'gradle war' which copies the war file (sample.war) to the build/dist directory.
3. The WAR has been tested under an installation of Tomcat 7.0.75.

Further improvements:

1. Currently, the /add API requires a username query parameter and then calls a POST to add that username resource. This could be improved to take the username as a JSON input in the request rather than a query parameter.
2. Not much was changed in the UserCache logic as originally provided. This could be further enhanced to read and write to an external datasource, if needed.
