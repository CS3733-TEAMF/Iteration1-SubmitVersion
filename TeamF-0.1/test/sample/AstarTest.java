/*Nik - To test that AStart functions properly*/
/*ALL PASS - Steph*/

package sample;

import org.junit.Test;

import java.util.Vector;

public class AstarTest {

    @Test
    public void aStarTest (){



        Node a = new Node("1",0,0,1,"HALL","asd","big","small",'f');
        Node b = new Node("2",3,0,1,"HALL","asd","big","small",'f');
        Node c = new Node("3",0,3,1,"HALL","asd","big","small",'f');
        Node d = new Node("4",4,5,1,"HALL","asd","big","small",'f');
        Node e = new Node("5",2,6,1,"HALL","asd","big","small",'f');
        Node f = new Node("6",7,3,1,"HALL","asd","big","small",'f');
        Node g = new Node("7",8,8,1,"HALL","asd","big","small",'f');



        //test 1 answ a,c,e,g

        Edge aEdge = new Edge("1",a,b);
        Edge bEdge = new Edge("2",b,d);
        Edge cEdge = new Edge("3",d,f);
        Edge dEdge = new Edge("4",f,g);
        Edge eEdge = new Edge("5",a,c);
        Edge fEdge = new Edge("6",c,e);
        Edge gEdge = new Edge("7",e,g);


        //test2 answ a,c,d,g

        Edge hEdge = new Edge("8",c,d);
        Edge iEdge = new Edge("9",d,g);
        Edge jEdge = new Edge("10",b,f);
        Vector<Node> googlefish = new Vector<Node>();
        Vector<Edge> babble = new Vector<Edge>();

        googlefish.add(a);
        googlefish.add(b);
        googlefish.add(c);
        googlefish.add(d);
        googlefish.add(e);
        googlefish.add(f);
        googlefish.add(g);



        babble.add(aEdge);
        babble.add(bEdge);
        babble.add(cEdge);
        babble.add(dEdge);
        babble.add(eEdge);
        babble.add(fEdge);
        babble.add(gEdge);
        babble.add(hEdge);
        babble.add(iEdge);
        babble.add(jEdge);

        Map MapObj = new Map(googlefish, babble);
        MapObj.BuildMap();

        Vector<Node> Result1 = new Vector<Node>();
        Result1 = MapObj.AStar(a,g);


        System.out.print("Result1:");
        for (int i=0; i< Result1.size();i++){
            System.out.print(" "+Result1.get(i).getNodeID());
        }

        System.out.print("\n");

    }
}