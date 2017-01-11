package ej8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static prueba.ejercicio7.UtilHtml.*;

/**
 * Servlet implementation class ej8
 */
@WebServlet("/ej8")
public class ej8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
		String clave = request.getParameter("clave") != null ? request.getParameter("clave") : "";
		String pais = request.getParameter("pais") != null ? request.getParameter("pais") : "";

		if (comprobaciones(nombre,clave)) {
			pintarCorrect(out,nombre, clave, pais);
		} else {
			pintarFormulario(out, nombre, clave, pais);
		}
	}

	private void pintarCorrect(PrintWriter out,String nombre, String clave, String pais) {
		
		out.println("<h1>Formulario correcto</h1><br>\n");
		out.println("<h1>nombre: "+nombre+"</h1><br>\n");
		out.println("<h1>Clave: "+clave+"</h1><br>\n");
		out.println("<h1>País: "+pais+"</h1><br>\n");
		
	}

	private boolean comprobaciones(String nombre, String clave) {
		boolean res= false;
		
		if (nombre.length()>0&& nombre!=null){
			if(clave!=null && clave.length()>5 && clave.length()<13 ){
				res=true;
			}
		}
		return res;
	}

	private void pintarFormulario(PrintWriter out, String nombre, String clave, String pais) {
		out.println("<form>");
		out.println("<label>nombre</label>");
		out.println("<input type=\"text\" name=\"nombre\" value=\"" + nombre + "\" ><br>");

		out.println("<label>clave</label>");
		out.println("<input type=\"password\" name=\"clave\" value=\"" + clave + "\" ><br>");

		Map<String, String> lista = new HashMap<String, String>();

		lista.put("E", "España");
		lista.put("I", "Italia");
		lista.put("F", "Francia");
		lista.put("P", "Portugal");

		out.print(generaSelect("pais", lista, pais) + "<br>");

		out.println("<input type=\"submit\" value=\"Enviar\" >");

		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
