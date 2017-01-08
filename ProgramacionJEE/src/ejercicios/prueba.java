package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/prueba")
public class prueba extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	 
	 out.println("<form method='post'>nombre<input type='text' name='nombre'><br><h2>Aficiones</h2><br>Cantar<input type='radio' name='aficion' value='cantar'>Bailar<input type='radio' name='aficion' value='bailar'><input type='submit' value='enviar'></form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aficion = request.getParameter("aficion");
		String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("Hola "+nombre+", te gusta "+aficion);
		}

}
