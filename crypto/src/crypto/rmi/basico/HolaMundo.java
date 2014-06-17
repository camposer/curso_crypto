package crypto.rmi.basico;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HolaMundo extends Remote {
	public String saludar(String nombre) 
			throws RemoteException;
}
