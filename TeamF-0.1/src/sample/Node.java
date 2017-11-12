package sample;

public class Node {
    public String nodeID;
    public int x;
    public int y;
    public int floor;
    public String building;
    public String nodeType;
    public String longName;
    public String shortName;
    public char teamAssigned;

    public Node(String nodeID, int xloc, int yloc, int floor, String build, String nodeTp, String longNm, String shortNm, char teamAss)
    {
        this.nodeID = nodeID;
        this.x = xloc;
        this.y = yloc;
        this.floor = floor;
        this.building = build;
        this.nodeType = nodeTp;
        this.longName = longNm;
        this.shortName = shortNm;
        this.teamAssigned = teamAss;
    }

    public boolean  isType(String input )
    {
        return true;
    }

    public boolean isLocation(String input ){

        return true;
    }
    public double distance( int x, int y){

        return 7;
    }
}
