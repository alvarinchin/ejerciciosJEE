package ej12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

/**
 * Servlet implementation class ejercicio12
 */
@WebServlet("/ejercicio12")
public class ejercicio12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		pintarFormulario(out);

	}

	private void pintarFormulario(PrintWriter out) {
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria= request.getParameter("categoria");
		
		if(insertarEnFormulario(isbn,titulo,categoria,out)){
			response.sendRedirect("http://localhost:8080/ProgramacionJEE/ejercicio12listar");
		//request.getRequestDispatcher("http://localhost:8080/ProgramacionJEE/ejercicio12listar").forward(request, response);
		
		}else{
			pintarError(out);
		}
		
		
	}

	private void pintarError(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println("Error en la base de datos");
		out.println("<a href=\"http://localhost:8080/ProgramacionJEE/ejercicio12\">Volver</a>");
	}

	private boolean insertarEnFormulario(String isbn, String titulo,
			String categoria, PrintWriter out) {
	
	String sql = "insert into libros (isbn,titulo,categoria) values ( ?,?,?)";
	
	try {
		//cargamos el driver
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		out.println("driver");
		return false;
		
	}
	
	//conectamos con la base de datos
	
	try {
		
	Connection conector = DriverManager.getConnection("jdbc:mysql://localhost/pruebasjee", "root", "");
		
		//preparamso la consulta
		PreparedStatement ps = conector.prepareStatement(sql);
		
		//ponemos los parametros en los huecos
		ps.setInt(1, Integer.parseInt(isbn));
		ps.setString(2, titulo);
		ps.setString(3, categoria);
		
		//ejecutamos consulta
		 ps.execute();
		
	
	
		 return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		out.println("conexion");
		return false;
	}
	
	
		
		
		
		
	}

}
