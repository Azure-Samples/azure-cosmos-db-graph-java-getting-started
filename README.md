---
services: cosmos-db
platforms: java
author: arramac
---

# Developing a Java app using Azure Cosmos DB
Azure Cosmos DB is a globally distributed multi-model database. One of the supported APIs is the Graph (Gremlin) API, which provides a graph data model with [Gremlin query/traversals](https://tinkerpop.apache.org/gremlin.html). This sample shows you how to use the Azure Cosmos DB with the Graph API to store and access data from a Java application.

## Running this sample

* Before you can run this sample, you must have the following prerequisites:

   * An active Azure account. If you don't have one, you can sign up for a [free account](https://azure.microsoft.com/free/). Alternatively, you can use the [Azure Cosmos DB Emulator](https://azure.microsoft.com/documentation/articles/documentdb-nosql-local-emulator) for this tutorial.
   * JDK 1.7+ (Run `apt-get install default-jdk` if you don't have JDK)
   * Maven (Run `apt-get install maven` if you don't have Maven)

* Then, clone this repository using `git clone git@github.com:arramac/azure-cosmosdb-graph-java-getting-started.git`

* Next, substitute the endpoint and authorization key in Program.java with your Cosmos DB account's values. 

* From a command prompt or shell, run `mvn package` to compile and resolve dependencies.

* From a command prompt or shell, run `mvn exec:java -D exec.mainClass=GetStarted.Program` to run the application.

## About the code
The code included in this sample is intended to get you quickly started with a Java application that connects to Azure Cosmos DB with the Graph (Gremlin) API.

## More information

- [Azure Cosmos DB](https://docs.microsoft.com/azure/cosmos-db/introduction)
- [Azure Cosmos DB : Graph API](https://docs.microsoft.com/azure/documentdb/graph-introduction)
- [Gremlin Java SDK](http://tinkerpop.apache.org/docs/current/reference/#gremlin-java)
- [Gremlin Java Reference Documentation](http://tinkerpop.apache.org/javadocs/current/full/)

