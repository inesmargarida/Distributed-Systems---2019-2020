# gRPC TTT - server

This is a gRPC implementation of Tic Tac Toe.

The server depends on the contract module, 
where the protocol buffers shared between server and client are defined.
The server needs to know the interface to provide an implementation for it.

## Instructions for using Maven

Make sure that you installed the contract module first.

To compile and run the server:

```
mvn compile exec:java
```


## To configure the Maven project in Eclipse

'File', 'Import...', 'Maven'-'Existing Maven Projects'

'Select root directory' and 'Browse' to the project base folder.

Check that the desired POM is selected and 'Finish'.


----

[SD Faculty](mailto:leic-sod@disciplinas.tecnico.ulisboa.pt)
