package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StartPageController {
    @FXML
    private TextField searchBox;

    @FXML
    public void search(){
        Main.mapScreen();
    }

    @FXML
    public void help(){
        System.out.print("Help");
    }

    @FXML
    public void login(){
        Main.loginScreen();
    }

    @FXML
    public void language(){

    }

}
