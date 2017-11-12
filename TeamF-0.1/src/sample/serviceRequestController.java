package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class serviceRequestController {

    //top menu bar
    @FXML
    public void backToStart() { Main.startScreen();}

    @FXML
    public void backToAdmin() {Main.adminScreen();}


    //shared between all service requests
    @FXML
    private Label serviceID;


    //assistance requests
    @FXML
    private TextField assistanceTime;

    @FXML
    private TextField assistanceUrgency;

    @FXML
    private TextArea assistanceDescription;

    @FXML
    public void assistanceThisLocation() {}

    @FXML
    public void assistanceChooseLocation() {}

    @FXML
    public void assistanceSendRequest() {}


    //food requests
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
    public void foodThisLocation() {}

    @FXML
    public void foodChooseLocation() {}

    @FXML
    public void foodSendRequest() {}


    //transport requests
    @FXML
    private TextField transportTime;

    @FXML
    private TextField transportPatient;

    @FXML
    private TextField transportType;

    @FXML
    private TextArea transportDescription;

    @FXML
    public void transportThisLocation() {}

    @FXML
    public void transportChooseLocation() {}

    @FXML
    public void transportSendRequest() {}


    //cleaning requests
    @FXML
    private TextField cleanTime;

    @FXML
    private TextField cleanLevel;

    @FXML
    private TextArea cleanDescription;

    @FXML
    public void cleanThisLocation() {}

    @FXML
    public void cleanChooseLocation() {}

    @FXML
    public void cleanSendRequest() {}


    //security requests
    @FXML
    private TextField securityTime;

    @FXML
    private TextField securityLevel;

    @FXML
    private TextArea securityDescription;

    @FXML
    public void securityThisLocation() {}

    @FXML
    public void securityChooseLocation() {}

    @FXML
    public void securitySendRequest() {}


}