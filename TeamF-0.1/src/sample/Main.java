package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

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
    public static void serviceScreen() {
        stage.setScene(service);
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
