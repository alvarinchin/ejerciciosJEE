package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ej6")
public class ej6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String[] gustos = request.getParameterValues("gustos");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (nombre != null) {
			if (gustos != null) {
				out.println("<h3>Hola " + nombre + " te gusta ");
				for (int i = 0; i < gustos.length; i++) {
					out.write(gustos[i] + ", ");
				}

			} else {
				out.println("<h3>A " + nombre + " no le gusta nada");
			}
			out.println("</h3>");
		}else {
			

			out.println("<form >" + "<input type='text' name='nombre'><br>");
			out.print("<input type='checkbox' name='gustos' value='cantar'>Cantar");
			out.print("<input type='checkbox' name='gustos' value='bailar'>Bailar");
			out.print("<input type='checkbox' name='gustos' value='cocinar'>Cocinar<br>");
			out.print("<input type='submit' value='enviar'>");
			out.print("</form>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
