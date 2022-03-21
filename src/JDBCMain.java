import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Clase JDBCMain: Se encarga de manejar el panel de control gracias al switch.
 */
public class JDBCMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException, InterruptedException {
		JDBCMenu menu = new JDBCMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();


		BioParcController bioParcController = new BioParcController(c);
		AnimalController animalController = new AnimalController(c);
		HabitatController habitatController = new HabitatController(c);


		int option = menu.mainMenu();
		while (option > 0 && option < 12) {
			switch (option) {
				case 1:
					bioParcController.borrarTablas();
					//Thread.sleep(2222);
					break;

				case 2:
					bioParcController.crearTablas();
					//Thread.sleep(2222);
					break;

				case 3:
					bioParcController.poblarTablas();
					//Thread.sleep(2222);
					break;

				case 4:
					animalController.consultaClaseConcreta();
					// dbaccessor.altaAutor();
					break;

				case 5:
					animalController.consultaOrdenConcreta();
					// dbaccessor.altaRevista();
					break;

				case 6:
					animalController.consultaNombreConcreta();
					// dbaccessor.altaArticle();
					break;

				case 7:
					animalController.consultaDietaConcreta();
					break;

				case 8:
					animalController.modificarNombre();
					break;

				case 9:
					habitatController.consultaHabitat();
					animalController.modificarClasesPorHabitat();
					break;

				case 10:
					animalController.eliminarAnimal();
					break;

				case 11:
					animalController.eliminarAnimalesPorClase();
					break;

				case 12:
					System.out.println("ADIOS!");
					c.close();
					System.exit(0);
					break;

				default:
					System.out.println("Introdueixi una de les opcions anteriors");
					break;

			}
			option = menu.mainMenu();
		}

	}

}
