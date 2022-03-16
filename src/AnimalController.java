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


    /**
     * Metodo consultaClase: Se encarga de mostrar por terminal una consulta concreta conectandose previamente a la base de datos.
     */

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

    /**
     * Metodo consultaOrden: Se encarga de mostrar por terminal una consulta concreta conectandose previamente a la base de datos.
     */

    public void consultaOrden(){
        ResultSet rs = null;
        String sql = "SELECT distinct orden FROM animal";
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);

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

    /**
     * Metodo consultaNombre: Se encarga de mostrar por terminal una consulta concreta conectandose previamente a la base de datos.
     */

    public void consultaNombre(){
        ResultSet rs = null;
        String sql = "SELECT id,nombre FROM animal";
        try{
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(" | " + rs.getString("id") + " | " + rs.getString("nombre") + " | ");
            }

            rs.close();
            st.close();
        }catch (Exception e){
            System.out.println("ERROR" + e);
        }
    }

    /**
     * Metodo consultaClaseConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la clase del animal conectandose previamente a la base de datos.
     */

    public void consultaClaseConcreta(){
        consultaClase();
        System.out.println("Escribe la clase a mostrar: ");
        String word = scanner.nextLine();
        String str = word.toLowerCase();
        String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
        String sql = "SELECT * FROM animal where clase='" + clase + "'";
        consultaToString(sql);
    }

    /**
     * Metodo consultaClaseConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la orden del animal conectandose previamente a la base de datos.
     */

    public void consultaOrdenConcreta(){
        consultaOrden();
        System.out.println("Escribe el orden a mostrar: ");
        String word = scanner.nextLine();
        String str = word.toLowerCase();
        String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
        String sql = "SELECT * FROM animal where orden='" + clase + "'";
        consultaToString(sql);
    }

    /**
     * Metodo consultaDietaConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente la dieta del animal conectandose previamente a la base de datos.
     */

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

    /**
     * Metodo consultaNombreConcreta: Se encarga de mostrar por terminal la consulta deseada escribiendo en el terminal previamente el nombre del animal conectandose previamente a la base de datos.
     */

    public void consultaNombreConcreta(){
        System.out.println("Escribe un numero: ");
        String word = scanner.nextLine();
        String sql = "SELECT * FROM animal where LENGtH(nombre) <=" + word;
        consultaToString(sql);
    }

    /**
     * Metodo modificarNombre: Se encarga de brindarnos la posibilidad de modificar por terminal el nombre deseado escribiendo en el terminal el nombre del animal conectandose previamente a la base de datos.
     */

    public void modificarNombre(){
        try {
            consultaNombre();
            Statement st = connection.createStatement();
            System.out.println("Escribe el numero de la id");
            String word = scanner.nextLine();
            System.out.println("Escribe el nuevo nombre: ");
            String word2 = scanner.nextLine();
            st.executeUpdate("update animal set nombre='" + word2 + "' where id=" + word );
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo modificarOrdenesPorHabitat: Se encarga de brindarnos la posibilidad de modificar por terminal el orden animal deseado escribiendo en el terminal el orden animal conectandose previamente a la base de datos.
     */

    public void modificarOrdenesPorHabitat() {
        try {
            consultaClase();
            Statement st = connection.createStatement();
            System.out.println("Escribe el habitat de los animales a modificar: ");
            String word = scanner.nextLine().toUpperCase();
            System.out.println("Escribe el orden a modificar: ");
            String word2 = scanner.nextLine();

            st.executeUpdate("update animal set orden='" + word2 + "' where habitat='" + word + "'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo eliminarAnimal: Se encarga de brindarnos la posibilidad de eliminar por terminal un animal deseado escribiendo en el terminal el nombre del animal conectandose previamente a la base de datos.
     */

    public void eliminarAnimal() {
        try {
            consultaNombre();
            Statement st = connection.createStatement();
            System.out.println("Escribe el numero de la id");
            String word = scanner.nextLine();
            st.executeUpdate("delete from animal where id=" + word);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo eliminarAnimalesPorClase: Se encarga de brindarnos la posibilidad de eliminar por terminal toddos los animales deseados escribiendo en el terminal la clase del animal conectandose previamente a la base de datos.
     */

    public void eliminarAnimalesPorClase() {
        try {
            consultaClase();
            Statement st = connection.createStatement();
            System.out.println("Escribe la clase: ");
            String word = scanner.nextLine();
            String str = word.toLowerCase();
            String clase = str.substring(0, 1).toUpperCase() + str.substring(1);
            st.executeUpdate("delete from animal where clase='" + clase +"'");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo consultaToString: Se encarga de mostrar por pantalla de una manera mas visual la respuesta a nuestro parametro que es una consulta
     * @param sql Sentencia sql
     */

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

    /**
     * Metodo consultaToString2: Se encarga de mostrar por pantalla de una manera mas visual la respuesta a nuestro parametro que es una consulta
     * @param sql Sentencia sql
     */

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
