package ej12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejercicio12listar
 */
@WebServlet("/ejercicio12listar")
public class ejercicio12listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ResultSet resultado = selectDB();

		pintarTabla(resultado, out);

	}

	private void pintarTabla(ResultSet resultado, PrintWriter out) {

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

	private ResultSet selectDB() {
		
		String sql = "select * from libros";

		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// conectamos con la base de datos

		try {

			java.sql.Connection conector = DriverManager.getConnection(
					"jdbc:mysql://localhost/pruebasjee", "root", "");

			// preparamso la consulta
			PreparedStatement ps = conector.prepareStatement(sql);

			// ejecutamos consulta
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}

}
