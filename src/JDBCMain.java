import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class JDBCMain {

	public static void main(String[] args) throws IOException, SQLException, ParseException, InterruptedException {
		JDBCMenu menu = new JDBCMenu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		TeamController teamController = new TeamController(c);
		PlayerController playerController = new PlayerController(c);
		MatchController matchController = new MatchController(c);
		BioParcController bioParcController = new BioParcController(c);
		AnimalController animalController = new AnimalController(c);
		HabitatController habitatController = new HabitatController(c);
		
//		Connection conn = null;
//		Identity identity;
//		int option;
//		int intents = 0;
//		DBAccessor dbaccessor = new DBAccessor();
//		dbaccessor.init();
//		while (intents < 3 && conn == null) {
//			identity = menu.authenticate(intents);
//			// prova de test
//			identity.toString();
//
//			conn = dbaccessor.getConnection(identity);
//			intents++;
//		}

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
					animalController.consultaDietaConcreta();;
					break;

				case 8:
					animalController.modificarNombre();
					break;

				case 9:
					habitatController.consultaHabitat();
					animalController.modificarOrdenesPorHabitat();
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
