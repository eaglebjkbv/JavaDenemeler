package sample;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class vtBaglanti {
    private Connection conn ;

    public Connection vtBaglan(){

        String url = "jdbc:sqlite:dbdeneme";

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Veri Tabanı Bağlantısı yapıldı");
            return conn;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return conn;
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
