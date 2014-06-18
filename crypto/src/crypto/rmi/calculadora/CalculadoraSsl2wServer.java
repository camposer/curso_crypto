package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * VM params:
 * ? 
 */
public class CalculadoraSsl2wServer {
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("Calculadora", new CalculadoraSsl2wImpl());
		System.out.println("Registro RMI iniciado...");
	}
}
