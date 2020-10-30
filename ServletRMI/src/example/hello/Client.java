package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import example.hello.InterfaceServlet;

public class Client {
    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            InterfaceServlet stub = (InterfaceServlet) registry.lookup("Hello");
            String response = stub.getDate();  
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}