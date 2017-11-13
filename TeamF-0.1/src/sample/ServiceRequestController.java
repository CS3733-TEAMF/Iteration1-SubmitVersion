/*It Request Work - Floris and Steph
* Purpose: to add additional Request for IT personell */


package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.ServiceRequest.*;
import sample.ServiceRequest.ServiceRequestList;

import java.util.Comparator;
import java.util.Date;
import java.text.*;
import java.util.PriorityQueue;



public class ServiceRequestController {

    //top menu bar
    @FXML
    public static void backToStart() { Main.startScreen();}

    @FXML
    public static void backToAdmin() {Main.adminScreen();}

    @FXML
    private static Menu start;

    @FXML
    private static Menu map;

    public static int ID = 1;   //service ID counter
    Node n1 = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
    static PriorityQueue<ServiceRequest>  priorityQueue = new PriorityQueue<ServiceRequest>(100,
            Comparator.comparing(ServiceRequest::getServiceID));             //creates priority queue of
    static ServiceRequestList requestList = new ServiceRequestList(priorityQueue);  //service requests, ordered by ID


    //assistance requests
    @FXML
    private static TitledPane assistancePane;

    @FXML
    private static Label assistanceID;

    @FXML
    private static Label assistanceTime;

    @FXML
    private static TextField assistanceUrgency;

    @FXML
    private static TextArea assistanceDescription;

    @FXML
    public static void updateAssistance(){                                      //when a request menu is opened
        assistanceID.setText(Integer.toString(ID));                      //sets correct service ID
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");    //for correct time format
        assistanceTime.setText(ft.format(date));;                        //sets current time
    }

    @FXML
    public static void assistanceThisLocation() {}

    @FXML
    public static void assistanceChooseLocation() {
    }

    @FXML
    public static void assistanceSendRequest() {                              //when the Send button is pressed
        AssistanceRequest newAssist = new AssistanceRequest(null, assistanceDescription.getText(),
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
    private static TitledPane foodPane;

    @FXML
    private static Label foodID;

    @FXML
    private static Label foodTime;

    @FXML
    private static TextField foodPatient;

    @FXML
    private static TextField foodServingTime;

    @FXML
    private static TextField foodOrder;

    @FXML
    private static TextArea foodDescription;

    @FXML
    public static void updateFood(){
        foodID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        foodTime.setText(ft.format(date));;
    }

    @FXML
    public static void foodThisLocation() {}

    @FXML
    public static void foodChooseLocation() {}

    @FXML
    public static void foodSendRequest() {
        FoodRequest newFood = new FoodRequest(null, foodDescription.getText(), Integer.parseInt(foodID.getText()),
                foodTime.getText(), 00000, "food", foodPatient.getText(),
                foodServingTime.getText(), foodOrder.getText());
        requestList.addRequest(newFood);

        foodPatient.clear();
        foodServingTime.clear();
        foodOrder.clear();
        foodDescription.clear();
        ID++;
        foodPane.setExpanded(false);
    }


    //transport requests
    @FXML
    private static TitledPane transportPane;

    @FXML
    private static Label transportID;

    @FXML
    private static Label transportTime;

    @FXML
    private static TextField transportPatient;

    @FXML
    private static TextField transportType;

    @FXML
    private static TextArea transportDescription;

    @FXML
    public static void updateTransport(){
        transportID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        transportTime.setText(ft.format(date));;
    }

    @FXML
    public static void transportThisLocation() {}

    @FXML
    public static void transportChooseLocation() {}

    @FXML
    public static void transportSendRequest() {
        TransportRequest newTransport = new TransportRequest(null, transportDescription.getText(),
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
    private static TitledPane cleanPane;

    @FXML
    private static Label cleanID;

    @FXML
    private static Label cleanTime;

    @FXML
    private static TextField cleanLevel;

    @FXML
    private static TextArea cleanDescription;

    @FXML
    public static void updateClean(){
        cleanID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        cleanTime.setText(ft.format(date));
    }

    @FXML
    public static void cleanThisLocation() {}

    @FXML
    public static void cleanChooseLocation() {}

    @FXML
    public static void cleanSendRequest() {
        CleaningRequest newClean = new CleaningRequest(null, cleanDescription.getText(),
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
    private static TitledPane securityPane;

    @FXML
    private static Label securityID;

    @FXML
    private static Label securityTime;

    @FXML
    private static TextField securityLevel;

    @FXML
    private static TextArea securityDescription;

    @FXML
    public static void updateSecurity(){
        securityID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("h:mm a");
        securityTime.setText(ft.format(date));
    }

    @FXML
    public static void securityThisLocation() {}

    @FXML
    public static void securityChooseLocation() {}

    @FXML
    public static void securitySendRequest() {
        SecurityRequest newSecurity = new SecurityRequest(null, securityDescription.getText(),
                Integer.parseInt(securityID.getText()), securityTime.getText(), 00000,
                "security", Integer.parseInt(securityLevel.getText()));
        requestList.addRequest(newSecurity);

        securityLevel.clear();
        securityDescription.clear();
        ID++;
        securityPane.setExpanded(false);
    }

    @FXML
    private static Label itRequestLabel;

    @FXML
    private static TextArea itDescription;

    @FXML
    private static Button sendItRequest;

    @FXML
    private static TextField itUrgency;

    @FXML
    private static Label itID;

    @FXML
    private static Label itTime;

    @FXML
    public static Label missingField;

    @FXML
    public static void updateIt(){
        itID.setText(Integer.toString(ID));
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        itTime.setText(ft.format(date));
    }

    @FXML
    public static void itSendRequest() throws MissingFieldException{
        ItRequest newIt = new ItRequest(null, itDescription.getText(),
                Integer.parseInt(itID.getText()), itTime.getText(), 00000,
                "it", Integer.parseInt(itUrgency.getText()));
        requestList.addRequest(newIt);

        itUrgency.clear();
        itDescription.clear();
        ID++;
    }

/*
    @FXML
    private TableColumn<ServiceRequest, String> requests;

    @FXML
    private TableColumn<String, String> status;

    public void initialize(URL, url)*/
}


