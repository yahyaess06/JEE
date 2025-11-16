package estn.MaServlet;

import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	        PrintWriter out = response.getWriter();
	        
	        out.println("<html><body>");
	        out.println("<h1 align='center'>Bonjour le monde</h1>");
	        out.println("<h1 align='center'>"+ LocalDate.now()+"</h1>");
	        out.println("</body></html>");
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}