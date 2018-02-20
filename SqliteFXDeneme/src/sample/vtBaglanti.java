package sample;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class vtBaglanti {
    public static Connection conn = null;
    public vtBaglanti() {

        String url = "jdbc:sqlite:dbdeneme";

    try {
        conn = DriverManager.getConnection(url);
        System.out.println("Veri Tabanı Bağlantısı yapıldı");


    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
//   finally {
//        try {
//            if (conn != null) {
//               conn.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
    public void vtBaglantiKapat(Connection conn) throws SQLException {
            conn.close();
        }




}
