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

* Then, clone this repository using `git clone https://github.com/Azure-Samples/azure-cosmos-db-graph-java-getting-started.git`

* Next, substitute the endpoint and authorization key in the `remote.yaml` with your Cosmos DB account's values. 

| Setting | Suggested Value | Description |
| ------- | --------------- | ----------- |
| hosts   | [***.graphs.azure.com] | This is the Gremlin URI value on the Overview page of the Azure portal, in square brackets, with the trailing :443/ removed.  This value can also be retrieved from the Keys tab, using the URI value by removing https://, changing documents to graphs, and removing the trailing :443/. |
| port | 443 | Set the port to 443 |
| username | `/dbs/<db>/colls/<coll>` | The resource of the form `/dbs/<db>/colls/<coll>` where `<db>` is your database name and `<coll>` is your collection name. |
| password | Your primary key | This is your primary key, which you can retrieve from the Keys page of the Azure portal, in the Primary Key box. Use the copy button on the left side of the box to copy the value. |
| connectionPool | `{enableSsl: true}` | Your connection pool setting for SSL. |
| serializer | { className: org.apache.tinkerpop.gremlin. driver.ser.GraphSONMessageSerializerV1d0, config: { serializeResultToString: true }} | Set to this value and delete any \n line breaks and spaces when pasting in the value. |

* From a command prompt or shell, run `mvn package` to compile and resolve dependencies.

* From a command prompt or shell, run `mvn exec:java -D exec.mainClass=GetStarted.Program` to run the application.

## About the code
The code included in this sample is intended to get you quickly started with a Java application that connects to Azure Cosmos DB with the Graph (Gremlin) API.

## More information

- [Azure Cosmos DB](https://docs.microsoft.com/azure/cosmos-db/introduction)
- [Azure Cosmos DB : Graph API](https://docs.microsoft.com/en-us/azure/cosmos-db/graph-introduction)
- [Gremlin Java SDK](http://tinkerpop.apache.org/docs/current/reference/#gremlin-java)
- [Gremlin Java Reference Documentation](http://tinkerpop.apache.org/javadocs/current/full/)

