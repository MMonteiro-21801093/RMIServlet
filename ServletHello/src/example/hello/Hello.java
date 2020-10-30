package example.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static InterfaceServlet stub = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }
public String getDate() {
	 Date date = new Date();
	return date.toString();
}
protected void getRegistryStub(String name) {
	try {
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
	    stub = (InterfaceServlet) registry.lookup(name);
	}catch(Exception e) {
		  System.err.println( e.getMessage());
	}
	
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getRegistryStub("Hello");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = stub.getDate();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" +"Hello" + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + msg + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
