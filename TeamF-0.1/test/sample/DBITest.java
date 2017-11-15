/*Steph - Database Integration Testing
* Purpose: To test connection between Database and Nodes*/
/*Work done by Griffin Roth previously, considered to satisfy requirements*/
/*IMPORTANT - EDITS THE TABLES, BE CAREFUL IF FILE IS IN MASTER*/
/*UNFINISHED - Steph*/

package sample;

import org.junit.Test;


public class DBITest {

    //Steph - adds Nodes and updates to run successfully, then removes
    @Test
    public void nodeTest(){
        testEmbeddedDB t = new testEmbeddedDB();

        //Adds a new node in the db
        testEmbeddedDB.addNodes("Test", 2, 2, "1", "Test", "Test", "Testing", "Test", "F");
        //Changes the x-coordinate of a specified node
        testEmbeddedDB.updateNodeXCoord("Test", 345);
        //Changes the y-coordinate of a specified node
        testEmbeddedDB.updateNodeYCoord("Test",678);
        //Changes the floor of a specified node
        testEmbeddedDB.updateNodeFloor("Test", "300");
        //Changes the building of a specified node
        testEmbeddedDB.updateNodeBuilding("Test", "A Tree");
        //Changes the node type of a spefied node
        testEmbeddedDB.updateNodeType("Test", "Help");
        //Changes the long name of a specified node
        testEmbeddedDB.updateNodeLongName("Test", "Testing dbs");
        //Changes the short name of a specified node
        testEmbeddedDB.updateNodeShortName("Test", "Test_Test");
        //Removes a specified node
        testEmbeddedDB.removeNode("Test");
    }

    //Steph - adds and updates edges to run successfully, then removes
    @Test
    public void edgeTest(){
        //Adds a new edge to the table
        testEmbeddedDB.addEdges("TEST_TEST_TEST_TEST_TEST-", "TEST_TEST_TEST_TEST_TEST-","T");
        //Changes the start node of a specified edge
        testEmbeddedDB.updateEdgeStart("TEST_TEST_TEST_TEST_TEST-", "fixingthings");
        //Changes the end node of a specified edge
        testEmbeddedDB.updateEdgeEnd("TEST_TEST_TEST_TEST_TEST-", "TTTT");
        //Removes a specified edge from the table
        testEmbeddedDB.removeEdge("TEST_TEST_TEST_TEST_TEST-");
        testEmbeddedDB.removeEdge("test");
    }
}
