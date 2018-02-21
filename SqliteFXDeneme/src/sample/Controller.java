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
import java.sql.Connection;
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
    @FXML
    private TableView<BenimModel> tblListe;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private ObservableList<BenimModel> data=FXCollections.observableArrayList();
    private vtBaglanti baglanti=new vtBaglanti();
    private Connection conn=null;
    public void setBtnListele_Click(){

        this.conn=baglanti.vtBaglan();
        String sql = "SELECT * FROM tblOgrenci";
        try {
            Statement stmt  = this.conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
    // Tablo Sütunlarını Hazırlama .......
            TableColumn titleCol1 = new TableColumn("Numara");
            titleCol1.setCellValueFactory(new PropertyValueFactory<BenimModel, Integer>("id"));
            titleCol1.setMaxWidth(50);
            TableColumn titleCol2 = new TableColumn("Adı");
            titleCol2.setCellValueFactory(new PropertyValueFactory<BenimModel, String>("ad"));
            titleCol2.setMaxWidth(100);
            TableColumn titleCol3 = new TableColumn("Soyadı");
            titleCol3.setCellValueFactory(new PropertyValueFactory<BenimModel, String>("soyad"));
            titleCol3.setMaxWidth(100);
     // Tablo Sütunlarını TableView e ekleme
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
            baglanti.vtBaglantiKapat(this.conn);
            System.out.println("Bağlantı Kapatıldı....");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
