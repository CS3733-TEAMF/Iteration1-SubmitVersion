package sample.ServiceRequest;

import javax.xml.soap.Node;

public class FoodRequest extends ServiceRequest {
    public FoodRequest(Node destination, String description, int serviceID, int serviceTime, int serviceEmployeeID, String typeOfRequest) {
        super(destination, description, serviceID, serviceTime, serviceEmployeeID, typeOfRequest);
    }
    private String patientName;
    private int timeToBeServed;
    private String foodOrder;

    public FoodRequest(Node destination, String description, int serviceID, int serviceTime, int serviceEmployeeID, String typeOfRequest, String patientName, int timeToBeServed, String foodOrder) {
        super(destination, description, serviceID, serviceTime, serviceEmployeeID, typeOfRequest);
        this.patientName = patientName;
        this.timeToBeServed = timeToBeServed;
        this.foodOrder = foodOrder;
    }

    public String getPatientName() {
        return this.patientName;
    }
    public int getServingTime() {
        return this.timeToBeServed;
    }

    public String getFoodOrder() {
        return this.foodOrder;
    }

}
