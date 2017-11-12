package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class serviceRequestController {

    //top menu bar
    @FXML
    public void backToStart() { Main.startScreen();}

    @FXML
    public void backToAdmin() {Main.adminScreen();}


    public int ID = 0;

    //assistance requests
    @FXML
    private TitledPane assistancePane;

    @FXML
    private Label assistanceID;

    @FXML
    private TextField assistanceTime;

    @FXML
    private TextField assistanceUrgency;

    @FXML
    private TextArea assistanceDescription;

    @FXML
    public void setAssistanceID(){
        assistanceID.setText(Integer.toString(ID));
    }

    @FXML
    public void assistanceThisLocation() {}

    @FXML
    public void assistanceChooseLocation() {
    }

    @FXML
    public void assistanceSendRequest() {
        ID++;
        assistanceID.setText(Integer.toString(ID));
        foodID.setText(Integer.toString(ID));
        transportID.setText(Integer.toString(ID));
        cleanID.setText(Integer.toString(ID));
        securityID.setText(Integer.toString(ID));
    }


    //food requests
    @FXML
    private TitledPane foodPane;

    @FXML
    private Label foodID;

    @FXML
    private TextField foodTime;

    @FXML
    private TextField foodPatient;

    @FXML
    private TextField foodServingTime;

    @FXML
    private TextField foodOrder;

    @FXML
    private TextArea foodDescription;

    @FXML
    public void setFoodID(){
        foodID.setText(Integer.toString(ID));
    }

    @FXML
    public void foodThisLocation() {}

    @FXML
    public void foodChooseLocation() {}

    @FXML
    public void foodSendRequest() {
        ID++;
        assistanceID.setText(Integer.toString(ID));
        foodID.setText(Integer.toString(ID));
        transportID.setText(Integer.toString(ID));
        cleanID.setText(Integer.toString(ID));
        securityID.setText(Integer.toString(ID));
    }


    //transport requests
    @FXML TitledPane transportPane;

    @FXML
    private Label transportID;

    @FXML
    private TextField transportTime;

    @FXML
    private TextField transportPatient;

    @FXML
    private TextField transportType;

    @FXML
    private TextArea transportDescription;

    @FXML
    public void setTransportID(){
        transportID.setText(Integer.toString(ID));
    }

    @FXML
    public void transportThisLocation() {}

    @FXML
    public void transportChooseLocation() {}

    @FXML
    public void transportSendRequest() {
        ID++;
        assistanceID.setText(Integer.toString(ID));
        foodID.setText(Integer.toString(ID));
        transportID.setText(Integer.toString(ID));
        cleanID.setText(Integer.toString(ID));
        securityID.setText(Integer.toString(ID));
    }


    //cleaning requests
    @FXML
    private TitledPane cleanPane;

    @FXML
    private Label cleanID;

    @FXML
    private TextField cleanTime;

    @FXML
    private TextField cleanLevel;

    @FXML
    private TextArea cleanDescription;

    @FXML
    public void setCleanID(){
        cleanID.setText(Integer.toString(ID));
    }

    @FXML
    public void cleanThisLocation() {}

    @FXML
    public void cleanChooseLocation() {}

    @FXML
    public void cleanSendRequest() {
        ID++;
        assistanceID.setText(Integer.toString(ID));
        foodID.setText(Integer.toString(ID));
        transportID.setText(Integer.toString(ID));
        cleanID.setText(Integer.toString(ID));
        securityID.setText(Integer.toString(ID));
    }


    //security requests
    @FXML
    private TitledPane securityPane;

    @FXML
    private Label securityID;

    @FXML
    private TextField securityTime;

    @FXML
    private TextField securityLevel;

    @FXML
    private TextArea securityDescription;

    @FXML
    public void setSecurityID(){
        securityID.setText(Integer.toString(ID));
    }

    @FXML
    public void securityThisLocation() {}

    @FXML
    public void securityChooseLocation() {}

    @FXML
    public void securitySendRequest() {
        ID++;
        assistanceID.setText(Integer.toString(ID));
        foodID.setText(Integer.toString(ID));
        transportID.setText(Integer.toString(ID));
        cleanID.setText(Integer.toString(ID));
        securityID.setText(Integer.toString(ID));
    }


}