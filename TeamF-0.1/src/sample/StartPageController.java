package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StartPageController {
    @FXML
    private TextField searchBox;

//    @FXML
//    private ChoiceBox langbox;
    @FXML
    public void search(){
        System.out.print(searchBox.getText());
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
