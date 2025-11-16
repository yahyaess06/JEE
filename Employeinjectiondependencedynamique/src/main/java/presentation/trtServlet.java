package presentation;
import jakarta.servlet.ServletException;
import Dao.EmployeIDAO;
import Dao.EmployeIMPL;
import Metier.EmpMetier;
import Metier.IEmpMetier;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

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
		//EmployeIMPL dao= new EmployeIMPL();
		try {
		ClassLoader cl= Thread.currentThread().getContextClassLoader();
		InputStream i= cl.getResourceAsStream("config.txt");
		Scanner sc= new Scanner(i);
		String daoCnom=sc.next();
		Class cdao=Class.forName(daoCnom);
		EmployeIDAO dao=(EmployeIDAO) cdao.getConstructor().newInstance();
		
		//EmpMetier metier = new EmpMetier();
		String metierCnom=sc.next();
		Class cmetier=Class.forName(metierCnom);
		IEmpMetier metier= (IEmpMetier) cmetier.getConstructor().newInstance();
		
		//metier.setDao(dao);
		Method meth=cmetier.getMethod("setDao", new Class[] {EmployeIDAO.class});
		meth.invoke(metier, new Object[] {dao});
		request.setAttribute("emp",metier.calculerPrime(id));
		request.getRequestDispatcher("/rslt.jsp").forward(request, response);
		}catch(Exception e) {
		 e.printStackTrace();
		}
		} 

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
