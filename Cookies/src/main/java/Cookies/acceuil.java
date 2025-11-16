package Cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/acceuil")
public class acceuil extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String color = null;
		String pcolor =null;
		String lprefere  = null;
		int num =0;
		if(cookies != null) {
		for(int i=0;i<cookies.length;i++) {
		if(cookies[i].getName().equals("color")) {
			color=cookies[i].getValue();
		}
		if(cookies[i].getName().equals("pcolor")) {
			pcolor=cookies[i].getValue();
		}
		if(cookies[i].getName().equals("lprefere")) {
			lprefere=cookies[i].getValue();
		}
		if(cookies[i].getName().equals("num")) {
			num=Integer.parseInt(cookies[i].getValue());
		}
		}
		}
		if(color==null && pcolor==null && lprefere==null && num==0) {
			response.sendRedirect(request.getContextPath()+"/index.html");
		}else {
		
		 PrintWriter out = response.getWriter();
		 
		 out.println("<html><body bgcolor="+color+">");
		 out.println("<p style=\"color: "+pcolor+"\">Texte en "+pcolor+"</p>");
		 if(lprefere=="programmation") {
		 out.println("<ul> "
		 		+ "<li style=\"color: "+pcolor+"\">le guide en cybersecurity</li>"
		 		+ "<li style=\"color: "+pcolor+"\">Programmer en java</li>"
		 		+ " </ul>");
		 }
		 else {
			 out.println("<ul> "
			 		+ "<li style=\"color: "+pcolor+"\">Droit du Maroc</li>"
			 		+ "<li style=\"color: "+pcolor+"\">Droit bancaire marocain</li>"
			 		+ " </ul>");
		 }
		 out.println("<p style=\"color: "+pcolor+"\">votre nombre preferee est "+num+"</p>");
		 out.println("</body></html>");
	}}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
