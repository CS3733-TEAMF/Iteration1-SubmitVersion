/*Steph - Testing Node Integration with Controller
* Purpose: To see if Nodes are correctly integrated with directions*/
/*UNFINISHED - Steph*/

package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import static org.junit.Assert.*;

public class NodeITest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    //Test path with only one node
    //Make sure test fails with no/null node
    //Test path with multiple nodes

    //Steph - makes sure PathException is thrown
    @Test
    public void throwsPathExceptionA() throws Exception{
        Vector<Node> nullNode = new Vector<Node>(10);
        nullNode.add(null);
        //get directions
        thrown.expect(PathException.class);
        thrown.expectMessage("Path is invalid");
        NavigationPageController.directions(nullNode);
    }

    //Steph - Test path with only one node
    @Test
    public void throwsPathExceptionB() throws Exception{
        //adds a singular node
        Vector<Node> oneNode = new Vector<Node>(10);
        Node n1 = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
        oneNode.add(n1);
        //getdirections
        thrown.expect(PathException.class);
        thrown.expectMessage("Path is invalid");
        NavigationPageController.directions(oneNode);
    }

}