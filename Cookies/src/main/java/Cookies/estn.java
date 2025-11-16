package Cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/estn")
public class estn extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String color = request.getParameter("color");
String pcolor = request.getParameter("colorp");
String lprefere = request.getParameter("type");
int num = Integer.parseInt(request.getParameter("numero"));

 Cookie c = new Cookie("color",color); 
 response.addCookie(c);
 Cookie c1 = new Cookie("pcolor",pcolor);
 response.addCookie(c1);
 Cookie c2 = new Cookie("lprefere",lprefere);
 response.addCookie(c2);
 Cookie c3 = new Cookie("num",""+num);
 response.addCookie(c3);
 PrintWriter out = response.getWriter();
 
 out.println("<html><body>");
 out.println("<h1 align='center'>votre infos sont enregistrees "
 		+ "vous pouvais acceder a la page d'accuille en cliquant sur"
 		+ "le lien suivant !! </h1>");
 out.println("<a href='acceuil'>accueil</a>");
 out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
