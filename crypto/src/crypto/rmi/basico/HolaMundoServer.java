package crypto.rmi.basico;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HolaMundoServer {
	public static void main(String[] args) throws Exception {
		// 1.- Creando el registro RMI
		Registry registry = LocateRegistry.createRegistry(1099); 
	
		// 2.- Creando el objeto remoto a publicar
		HolaMundo holaMundo = new HolaMundoImpl();
		
		// 3.- Publicando objeto remoto
		registry.rebind("HolaMundo", holaMundo);
		System.out.println("Registro RMI iniciado...");
	}
}
