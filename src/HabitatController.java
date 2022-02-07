import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HabitatController {

        private Connection connection;
        private Scanner scanner;

        public HabitatController(Connection connection) {
            this.connection = connection;
            this.scanner = new Scanner(System.in);
        }

        public void consultaHabitat(){
            ResultSet rs = null;
            String sql = "SELECT distinct habitat FROM habitat";
            try{
                Statement st = connection.createStatement();
                rs = st.executeQuery(sql);
                System.out.print("| ");
                while (rs.next()) {
                    System.out.print(rs.getString("habitat") + " | ");
                }
                System.out.println();
                System.out.println("+----------------------------------------+-----------------+-------------------+--------------------+");

                rs.close();
                st.close();
            }catch (Exception e){
                System.out.println("ERROR" + e);
            }
        }




}
