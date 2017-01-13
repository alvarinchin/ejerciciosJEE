package ej11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ejercicio11")
public class ejercicio11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		pintarFormulario(out);
		
	}

	private void pintarFormulario(PrintWriter out) {
		out.println("<form method=\"post\" >");
		out.println("<label>nombre</label><br>");
		out.println("<input type=\"text\" name=\"nombre\" ><br>");

		out.println("<label>Contraseña</label>");
		out.println("<input type=\"text\" name=\"clave\" ><br>");

		out.println("<input type=\"submit\" value=\"Enviar\" >");

		out.println("</form>");
	}

	private boolean comprobarUsuario(String nombre, String clave, Map<String, String> usuarios) {

		boolean res = false;
		if (usuarios.containsKey(nombre)) {
			if (usuarios.get(nombre).equals(clave)) {
				res = true;
			}
		}
		return res;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");

		Map<String, String> usuarios = new HashMap<String, String>();
		usuarios.put("usu1", "usu1");
		usuarios.put("usu2", "usu2");

		if (comprobarUsuario(nombre, clave, usuarios)) {
			int visitas =0;
			HttpSession sesion = request.getSession(true);
			if(sesion.getAttribute(nombre)==null){
				visitas+=1;
				sesion.setAttribute(nombre, visitas);
				
			}else{
				visitas = (int) sesion.getAttribute(nombre);
				visitas+=1;
				sesion.setAttribute(nombre,visitas);
				
			}
			out.println("bienvenido "+nombre+"<br>");
			out.println("Es tu visita número"+visitas+"<br>");
			out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio11\">Volver</a>");
			
		}else{
			
		
		out.println("ah ah ah,no has dicho la palabra mágica <br>");
		out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio11\">Volver</a>");
		}
	}

}
