# user-app
Repository for a sample app to show and add users through a RESTful service

Description:
This is a demo app to add and show users using a RESTful web service

Tools and frameworks used:
Jersey, Spring, Gson, JUnit, Gradle and Tomcat 7.x

Release notes:

1. The architecture is 3-tiered with the REST (Jersey) layer, the Service layer and the DAO layer.
2. Show users can be tested by calling GET http://localhost:8080/sample/user/show (can test in a browser too).
3. Add user can be tested by calling  POST http://localhost:8080/sample/user/add?username={username} (need to use a REST client).
4. Additional validation was added to make username query paramater mandatory and to reject a duplicate username, if already added. 
5. A ServiceException class was added as a generic exception class that can be used by the service layer to customize exceptions. Currently, it just produces error messages for invalid/duplicate usernames. 
6. Unit tests were added to the implementation classes of the service, DAO layers and some REST helper classes. 
7. Gradle was chosen as the build tool and the dependencies are specified in the build.gradle file. It contains the java and war plugins to compile, run tests and build the WAR file. It also has a method to copy the dependencies to the build/lib directory (for convenience).
8. The WAR file can be built by issuing the command 'gradle war' which copies the war file (sample.war) to the build/dist directory.
9. The WAR was tested under an installation of Tomcat 7.0.75.

Further improvements:
1. Currently, the /add API requires a username query parameter and then calls a POST to add that username resource. This could be improved to take the username as a JSON input in the request rather than a query parameter.
2. Not much was changed in the UserCache logic as originally provided. This could be further enhanced to read and write to an external datasource. 






