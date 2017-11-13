package sample;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.sql.*;


public class testEmbeddedDB {

    Connection c;


    public testEmbeddedDB(){


        try{

            final String url = "jdbc:derby:Skynet";
            c = DriverManager.getConnection(url);

            //testEmbeddedDB.dropTables();

            //testEmbeddedDB.createTable();

            //testEmbeddedDB.fillNodesTable();

            //testEmbeddedDB.createPrimKey();

            //testEmbeddedDB.fillEdgesTable();

            //testEmbeddedDB.dropServiceRequests();

            //testEmbeddedDB.createServiceRequestTable();

            testEmbeddedDB.addFoodRequest("dickbutt", "penis", 6969, "6969",
                    420, "gimme the g00dSucc", "Joseph Stalin",
                    14411, "the Bourgoisies head");

            testEmbeddedDB.addAssistanceRequest("assistance", "not a penis", 68686, "4444",
                    823450, "assistance", 4);

            testEmbeddedDB.addTransportRequest("test", "test", 1123, "234234",
                    2, "test", true, "bob");

            //testEmbeddedDB.writeToCSV();

            System.out.println("done.");



        } catch (Exception e){
            System.out.println("Error Creating the Database");
            System.out.println(e.getMessage());
        }
    }

    public static void createPrimKey(){
        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();

            s.execute("ALTER TABLE NODES ADD PRIMARY KEY (NODEID)");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void dropTables(){
        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();
            s.execute("DROP TABLE Nodes");
            System.out.println("Nodes dropped.");

            s.execute("DROP TABLE Edges");
            System.out.println("Edges dropped.");

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void dropServiceRequests(){
        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();
            s.execute("DROP TABLE SERVICEREQUESTS");

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void createServiceRequestTable(){
        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();

            s.execute("CREATE TABLE ServiceRequests (" +
                    "destination CHAR(25) NOT NULL ," +
                    "description CHAR(60) NOT NULL ," +
                    "serviceID INTEGER NOT NULL," +
                    "serviceTime CHAR(20) NOT NULL ," +
                    "serviceEmployeeID INTEGER NOT NULL ," +
                    "typeOfReqest CHAR(30) NOT NULL ," +
                    "patientName CHAR(40) DEFAULT NULL ," +
                    "timeToBeServed INTEGER DEFAULT NULL ," +
                    "foodOrder CHAR(30) DEFAULT NULL ," +
                    "urgency INTEGER DEFAULT NULL ," +
                    "arrival BOOLEAN DEFAULT FALSE ," +
                    "typeOfTransport CHAR(60) DEFAULT NULL ," +
                    "PRIMARY KEY (serviceID))");

            s.close();

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void addFoodRequest(String nodeID, String desc, int serviceID, String  serviceTime,
                                      int serviceEmployeeId, String reqType, String patientName,
                                      int timeToBeServed, String order){

        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement eee = c.createStatement();

            eee.execute("INSERT into SERVICEREQUESTS (DESTINATION, DESCRIPTION, SERVICEID, " +
                    "SERVICETIME, SERVICEEMPLOYEEID, TYPEOFREQEST, PATIENTNAME, TIMETOBESERVED,FOODORDER) " +
                    "VALUES ('" + nodeID + "', '" + desc + "', " + serviceID + ", '" + serviceTime + "'," +
                    serviceEmployeeId + ",'" + reqType + "','" + patientName + "', " + timeToBeServed + ",'" +
                    order + "')");

            eee.close();

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void addAssistanceRequest(String nodeID, String desc, int serviceID, String serviceTime,
                                      int serviceEmployeeId, String reqType, int urgency){

        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement q = c.createStatement();

            q.execute("INSERT into SERVICEREQUESTS (DESTINATION, DESCRIPTION, SERVICEID, " +
                    "SERVICETIME, SERVICEEMPLOYEEID, TYPEOFREQEST, URGENCY) " +
                    "VALUES ('" + nodeID + "', '" + desc + "', " + serviceID + ", '" + serviceTime + "'," +
                    serviceEmployeeId + ",'" + reqType + "',"+ urgency+ ")");

            q.close();

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void addTransportRequest(String nodeID, String desc, int serviceID, String  serviceTime,
                                            int serviceEmployeeId, String reqType, boolean arrival,
                                           String patName){

        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement eee = c.createStatement();

            eee.execute("INSERT into SERVICEREQUESTS (DESTINATION, DESCRIPTION, SERVICEID, " +
                    "SERVICETIME, SERVICEEMPLOYEEID, TYPEOFREQEST, ARRIVAL, PATIENTNAME) " +
                    "VALUES ('" + nodeID + "', '" + desc + "', " + serviceID + ", '" + serviceTime + "'," +
                    serviceEmployeeId + ",'" + reqType + "'," + arrival + ", '" + patName + "')");

            eee.close();

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void createTable(){

        try{
            final String url = "jdbc:derby:Skynet";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();

            // Create the table.
            s.execute("CREATE TABLE Nodes (" +
                    "nodeID CHAR(25) NOT NULL, " +
                    "xcoord INTEGER, " +
                    "ycoord INTEGER, " +
                    "floor CHAR(4), " +
                    "building CHAR(15), " +
                    "nodeType CHAR(4), " +
                    "longName CHAR(60), " +
                    "shortName CHAR(20), " +
                    "teamAssigned CHAR(1)," +
                    "PRIMARY KEY (nodeID)" +
                    ")");

            s.execute("CREATE TABLE Edges (" +
                    "edgeID CHAR(25) NOT NULL, " +
                    "startNode CHAR(25), " +
                    "endNode CHAR(25), " +
                    "PRIMARY KEY (edgeID)" +
                    ")");

            c.close();

            System.out.println("done");
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public static void fillNodesTable(){
        CSVLoader l;
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);
            l = new CSVLoader(c);
            l.loadCSV("TeamF-0.1/src/sample/Data/MapFNodes.csv", "NODES", true);

            c.close();

        } catch (BatchUpdateException e){
            int[] updateCount = e.getUpdateCounts();

            int count = 1;

            for (int i : updateCount) {
                if  (i == Statement.EXECUTE_FAILED) {
                    System.out.println("Error on request " + count +": Execute failed");
                } else {
                    System.out.println("Request " + count +": OK");
                }
                count++;
            }


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }



    }

    public static void fillEdgesTable(){
        CSVLoader l;
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);
            l = new CSVLoader(c);
            l.loadCSV("TeamF-0.1/src/sample/Data/MapFEdges.csv", "EDGES", true);

            c.close();

        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }



    }

    public static void writeToCSV(){

        CSVWriter w = null;
        FileWriter f = null;
        final String url = "jdbc:derby:Skynet";


        try{
            f = new FileWriter("TeamF-0.1/src/sample/Data/databaseOutput.csv");
            w = new CSVWriter(f, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM NODES WHERE NODETYPE = 'DEPT'");

            while(r.next()) {
                String name = r.getString("nodeID");
                System.out.println("nodeID: " + name);
            }

            w.writeAll(r, true);

            c.close();

            System.out.println("printed!");


        } catch (Exception e){
            System.out.println("writeToCSV error: " + e.getMessage());
        } finally {
            try{
                w.close();

            } catch (Exception e){
                System.out.println("finally error: " + e.getMessage());
            }
        }
    }

    public static void addNodes(String nodeID, int xCoord, int yCoord, String floor, String building,
                         String nodeType, String longName, String shortName, String team){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("INSERT INTO NODES (NODEID, XCOORD, YCOORD, FLOOR, BUILDING, " +
                    "NODETYPE, LONGNAME, SHORTNAME, TEAMASSIGNED)" +
                    " VALUES ('"+nodeID+"',"+ xCoord+","+yCoord+",'"+ floor+"','"+ building+"','" +
                    nodeType+"','"+ longName+"','"+ shortName+"','" + team +"')");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void addEdges(String edgeID, String startNodes, String endNodes){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("INSERT INTO EDGES (EDGEID, STARTNODE, ENDNODE) VALUES ('"+edgeID+"','" +startNodes+"','" +endNodes+"')");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeXCoord(String nodeID, int xcoord){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set XCOORD = " + xcoord + " where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeYCoord(String nodeID, int ycoord){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set YCOORD = " + ycoord + " where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeFloor(String nodeID, String floor){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set FLOOR = '" + floor + "' where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeBuilding(String nodeID, String building){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set BUILDING = '" + building + "' where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeType(String nodeID, String nodeType){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set NODETYPE = '" + nodeType + "' where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeLongName(String nodeID, String longName){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set LONGNAME = '" + longName + "' where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateNodeShortName(String nodeID,String shortName){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("UPDATE NODES set SHORTNAME = '" + shortName + "' where NODEID = '" + nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }

    public static void updateEdgeStart(String edgeID, String start){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();
            s.execute("UPDATE EDGES set STARTNODE = '" + start + "' where EDGEID = '" + edgeID+"'");
            c.close();
        } catch (Exception e){
            System.out.println("error : " + e.getMessage());
        }

    }

    public static void updateEdgeEnd(String edgeID, String end){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();
            s.execute("UPDATE EDGES set ENDNODE = '" + end + "' where EDGEID = '" + edgeID+"'");
            c.close();
        } catch (Exception e){
            System.out.println("error : " + e.getMessage());
        }

    }

    public static void removeNode(String nodeID){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("DELETE FROM NODES WHERE NODEID = '"+nodeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void removeEdge(String edgeID){
        final String url = "jdbc:derby:Skynet";

        try{
            Connection c = DriverManager.getConnection(url);

            Statement s = c.createStatement();
            s.execute("DELETE FROM EDGES WHERE EDGEID = '"+edgeID+"'");

            c.close();


        } catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }


}
