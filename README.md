# GitHubEvents-REST-API-SpringBoot
<b>Create a REST API to provide info regarding GitHub Events using SpringBoot Framework</b>
In this challenge, you are part of a team building a git event tracking platform. One requirement is for a REST API service to provide events information using the Spring Boot framework. You will need to add functionality to add and delete information as well as to perform some queries. You'll be dealing with typical information for git event data like repository, actor, event type, etc. 

The definitions and a detailed requirements list follow:

Each event data is a JSON entry with the following keys:

{<br/>
id: This is the event unique ID.<br/>
type: This is the event type.<br/>
actor: The actor responsible for the event. The actor itself is a JSON entry consisting of following fields:<br/>
	 &nbsp;&nbsp;&nbsp;&nbsp; { id: This is the actor unique ID.<br/>
	 &nbsp;&nbsp;&nbsp;&nbsp;  login: This is the actor unique login ID.<br/>
	 &nbsp;&nbsp;&nbsp;&nbsp; avatar_url: This is the actor avatar URL.}<br/>
repo: The repository to which this event is associated with. The repo itself is a JSON entry consisting of following fields:<br/>
	  &nbsp;&nbsp;&nbsp;&nbsp; {id: This is the repo unique ID.<br/>
	  &nbsp;&nbsp;&nbsp;&nbsp; name: This is the repo name.<br/>
	  &nbsp;&nbsp;&nbsp;&nbsp; url: This is the repo URL.}<br/>
created_at: This is the timestamp for the event creation given in the format yyyy-MM-dd HH:mm:ss. The timezone is UTC +0.<br/>
}


<h2>API</h2><br/>
The REST service should implement the following functionalities:<br/>

1) Erasing all the events: The service should be able to erase all the events by the DELETE request at /erase. The HTTP response code should be 200.

2) Adding new events: The service should be able to add a new event by the POST request at /events. The event JSON is sent in the request body. If an event with the same id already exists then the HTTP response code should be 400, otherwise, the response code should be 201.

3) Returning all the events: The service should be able to return the JSON array of all the events by the GET request at /events. The HTTP response code should be 200. The JSON array should be sorted in ascending order by event ID.

4) Returning the event records filtered by the actor ID: The service should be able to return the JSON array of all the events which are performed by the actor ID by the GET request at /events/actors/{actorID}. If the requested actor does not exist then HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by event ID.

5) Returning the event records filtered by the Repo ID: The service should be able to return the JSON array of all the events which are performed by the repo ID by the GET request at /events/actors/{repoID}. If the requested rep does not exist then HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by event ID.

6) Returning the event records filtered by the Repo ID and actor ID: The service should be able to return the JSON array of all the events which are performed by the actor ID and ID repo ID by the GET request at /events/actors/{repoID}/actors/{actorId}. If the requested rep does not exist then HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by event ID.

You should complete the given incomplete project so that it passes all the test cases when running the provided JUnit tests. The project by default supports the use of H2 database, but you can make use of any database to store the events data by specifying the dependency in the pom.xml file.

/home/joy/apache-maven-3.5.4/bin/mvn clean spring-boot:run<br/>
/home/joy/apache-maven-3.5.4/bin/mvn clean install<br/>
/home/joy/apache-maven-3.5.4/bin/mvn clean test; cat target/customReports/result.txt<br/>

<b>Reference Links</b><br/>
https://www.concretepage.com/spring-boot/spring-boot-crudrepository-example#Interface

https://www.baeldung.com/spring-jpa-test-in-memory-database

https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration#controller

http://localhost:8000/h2-console
