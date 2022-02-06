import com.opencsv.CSVReader;
import com.opencsv.bean.util.OpencsvUtils;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
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



    public List<String[]> oneByOne()  {
        try{
            Reader reader = Files.newBufferedReader(Paths.get("Habitat.csv"));
            List<String[]> list = new ArrayList<>();
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
            }
            for (String[] a:list) {
                System.out.println(a);
            }
            reader.close();
            csvReader.close();
            return list;
        }catch (Exception e){
            System.out.println("Error" + e);
            return null;
        }

    }

}
