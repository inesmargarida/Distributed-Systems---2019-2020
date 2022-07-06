# Supplier client

This is the Supplier client.    
The client depends on the contract module, where the protocol buffers shared between server and client are defined.  
The client needs to know the interface to make remote calls.


## Instructions for using Maven

Make sure that you installed the contract module first.

To compile and run the client:

```
mvn compile exec:java
```

To compile and run the client with debug messages:

```
mvn compile exec:java -Ddebug
```


## To configure the Maven project in Eclipse

'File', 'Import...', 'Maven'-'Existing Maven Projects'

'Select root directory' and 'Browse' to the project base folder.

Check that the desired POM is selected and 'Finish'.


----

[SD Faculty](mailto:leic-sod@disciplinas.tecnico.ulisboa.pt)
