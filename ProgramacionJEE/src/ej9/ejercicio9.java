package ej9;

import static prueba.ejercicio7.UtilHtml.generaSelect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javafx.scene.SubScene;

/**
 * Servlet implementation class ejercicio9
 */
@MultipartConfig(location = "d:\\alvaro\\ficheros", maxFileSize = 10485760L)
@WebServlet("/ejercicio9")
public class ejercicio9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		pintarFormulario(out);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part archivo = request.getPart("archivo");
		
		String nombre = request.getParameter("nombre");
		String nombreArchivo=nombre.length()!=0?nombre:nombreArchivo(archivo);
		archivo.write(nombreArchivo);
		doGet(request, response);
		
	}
	
	private void pintarFormulario(PrintWriter out) {
		out.println("<form method=\"post\" enctype=\"multipart/form-data\">");
		out.println("<label>Seleccionar fichero</label><br>");
		out.println("<input type=\"file\" name=\"archivo\" ><br>");

		out.println("<label>Nombre nuevo</label>");
		out.println("<input type=\"text\" name=\"nombre\" ><br>");
		
		out.println("<input type=\"submit\" value=\"Enviar\" >");

		out.println("</form>");
	}
	
	private String nombreArchivo(Part parte){
		for ( String cd: parte.getHeader("content-disposition").split(";")){
				if ( cd.trim().startsWith("filename")){
					String filename=cd.substring(cd.lastIndexOf('=')+1).trim().replace("\"", "");
					return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
				}
		}
		return null;
		
	}

}
