import java.sql.Connection;

public class AnimalController {
    private Connection connection;

    public AnimalController(Connection connection) {
        this.connection = connection;
    }


}
