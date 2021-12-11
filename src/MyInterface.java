import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    String reverse(String msg) throws RemoteException;
    Character minChar(String msg) throws RemoteException;
    String CaseChanger(String msg) throws RemoteException;
}
