package sample;

import java.util.HashMap;
import java.util.Vector;

public class SearchEngine {

    //Fields
    private Map map;
    private int Result;
    //private Vector<Node> QueryList = new Vector<>();
    private Node KioskLocation;

    //Tp be Implemented in the data base for later Iteration
    private Vector<SearchQuery> SearchHistory = new Vector<>();


    // Constructor
    public SearchEngine(Map map) {
        this.map = map;
        KioskLocation  = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

   /* public Vector<Node> getQueryList() {
        return QueryList;
    }

    public void setQueryList(Vector<Node> queryList) {
        QueryList = queryList;
    }*/

    public Node getKioskLocation() {
        return KioskLocation;
    }

    public void setKioskLocation(Node kioskLocation) {
        KioskLocation = kioskLocation;
    }

    public Vector<SearchQuery> getSearchHistory() {
        return SearchHistory;
    }

    public void setSearchHistory(Vector<SearchQuery> searchHistory) {
        SearchHistory = searchHistory;
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
            for(int i = 0; i<map.getMap().size();i++){
                if ((map.getMap().get(i).getLongName().toLowerCase().contains(Query.toLowerCase()))){
                    r.add(map.getMap().get(i));
                }
            }
        }

        Node MinNode = KioskLocation;
        Double MinDistance=1000000.0;

        for(int i =0; i<r.size();i++ ){
            if(MinDistance  > map.TotalDistance(map.AStar(KioskLocation,r.get(i)))){
                System.out.print("HEREEEEEEEEEE");
                MinDistance = map.TotalDistance(map.AStar(KioskLocation,r.get(i)));
                MinNode = r.get(i);
            }
        }

        return map.AStar(KioskLocation,MinNode);
    }
/*
    public void buildSearch(){
        QueryList = map.getMap();
    }

*/


}

