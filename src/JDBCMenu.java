import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCMenu {
	private int option;

	public JDBCMenu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Borrar las tablas de la base de datos y su información");
			System.out.println("2. Crear las tablas de la base de datos");
			System.out.println("3. Poblar masivamente las tablas de la base de datos");
			System.out.println("4. Animales con clase a selecionar");
			System.out.println("5. Animales con orden a selecionar");
			System.out.println("6. Animales que tengan el numero de letras a selecionar");
			System.out.println("7. Animales que contengan la palabra a selecionar en la dieta");
			System.out.println("8. Modificar el nombre de un animal a selecionar");
			System.out.println("9. Modificar todas las ordenes de una clase a selecionar");
			System.out.println("10. Elimina un animal a selecionar");
			System.out.println("11. Elimina todos los animales de una clase a selecionar");
			System.out.println("12. SALIR");
			System.out.println("Esculli opció: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("valor no vàlid");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10 && option != 11 && option != 12);

		return option;
	}

	public Identity authenticate(int tries) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("============================ACB=============================");
		System.out.println("============================================================");
		System.out.println("Avís: tens " + (3 - tries) + " intents per loginarte");
		System.out.println("============================================================");
		System.out.println("Inserta nom del usuari: ");
		String user = br.readLine();
		System.out.println("Inserta contrasenya: ");
		String password = br.readLine();

		Identity identity = new Identity(user, password);
		return identity;

	}

}
