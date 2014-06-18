package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * VM params:
 * -Djavax.net.ssl.trustStore=stores/truststore-cliente.ts -Djavax.net.ssl.trustStorePassword=123456
 * -Djavax.net.ssl.keyStore=stores/keystore-cliente.jks -Djavax.net.ssl.keyStorePassword=123456 
 */
public class CalculadoraClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("operación?");
		String operacion = scanner.nextLine();
		System.out.println("a?");
		String sa = scanner.nextLine();
		Float a = Float.parseFloat(sa);
		System.out.println("b?");
		String sb = scanner.nextLine();
		Float b = Float.parseFloat(sb);
		
		if (operacion.equals("sum") || 
				operacion.equals("res") ||
				operacion.equals("div") ||
				operacion.equals("mul")) {
			
			Registry registry = LocateRegistry
					.getRegistry("localhost", 1099);
			Calculadora calc = (Calculadora)
					registry.lookup("Calculadora");

			Float resultado = 0f;
			if (operacion.equals("sum"))
				resultado = calc.sumar(a, b);
			else if (operacion.equals("res"))
				resultado = calc.restar(a, b);
			else if (operacion.equals("mul"))
				resultado = calc.multiplicar(a, b);
			else 
				resultado = calc.dividir(a, b);
			
			System.out.println(operacion + " " + a + ", " + b + 
					" = " + resultado);
		} else {
			System.out.println("Operación inválida");
		}
	}

}
