package ej13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static ej13.Util.*;
import static ej13.LibroDAO.*;

/**
 * Servlet implementation class Ejercicio13
 */
@WebServlet("/Ejercicio13")
public class Ejercicio13 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			pintarFormulario(out);	
			
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria= request.getParameter("categoria");
		
		if( insertarEnFormulario(isbn,titulo,categoria)){
			response.sendRedirect("http://localhost:8080/ProgramacionJEE/ejercicio13listar");
		
		}else{
			pintarError(out);
		}
	}

}
