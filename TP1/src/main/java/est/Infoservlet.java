package est;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hello")
public class Infoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
	        
	        PrintWriter out = res.getWriter();
	        res.setContentType("text/html; charset=UTF-8");

	        out.println("<html>");
	        out.println("<head><title>Simple Servlet</title></head>");
	        out.println("<body>");
	        out.println("<p>Protocole : " + req.getProtocol() + "</p>");
	        out.println("<p>Adresse IP du client : " + req.getRemoteAddr() + "</p>");
	        out.println("</body>");
	        out.println("</html>");

	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
