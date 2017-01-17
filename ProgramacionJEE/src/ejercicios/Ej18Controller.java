package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;



@SuppressWarnings("serial")
@WebServlet({ "/t7/ej18", "/t7/ej18/", "/t7/ej18/*" })
public class Ej18Controller extends Controller {
	public void saludarGet() {
		PrintWriter out;
		try {
			this.response.setContentType("text/html");
			out = this.response.getWriter();
			out.println("<form method=\"post\" action=\"" + this.baseURL
					+ "t7/ej18/saludar\">");

			out.println("<input type=\"text\" name=\"nombre\" >");
			out.println("<input type=\"submit\" value=\"Enviar\" >");

			out.println("</form>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saludarPost() {
		PrintWriter out;
		this.response.setContentType("text/html");
		try {
			out = this.response.getWriter();

			String nombre = this.request.getParameter("nombre");

			out.println("hola " + nombre);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void despedirseGet() {
		
		PrintWriter out;
		try {
			this.response.setContentType("text/html");
			out = this.response.getWriter();
			out.println("<form method=\"post\" action=\"" + this.baseURL
					+ "t7/ej18/despedirse\">");

			out.println("<input type=\"text\" name=\"nombre\" >");
			out.println("<input type=\"submit\" value=\"Enviar\" >");

			out.println("</form>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void despedirsePost() {
		
		PrintWriter out;
		this.response.setContentType("text/html");
		try {
			out = this.response.getWriter();

			String nombre = this.request.getParameter("nombre");

			out.println("Adios " + nombre);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void indexGet(){
		try {
			this.response.sendRedirect(this.baseURL+"t7/ej18/saludar");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
