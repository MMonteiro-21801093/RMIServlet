package example.hello;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InterfaceServlet  extends Remote {
String getDate() throws RemoteException;
}
