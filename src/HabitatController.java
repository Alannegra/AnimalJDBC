import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Clase HabitatController: Se encarga de controlar la tabla Animal en la base de datos.
 */
public class HabitatController {

        private Connection connection;
        private Scanner scanner;

    /**
     * Constructor AnimalController: Se encarga de construir la clase.
     * @param connection Conexión a la base de datos
     */
        public HabitatController(Connection connection) {
            this.connection = connection;
            this.scanner = new Scanner(System.in);
        }

    /**
     * Metodo consultaHabitat: Se encarga de mostrar por terminal una consulta concreta conectandose previamente a la base de datos.
     */
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
