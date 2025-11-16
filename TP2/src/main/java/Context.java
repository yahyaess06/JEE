

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Context
 */
@WebServlet("/Context")
public class Context extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

       
        ServletContext context = getServletContext();
        String webmaster = context.getInitParameter("webmaster");
        String email = context.getInitParameter("email");

    
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Paramètres Contexte</title></head><body>");
        out.println("<h1>Paramètres du contexte</h1>");
        out.println("<ul>");
        out.println("<li>Webmaster : " + webmaster + "</li>");
        out.println("<li>Email : " + email + "</li>");
        out.println("</ul>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}