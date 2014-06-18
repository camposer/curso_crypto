package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraServer {
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("Calculadora", new CalculadoraImpl());
		System.out.println("Registro RMI iniciado...");
	}
}
