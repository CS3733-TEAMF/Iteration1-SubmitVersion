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
        boolean success = true;
        //EmailService emailService = new EmailService("teamFCS3733@gmail.com", "FuschiaFairiesSoftEng");
        EmailService emailService = new EmailService("teamFCS3733@gmail.com", "FuschiaFairiesSoftEng");
        emailService.sendEmail("Some directions", email.getText());
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
        out = out.concat("Start at " + a.longName+"\n");
        out = out.concat("Go towards " + b.longName+"\n");

        for(int i = 2; i < in.size(); i++){
            a = in.get(i-2);
            b = in.get(i-1);
            c = in.get(i);
            String turn = "";
            double angle = NodeMath.findAngle(a.x, a.y, b.x, b.y, c.x, c.y);
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

            out = out.concat("When you arrive at " + b.longName + " go " + turn + " towards " + c.longName + "\n");
        }
        return out;
    }

}
