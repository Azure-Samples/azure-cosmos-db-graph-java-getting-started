package GetStarted;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Program
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {


        /**
         * There typically needs to be only one Cluster instance in an application.
         */
        Cluster cluster;

        /**
         * Use the Cluster instance to construct different Client instances (e.g. one for sessionless communication
         * and one or more sessions). A sessionless Client should be thread-safe and typically no more than one is
         * needed unless there is some need to divide connection pools across multiple Client instances. In this case
         * there is just a single sessionless Client instance used for the entire App.
         */
        Client client;

        try {
            cluster = Cluster.build(new File("src/remote.yaml")).create();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        client = cluster.connect();

        /*
            Example Gremlin queries to perform the following:
            - add vertices and edges
            - query with filters, projections, 
            - traversals, including loops
            - update annd delete vertices and edges
        */
        String gremlinQueries[] = new {
            "g.V().drop()",
            "g.addV('person').property('id', 'thomas').property('firstName', 'Thomas').property('age', 44)",
            "g.addV('person').property('id', 'mary').property('firstName', 'Mary').property('lastName', 'Andersen').property('age', 39)",
            "g.addV('person').property('id', 'ben').property('firstName', 'Ben').property('lastName', 'Miller')",
            "g.addV('person').property('id', 'robin').property('firstName', 'Robin').property('lastName', 'Wakefield')",
            "g.V('thomas').addE('knows').to(g.V('mary'))",
            "g.V('thomas').addE('knows').to(g.V('ben'))",
            "g.V('ben').addE('knows').to(g.V('robin'))",
            "g.V('thomas').property('age', 44)",
            "g.V().count()",
            "g.V().hasLabel('person').has('age', gt(40))",
            "g.V().hasLabel('person').order().by('firstName', decr)",
            "g.V('thomas').outE('knows').inV().hasLabel('person')",
            "g.V('thomas').outE('knows').inV().hasLabel('person').outE('knows').inV().hasLabel('person')",
            "g.V('thomas').repeat(out()).until(has('id', 'robin')).path()",
            "g.V('thomas').outE('knows').where(inV().has('id', 'mary')).drop()",
            "g.E().count()",
            "g.V('thomas').drop()" };

        for (String gremlin : gremlinQueries) {
            ResultSet results = client.submit(gremlin);

            CompletableFuture<List<Result>> completableFutureResults = results.all();
            List<Result> resultList = completableFutureResults.get();

            for (Result result : resultList) {
                System.out.println(result.toString());
            }
        }
    }
}
