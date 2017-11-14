package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Comparator;
import java.util.Date;
import java.text.*;
import java.util.PriorityQueue;
import java.util.Vector;


public class ServiceRequestController {

    //top menu bar
    @FXML
    public void backToStart() { Main.startScreen();}

    @FXML
    public void backToAdmin() {Main.adminScreen();}


    public int ID = 1;   //service ID counter
    Node n1 = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
    PriorityQueue<ServiceRequest>  priorityQueue = new PriorityQueue<ServiceRequest>(100,
            Comparator.comparing(ServiceRequest::getServiceID));             //creates priority queue of
    ServiceRequestList requestList = new ServiceRequestList(priorityQueue);  //service requests, ordered by ID


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
    public void updateAssistance(){                                      //when a request menu is opened
        assistanceID.setText(Integer.toString(ID));                      //sets correct service ID
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");    //for correct time format
        assistanceTime.setText(ft.format(date));;                        //sets current time
    }

    @FXML
    public void assistanceThisLocation() {}

    @FXML
    public void assistanceChooseLocation() {
    }

    @FXML
    public void assistanceSendRequest() {                              //when the Send button is pressed
        AssistanceRequest newAssist = new AssistanceRequest(n1, assistanceDescription.getText(),
                Integer.parseInt(assistanceID.getText()), assistanceTime.getText(), 00000,
                "assistance", Integer.parseInt(assistanceUrgency.getText()));
        requestList.addRequest(newAssist);               //new service request is made and added to priority queue

        assistanceUrgency.clear();                      //clears textfields
        assistanceDescription.clear();
        ID++;                                           //increments service ID counter
        assistancePane.setExpanded(false);              //closes the request menu
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
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        foodTime.setText(ft.format(date));;
    }

    @FXML
    public void foodThisLocation() {}

    @FXML
    public void foodChooseLocation() {}

    @FXML
    public void foodSendRequest() {
        FoodRequest newFood = new FoodRequest(n1, foodDescription.getText(), Integer.parseInt(foodID.getText()),
                foodTime.getText(), 00000, "food", foodPatient.getText(),
                        foodServingTime.getText(), foodOrder.getText());
        requestList.addRequest(newFood);

        foodPatient.clear();
        foodServingTime.clear();
        foodOrder.clear();
        foodDescription.clear();
        ID++;
        foodPane.setExpanded(false);

        //Vector<ServiceRequest> v = testEmbeddedDB.getAllServiceRequests();
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
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        transportTime.setText(ft.format(date));;
    }

    @FXML
    public void transportThisLocation() {}

    @FXML
    public void transportChooseLocation() {}

    @FXML
    public void transportSendRequest() {
        TransportRequest newTransport = new TransportRequest(n1, transportDescription.getText(),
                Integer.parseInt(transportID.getText()), transportTime.getText(), 00000,
                "transport", false, transportPatient.getText(), transportType.getText());
        requestList.addRequest(newTransport);

        transportPatient.clear();
        transportType.clear();
        transportDescription.clear();
        ID++;
        transportPane.setExpanded(false);
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
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        cleanTime.setText(ft.format(date));;
    }

    @FXML
    public void cleanThisLocation() {}

    @FXML
    public void cleanChooseLocation() {}

    @FXML
    public void cleanSendRequest() {
        CleaningRequest newClean = new CleaningRequest(n1, cleanDescription.getText(),
                Integer.parseInt(cleanID.getText()), cleanTime.getText(), 00000,
                "cleaning", Integer.parseInt(cleanLevel.getText()));
        requestList.addRequest(newClean);

        cleanLevel.clear();
        cleanDescription.clear();
        ID++;
        cleanPane.setExpanded(false);
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
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        securityTime.setText(ft.format(date));;
    }

    @FXML
    public void securityThisLocation() {}

    @FXML
    public void securityChooseLocation() {}

    @FXML
    public void securitySendRequest() {
        SecurityRequest newSecurity = new SecurityRequest(n1, securityDescription.getText(),
                Integer.parseInt(securityID.getText()), securityTime.getText(), 00000,
                "security", Integer.parseInt(securityLevel.getText()));
        requestList.addRequest(newSecurity);

        securityLevel.clear();
        securityDescription.clear();
        ID++;
        securityPane.setExpanded(false);
    }

/*
    @FXML
    private TableColumn<ServiceRequest, String> requests;

    @FXML
    private TableColumn<String, String> status;

    public void initialize(URL, url)*/
}