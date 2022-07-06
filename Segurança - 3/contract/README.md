# gRPC contract

This small module contains the protocol buffers (protobuf) definition of the gRPC application.

The interface is shared by the server, that implements it, and
by the client, that needs it to make remote calls.


## Instructions for using Maven

To compile `protobuf` and generate Java classes:

```
mvn clean generate-sources
```

You can find the Java classes generated from the `protobuf` definition in the `target/generated-sources/protobuf/` folder.

To install the module and make it available as a dependency in the local repository:

```
mvn install
```


## To configure the Maven project in Eclipse

'File', 'Import...', 'Maven'-'Existing Maven Projects'

'Select root directory' and 'Browse' to the project base folder.

Check that the desired POM is selected and 'Finish'.


----

[SD Faculty](mailto:leic-sod@disciplinas.tecnico.ulisboa.pt)
