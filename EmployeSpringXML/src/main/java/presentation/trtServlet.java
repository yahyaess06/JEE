package presentation;
import jakarta.servlet.ServletException;

import Metier.IEmpMetier;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("*.do")
public class trtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public trtServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		System.out.print("path");
		if("/accueil.do".equals(path)) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		else  if("/trtServlet.do".equals(path)){
		int id=Integer.parseInt(request.getParameter("id"));
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		IEmpMetier metier=ctx.getBean(IEmpMetier.class);
		request.setAttribute("emp",metier.calculerPrime(id));
		request.getRequestDispatcher("/rslt.jsp").forward(request, response);
		} 

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
