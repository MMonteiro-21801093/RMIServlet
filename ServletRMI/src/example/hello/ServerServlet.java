package example.hello;

 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
 
public class ServerServlet implements InterfaceServlet {
	
public ServerServlet() {}
	

	public String getDate() {
		 Date date = new Date();
		return date.toString();
	}
	private static Registry newRegistry(int port) throws RemoteException{
		LocateRegistry.createRegistry(port);
		Registry reg = LocateRegistry.getRegistry(port);
		return reg;
	}
    public static void main(String args[]) {
            int port = 1099;
        try {
        	ServerServlet obj = new ServerServlet();
        	InterfaceServlet stub = (InterfaceServlet) UnicastRemoteObject.exportObject(obj, 0);


           Registry registry = newRegistry(port);

            registry.bind("Hello", stub);
            
            
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
