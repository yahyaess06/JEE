package Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Metier.IclientMetier;

@WebServlet("*.wamp")
public class trtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("Dao","Metier");
		IclientMetier metier=ctx.getBean(IclientMetier.class);
		String path=request.getServletPath();
		if("/acceuil.wamp".equals(path)) {

			String like=request.getParameter("like");
			  request.setAttribute("Clients",metier.afficherdonnerClient(like) );
			request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);;
			}
		else if("/pageajoute.wamp".equals(path)) {
			request.getRequestDispatcher("/ajouter.html").forward(request, response);
		}
		else if("/ajouter.wamp".equals(path)){
			String nom =request.getParameter("nom");
			String prenom =request.getParameter("prenom");
			int ages = Integer.parseInt(request.getParameter("age"));
			  metier.creerClient(nom, prenom, ages);
			
				    response.sendRedirect("acceuil.wamp");
			}else if("/modifier.wamp".equals(path)){
				int id=Integer.parseInt(request.getParameter("id"));
				  request.setAttribute("cl",metier.afficherClientAmodifier(id) );
				request.getRequestDispatcher("/modifier.jsp").forward(request, response);
			}else if("/mod.wamp".equals(path)) {
				int idn=Integer.parseInt(request.getParameter("id"));
				String nom =request.getParameter("nom");
				String prenom =request.getParameter("prenom");
				int ages = Integer.parseInt(request.getParameter("age"));
				metier.modClient(nom, prenom, ages, idn);
						 response.sendRedirect("acceuil.wamp");
				}
			else if("/del.wamp".equals(path)) {
				int id=Integer.parseInt(request.getParameter("id"));
				metier.delClient(id);
					 response.sendRedirect("acceuil.wamp");
			}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
