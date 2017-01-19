package org.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class Controller extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String baseURL;
	protected Map<String, Object> datos = new HashMap<String, Object>();

	protected void ejecutar(String modo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		this.request = request;
		this.response = response;
		this.baseURL = request.getRequestURL().toString().substring(0,
				request.getRequestURL().toString().length() - request.getRequestURI().length())
				+ request.getContextPath() + "/";
		request.setAttribute("baseUrl", this.baseURL);
		String accion;

		String[] extra = request.getPathInfo() != null ? request.getPathInfo().split("/") : null;
		accion = (extra != null && extra.length > 0) ? extra[1] : "index";
		
				accion += (modo.equals("get") ? "Get" : "Post");

		try {

			Method funcion = this.getClass().getMethod(accion);

			funcion.invoke(this);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getWriter().println("<h1>Objeto no encontrado</h1>");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.ejecutar("get", request, response);
	}

	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.ejecutar("post", request, response);
	}

	protected void view(String rutaAVista) {

		this.view(rutaAVista, true);

	}

	protected void view(String ruta, Boolean enmarcada) {

		this.request.setAttribute("rutaVista", "/view/" + ruta);
		this.request.setAttribute("baseURL", this.baseURL);

		for (String elem : this.datos.keySet()) {
			this.request.setAttribute(elem, this.datos.get(elem));
		}

		try

		{
			if (enmarcada) {

				this.request.getRequestDispatcher("/view/_templates/_MASTER.jsp").forward(request, response);
			} else {
				this.request.getRequestDispatcher("/view/" + ruta).forward(this.request, this.response);
			}

		} catch (

		ServletException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (

		IOException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
