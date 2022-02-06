import com.opencsv.CSVReader;
import com.opencsv.bean.util.OpencsvUtils;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BioParcController {
    private Connection connection;

    public BioParcController(Connection connection) {
        this.connection = connection;
    }

        public void borrarTablas(){
                try {
                    Statement st = connection.createStatement();
                    st.executeUpdate("DROP table animal");
                    st.executeUpdate("DROP table habitat");
                    st.close();
                    System.out.println("Tablas Borradas con Exito");

                } catch (SQLException  e){
                    System.out.println("ERROR " + e);
            }
        }

        public void crearTablas(){
            try {
                Statement st = connection.createStatement();
                st.executeUpdate("CREATE TABLE habitat (\n" +
                        "id int GENERATED ALWAYS AS IDENTITY,\n" +
                        "habitat text NOT NULL,\n" +
                        "description text  NOT NULL,\n" +
                        "CONSTRAINT  habitat_habitat UNIQUE (habitat),\n" +
                        "CONSTRAINT habitat_id PRIMARY KEY (id));\n");

                st.executeUpdate("CREATE TABLE animal (\n" +
                        "id int GENERATED ALWAYS AS IDENTITY,\n" +
                        "nombre text  NOT NULL,\n" +
                        "especie text  NOT NULL,\n" +
                        "familia text  NOT NULL,\n" +
                        "orden text  NOT NULL,\n" +
                        "clase text  NOT NULL,\n" +
                        "habitat text  NOT NULL REFERENCES habitat(habitat),\n" +
                        "dieta text  NOT NULL,\n" +
                        "gestacion text  NOT NULL,\n" +
                        "crias text  NOT NULL,\n" +
                        "vida text  NOT NULL,\n" +
                        "CONSTRAINT animal_name UNIQUE (nombre),\n" +
                        "CONSTRAINT animal_id PRIMARY KEY (id));\n");
                st.close();
                System.out.println("Tablas Creadas con Exito");

            } catch (SQLException  e) {
                System.out.println("ERROR " + e);
            }
        }

    public void poblarTablas()  {
        int num = 0 ;
        int num2 = 0 ;
        try{
            Reader reader = Files.newBufferedReader(Paths.get("Habitat.csv"));
            List<String[]> list = new ArrayList<>();
            CSVReader csvReader = new CSVReader(reader);
            String[] line;

            Reader reader2 = Files.newBufferedReader(Paths.get("Animal.csv"));
            List<String[]> list2 = new ArrayList<>();
            CSVReader csvReader2 = new CSVReader(reader2);
            String[] line2;

            while ((line = csvReader.readNext()) != null) {
                if(num > 0){
                    list.add(line);
                    String sql = "INSERT INTO habitat (habitat,description) VALUES (?,?)";

                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, line[0]);
                    pst.setString(2, line[1]);

                    pst.executeUpdate();

                    pst.close();
                }
                num++;
            }
            while ((line2 = csvReader2.readNext()) != null) {
                if(num2 > 0){
                    list2.add(line2);
                    String sql = "INSERT INTO animal (nombre, especie, familia, orden, clase, habitat, dieta, gestacion, crias, vida) VALUES (?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, line2[0]);
                    pst.setString(2, line2[1]);
                    pst.setString(3, line2[2]);
                    pst.setString(4, line2[3]);
                    pst.setString(5, line2[4]);
                    pst.setString(6, line2[5]);
                    pst.setString(7, line2[6]);
                    pst.setString(8, line2[7]);
                    pst.setString(9, line2[8]);
                    pst.setString(10, line2[9]);

                    pst.executeUpdate();
                    pst.close();
                }
                num2++;
            }

            for (String[] a:list) {
                System.out.println(a[0]);
            }
            System.out.println(num-1);

            for (String[] a:list2) {
                System.out.println(a[0]);
            }
            System.out.println(num2-1);

            reader.close();
            csvReader.close();

            reader2.close();
            csvReader2.close();


        }catch (Exception e){
            System.out.println("Error" + e);
        }


    }

}
