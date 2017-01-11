package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombreASaludar = request.getParameter("nombre");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (nombreASaludar == null) {

			
			out.println("<form >" + "<input type='text' name='nombre'>"
					+ "<input type='submit' value='enviar'>");
			
		
		out.write("</form>");
		}
		else{
			
			out.println("<h1>Hola "+nombreASaludar+"</h1>");
		}
	}

}