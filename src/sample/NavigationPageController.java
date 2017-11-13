package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Vector;

public class NavigationPageController {
    @FXML
    private TextField email;

    @FXML
    private TextField destination;

    @FXML
    private CheckBox stairs;

    @FXML
    private  CheckBox elevator;

    @FXML
    private static Label invalidEmailText;

    @FXML
    public void go(){

    }

    @FXML
    public void clear(){

    }

    //sets invalid email label when necessary for errorhandling
    @FXML
    public static void setInvalidEmail(){
        invalidEmailText.setVisible(true);
    }

    //sends the email message by using user input
    @FXML
    public void sendMsg() throws Exception{
        Vector<Node> msgVec = new Vector<Node>(10);

        //here we would add the node elements to the thing however it goes, rn I'm adding manually
        Node n1 = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
        msgVec.addElement(n1);
        Node n2 = new Node("FHALL00201", 1640, 850, 1, "Tower", "HALL", "Chapel Hall Point 1", "CHP1", 'F');
        msgVec.addElement(n2);
        Node n3 = new Node("FHALL00301", 1788, 850, 1, "Tower", "HALL", "Chapel Hall Point 2", "CHP2", 'F');
        msgVec.addElement(n3);
        Node n4 = new Node("FHALL00701", 1759, 900, 1, "Tower", "HALL", "Chapel Hall Entrance", "CHE", 'F');
        msgVec.addElement(n4);
        Node n5 = new Node("FHALL01301", 1760, 952, 1, "Tower", "HALL", "International Hall Point 2", "IHP2", 'F');
        msgVec.addElement(n5);
        Node n6 = new Node("FSERV00101", 1724, 930, 1, "Tower", "SERV", "Multifaith Chapel", "MFC", 'F');
        msgVec.addElement(n6);

        EmailService emailService = new EmailService("teamFCS3733@gmail.com", "FuschiaFairiesSoftEng");
        emailService.sendEmail(NavigationPageController.directions(msgVec), email.getText());
    }

    @FXML
    public void back(){
        Main.startScreen();
    }

    public static String directions(Vector<Node> in){
        String out = "";
        Node a, b, c;
        if(in.size()<2){
            out = out.concat("Path too short");
        }
        a = in.get(0);
        b = in.get(1);
        out = out.concat("Start at " + a.getLongName()+"<br>");
        out = out.concat("Go towards " + b.getLongName()+"<br>");

        for(int i = 2; i < in.size(); i++){
            a = in.get(i-2);
            b = in.get(i-1);
            c = in.get(i);
            String turn = "";
            double angle = NodeMath.findAngle(a.getxCoordinate(), a.getyCoordinate(), b.getxCoordinate(), b.getyCoordinate(), c.getxCoordinate(), c.getyCoordinate());
            if(angle<45){
                turn = "sharply right";
            }else if(angle < 135){
                turn = "right";
            }else if(angle < 225){
                turn = "straight";
            }else if(angle <315){
                turn = "left";
            }else{
                turn = "sharply left";
            }

            out = out.concat("When you arrive at " + b.getLongName() + " go " + turn + " towards " + c.getLongName() + "<br>");
        }
        return out;
    }

}
