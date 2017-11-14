package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

public class Main extends Application {

    private static Stage stage;
    private static Scene start;
    private static Scene login;
    private static Scene map;
    private static Scene admin;
    private static Scene service;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        start = new Scene(FXMLLoader.load(getClass().getResource("UI/StartPage.fxml")), 1024, 768);
        login = new Scene(FXMLLoader.load(getClass().getResource("UI/Login.fxml")), 640, 480);
        map = new Scene(FXMLLoader.load(getClass().getResource("UI/NavigationScreen.fxml")), 1024, 768);
        admin = new Scene(FXMLLoader.load(getClass().getResource("UI/AdminControls.fxml")), 1024, 768);
        service = new Scene(FXMLLoader.load(getClass().getResource("UI/Service_Request_Menu.fxml")), 1024, 768);
        //Parent root = FXMLLoader.load(getClass().getResource("UI/StartPage.fxml"));
        stage.setTitle("Team F Hospital GPS");
        stage.setScene(start);
        //primaryStage.setFullScreen(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void loginScreen(){
        stage.setScene(login);
        stage.centerOnScreen();
    }

    public static void startScreen(){
        stage.setScene(start);
        stage.centerOnScreen();
    }

    public static void mapScreen(){
        stage.setScene(map);
        stage.centerOnScreen();
    }

    public static void adminScreen(){
        stage.setScene(admin);
        stage.centerOnScreen();
    }

    public static void serviceScreen(){
        stage.setScene(service);
        stage.centerOnScreen();
    }

    public static void main(String[] args) throws IOException{
        Vector<Node> Vec = new Vector<Node>(10);
        Node n1 = new Node("FDEPT00101", 1614, 829, 1, "Tower", "DEPT", "Center for International Medecine", "CIM", 'F');
        Vec.addElement(n1);
        Node n2 = new Node("FHALL00201", 1640, 850, 1, "Tower", "HALL", "Chapel Hall Point 1", "CHP1", 'F');
        Vec.addElement(n2);
        Node n3 = new Node("FHALL00301", 1788, 850, 1, "Tower", "HALL", "Chapel Hall Point 2", "CHP2", 'F');
        Vec.addElement(n3);
        Node n4 = new Node("FHALL00701", 1759, 900, 1, "Tower", "HALL", "Chapel Hall Entrance", "CHE", 'F');
        Vec.addElement(n4);
        Node n5 = new Node("FHALL01301", 1760, 952, 1, "Tower", "HALL", "International Hall Point 2", "IHP2", 'F');
        Vec.addElement(n5);
        Node n6 = new Node("FSERV00101", 1724, 930, 1, "Tower", "SERV", "Multifaith Chapel", "MFC", 'F');
        Vec.addElement(n6);

        Vector<Node> InverseVec = new Vector<Node>(10);
        InverseVec.addElement(n6);
        InverseVec.addElement(n5);
        InverseVec.addElement(n4);
        InverseVec.addElement(n3);
        InverseVec.addElement(n3);
        InverseVec.addElement(n2);
        InverseVec.addElement(n1);

        //System.out.print(NavigationPageController.directions(Vec));
        //System.out.print(NavigationPageController.directions(InverseVec));

        NavigationPageController controller = new NavigationPageController();
        //controller.drawDirections(Vec);
        launch(args);
    }
}
