package crypto.rmi.calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

public class CalculadoraSsl1wImpl extends UnicastRemoteObject implements Calculadora {
	private static final long serialVersionUID = -9095263864501217205L;

	protected CalculadoraSsl1wImpl() throws RemoteException {
		super(
				0, 
				new SslRMIClientSocketFactory(), 
				new SslRMIServerSocketFactory()
			);
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
