# Bookmarks Storage

Application for storing bookmarks for paper books.

**Demo**: https://mk-sas4ta.appspot.com/api/v1/bookmarks

## API Methods

### Add new bookmark

```
curl --location --request POST 'https://mk-sas4ta.appspot.com/api/v1/bookmarks' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookName": "Alice Schertle: Little Blue Truck",
    "pageNumber": 15
}'
```

### Get list of bookmarks

```
curl --location --request GET 'https://mk-sas4ta.appspot.com/api/v1/bookmarks'
```

# Tools and Technologies

- Java
- Maven
- SonarQube
- Google Cloud: App Engine, Datastore, Cloud Build, Secret Manager

# Useful information

- Dependency injection in Spring:
    - https://www.baeldung.com/constructor-injection-in-spring

- Developing REST service with Spring:
    - https://spring.io/guides/gs/rest-service/
    - https://spring.io/guides/tutorials/rest/

- Storing/Loading entities in Datastore:
    - https://happycoding.io/tutorials/google-cloud/datastore
    
- Testing Spring REST Controller:
    - https://spring.io/guides/gs/testing-web/

- Testing with test configuration injection in Spring:
    - https://spring.io/blog/2011/06/21/spring-3-1-m2-testing-with-configuration-classes-and-profiles

- Unit Testing of Datastore:
    - https://www.programcreek.com/java-api-examples/?api=com.google.cloud.datastore.testing.LocalDatastoreHelper
    - https://cloud.google.com/appengine/docs/standard/java/tools/localunittesting#high-replication-datastore