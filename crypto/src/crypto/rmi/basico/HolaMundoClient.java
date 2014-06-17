package crypto.rmi.basico;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HolaMundoClient {
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry
				.getRegistry("localhost", 1099);
		
		HolaMundo holaMundo = (HolaMundo)
				registry.lookup("HolaMundo");
		String mensaje = holaMundo.saludar("Rodolfo");
		System.out.println(mensaje);
	}
}
