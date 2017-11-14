package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;


import javax.swing.text.html.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    // These fxml things were added by Andrew S.
    @FXML
    private SplitMenuButton floorselector;

    @FXML
    private MenuItem thirdfloor;

    @FXML
    private MenuItem secondfloor;

    @FXML
    private MenuItem firstfloor;

    @FXML
    private MenuItem groundfloor;

    @FXML
    private MenuItem basementone;

    @FXML
    private MenuItem basementtwo;

    @FXML
    private javafx.scene.image.ImageView map;

    @FXML
    private void thirdflooractivate() throws FileNotFoundException
    {
        String path = ".\\TeamF-0.1\\src\\sample\\UI\\Icons\\03_thethirdfloor.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    private void secondflooractivate() throws FileNotFoundException
    {
        String path = ".\\TeamF-0.1\\src\\sample\\UI\\Icons\\02_thesecondfloor.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    private void firstflooractivate() throws FileNotFoundException
    {
        String path = ".\\TeamF-0.1\\src\\sample\\UI\\Icons\\01_thefirstfloor.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    private void groundflooractivate() throws FileNotFoundException
    {
        String path = ".\\TeamF-0.1\\src\\sample\\UI\\Icons\\00_thegroundfloor.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    private void basementoneactivate() throws FileNotFoundException
    {
        String path = ".\\TeamF-0.1\\src\\sample\\UI\\Icons\\00_thelowerlevel1.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    private void basementtwoactivate() throws FileNotFoundException
    {
        String path = "D:\\SoftEng\\Iteration_One\\Iteration1-SubmitVersion\\TeamF-0.1\\src\\sample\\UI\\Icons\\00_thelowerlevel2.png";
        map.setImage(new Image(new FileInputStream(path)));
    }

    @FXML
    public void go(){

    }

    @FXML
    public void clear(){

    }

    @FXML // This is for the SpitMenuButton floor; // Andrew S
    private void switchMap()
    {
//        SplitMenuButton menu = new SplitMenuButton();

        MenuItem item1 = new MenuItem();

        /*
        boolean bs2 = false;
        boolean bs1 = false;
        boolean gnd = false;
        boolean flr1 = false;
        boolean flr2 = false;
        boolean flr3 = false;

        bs2 = basementtwo.getOnMenuValidation().equals(true);
        bs1 = basementone.getOnMenuValidation().equals(true);
        gnd = groundfloor.getOnMenuValidation().equals(true);
        flr1 = firstfloor.getOnMenuValidation().equals(true);
        flr2 = secondfloor.getOnMenuValidation().equals(true);
        flr3 = thirdfloor.getOnMenuValidation().equals(true);
        */

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
