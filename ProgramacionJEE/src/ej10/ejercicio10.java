package ej10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejercicio10")
public class ejercicio10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		Map<String, String> usuarios = new HashMap<String, String>();
		usuarios.put("usu1", "usu1");
		usuarios.put("usu2", "usu2");
		if (comprobarUsuario(nombre, clave, usuarios)) {
			// login ok
			PrintWriter out = response.getWriter();
			Cookie[] cs = request.getCookies();

			if (cs != null && cs.length > 0) {

				long tiempo = Long.parseLong(cs[0].getValue());
		
				long ahora = new Date().getTime();
				
				
				
				if (ahora - tiempo <= 60000) {

					out.println("han pasado "+ String.valueOf((ahora-tiempo)/1000)+" segundos desde el último login<br>");
					out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio10\">Volver</a>");
					
				}else{
					out.println("ha pasado más de un minuto desde el último login<br>");
					out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio10\">Volver</a>");

					
				}
				
				cs[0].setMaxAge(-1);
				Cookie c = new Cookie("timeStamp", String.valueOf(System.currentTimeMillis()));
			} else {

				Cookie c = new Cookie("timeStamp", String.valueOf(System.currentTimeMillis()));
				response.addCookie(c);
				out.println("Primer login");
				out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio10\">Volver</a>");

			}

			// colocamos la cookie que dura 10 minuto

		} else {
			// login error
		}

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

}
