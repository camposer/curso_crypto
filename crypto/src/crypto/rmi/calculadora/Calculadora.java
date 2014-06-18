package crypto.rmi.calculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
	public Float sumar(Float a, Float b) throws RemoteException;
	public Float restar(Float a, Float b) throws RemoteException;
	public Float multiplicar(Float a, Float b) throws RemoteException;
	public Float dividir(Float a, Float b) throws RemoteException;
}
