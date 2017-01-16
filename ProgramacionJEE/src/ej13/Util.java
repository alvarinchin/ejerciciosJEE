package ej13;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
	
	public static void pintarFormulario(PrintWriter out) {
		out.println("<form method=\"post\" >");
		
		out.println("<label>isbn</label><br>");
		out.println("<input type=\"text\" name=\"isbn\" ><br>");
		
		out.println("<label>titulo</label><br>");
		out.println("<input type=\"text\" name=\"titulo\" ><br>");

		out.println("<label>categoria</label><br>");
		out.println("<input type=\"text\" name=\"categoria\" ><br>");

		out.println("<input type=\"submit\" value=\"Enviar\" >");

		out.println("</form>");
	}
	
	public static void pintarError(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println("Error en la base de datos");
		out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio12\">Volver</a>");
	}
	
	public static void pintarTabla(ResultSet resultado, PrintWriter out) {

		try {
			// sacamos los arrays de cada columna
			out.println("<table border=\"solid black 1px\">");
			out.println("<tr><td>isbn</td><td>Titulo</td><td>categoria</td></tr>");
			while (resultado.next()) {
				int isbn = resultado.getInt("isbn");
				String titulo = resultado.getString("titulo");
				String categoria = resultado.getString("categoria");

				out.println("<tr>");
				out.println("<td>" + isbn + "</td>");
				out.println("<td>" + titulo + "</td>");
				out.println("<td>" + categoria + "</td>");
				out.println("</tr>");

			}

			out.println("</table>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Error");
		}

	}

}
