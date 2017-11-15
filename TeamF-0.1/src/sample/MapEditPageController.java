package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
public class MapEditPageController {
    @FXML
    public void editNodes(){
        Main.nodeEditScreen();
    }

    @FXML
    public void editEdges(){
        Main.edgeEditScreen();
    }

}
