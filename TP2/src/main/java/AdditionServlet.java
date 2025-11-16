

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Addition</title></head>");
        out.println("<body>");
        out.println("<h2>Formulaire d’addition</h2>");
        out.println("<form method='POST' action='AdditionServlet'>");
        out.println("Valeur 1: <input type='number' name='zone1'><br>");
        out.println("Valeur 2: <input type='number' name='zone2'><br>");
        out.println("<input type='submit' value='Additionner'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n1 = request.getParameter("zone1");
        String n2 = request.getParameter("zone2");
        int result = 0;

        out.println("<html>");
        out.println("<head><title>Résultat Addition</title></head>");
        out.println("<body>");
        out.println("<h2>Résultat de l’addition</h2>");

        try {
            int a = Integer.parseInt(n1);
            int b = Integer.parseInt(n2);
            result = a + b;
            out.println("<p>Résultat = " + result + "</p>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red'>Veuillez entrer deux nombres valides.</p>");
        }

  
        out.println("<form method='POST' action='AdditionServlet'>");
        out.println("Valeur 1: <input type='number' name='zone1'><br>");
        out.println("Valeur 2: <input type='number' name='zone2'><br>");
        out.println("<input type='submit' value='Additionner'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}