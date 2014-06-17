package crypto.rmi.basico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HolaMundoImpl 
		extends UnicastRemoteObject
		implements HolaMundo {

	private static final long serialVersionUID = -8640543014075504394L;

	protected HolaMundoImpl() throws RemoteException {
		super();
	}

	@Override
	public String saludar(String nombre) 
			throws RemoteException {

		return "Hola " + nombre;
	}

}
