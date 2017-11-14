package sample;

import java.util.HashMap;
import java.util.Vector;

public class SearchEngine {

    //Fields
    private Map map;
    private int Result;
    private Vector<Node> QueryList = new Vector<>();
    private Node KioskLocation;

    //Tp be Implemented in the data base for later Iteration
    private Vector<SearchQuery> SearchHistory = new Vector<>();


    // Constructor
    public SearchEngine(Map map) {
        this.map = map;
        QueryList = map.getMap();
        KioskLocation  = new Node();
    }

    /**
     * This is the A* algorithm to find the most efficient path
     * <p>
     *   A* is designed so that it finds the most cost efficient path. Now with multiple floors based
     *   on elevators and stairs
     * </p>
     * @param   Query  string
     * @return  ListPoint it returns a vector that contains the nodes, that the minimum path from Start to End consists of.
     */

    public Vector<Node> SearchPath(String Query){

        Vector<Node> r = new Vector<>();

        if ( Query !=  ""){
            for(int i = 0; i<QueryList.size();i++){
                if ((QueryList.get(i).getLongName().toLowerCase().contains(Query.toLowerCase()))){
                    r.add(QueryList.get(i));
                }
            }
        }

        Node MinNode = null;
        Double MinDistance=1000000.0;

        for(int i =0; i<r.size();i++ ){
            if(MinDistance  > map.TotalDistance(map.AStar(KioskLocation,r.get(i)))){
                MinDistance = map.TotalDistance(map.AStar(KioskLocation,r.get(i)));
                MinNode = r.get(i);
            }
        }

        return map.AStar(KioskLocation,MinNode);
    }



}
