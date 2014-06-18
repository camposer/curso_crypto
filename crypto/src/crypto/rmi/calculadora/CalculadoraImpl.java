package crypto.rmi.calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
	private static final long serialVersionUID = 2234187548252912589L;

	protected CalculadoraImpl() throws RemoteException {
		super();
	}

	@Override
	public Float sumar(Float a, Float b) throws RemoteException {
		return a + b;
	}

	@Override
	public Float restar(Float a, Float b) throws RemoteException {
		return a - b;
	}

	@Override
	public Float multiplicar(Float a, Float b) throws RemoteException {
		return a * b;
	}

	@Override
	public Float dividir(Float a, Float b) throws RemoteException {
		return a / b;
	}

}
