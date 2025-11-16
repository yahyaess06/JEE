

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	   public void service(ServletRequest req, ServletResponse res)
	            throws ServletException, IOException {

	        res.setContentType("text/html");
	        PrintWriter out = res.getWriter();

	        out.println("<!DOCTYPE html>");
	        out.println("<html><head><title>SimpleServlet</title></head><body>");
	        out.println("<h1>Bonjour depuis SimpleServlet !</h1>");
	        out.println("<p>Ceci est une servlet simple qui affiche du texte en HTML.</p>");
	        out.println("</body></html>");
	    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
