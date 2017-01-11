package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/t7/ej5/*")
public class ej5 extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String variables[][]=
		{{"AUTH_TYPE",request.getAuthType()},
		{"CONTENT_LENGTH",String.valueOf(request.getContentLength())},
		{"CONTENT_TYPE",request.getContentType()},
		{"DOCUMENT_ROOT",getServletContext().getRealPath("/")},
		{"PATH_INFO",request.getPathInfo()},
		{"PATH_TRASNLATED",request.getPathTranslated()},
		{"QUERY_STRING",request.getQueryString()},
		{"REMOTE_ADDR",request.getRemoteAddr()},
		{"REMOTE_HOST",request.getRemoteHost()},
		{"REMOTE_USER",request.getRemoteUser()},
		{"REQUEST_METHOD",request.getMethod()},
		{"SCRIP_NAME",request.getServletPath()},
		{"SERVER_NAME",request.getServerName()},
		{"SERVER_PORT",String.valueOf(request.getServerPort())},
		{"SERVER_PROTOCOL",request.getProtocol()},
		{"SERVER_SOFTWARE",request.getServletContext().getServerInfo()},
		{"REQUEST_URL",request.getRequestURI()},
		{"BASE_URL",request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"},
		};
		
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<table border=\"solid black 1px\"><tr><th>variables</th><th>valor</th></tr>");
		
		for (int i = 0; i < variables.length; i++) {
			String nombre = variables[i][0];
			String valor = variables[i][1];
			out.println("<tr><td>"+nombre+"</td><td>"+valor+"</td></tr>");

		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
