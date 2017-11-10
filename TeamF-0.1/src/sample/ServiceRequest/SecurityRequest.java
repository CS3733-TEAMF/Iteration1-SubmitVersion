package sample.ServiceRequest;

import javax.xml.soap.Node;

public class SecurityRequest extends ServiceRequest {
    private int urgency;

    public SecurityRequest(Node destination, String description, int serviceID, int serviceTime, int serviceEmployeeID, String typeOfRequest, int urgency) {
        super(destination, description, serviceID, serviceTime, serviceEmployeeID, typeOfRequest);
        this.urgency = urgency;
    }

    public int getUrgency() {
        return this.urgency;
    }

}
