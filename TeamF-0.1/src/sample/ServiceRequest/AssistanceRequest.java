package sample.ServiceRequest;

import javax.xml.soap.Node;

public class AssistanceRequest extends ServiceRequest {
    private int urgency;

    public AssistanceRequest(Node destination, String description, int serviceID, String serviceTime, int serviceEmployeeID, String typeOfRequest, int urgency) {
        super(destination, description, serviceID, serviceTime, serviceEmployeeID, typeOfRequest);
        this.urgency = urgency;
    }

    public int getUrgency() {
        return this.urgency;
    }

}
