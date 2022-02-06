import java.sql.Connection;
import java.util.Scanner;

public class HabitatController {

        private Connection connection;
        private Scanner scanner;

        public HabitatController(Connection connection) {
            this.connection = connection;
            this.scanner = new Scanner(System.in);
        }


}
