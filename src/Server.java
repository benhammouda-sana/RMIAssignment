import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    @Override
    public String reverse(String msg)throws RemoteException {
        String revMsg = "";
        for(int i=msg.length()-1;i>=0;i--){
            revMsg = revMsg + msg.charAt(i);
        }
        return revMsg;
    }

    @Override
    public Character minChar(String msg) throws RemoteException{
        int minVal = 256;
        Character minCh = ' ';
        for(int i=0;i<msg.length();i++){
            int asciiVal = (int) msg.charAt(i);
            if (asciiVal<minVal){
                minCh = msg.charAt(i);
                minVal  = (int) msg.charAt(i);
            }
        }
        return minCh;
    }

    @Override
    public String CaseChanger(String msg) throws RemoteException{
        char[] chars = msg.toCharArray();
        for(int i=0;i<chars.length;i++){
            if (Character.isUpperCase(msg.charAt(i))){
                chars[i] = Character.toLowerCase(msg.charAt(i));
            }else if(Character.isLowerCase(msg.charAt(i))){
                chars[i] = Character.toUpperCase(msg.charAt(i));
            }
        }
        return String.valueOf(chars);
    }

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }
}
