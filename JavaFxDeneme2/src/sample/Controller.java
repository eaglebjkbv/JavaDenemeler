package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
@FXML private Label lblDeneme;
public void Yazdir(ActionEvent event){
    lblDeneme.setText("Merhaba");
}
}
