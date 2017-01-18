package pruebasController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;



@SuppressWarnings("serial")
@WebServlet({ "/t7/ej18", "/t7/ej18/", "/t7/ej18/*" })
public class Ej18Controller extends Controller {
	public void saludarGet() {
	
		
			this.view("saludar/saludar.jsp",false);
	
	}

	public void saludarPost() {
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		try {
		request.getRequestDispatcher("/saludar/saludarOK.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void despedirseGet() {
		

		request.setAttribute("baseURL", this.baseURL);
		try {
		request.getRequestDispatcher("/despedir/despedirse.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void despedirsePost() {
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		try {
		request.getRequestDispatcher("/despedir/despedirseOK.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void indexGet(){
		try {
			this.response.sendRedirect(this.baseURL+"t7/ej18/saludar");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
