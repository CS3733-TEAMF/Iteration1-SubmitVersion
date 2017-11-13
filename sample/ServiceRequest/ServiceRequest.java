package sample.ServiceRequest;

import javax.xml.soap.Node;

//Talal and willis
public abstract class ServiceRequest {

    protected Node destination;
    protected String description;
    protected int serviceID;
    protected String serviceTime;
    protected int serviceEmployeeID;
    protected String typeOfRequest;

    public ServiceRequest(Node destination, String description, int serviceID, String serviceTime, int serviceEmployeeID, String typeOfRequest) {
        this.destination = destination;
        this.description = description;
        this.serviceID = serviceID;
        this.serviceTime = serviceTime;
        this.serviceEmployeeID = serviceEmployeeID;
        this.typeOfRequest = typeOfRequest;
    }

    public void setServiceEmployeeID(int a) {
        return;
    }
    public Node getDestination() {
        return this.destination;
    }
    public String getDescription() {
        return this.description;
    }

    public int getServiceID() {
        return this.serviceID;
    }
    public String getServiceTime() {
        return this.serviceTime;
    }
    public int getServiceEmployeeID() {
        return this.serviceEmployeeID;
    }
    public String getTypeInt() {
        return this.typeOfRequest;
    }





}



