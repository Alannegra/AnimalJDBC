import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AnimalController {
    private Connection connection;
    private Scanner scanner;

    public AnimalController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

   /*Seleccionar todos los elementos que contengan un texto concreto.
    Seleccionar todos los elementos que cumplan una condición.
    Seleccionar elementos concretos.*/

    public void consultaClase(){
        ResultSet rs = null;
        String sql = "SELECT distinct clase FROM animal";
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.print("| ");
            while (rs.next()) {
                System.out.print(rs.getString("clase") + " | ");
            }
            System.out.println();
            System.out.println("+----------+-----------+---------+----------+----------+------+");

            rs.close();
            st.close();
        }catch (Exception e){
            System.out.println("ERROR" + e);
        }
    }

    public void consultaOrden(){
        ResultSet rs = null;
        String sql = "SELECT distinct orden FROM animal";
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.print("| ");
            int cont = 0;
            while (rs.next()) {
                if(cont % 5 == 0){
                    System.out.println();
                    System.out.print("| ");
                }else{
                    System.out.print(rs.getString("orden") + " | ");
                }

                cont++;
            }
            System.out.println();

            rs.close();
            st.close();
        }catch (Exception e){
            System.out.println("ERROR" + e);
        }
    }

    public void consultaClaseConcreta(){
        consultaClase();
        System.out.println("Escribe la clase a mostrar: ");
        String word = scanner.nextLine();
        String str = word.toLowerCase();
        String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
        String sql = "SELECT * FROM animal where clase='" + clase + "'";
        consultaToString(sql);
    }

    public void consultaOrdenConcreta(){
        consultaOrden();
        System.out.println("Escribe el orden a mostrar: ");
        String word = scanner.nextLine();
        String str = word.toLowerCase();
        String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
        String sql = "SELECT * FROM animal where orden='" + clase + "'";
        consultaToString(sql);
    }

    public void consultaDietaConcreta(){
        System.out.println("|@#|@#|@# EJEMPLOS #@|#@|#@|");
        System.out.println("- Fruta");
        System.out.println("- Huevo");
        System.out.println("- Semilla");
        System.out.println("- Insecto");
        System.out.println("- Flor");
        System.out.println("- Raton");
        System.out.println("Escribe la palabra a contener: ");
        String word = scanner.nextLine();
        String str = word.toLowerCase();
        String sql = "SELECT * FROM animal where dieta like '%" + str + "%'";
        consultaToString2(sql);
    }

    public void consultaNombreConcreta(){
        System.out.println("Escribe un numero: ");
        String word = scanner.nextLine();
        String sql = "SELECT * FROM animal where LENGtH(nombre) <=" + word;
        consultaToString(sql);
    }

    public void consultaToString(String sql){
        ResultSet rs = null;
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("|    Nombre     |    Orden   |   Clase   |   Habitat    |   Gestacion   |   Crias   |   Vida    |");
            System.out.println("+---------------+------------+-----------+--------------+---------------+-----------+-----------+");
            while (rs.next()) {
                System.out.println("| " + rs.getString("nombre") +
                        " | " + rs.getString("orden") +
                        " | " + rs.getString("clase") +
                        " | " + rs.getString("habitat") +
                        " | " + rs.getString("gestacion") +
                        " | " + rs.getString("crias") +
                        " | " + rs.getString("vida") + " | ");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void consultaToString2(String sql){
        ResultSet rs = null;
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("|       Nombre       |                         Dieta                         | ");
            System.out.println("+--------------------+-------------------------------------------------------+");
            while (rs.next()) {
                System.out.println("| " + rs.getString("nombre") +
                        " | " + rs.getString("dieta") + " | ");
            }

            rs.close();
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }




}
