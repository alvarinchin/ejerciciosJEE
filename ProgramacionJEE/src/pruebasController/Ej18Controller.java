package pruebasController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;



@SuppressWarnings("serial")
@WebServlet({ "/t7/ej18"
		+ "", "/t7/ej18/", "/t7/ej18/*" })
public class Ej18Controller extends Controller {
	public void saludarGet() {
		String ruta="saludar/saludar.jsp";

			this.view(ruta,false);
			
	
	}

	public void saludarPost() {
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		datos.put("nombre", nombre);
		view("saludar/saludarOK.jsp", false);

	}

	public void despedirseGet() {
		

		String ruta="despedir/despedirse.jsp";

		this.view(ruta,false);


	}

	public void despedirsePost() {
		
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		datos.put("nombre", nombre);
		view("despedir/despedirseOK.jsp", false);


		
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
