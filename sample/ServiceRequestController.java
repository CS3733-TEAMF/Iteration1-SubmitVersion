package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import sample.ServiceRequest.*;

import java.util.Comparator;
import java.util.Date;
import java.text.*;
import java.util.PriorityQueue;

public class ServiceRequestController {

    //top menu bar
    @FXML
    public void backToStart() { Main.startScreen();}

    @FXML
    public void backToAdmin() {Main.adminScreen();}


    public int ID = 1;
    PriorityQueue<ServiceRequest>  priorityQueue = new PriorityQueue<ServiceRequest>(1000,
            Comparator.comparing(ServiceRequest::getServiceID));
    ServiceRequestList requestList = new ServiceRequestList(priorityQueue);

    //assistance requests
    @FXML
    private TitledPane assistancePane;

    @FXML
    private Label assistanceID;

    @FXML
    private Label assistanceTime;

    @FXML
    private TextField assistanceUrgency;

    @FXML
    private TextArea assistanceDescription;

    @FXML
    public void updateAssistance(){
        assistanceID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        assistanceTime.setText(ft.format(date));;
    }

    @FXML
    public void assistanceThisLocation() {}

    @FXML
    public void assistanceChooseLocation() {
    }

    @FXML
    public void assistanceSendRequest() {
        AssistanceRequest newAssist = new AssistanceRequest(null, assistanceDescription.getText(),
                Integer.parseInt(assistanceID.getText()), assistanceTime.getText(), 00000,
                "assistance", Integer.parseInt(assistanceUrgency.getText()));
        requestList.addRequest(newAssist);

        assistanceUrgency.clear();
        assistanceDescription.clear();
        assistanceID.setText(Integer.toString(++ID));
    }


    //food requests
    @FXML
    private TitledPane foodPane;

    @FXML
    private Label foodID;

    @FXML
    private Label foodTime;

    @FXML
    private TextField foodPatient;

    @FXML
    private TextField foodServingTime;

    @FXML
    private TextField foodOrder;

    @FXML
    private TextArea foodDescription;

    @FXML
    public void updateFood(){
        foodID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        foodTime.setText(ft.format(date));;
    }

    @FXML
    public void foodThisLocation() {}

    @FXML
    public void foodChooseLocation() {}

    @FXML
    public void foodSendRequest() {
        FoodRequest newFood = new FoodRequest(null, foodDescription.getText(), Integer.parseInt(foodID.getText()),
                foodTime.getText(), 00000, "food", foodPatient.getText(),
                        foodServingTime.getText(), foodOrder.getText());
        requestList.addRequest(newFood);

        foodPatient.clear();
        foodServingTime.clear();
        foodOrder.clear();
        foodDescription.clear();
        foodID.setText(Integer.toString(++ID));
    }


    //transport requests
    @FXML TitledPane transportPane;

    @FXML
    private Label transportID;

    @FXML
    private Label transportTime;

    @FXML
    private TextField transportPatient;

    @FXML
    private TextField transportType;

    @FXML
    private TextArea transportDescription;

    @FXML
    public void updateTransport(){
        transportID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        transportTime.setText(ft.format(date));;
    }

    @FXML
    public void transportThisLocation() {}

    @FXML
    public void transportChooseLocation() {}

    @FXML
    public void transportSendRequest() {
        TransportRequest newTransport = new TransportRequest(null, transportDescription.getText(),
                Integer.parseInt(transportID.getText()), transportTime.getText(), 00000,
                "transport", false, transportPatient.getText(), transportType.getText());
        requestList.addRequest(newTransport);

        transportPatient.clear();
        transportType.clear();
        transportDescription.clear();
        transportID.setText(Integer.toString(++ID));
    }


    //cleaning requests
    @FXML
    private TitledPane cleanPane;

    @FXML
    private Label cleanID;

    @FXML
    private Label cleanTime;

    @FXML
    private TextField cleanLevel;

    @FXML
    private TextArea cleanDescription;

    @FXML
    public void updateClean(){
        cleanID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        cleanTime.setText(ft.format(date));;
    }

    @FXML
    public void cleanThisLocation() {}

    @FXML
    public void cleanChooseLocation() {}

    @FXML
    public void cleanSendRequest() {
        CleaningRequest newClean = new CleaningRequest(null, cleanDescription.getText(),
                Integer.parseInt(cleanID.getText()), cleanTime.getText(), 00000,
                "cleaning", Integer.parseInt(cleanLevel.getText()));
        requestList.addRequest(newClean);

        cleanLevel.clear();
        cleanDescription.clear();
        cleanID.setText(Integer.toString(++ID));
    }


    //security requests
    @FXML
    private TitledPane securityPane;

    @FXML
    private Label securityID;

    @FXML
    private Label securityTime;

    @FXML
    private TextField securityLevel;

    @FXML
    private TextArea securityDescription;

    @FXML
    public void updateSecurity(){
        securityID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        securityTime.setText(ft.format(date));;
    }

    @FXML
    public void securityThisLocation() {}

    @FXML
    public void securityChooseLocation() {}

    @FXML
    public void securitySendRequest() {
        SecurityRequest newSecurity = new SecurityRequest(null, securityDescription.getText(),
                Integer.parseInt(securityID.getText()), securityTime.getText(), 00000,
                "security", Integer.parseInt(securityLevel.getText()));
        requestList.addRequest(newSecurity);

        securityLevel.clear();
        securityDescription.clear();
        securityID.setText(Integer.toString(++ID));
    }


}