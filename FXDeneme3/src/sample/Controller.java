package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Button btnGiris;
    @FXML
    private TextField txtKad;
    @FXML
    private TextField txtSifre;
    @FXML
    private TextArea txtMesaj;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtMesaj.setText("Mehaba hoş Geldiniz. Lütfen giriş yapınız...");
    }
    @FXML
    public void btnGirisClicked(){


        if(txtKad.getText().equals("bulent") && txtSifre.getText().equals("1234")){
            txtMesaj.setText(txtKad.getText()+"\n Hoş Geldin....");

        }else {
            txtMesaj.setText("Kullanıcı adı ya da şifre Hatalı Üzgünüm....");
        }

    }

}
