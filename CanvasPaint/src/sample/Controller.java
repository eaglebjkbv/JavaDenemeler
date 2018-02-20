package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Canvas cizimAlani;
    @FXML
    private ColorPicker renkSecimi;
    @FXML
    private Slider cizgiKalinligi;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext g=cizimAlani.getGraphicsContext2D();
        renkSecimi.setValue(Color.rgb(50,10,10));
        cizimAlani.setStyle("-fx-background-color: red");
        cizimAlani.setOnMouseDragged(e->{
            double boyut=cizgiKalinligi.getValue();
            double posX=e.getX();
            double posY=e.getY();


            g.setFill(renkSecimi.getValue());
            g.fillRect(posX ,posY ,boyut,boyut);
                }
        );


    }
}
