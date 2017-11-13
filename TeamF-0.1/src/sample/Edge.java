package sample;

public class Edge {

    //Fields
    private int EdgeID;
    private Node Start;
    private Node End;

    //Constructor
    public Edge(int EdgeID,Node Start, Node End) {

        this.EdgeID = EdgeID;
        this.Start = Start;
        this.End = End;
    }

    // Getters and Setters
    public int getEdgeID() {
        return EdgeID;
    }

    public void setEdgeID(int edgeID) {
        this.EdgeID = edgeID;
    }

    public Node getStart() {
        return Start;
    }

    public void setStart(Node start) {
        this.Start = start;
    }

    public Node getEnd() {
        return End;
    }

    public void setEnd(Node end) {
        this.End = end;
    }


}
