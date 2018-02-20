package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.print.Book;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button btnKaydet;
    @FXML
    private Button btnListele;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private TableView<BenimModel> tblListe;
    private ObservableList<BenimModel> data=FXCollections.observableArrayList();

    public void setBtnListele_Click(){

        vtBaglanti baglanti=new vtBaglanti();
        String sql = "SELECT * FROM tblOgrenci";
        try {
        Statement stmt  = baglanti.conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);

            TableColumn titleCol1 = new TableColumn("Numara");
            titleCol1.setCellValueFactory(new PropertyValueFactory<BenimModel, Integer>("id"));
            titleCol1.setMaxWidth(50);
            TableColumn titleCol2 = new TableColumn("Adı");
            titleCol2.setCellValueFactory(new PropertyValueFactory<BenimModel, String>("ad"));
            titleCol2.setMaxWidth(100);
            TableColumn titleCol3 = new TableColumn("Soyadı");
            titleCol3.setCellValueFactory(new PropertyValueFactory<BenimModel, String>("soyad"));
            titleCol3.setMaxWidth(100);
            tblListe.setEditable(true);
            tblListe.getColumns().setAll(titleCol1,titleCol2, titleCol3);
            tblListe.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



            while (rs.next()) {

                BenimModel person=new BenimModel(rs.getInt("id"),rs.getString("ad"),rs.getString("soyad"));

                data.add(person);

                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("ad") + "\t" +
                        rs.getString("soyad"));

            }
            tblListe.setItems(data);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            baglanti.vtBaglantiKapat(baglanti.conn);
            System.out.println("Bağlantı Kapatıldı....");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
