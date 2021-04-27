# Demo:

https://mk-sas4ta.appspot.com/api/v1/bookmarks

## Methods

### List of bookmarks
```
curl --location --request GET 'https://mk-sas4ta.appspot.com/api/v1/bookmarks'
```

### Add new bookmark
```
curl --location --request POST 'https://mk-sas4ta.appspot.com/api/v1/bookmarks' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookName": "Alice Schertle: Little Blue Truck",
    "pageNumber": 15
}'
```

# Tools and Technologies

- Java
- Maven
- Google Cloud: App Engine, Datastore

# Useful information

- Storing/Loading entities in Datastore: https://happycoding.io/tutorials/google-cloud/datastore
- Spring - Building a RESTful Web Service: https://spring.io/guides/gs/rest-service/
- Spring - Building REST services with Spring: https://spring.io/guides/tutorials/rest/

- https://www.baeldung.com/constructor-injection-in-spring

testing rest controller:
https://spring.io/guides/gs/testing-web/

testing datastore:
https://www.programcreek.com/java-api-examples/?api=com.google.cloud.datastore.testing.LocalDatastoreHelper
https://cloud.google.com/appengine/docs/standard/java/tools/localunittesting#high-replication-datastore
https://spring.io/blog/2011/06/21/spring-3-1-m2-testing-with-configuration-classes-and-profiles