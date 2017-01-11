package prueba.ejercicio7;
import static prueba.ejercicio7.UtilHtml.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ej7")
public class ej7 extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> lista = new HashMap <String,String>();
		lista.put("b","bailar" );
		lista.put("c","cantar" );
		lista.put("co","comer" );
		lista.put("i","ir al cine" );
		 
		response.setContentType("text/html");

		String[] select = {"comer","cantar"};
		
		response.getWriter().println(generaRadio("aficiones", lista,"comer"));
		response.getWriter().println(generaCheck("aficionesCheck", lista, select));
		response.getWriter().println(generaSelect("aficionesCheck", lista,"comer"));
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
