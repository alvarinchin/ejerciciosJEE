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
    public ej8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<form>");
		out.println("<label>nombre</label>");
		out.println("<input type=\"text\" name=\"nombre\" ><br>");
		
		out.println("<label>clave</label>");
		out.println("<input type=\"password\" name=\"pass\" ><br>");
		
		Map <String,String> lista= new HashMap <String,String>();
		
		lista.put("E","España" );
		lista.put("I","Italia" );
		lista.put("F","Francia" );
		lista.put("P","Portugal" );
		
		
		out.print(generaSelect("pais", lista, "España")+"<br>");
		
		out.println("<input type=\"submit\" value=\"Enviar\" >");
		
		
		
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
