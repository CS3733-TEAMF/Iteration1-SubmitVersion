package sample.ServiceRequest;
import javax.xml.soap.Node;

public class ItRequest extends ServiceRequest{

    public ItRequest(Node destination, String description, int serviceID, String serviceTime, int serviceEmployeeID, String typeOfRequest) {
        super(destination, description, serviceID, serviceTime, serviceEmployeeID, typeOfRequest);
    }

}
